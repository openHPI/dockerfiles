FROM openhpi/docker_exec
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN apt-get update && apt-get install -y g++ libffi-dev libssl-dev make wget zlib1g-dev
RUN wget -O ruby.tar.gz http://cache.ruby-lang.org/pub/ruby/2.5/ruby-2.5.1.tar.gz && mkdir ruby && tar xfz ruby.tar.gz -C ruby --strip-components=1 && cd ruby && ./configure && make && make install

RUN gem install rspec rspec-expectations rubocop
