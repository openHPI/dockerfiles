FROM phusion/baseimage:noble-1.0.0
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Base exeuction environment for CodeOcean'
LABEL org.opencontainers.image.description='This image is the base for all other execution environments.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'

# Update the system
RUN apt-get update && apt-get upgrade -y -o Dpkg::Options::="--force-confold" && \
    apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Create a non-privileged user called with a new group having the same name
RUN adduser --disabled-password --home /workspace --no-create-home --gecos "CodeOcean User" user

# The /workspace folder is a location accessible to the user.
RUN mkdir /workspace
# We set the sticky bit to make sure that only the owner can rename and delete files in this folder.
# Otherwise, everyone has full access to the folder and files.
RUN chmod 1777 /workspace

# For the DockerContainerPool, the workspace folder must be accessible as a
# volume. For Poseidon, this is not necessary.
VOLUME /workspace

# The /workspace folder is the start working directory when executing a process
# in the container. This is where submission files are placed by default and
# where the run and test commands get executed if not specified otherwise.
WORKDIR /workspace

# Generate English locale files
RUN locale-gen en_US.UTF-8
# Set English as the main language and UTF-8 as desired encoding
ENV LANGUAGE=en_US.UTF-8
ENV LANG=en_US.UTF-8
ENV LC_ALL=en_US.UTF-8
# Specify terminal emulation.
ENV TERM=ansi
# Prevent folding of output (for lines not longer than 10000 characters).
ENV COLUMNS=10000
# Identify this environment as being part of CodeOcean.
ENV CODEOCEAN=true

# We start the container with the pre-configured init script and switch to our non-privileged user without access to the environment variables
ENTRYPOINT ["/sbin/my_init", "--quiet", "--skip-runit", "--", "env", "-i", "/sbin/setuser", "user"]

# We want to start with an empty bash session for any user that launches the container
CMD ["/bin/bash"]
