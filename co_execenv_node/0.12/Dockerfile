FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Node 0.12 environment with npm, mocha and q.'
LABEL run_command='node %{filename}'
LABEL test_command='mocha | iconv -c -t ASCII'

# Install Node version 0.12
ENV KEYRING=/usr/share/keyrings/nodesource.gpg
RUN curl -fsSL https://deb.nodesource.com/gpgkey/nodesource.gpg.key | gpg --dearmor | tee "$KEYRING" >/dev/null
RUN echo "deb [signed-by=$KEYRING] https://deb.nodesource.com/node_0.12 xenial main" | tee /etc/apt/sources.list.d/nodesource.list
RUN echo "deb-src [signed-by=$KEYRING] https://deb.nodesource.com/node_0.12 xenial main" | tee -a /etc/apt/sources.list.d/nodesource.list
RUN install_clean nodejs=0.12.18-1nodesource1~xenial1

# Add some Node packages
RUN npm install -g npm@4.2.0
RUN npm install -g mocha@3.2.0 q@1.4.1

# Adjust Path variables
ENV NODE_PATH=/usr/local/lib/node_modules
