FROM openhpi/co_execenv_java
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN apt-get install -y make wget
RUN mkdir -p /usr/java && wget -O java.tar.gz http://download.oracle.com/otn-pub/java/jdk/8u40-b25/jdk-8u40-linux-x64.tar.gz --header "Cookie: oraclelicense=accept-securebackup-cookie" && tar xfz java.tar.gz -C /usr/java
ENV JAVA_HOME /usr/java/jdk1.8.0_40
ENV PATH $PATH:$JAVA_HOME/bin
RUN mkdir -p /usr/java/lib
ADD hamcrest-core-1.3.jar /usr/java/lib/
ADD junit-4.11.jar /usr/java/lib/
RUN mkdir -p /usr/local/lib && cd /usr/local/lib && wget http://www.antlr.org/download/antlr-4.5-complete.jar
ENV CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
RUN mkdir -p /antlr-test/
ADD Java8.g4 /antlr-test/
WORKDIR /antlr-test/
RUN java -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool Java8.g4 && javac *.java
