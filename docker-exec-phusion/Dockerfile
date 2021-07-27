FROM phusion/baseimage:master
MAINTAINER openHPI team <openhpi-info@hpi.de>
LABEL description="This image is the base image for other execution environments."

RUN apt-get update && apt-get upgrade -y -o Dpkg::Options::="--force-confold"
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Executions should run as user. Add "USER user" to the Dockerfile of a derived
# image.
RUN useradd --home-dir /workspace --no-create-home --user-group user

# The /workspace folder is a location accessible to the user.
RUN mkdir /workspace
RUN chown user:user /workspace

# For the DockerContainerPool, the workspace folder must be accessible as a
# volume. For Poseidon, this is not necessary.
VOLUME /workspace

# The /workspace folder is the start working directory when executing a process
# in the container. This is where submission files are placed by default and
# where the run and test commands get executed if not specified otherwise.
WORKDIR /workspace

# TERM=ansi helps programs to output colors.
ENV TERM=ansi
# Prevent folding of output (for lines not longer than 10000 characters).
ENV COLUMNS=10000
ENV CODEOCEAN=true

CMD ["/bin/bash"]
