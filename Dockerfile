FROM java:8-jdk

ENV HOME=/home/application

WORKDIR $HOME/spring-boot-apache-camel

ADD build/libs/spring-boot-apache-camel.jar spring-boot-apache-camel.jar

CMD ["java", "-jar", "spring-boot-apache-camel.jar"]