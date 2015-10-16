FROM openhpi/docker-exec
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN apt-get install -y g++ libffi-dev libssl-dev make wget zlib1g-dev
RUN wget -O ruby.tar.gz http://cache.ruby-lang.org/pub/ruby/2.2/ruby-2.2.1.tar.gz && mkdir ruby && tar xfz ruby.tar.gz -C ruby --strip-components=1 && cd ruby && ./configure && make && make install
RUN gem install bundler
ADD Gemfile /
RUN bundle
