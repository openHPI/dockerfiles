FROM ruby:2.5
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN read command; exec $command

# Install gems for testing
RUN gem install rspec rspec-expectations minitest

ENV LANG C.UTF-8
ENV LANGUAGE C.UTF-8
ENV LANG_ALL C.UTF-8

VOLUME /workspace
WORKDIR /workspace

CMD ["/bin/bash"]
