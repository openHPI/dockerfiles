FROM ruby:2.5
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN read command; exec $command

# Install gems for testing
RUN gem install rspec rspec-expectations minitest

VOLUME /workspace
WORKDIR /workspace

CMD ["/bin/bash"]
