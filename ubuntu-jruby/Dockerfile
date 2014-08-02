FROM hklement/ubuntu-java
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y wget
RUN mkdir /usr/jruby && wget -O jruby.tar.gz http://jruby.org.s3.amazonaws.com/downloads/1.7.13/jruby-bin-1.7.13.tar.gz && mkdir jruby && tar xfz jruby.tar.gz -C /usr/jruby
ENV PATH $PATH:/usr/jruby/jruby-1.7.13/bin
RUN gem install bundler
ADD Gemfile /
RUN bundle
