FROM openhpi/docker_exec_phusion
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN add-apt-repository -y ppa:deadsnakes/ppa --no-update
RUN install_clean python3.7 python3-setuptools python3-pip
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.7 1
RUN update-alternatives --set python3 /usr/bin/python3.7
RUN pip3 install wheel
RUN pip3 install pylint\<2.6
RUN pip3 install bitstring
RUN pip3 install torch==1.8.0+cpu torchvision==0.9.0+cpu -f https://download.pytorch.org/whl/torch_stable.html

RUN locale-gen en_US.UTF-8

ENV LANG en_US.UTF-8
ENV PYTHONPATH $PYTHONPATH:/usr/lib/python3.7:/workspace
ENV PATH $PATH:/usr/lib/python3.7

ADD webpython.py /usr/lib/python3.7/webpython.py

RUN rm /usr/lib/python3.7/turtle.py

ADD turtle.py /usr/lib/python3.8/turtle.py

USER user
