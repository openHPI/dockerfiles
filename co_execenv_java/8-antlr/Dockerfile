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
ARG HAMCREST_VERSION=3.0
ARG JUNIT_VERSION=4.13.2
ARG ANTLR_VERSION=4.5.3
RUN curl -fsSL -O --output-dir /usr/java/lib https://repo1.maven.org/maven2/org/hamcrest/hamcrest/$HAMCREST_VERSION/hamcrest-$HAMCREST_VERSION.jar
RUN curl -fsSL -O --output-dir /usr/java/lib https://repo1.maven.org/maven2/junit/junit/$JUNIT_VERSION/junit-$JUNIT_VERSION.jar
RUN curl -fsSL -O --output-dir /usr/java/lib https://www.antlr.org/download/antlr-${ANTLR_VERSION}-complete.jar
# I could not find the antlr-java8.jar file anywhere, so I added it manually
# The files within the JAR were most likely created with ANTLR 4.5.2.
# ANTLR versions >=4.6 and <4.10 will work with this JAR, but issue a warning.
# ANTLR versions >=4.10 will not work with this JAR.
ADD antlr-java8.jar /usr/java/lib/

# Adjust Path variables
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-$TARGETARCH
ENV HAMCREST=/usr/java/lib/hamcrest-$HAMCREST_VERSION.jar
ENV JUNIT=/usr/java/lib/junit-$JUNIT_VERSION.jar
ENV ANTLR=/usr/java/lib/antlr-${ANTLR_VERSION}-complete.jar
ENV ANTLR_JAVA8=/usr/java/lib/antlr-java8.jar
ENV CLASSPATH=.:$HAMCREST:$JUNIT:$ANTLR:$ANTLR_JAVA8
