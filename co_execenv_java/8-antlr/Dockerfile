FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides an OpenJDK 8.0 environment with JUnit 4 and Antlr support.'
LABEL run_command='make run CLASS_NAME="%{class_name}" FILENAME="%{filename}"'
LABEL test_command='make test CLASS_NAME="%{class_name}" FILENAME="%{filename}"'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install latest OpenJDK version 8.0
RUN install_clean openjdk-8-jdk make

# Add JUnit 4 and Antlr
RUN mkdir -p /usr/java/lib
ADD hamcrest-core-1.3.jar /usr/java/lib/
ADD junit-4.13.jar /usr/java/lib/
ADD antlr-4.5-complete.jar /usr/local/lib/
ADD antlr-java8.jar /usr/java/lib/

# Adjust Path variables
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-$TARGETARCH
ENV JUNIT /usr/java/lib/junit-4.13.jar
ENV HAMCREST /usr/java/lib/hamcrest-core-1.3.jar
ENV CLASSPATH .:$JUNIT:$HAMCREST
