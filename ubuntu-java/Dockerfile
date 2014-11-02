FROM hklement/ubuntu-base
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y make wget
RUN mkdir /usr/java && wget -O java.tar.gz http://download.oracle.com/otn-pub/java/jdk/8u25-b17/jdk-8u25-linux-x64.tar.gz --header "Cookie: oraclelicense=accept-securebackup-cookie" && tar xfz java.tar.gz -C /usr/java
ENV JAVA_HOME /usr/java/jdk1.8.0_25
ENV PATH $PATH:$JAVA_HOME/bin
