FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Python 3.4 execution environment with selenium and flask for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a Python 3.4 environment with selenium and flask support.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='make run'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install dependencies
RUN install_clean build-essential gdb lcov pkg-config \
  libbz2-dev libffi-dev libgdbm-dev libgdbm-compat-dev liblzma-dev \
  libncurses5-dev libreadline6-dev libsqlite3-dev libssl-dev \
  lzma lzma-dev tk-dev uuid-dev zlib1g-dev libgdbm-compat-dev

# Install OpenSSL version 1.0
ARG OPENSSL_TMP_DIR=/tmp/openssl1.0
RUN mkdir -p $OPENSSL_TMP_DIR
RUN curl -fsSL https://www.openssl.org/source/old/1.0.2/openssl-1.0.2u.tar.gz | tar -xz -C $OPENSSL_TMP_DIR --strip-components=1
RUN cd $OPENSSL_TMP_DIR && ./config -fPIC -shared && make install

# Set environment variables for OpenSSL
ENV OPENSSL_INCLUDE_DIR=/usr/local/ssl/include
ENV OPENSSL_LIB_DIR=/usr/local/ssl/lib
ENV LD_LIBRARY_PATH=$OPENSSL_LIB_DIR

# Install Python version 3.4
ARG PYTHON_TMP_DIR=/tmp/python3
ENV PYTHON_DIR=/usr/lib/python3.4
RUN mkdir -p $PYTHON_TMP_DIR
RUN curl -fsSL https://www.python.org/ftp/python/3.4.10/Python-3.4.10.tgz | tar -xz -C $PYTHON_TMP_DIR --strip-components=1
RUN cd $PYTHON_TMP_DIR && CPPFLAGS="-I/usr/include/tirpc -I$OPENSSL_INCLUDE_DIR" LDFLAGS="-L$OPENSSL_LIB_DIR" ./configure --prefix=/usr && LD_LIBRARY_PATH="/usr/local/ssl/lib" make altinstall
# We need to disable a "fix" in ctypes for tests on Windows.
# See https://stackoverflow.com/questions/5914673/python-ctypes-memoryerror-in-fcgi-process-from-pil-library
RUN sed -i 's/CFUNCTYPE(c_int)(lambda: None)/# CFUNCTYPE(c_int)(lambda: None)/g' /usr/lib/python3.4/ctypes/__init__.py

# Remove temporary files
RUN rm -rf $OPENSSL_TMP_DIR $PYTHON_TMP_DIR

# Add some Python packages
RUN curl -fsSL https://bootstrap.pypa.io/pip/3.4/get-pip.py | python3.4
RUN pip3.4 install setuptools --upgrade
RUN pip3.4 install wheel pylint\<2.6 bitstring
# Set up selenium for test and flask for web development
RUN pip3.4 install beautifulsoup4 flask flask-bootstrap

# lsb_release is a Python script not compatible with Python 3.4.
# Therefore, we are updating the alternatives to use Python 3.4 as late as possible.
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.4 1
RUN update-alternatives --set python3 /usr/bin/python3.4

# Adjust Path variables
ENV PYTHONPATH=$PYTHONPATH:$PYTHON_DIR:/workspace
ENV PATH=$PATH:$PYTHON_DIR
