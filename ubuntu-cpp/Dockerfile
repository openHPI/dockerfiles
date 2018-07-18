FROM openhpi/docker_exec
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN  apt-add-repository "deb http://apt.llvm.org/xenial/ llvm-toolchain-xenial-6.0 main"
RUN  apt-get install -y clang-6.0

RUN  update-alternatives --install /usr/bin/clang++ clang++ /usr/bin/clang++-3.8 100
RUN  update-alternatives --install /usr/bin/clang++ clang++ /usr/bin/clang++-6.0 1000
RUN  update-alternatives --install /usr/bin/clang++ clang /usr/bin/clang-3.8 100
RUN  update-alternatives --install /usr/bin/clang clang /usr/bin/clang-3.8 100
RUN  update-alternatives --install /usr/bin/clang clang /usr/bin/clang-6.0 1000
