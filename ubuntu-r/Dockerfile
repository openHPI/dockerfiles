FROM openhpi/docker_exec_phusion
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E298A3A825C0D65DFD57CBB651716619E084DAB9
RUN add-apt-repository -y 'deb https://cloud.r-project.org/bin/linux/ubuntu bionic-cran40/'  --no-update

RUN install_clean r-base

RUN Rscript -e 'install.packages("berryFunctions", repos="http://cran.rstudio.com")'
RUN Rscript -e 'if(!requireNamespace("remotes", quietly=TRUE))    install.packages("remotes", repos="http://cran.rstudio.com")'
RUN Rscript -e 'if(!requireNamespace("codeoceanR", quietly=TRUE)) remotes::install_github("openHPI/codeoceanR")'
