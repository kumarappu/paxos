#!/bin/sh

echo " Running Assignment 1"

echo " Starting Eureka Service Discovery microservices"
java -jar microservice-eureka-naming-server/target/eureka-discovery-microservice.jar &
sleep 20
echo " Starting Dataaccess microservices"
java -jar microservice-dataaccess-service/target/dataaccess-microservice.jar &
sleep 20
echo " Starting SHA256 microservices"
java -jar microservice-sha256-service/target/sha256-microservice.jar &
