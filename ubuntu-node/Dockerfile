FROM hklement/ubuntu-exec
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y g++ make python wget
RUN wget -O node.tar.gz http://nodejs.org/dist/v0.12.0/node-v0.12.0.tar.gz && mkdir node && tar xfz node.tar.gz -C node --strip-components=1 && cd node && ./configure && make && make install
