FROM hklement/ubuntu-exec
MAINTAINER Martin Malchow <martin.malchow@hpi.de>
RUN apt-get update
RUN apt-get install -y g++ make python wget
RUN wget -O node.tar.gz http://nodejs.org/dist/v0.12.4/node-v0.12.4.tar.gz && mkdir node && tar xfz node.tar.gz -C node --strip-components=1 && cd node && ./configure && make && make install
RUN npm install npm -g
RUN npm install -g mocha
RUN npm install q -g
RUN export NODE_PATH=/usr/local/lib/node_modules
RUN apt-get -y install recode
ENV LANG=en_US.UTF-8
