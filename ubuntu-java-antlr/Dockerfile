#FROM openhpi/docker_exec
FROM ubuntu:14.04
VOLUME /workspace
WORKDIR /workspace
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN apt-get install -y make wget
RUN mkdir -p /usr/java && wget -O java.tar.gz http://download.oracle.com/otn-pub/java/jdk/8u40-b25/jdk-8u40-linux-x64.tar.gz --header "Cookie: oraclelicense=accept-securebackup-cookie" && tar xfz java.tar.gz -C /usr/java
ENV JAVA_HOME /usr/java/jdk1.8.0_40
ENV PATH $PATH:$JAVA_HOME/bin
RUN mkdir -p /usr/java/lib
ADD hamcrest-core-1.3.jar /usr/java/lib/
ADD junit-4.11.jar /usr/java/lib/
ADD antlr-4.5-complete.jar /usr/local/lib/
ADD antlr-java8.jar /usr/java/lib/
#CMD ["/bin/bash"]
