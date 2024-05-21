#!/usr/bin/env bash

# Install tools for mk-build-deps using the jammy repository. Otherwise, Python2 is not available
if [ "$TARGETARCH" = "arm64" ]; then \
    add-apt-repository -y "deb http://ports.ubuntu.com/ubuntu-ports jammy universe" --no-update; \
else \
    add-apt-repository -y "deb http://archive.ubuntu.com/ubuntu jammy universe" --no-update; \
fi
install_clean dpkg-dev devscripts equivs python2
update-alternatives --install /usr/bin/python python /usr/bin/python2 1
update-alternatives --set python2 /usr/bin/python2

# Cache source lists
apt-get update

mkdir -p /tmp/build && cd /tmp/build

tee -a python <<EOF
Section: misc
Priority: optional
Standards-Version: 3.9.2

Package: python
Version: 2.99
Depends: python2
Provides: python
Description: Fake a python package and use python2 instead
EOF

equivs-build python && dpkg -i python_2.99_all.deb

apt-get source nodejs=0.12.18-1nodesource1~xenial1
cd nodejs-0.12.18 && mk-build-deps --install --remove --tool 'apt-get --no-install-recommends --yes'

sed -i 's/-dumpversion/-dumpfullversion/g' /tmp/build/nodejs-0.12.18/configure
./configure --dest-cpu=arm64 # Always build for arm64, even on amd64
if [ "$TARGETARCH" = "arm64" ]; then \
    sed -i 's/__x86_64__/__aarch64__/g' /tmp/build/nodejs-0.12.18/deps/openssl/config/opensslconf.h && \
    sed -i 's/-m64//g' /tmp/build/nodejs-0.12.18/deps/v8/build/toolchain.gypi; \
fi

# Run `make install` with retries.
# On some systems, the build process may fail due to a lack of memory.
# Luckily, the build process is resumable, so we can retry it.
make_retry_count=0
make_max_retries=3
until make install
do
    make_retry_count=$((make_retry_count + 1))
    echo
    if [ $make_retry_count -ge $make_max_retries ]; then
        echo "Failed to make install after $make_retry_count attempts."
        exit 1
    else
        echo "Failed to make install, retrying..."
        sleep 1
    fi
done
ln -fs /usr/local/bin/node /usr/local/bin/nodejs

# Clean source files
rm -rf /tmp/build
apt-get remove -y nodejs-build-deps dpkg-dev devscripts equivs
install_clean
