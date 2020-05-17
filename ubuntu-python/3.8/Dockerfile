FROM openhpi/docker_exec_phusion
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN add-apt-repository -y ppa:deadsnakes/ppa --no-update
RUN install_clean python3.8 python3-setuptools python3-pip
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.8 1
RUN update-alternatives --set python3 /usr/bin/python3.8
RUN pip3 install wheel
RUN pip3 install pylint
RUN pip3 install bitstring

RUN locale-gen en_US.UTF-8

ENV LANG en_US.UTF-8
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.8:/workspace
ENV PATH $PATH:/usr/lib/python3.8

ADD assess.py /usr/lib/python3.8/assess.py
ADD webpython.py /usr/lib/python3.8/webpython.py

RUN rm /usr/lib/python3.8/turtle.py

RUN adduser --disabled-password --gecos Python python
ADD turtle.py /usr/lib/python3.8/turtle.py

USER python
