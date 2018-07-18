FROM openhpi/docker_base
MAINTAINER openHPI team <openhpi-info@hpi.de>

wget -O - https://apt.llvm.org/llvm-snapshot.gpg.key | sudo apt-key add -
RUN  apt-add-repository "deb http://apt.llvm.org/xenial/ llvm-toolchain-xenial-6.0 main"
RUN  apt-get install -y clang-6.0
