FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Java 17 execution environment for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a Java 17.0 environment with JUnit 5 support.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='make run'
LABEL test_command='make test CLASS_NAME="%{class_name}" FILENAME="%{filename}"'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install latest OpenJDK version 17.0
RUN install_clean openjdk-17-jdk make

# Add JUnit 5 Platform
ARG JUNIT_VERSION=1.11.0
RUN mkdir -p /usr/java/lib
RUN curl -fsSL -O --output-dir /usr/java/lib https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$JUNIT_VERSION/junit-platform-console-standalone-$JUNIT_VERSION.jar

# Adjust Path variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-$TARGETARCH
ENV JUNIT=/usr/java/lib/junit-platform-console-standalone-$JUNIT_VERSION.jar
ENV CLASSPATH=.:$JUNIT
