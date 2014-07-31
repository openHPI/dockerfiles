FROM hklement/ubuntu-base
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y wget
RUN mkdir /usr/java && cd /usr/java && wget -O java.tar.gz http://download.oracle.com/otn-pub/java/jdk/8u11-b12/jdk-8u11-linux-x64.tar.gz --header "Cookie: oraclelicense=accept-securebackup-cookie" && tar xfz java.tar.gz && rm java.tar.gz
ENV JAVA_HOME /usr/java/jdk1.8.0_11
ENV PATH $PATH:$JAVA_HOME/bin
