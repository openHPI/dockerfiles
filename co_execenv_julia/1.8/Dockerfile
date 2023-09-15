FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Julia 1.8 environment.'
LABEL run_command='julia --color=no %{filename}'
LABEL test_command='julia --color=no %{filename}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Create a directory for Julia
RUN mkdir -p /opt/julia

# Install Julia version 1.8 with the official binaries
RUN if [ "$TARGETARCH" = "arm64" ]; then \
        curl -fsSL https://julialang-s3.julialang.org/bin/linux/aarch64/1.8/julia-1.8.5-linux-aarch64.tar.gz | tar -xzv -C /opt/julia/ --strip-components=1; \
    else \
        curl -fsSL https://julialang-s3.julialang.org/bin/linux/x64/1.8/julia-1.8.5-linux-x86_64.tar.gz | tar -xzv -C /opt/julia/ --strip-components=1; \
    fi

# Add Julia to the path
ENV PATH $PATH:/opt/julia/bin
