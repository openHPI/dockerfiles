FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Node 0.12 execution environment for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a Node 0.12 environment with npm, mocha and q.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='node %{filename}'
LABEL test_command='mocha | iconv -c -t ASCII'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install Node version 0.12
ENV KEYRING=/usr/share/keyrings/nodesource.gpg
RUN curl -fsSL https://deb.nodesource.com/gpgkey/nodesource.gpg.key | gpg --dearmor | tee "$KEYRING" >/dev/null
RUN echo "deb-src [signed-by=$KEYRING] https://deb.nodesource.com/node_0.12 xenial main" | tee -a /etc/apt/sources.list.d/nodesource.list

ADD build_node.sh /tmp/
RUN /tmp/build_node.sh

# Add some Node packages
RUN npm install -g npm@4.2.0
RUN npm install -g mocha@3.2.0 q@1.4.1

# Adjust Path variables
ENV NODE_PATH=/usr/local/lib/node_modules
