FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a Julia 1.10 environment.'
LABEL run_command='julia --color=no %{filename}'
LABEL test_command='julia --color=no %{filename}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install clang for creating a system image in Julia
RUN install_clean clang

# Create a directory for Julia
ENV JULIA_HOME /opt/julia
RUN mkdir -p $JULIA_HOME

# Install Julia version 1.9 with the official binaries
RUN if [ "$TARGETARCH" = "arm64" ]; then \
        curl -fsSL https://julialang-s3.julialang.org/bin/linux/aarch64/1.10/julia-1.10.0-beta2-linux-aarch64.tar.gz | tar -xz -C $JULIA_HOME --strip-components=1; \
    else \
        curl -fsSL https://julialang-s3.julialang.org/bin/linux/x64/1.10/julia-1.10.0-beta2-linux-x86_64.tar.gz | tar -xz -C $JULIA_HOME --strip-components=1; \
    fi

# Add Julia to the path
ENV PATH $PATH:$JULIA_HOME/bin

# Install Julia packages and rebuild the system image
RUN JULIA_DEPOT_PATH=$JULIA_HOME/share/julia julia -e 'import Pkg; Pkg.add("PackageCompiler")'
ADD build_sysimage.jl $JULIA_HOME/build_sysimage.jl
RUN $JULIA_HOME/build_sysimage.jl
