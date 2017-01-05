FROM ubuntu:14.04
VOLUME /workspace
WORKDIR /workspace
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.4:/workspace
ENV PATH $PATH:/usr/lib/python3.4
RUN adduser --disabled-password --gecos Python python
USER python
