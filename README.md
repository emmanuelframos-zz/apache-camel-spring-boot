# Apache Camel with Spring Boot

## Description
An background application using Apache Camel with Spring Boot stack. The objective is produce content and integrate it in queues.

## Installing dependencies
- [Install](http://www.oracle.com/technetwork/java/javase/downloads/index.html) Java
- [Install](https://gradle.org/install/) Gradle
- [Install](https://docs.docker.com/engine/installation/) Docker
- [Install](https://docs.docker.com/compose/install/) Docker Compose

## Running application
1. Access application root directory
2. Execute **run.sh** file
    
## Usage
- We can check the queues in RabbitMQ management console accessing: [http://localhost:15672], using as user: **admin** and password: **nimda**   

## Funcionalities
- The producer route reads data from file and stores in a queue (QU_PRODUCER).
- The consumer route consumes data from producer queue (QU_PRODUCER) and sends to consumer queue (QU_CONSUMER) as below:<br/>
![](https://preview.ibb.co/isr19b/Screenshot_from_2017_12_07_17_09_11.png)

## Supported Versions
We recommend that you use:
 - Java >= 8
 - Gradle >= 3.0
 - Docker >= 17.09.0-ce
 - Docker Compose >= 1.17.0
     
## License
It is free software, and may be redistributed.
