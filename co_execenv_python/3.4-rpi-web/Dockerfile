FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Python 3.4 environment with selenium and flask support.'
LABEL run_command='make run'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Install Python version 3.4
RUN add-apt-repository -y "deb http://ppa.launchpad.net/deadsnakes/ppa/ubuntu bionic main" --no-update
RUN add-apt-repository -y "deb http://archive.ubuntu.com/ubuntu bionic main" --no-update
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys F23C5A6CF475977595C89F51BA6932366A755776
RUN install_clean python3.4 python3.4-dev gcc make
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.4 1
RUN update-alternatives --set python3 /usr/bin/python3.4

# Add some Python packages
RUN curl -fsSL https://bootstrap.pypa.io/pip/3.4/get-pip.py | python3
RUN pip3 install wheel pylint\<2.6 bitstring
# Set up selenium for test and flask for web development
RUN pip3 install beautifulsoup4 flask flask-bootstrap

# Adjust Path variables
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.4:/workspace
ENV PATH $PATH:/usr/lib/python3.4

# Switch user
USER user
