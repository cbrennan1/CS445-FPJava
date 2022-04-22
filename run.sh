#!/bin/bash
# Automate Set Up for CS445 Final Project
# Colin Brennan

#Install openjdk-17-jdk
sudo apt update -y
sudo apt install openjdk-17-jdk -y
java --version

#Install Maven
wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.8.5 /opt/maven

#Set up Enviornment Variables for Maven
sudo touch /etc/profile.d/maven.sh
sudo cat << EOF >> /etc/profile.d/maven.sh
export JAVA_HOME=/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/opt/apache-maven-3.8.5
export MAVEN_HOME=/opt/apache-maven-3.8.5
export PATH=${M2_HOME}/bin:${PATH}
EOF

#Change permissions and load enviornment variables
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
mvn -version

#Install Postman
sudo snap install postman

#Clean -> Package -> Run Maven Project
cd RestControl
mvn clean
mvn clean package
mvn spring-boot:run