FROM openhpi/docker_exec_phusion
MAINTAINER openHPI Team <openhpi-info@hpi.de>
LABEL description='This image provides a R 4.0 environment with custom libraries from Berry.'
LABEL run_command='make run FILENAME="%{filename}"'
LABEL test_command='make test FILENAME="%{filename}"'

# Install latest R version 4.0
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E298A3A825C0D65DFD57CBB651716619E084DAB9
RUN add-apt-repository -y 'deb https://cloud.r-project.org/bin/linux/ubuntu focal-cran40/'  --no-update
RUN install_clean r-base build-essential libcurl4-openssl-dev libssl-dev

# Add custom packages
RUN Rscript -e 'install.packages("remotes", repos="http://cran.rstudio.com")'
RUN Rscript -e 'remotes::install_github("brry/berryFunctions")'
RUN Rscript -e 'remotes::install_github("openHPI/codeoceanR")'
RUN Rscript -e 'install.packages("zoo")'

# Switch user
USER user
