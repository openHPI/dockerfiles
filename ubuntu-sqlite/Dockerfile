FROM openhpi/docker_ruby
MAINTAINER openHPI team <openhpi-info@hpi.de>
RUN apt-get install -y libsqlite3-dev sqlite
ADD Gemfile /
RUN bundle
ADD database.db /
