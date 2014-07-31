FROM hklement/ubuntu-base
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y g++ make wget
RUN wget -O python.tgz https://www.python.org/ftp/python/2.7.8/Python-2.7.8.tgz && mkdir python && tar xfz python.tgz -C python --strip-components=1 && cd python && ./configure && make && make install
