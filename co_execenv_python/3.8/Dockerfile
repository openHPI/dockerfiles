FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Python 3.8 execution environment for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a Python 3.8 environment with custom JSON message output and turtle support.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='python3 -B /usr/lib/python3.8/webpython.py -f %{filename}'
LABEL test_command='python3 -B -m unittest --verbose %{module_name}'

# Install Python version 3.8
RUN add-apt-repository -y ppa:deadsnakes/ppa --no-update
RUN install_clean python3.8 python3.8-distutils python3-pip
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.8 1
RUN update-alternatives --set python3 /usr/bin/python3.8

# Add some Python packages
# `pylint` is used for the linter output and pinned to an older version to get whitespace issues
# `bitstring` is used for WWW exercises
# `requests py-sudoku matplotlib numpy beautifulsoup4 tk pandas` is used for the python1 openSAP course
RUN pip3 install setuptools\<68 # Pylint <2.6 (or, specifically wrapt <1.13) is not compatible with setuptools >=68
RUN pip3 install wheel pylint\<2.6 bitstring requests py-sudoku matplotlib numpy beautifulsoup4 tk pandas

# Adjust Path variables
ENV PYTHONPATH=$PYTHONPATH:/usr/lib/python3.8:/workspace
ENV PATH=$PATH:/usr/lib/python3.8

# Add custom files to Python path
ADD assess.py /usr/lib/python3.8/assess.py
ADD webpython.py /usr/lib/python3.8/webpython.py

# Replace maintainers turtle version
RUN rm /usr/lib/python3.8/turtle.py
ADD turtle.py /usr/lib/python3.8/turtle.py
