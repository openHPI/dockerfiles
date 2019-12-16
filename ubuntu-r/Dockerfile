FROM openhpi/docker_exec_phusion
MAINTAINER openHPI team <openhpi-info@hpi.de>

RUN apt-get update && apt-get install -y r-base

RUN Rscript -e 'install.packages("berryFunctions", repos="http://cran.rstudio.com")'
