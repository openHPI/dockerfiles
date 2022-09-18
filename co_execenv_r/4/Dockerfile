FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a R 4.0 environment with custom libraries from Berry.'
LABEL run_command='Rscript -e "options(warn=1); source('%{filename}', echo=TRUE)"'
LABEL test_command='Rscript %{filename}'

# Install latest R version 4.0
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E298A3A825C0D65DFD57CBB651716619E084DAB9
RUN add-apt-repository -y 'deb https://cloud.r-project.org/bin/linux/ubuntu focal-cran40/'  --no-update
RUN install_clean r-base build-essential libcurl4-openssl-dev libssl-dev libpoppler-cpp-dev poppler-data libjpeg-dev libz-dev

# Add custom packages
RUN Rscript -e 'install.packages("zoo")'
RUN Rscript -e 'install.packages("pdftools")'
RUN Rscript -e 'install.packages("base64enc")'
RUN Rscript -e 'install.packages("remotes", repos="https://cran.rstudio.com")'
RUN Rscript -e 'remotes::install_github("brry/berryFunctions")'
RUN Rscript -e 'remotes::install_github("openHPI/codeoceanR")'

# Adjust Path variables
ENV PAGER /usr/bin/cat