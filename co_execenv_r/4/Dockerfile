FROM openhpi/docker_exec_phusion
LABEL org.opencontainers.image.vendor='openHPI Team'
LABEL org.opencontainers.image.authors='openhpi-info@hpi.de'
LABEL org.opencontainers.image.title='R 4.0 execution environment for CodeOcean'
LABEL org.opencontainers.image.description='This image provides a R 4.0 environment with custom libraries from Berry.'
LABEL org.opencontainers.image.url='https://github.com/openHPI/dockerfiles'
LABEL run_command='Rscript -e "options(warn=1); source('%{filename}', echo=TRUE)"'
LABEL test_command='Rscript %{filename}'

# Get target architecture from Docker buildx
ARG TARGETARCH

# Install latest R version 4.0
RUN if [ "$TARGETARCH" = "arm64" ]; then \
        apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 648ACFD622F3D138 0E98404D386FA1D9 && \
        add-apt-repository -y 'deb http://httpredir.debian.org/debian/ unstable main contrib non-free' --no-update; \
    else \
        apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E298A3A825C0D65DFD57CBB651716619E084DAB9 && \
        add-apt-repository -y "deb https://cloud.r-project.org/bin/linux/ubuntu $(lsb_release -cs)-cran40/"  --no-update; \
    fi
RUN install_clean r-base build-essential libcurl4-openssl-dev libssl-dev libpoppler-cpp-dev poppler-data libjpeg-dev libz-dev

# Add custom packages
RUN Rscript -e 'install.packages("zoo")'
RUN Rscript -e 'install.packages("pdftools")'
RUN Rscript -e 'install.packages("base64enc")'
RUN Rscript -e 'install.packages("remotes", repos="https://cran.rstudio.com")'
RUN Rscript -e 'remotes::install_github("brry/berryFunctions")'
RUN Rscript -e 'remotes::install_github("openHPI/codeoceanR")'

# Adjust Path variables
ENV PAGER=/usr/bin/cat
