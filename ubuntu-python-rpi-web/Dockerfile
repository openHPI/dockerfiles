FROM ubuntu:14.04
VOLUME /workspace
WORKDIR /workspace
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN apt-get update && apt-get install -y make Xvfb python3-pip firefox wget
RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.4:/workspace
ENV PATH $PATH:/usr/lib/python3.4

# Get geckodriver
RUN wget https://github.com/mozilla/geckodriver/releases/download/v0.17.0/geckodriver-v0.17.0-linux64.tar.gz && tar xfvz geckodriver-v0.17.0-linux64.tar.gz && mv geckodriver /usr/local/bin

# Set up selenium for test
RUN pip3 install selenium

# Set up flask
RUN pip3 install flask

# Start xserver
CMD Xvfb :99 &
