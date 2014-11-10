FROM hklement/ubuntu-base
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y g++ libssl-dev make wget zlib1g-dev
RUN wget -O ruby.tar.gz http://cache.ruby-lang.org/pub/ruby/2.1/ruby-2.1.4.tar.gz && mkdir ruby && tar xfz ruby.tar.gz -C ruby --strip-components=1 && cd ruby && ./configure && make && make install
RUN gem install bundler
ADD Gemfile /
RUN bundle
