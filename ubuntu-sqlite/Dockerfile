FROM hklement/ubuntu-ruby
MAINTAINER Hauke Klement <dev@hklement.de>
RUN apt-get install -y libsqlite3-dev sqlite
ADD Gemfile /
RUN bundle
ADD database.db /
