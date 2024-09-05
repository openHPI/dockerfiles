FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Python 3.7 execution environment for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a Python 3.7 environment with custom JSON message output and Machine Learning support.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='python3 -B /usr/lib/python3.7/webpython.py -f %{filename}'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Install Python version 3.7
RUN add-apt-repository -y ppa:deadsnakes/ppa --no-update
RUN install_clean python3.7 python3.7-distutils python3-pip
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.7 1
RUN update-alternatives --set python3 /usr/bin/python3.7

# Add some Python packages
RUN pip3 install setuptools\<68 # Pylint <2.6 (or, specifically wrapt <1.13) is not compatible with setuptools >=68
RUN pip3 install wheel pylint\<2.6 bitstring
RUN pip3 install pandas torch==1.8.1 torchvision==0.9.1 -f https://download.pytorch.org/whl/cpu

# Adjust Path variables
ENV PYTHONPATH=$PYTHONPATH:/usr/lib/python3.7:/workspace
ENV PATH=$PATH:/usr/lib/python3.7

# Add custom files to Python path
ADD webpython.py /usr/lib/python3.7/webpython.py
