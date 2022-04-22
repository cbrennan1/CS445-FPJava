# CS445-FP
## Colin Brennan

## What is this repository for?
  - The project is setup to implement Maven, Java 17, as well as Apache Tomcat 10.
  - The assumption is that this is ran on a fresh installation of Ubuntu 20.04.3

## Automation Script
To take care of initial set up please run the run.sh script first.
```
sudo cmod 777 run.sh
./run.sh
```

## Maven Set Up

1. Set up Enviornment Variables for Maven
```
sudo vim /etc/profile.d/maven.sh
```

Once the file is open you need to append the following into it.
```
export JAVA_HOME=/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/opt/apache-maven-3.8.5
export MAVEN_HOME=/opt/apache-maven-3.8.5
export PATH=${M2_HOME}/bin:${PATH}
```

2. Run runmaven.sh 
```
sudo chmod 777 runmaven.sh
./runmaven.sh
```






