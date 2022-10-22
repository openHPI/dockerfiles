#!/usr/bin/env bash

# Install tools for mk-build-deps
install_clean dpkg-dev devscripts equivs

# Cache source lists
apt-get update

mkdir -p /tmp/build && cd /tmp/build

apt-get source nodejs=0.12.18-1nodesource1~xenial1
cd nodejs-0.12.18 && mk-build-deps --install --remove --tool 'apt-get --no-install-recommends --yes'

sed -i 's/-dumpversion/-dumpfullversion/g' /tmp/build/nodejs-0.12.18/configure
./configure --dest-cpu=arm64
if [ "$TARGETARCH" = "arm64" ]; then \
    sed -i 's/__x86_64__/__aarch64__/g' /tmp/build/nodejs-0.12.18/deps/openssl/config/opensslconf.h && \
    sed -i 's/-m64//g' /tmp/build/nodejs-0.12.18/deps/v8/build/toolchain.gypi; \
    fi
make install
ln -fs /usr/local/bin/node /usr/local/bin/nodejs

# Clean source files
rm -rf /tmp/build
apt-get remove -y nodejs-build-deps dpkg-dev devscripts equivs
install_clean
