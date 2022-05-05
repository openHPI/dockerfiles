FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Python 3.8 environment with custom JSON message output and turtle support.'
LABEL run_command='python3 -B /usr/lib/python3.8/webpython.py -f %{filename}'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Install Python version 3.8
RUN add-apt-repository -y ppa:deadsnakes/ppa --no-update
RUN install_clean python3.8 python3-setuptools python3-pip
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.8 1
RUN update-alternatives --set python3 /usr/bin/python3.8

# Add some Python packages
# `pylint` is used for the linter output
# `bitstring` is used for WWW exercises
# `requests py-sudoku matplotlib numpy beautifulsoup4 tk pandas` is used for the python1 openSAP course
RUN pip3 install wheel pylint\<2.6 bitstring requests py-sudoku matplotlib numpy beautifulsoup4 tk pandas

# Adjust Path variables
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.8:/workspace
ENV PATH $PATH:/usr/lib/python3.8

# Add custom files to Python path
ADD assess.py /usr/lib/python3.8/assess.py
ADD webpython.py /usr/lib/python3.8/webpython.py

# Replace maintainers turtle version
RUN rm /usr/lib/python3.8/turtle.py
ADD turtle.py /usr/lib/python3.8/turtle.py

# Switch user
USER user
