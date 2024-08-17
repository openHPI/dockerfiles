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
ARG HAMCREST_VERSION=1.3
ARG JUNIT_VERSION=4.13
ARG ANTLR_VERSION=4.5
RUN curl -fsSL -O --output-dir /usr/java/lib https://repo1.maven.org/maven2/org/hamcrest/hamcrest/$HAMCREST_VERSION/hamcrest-$HAMCREST_VERSION.jar
RUN curl -fsSL -O --output-dir /usr/java/lib https://repo1.maven.org/maven2/junit/junit/$JUNIT_VERSION/junit-$JUNIT_VERSION.jar
RUN curl -fsSL -O --output-dir /usr/java/lib https://www.antlr.org/download/antlr-${ANTLR_VERSION}-complete.jar
# I could not find the antlr-java8.jar file anywhere, so I added it manually
ADD antlr-java8.jar /usr/java/lib/

# Adjust Path variables
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-$TARGETARCH
ENV HAMCREST /usr/java/lib/hamcrest-$HAMCREST_VERSION.jar
ENV JUNIT /usr/java/lib/junit-$JUNIT_VERSION.jar
ENV CLASSPATH .:$JUNIT:$HAMCREST
