#FROM phusion/baseimage
FROM ubuntu:18.04       
MAINTAINER openHPI team <openhpi-info@hpi.de>   

# based on the most recent ubuntu LTS directly, not on the "ubuntu-exec/base"-dockerfile, therefore the following line is required                     
VOLUME /workspace
WORKDIR /workspace
RUN apt-get update || apt-get update
RUN read command; exec $command

RUN apt-get install -y wget
RUN apt-get install -y gnupg2
RUN apt-get install -y cmake

#RUN echo "deb http://apt.llvm.org/xenial/ llvm-toolchain-xenial-6.0 main" > pgdg.list 
RUN echo "deb http://apt.llvm.org/bionic/ llvm-toolchain-bionic-6.0 main" > pgdg.list 
RUN wget -O - https://apt.llvm.org/llvm-snapshot.gpg.key | apt-key add -


RUN  apt-get install -y clang-6.0
RUN  apt-get install -y libc6-dev
RUN  apt-get install -y libc++abi-dev
RUN  apt autoremove -y
