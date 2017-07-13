FROM ubuntu:14.04
VOLUME /workspace
WORKDIR /workspace
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN apt-get update && apt-get install -y make python3-pip wget
RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.4:/workspace
ENV PATH $PATH:/usr/lib/python3.4

# Set up selenium for test
RUN pip3 install beautifulsoup4

# Set up flask
RUN pip3 install flask flask-bootstrap

RUN adduser --disabled-password --gecos Python python
USER python
