FROM openhpi/docker_exec_phusion
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN add-apt-repository ppa:linuxuprising/java --no-update -y
RUN echo oracle-java16-installer shared/accepted-oracle-license-v1-2 select true | /usr/bin/debconf-set-selections
RUN install_clean oracle-java16-set-default make

RUN mkdir -p /usr/java/lib
RUN wget -P /usr/java/lib https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.2/junit-platform-console-standalone-1.7.2-all.jar

RUN locale-gen en_US.UTF-8

ENV LANG en_US.UTF-8
ENV JAVA_HOME /usr/lib/jvm/java-16-oracle
ENV JUNIT /usr/java/lib/junit-platform-console-standalone-1.7.2-all.jar
ENV CLASSPATH .:$JUNIT
RUN adduser --disabled-password --gecos Java java

USER java
