FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Python 3.4 environment with custom JSON message output and turtle support.'
LABEL run_command='python3 -B /usr/lib/python3.4/webpython.py -f %{filename}'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install Python version 3.4 and older dependencies
RUN add-apt-repository -y "deb http://ppa.launchpad.net/deadsnakes/ppa/ubuntu bionic main" --no-update
RUN if [ "$TARGETARCH" = "arm64" ]; then \
        add-apt-repository -y "deb http://ports.ubuntu.com/ bionic main" --no-update; \
    else \
        add-apt-repository -y "deb http://archive.ubuntu.com/ubuntu bionic main" --no-update; \
    fi
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys F23C5A6CF475977595C89F51BA6932366A755776 3B4FE6ACC0B21F32
RUN install_clean python3.4
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.4 1
RUN update-alternatives --set python3 /usr/bin/python3.4

# Adjust Path variables
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.4:/workspace
ENV PATH $PATH:/usr/lib/python3.4

# Add custom files to Python path
ADD assess.py /usr/lib/python3.4/assess.py
ADD webpython.py /usr/lib/python3.4/webpython.py

# Replace maintainers turtle version
RUN rm /usr/lib/python3.4/turtle.py
ADD turtle.py /usr/lib/python3.4/turtle.py
