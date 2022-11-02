FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Ruby 2.5 environment with rspec, minitest and rubocop.'
LABEL run_command='ruby %{filename}'
LABEL test_command='rspec --format documentation --no-color %{filename}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install Ruby version 2.5 with a fixed Ubunut version
RUN add-apt-repository -y 'deb https://ppa.launchpadcontent.net/ticketsolve/ruby-builds/ubuntu focal main' --no-update
RUN if [ "$TARGETARCH" = "arm64" ]; then \
        add-apt-repository -y "deb http://ports.ubuntu.com/ubuntu-ports focal-updates main" --no-update; \
    else \
        add-apt-repository -y "deb http://archive.ubuntu.com/ubuntu focal-updates main" --no-update; \
    fi
RUN install_clean ruby2.5

# Add some Ruby gems
RUN gem install rspec rspec-expectations minitest:5.15 rubocop-ast:1.17 rubocop:1.28
