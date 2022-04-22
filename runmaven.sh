#!/bin/bash
# Automate Maven Set Up for CS445 Final Project
# Colin Brennan

sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
mvn -version

cd RestControl
mvn clean
mvn clean package
mvn spring-boot:run