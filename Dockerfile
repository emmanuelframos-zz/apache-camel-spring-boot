FROM java:8-jdk

ENV HOME=/home/application

WORKDIR $HOME/apache-camel-spring-boot

ADD wait-for-it.sh wait-for-it.sh

ADD build/libs/apache-camel-spring-boot.jar apache-camel-spring-boot.jar