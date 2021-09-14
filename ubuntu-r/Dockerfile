FROM openhpi/docker_exec_phusion
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E298A3A825C0D65DFD57CBB651716619E084DAB9
RUN add-apt-repository -y 'deb https://cloud.r-project.org/bin/linux/ubuntu focal-cran40/'  --no-update

RUN install_clean r-base build-essential libcurl4-openssl-dev libssl-dev

RUN Rscript -e 'install.packages("remotes", repos="http://cran.rstudio.com")'
RUN Rscript -e 'remotes::install_github("brry/berryFunctions")'
RUN Rscript -e 'remotes::install_github("openHPI/codeoceanR")'

USER user
