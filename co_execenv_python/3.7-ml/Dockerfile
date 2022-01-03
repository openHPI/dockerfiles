FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Python 3.7 environment with custom JSON message output and Machine Learning support.'
LABEL run_command='python3 -B /usr/lib/python3.7/webpython.py -f %{filename}'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Install Python version 3.7
RUN add-apt-repository -y ppa:deadsnakes/ppa --no-update
RUN install_clean python3.7 python3-setuptools python3-pip
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.7 1
RUN update-alternatives --set python3 /usr/bin/python3.7

# Add some Python packages
RUN pip3 install wheel pylint\<2.6 bitstring
RUN pip3 install pandas torch==1.8.0+cpu torchvision==0.9.0+cpu -f https://download.pytorch.org/whl/torch_stable.html

# Adjust Path variables
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.7:/workspace
ENV PATH $PATH:/usr/lib/python3.7

# Add custom files to Python path
ADD webpython.py /usr/lib/python3.7/webpython.py

# Switch user
USER user
