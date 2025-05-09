FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='Julia 1.8 execution environment for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a Julia 1.8 environment.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='julia --color=no %{filename}'
LABEL test_command='julia --color=no %{filename}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install clang for creating a system image in Julia
RUN install_clean clang

# Create a directory for Julia
ENV JULIA_HOME=/opt/julia
RUN mkdir -p $JULIA_HOME

# Install Julia version 1.8 with the official binaries
ARG JULIA_VERSION=1.8.5
RUN if [ "$TARGETARCH" = "arm64" ]; then \
        curl -fsSL https://julialang-s3.julialang.org/bin/linux/aarch64/1.8/julia-${JULIA_VERSION}-linux-aarch64.tar.gz | tar -xz -C $JULIA_HOME --strip-components=1; \
    else \
        curl -fsSL https://julialang-s3.julialang.org/bin/linux/x64/1.8/julia-${JULIA_VERSION}-linux-x86_64.tar.gz | tar -xz -C $JULIA_HOME --strip-components=1; \
    fi

# Add Julia to the path
ENV PATH=$PATH:$JULIA_HOME/bin

# Install Julia packages and rebuild the system image
ARG JULIA_DEPOT_PATH=$JULIA_HOME/share/julia
RUN julia -e 'import Pkg; Pkg.add("PackageCompiler")'
ADD build_sysimage.jl $JULIA_HOME/build_sysimage.jl
RUN $JULIA_HOME/build_sysimage.jl
