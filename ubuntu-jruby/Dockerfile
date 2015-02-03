FROM hklement/ubuntu-java
MAINTAINER Hauke Klement <dev@hklement.de>
RUN wget -O /tmp/jruby.tar.gz https://s3.amazonaws.com/jruby.org/downloads/1.7.19/jruby-bin-1.7.19.tar.gz
RUN mkdir /usr/jruby
RUN tar xfz /tmp/jruby.tar.gz -C /usr/jruby
ENV PATH $PATH:/usr/jruby/jruby-1.7.19/bin
RUN gem install bundler
ADD Gemfile /
RUN bundle
