# Apache Camel with Spring Boot
![](http://buzz-build-aws.dextra-sw.com/job/TEST-API-Parts-And-Services-Deploy/badge/icon)

## Description
An background application using Apache Camel with Spring Boot stack. The objective is produce content and integrate it in queues.

## Installing dependencies
- [Install](http://www.oracle.com/technetwork/java/javase/downloads/index.html) Java
- [Install](https://gradle.org/install/) Gradle
- [Install](https://docs.docker.com/engine/installation/) Docker
- [Install](https://docs.docker.com/compose/install/) Docker Compose

## Functionalities
- The producer route reads data from file and stores in a queue (QU_PRODUCER).
- The consumer route consumes data from producer queue (QU_PRODUCER) and sends to consumer queue (QU_CONSUMER) as below:<br/>
![](https://preview.ibb.co/isr19b/Screenshot_from_2017_12_07_17_09_11.png)

## Running application
1. Access application root directory
2. Execute **run.sh** file
    
## Usage
- Drop files into **/files** directory, inside project's root directory 
- File will be integrated into queues in RabbitMQ server
- We can check the queues in RabbitMQ management console accessing: [http://localhost:15672](http://localhost:15672), with following credentials, user: **admin** and password: **nimda**   

## Supported Versions
We recommend that you use:
 - Java >= 8
 - Gradle >= 3.0
 - Docker >= 17.09.0-ce
 - Docker Compose >= 1.17.0
     
## License
It is free software, and may be redistributed.
