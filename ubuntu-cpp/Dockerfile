#FROM phusion/baseimage
FROM ubuntu:14.04
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN apt-get update || apt-get update
VOLUME /workspace
WORKDIR /workspace
RUN read command; exec $command

RUN  apt-get install -y clang-6.0
RUN  apt-get install libc6-dev
RUN  apt autoremove -y
