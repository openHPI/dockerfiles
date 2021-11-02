FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Ruby 2.5 environment with rspec, minitest and rubocop.'
LABEL run_command='ruby %{filename}'
LABEL test_command='rspec --format documentation --no-color %{filename}'

# Install Ruby version 2.5
RUN add-apt-repository -y ppa:brightbox/ruby-ng --no-update
RUN install_clean ruby2.5

# Add some Ruby gems
RUN gem install rspec rspec-expectations minitest rubocop

# Switch user
USER user
