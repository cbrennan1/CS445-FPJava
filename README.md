# CS445-FP
## Colin Brennan

## What is this repository for?
  - The project is setup to implement Maven, Java 17, as well as SpringBoot.
  - The assumption is that this is ran on a fresh installation of Ubuntu 20.04.3



## Set Up (Using Automation Scripts)
1. First Run the setup script titled runsetup.sh
```
sudo chmod 777 runsetup.sh
./runsetup.sh
```

2. Set up Enviornment Variables for Maven
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

3. Run the Maven Script
```
sudo chmod 777 runmaven.sh
./runmaven.sh
```



## Set Up (Without Using Scripts)
1. Install openjdk-17-jdk if not already installed.
```
sudo apt update -y
sudo apt install openjdk-17-jdk -y
java --version
```

2. Install Maven
```
wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.8.5 /opt/maven
```

3. Set up Enviornment Variables for Maven
```
sudo apt-get install vim -y
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

Change permissions and load enviornment variables
```
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
mvn -version
```

4. Install Postman
```
sudo snap install postman
```

5. Clean -> Package -> Run Maven Project
```
cd RestControl
mvn clean
mvn clean package
mvn spring-boot:run
```
## Where Can Tests Be Located
 Once you have gone through the set up steps (either with automation scripts or manually) and the spring-boot:run command is up and running you can see the jacoco test coverage that was created with the command "mvn clean package".  The path is displayed below to the created index.html file.
 ```
 CS445-FPJava/RestControl/target/site/jacoco/index.html
 ```

