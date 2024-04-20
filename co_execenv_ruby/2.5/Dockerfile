FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Ruby 2.5 environment with rspec, minitest and rubocop.'
LABEL run_command='ruby %{filename}'
LABEL test_command='rspec --format documentation --no-color %{filename}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install Ruby version 2.5 with a fixed Debian version
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 112695A0E562B32A 54404762BBB6E853 648ACFD622F3D138 0E98404D386FA1D9 && \
    add-apt-repository -y "deb http://deb.debian.org/debian buster main contrib non-free" --no-update; \
    add-apt-repository -y "deb http://security.debian.org/debian-security/ buster/updates main contrib non-free" --no-update;
RUN install_clean libncurses6 build-essential libgmp-dev
RUN install_clean -t buster ruby2.5 ruby2.5-dev

# Add some Ruby gems
RUN gem install rspec rspec-expectations minitest:5.15 rubocop-ast:1.17 rubocop:1.28
