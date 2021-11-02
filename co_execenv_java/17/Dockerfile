FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Java 17.0 environment with JUnit 5 support.'
LABEL run_command='make run'
LABEL test_command='make test CLASS_NAME="%{class_name}" FILENAME="%{filename}"'

# Install latest Java version 17.0
RUN add-apt-repository ppa:linuxuprising/java --no-update -y
RUN echo oracle-java17-installer shared/accepted-oracle-license-v1-3 select true | /usr/bin/debconf-set-selections
RUN install_clean oracle-java17-set-default make

# Add JUnit 5 Platform
RUN mkdir -p /usr/java/lib
RUN wget -P /usr/java/lib https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar

# Adjust Path variables
ENV JAVA_HOME /usr/lib/jvm/java-17-oracle
ENV JUNIT /usr/java/lib/junit-platform-console-standalone-1.8.1.jar
ENV CLASSPATH .:$JUNIT

# Switch user
USER user
