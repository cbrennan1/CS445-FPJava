# CS445-FP
## Colin Brennan

## What is this repository for?
  - The project is setup to implement Gradle, Java 17, as well as Apache Tomcat 10.
  - The assumption is that this is ran on a fresh installation of Ubuntu 20.04.3

## Set Up
1. Install openjdk-17-jdk if not already installed.
```
sudo apt update
sudo apt install openjdk-17-jdk
java --version
```
2. Install Maven
```
wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.6.3 /opt/maven
```

3. Set up Enviornment Variables for Maven
```
sudo apt-get install vim
sudo vim /etc/profile.d/maven.sh
```

Once the file is open you need to append the following into it.
```
export JAVA_HOME=/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
```

Change permissions and load enviornment variables
```
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
sudo apt install maven
mvn -version
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=4.0.0-beta.1 

```

4. Install Github and Clone Repo
```
sudo apt-get install git
mkdir Colin-FP
cd Colin-FP
git init
git pull https://github.com/cbrennan1/CS445-FPJava
```

5. Install Tomcat Apache Server
```
cd /tmp
wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.20/bin/apache-tomcat-10.0.20.tar.gz

