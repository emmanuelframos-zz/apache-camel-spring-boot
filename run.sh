docker stop $(docker ps -qa) || true &&
docker-compose up -d &&
gradle clean build &&
java -jar build/libs/apache-camel-spring-boot.jar