# Sure_calculator

This project was created to analyze data from a cryptocurrency exchange. It should help the owners of a large volume of cryptocurrency tokens or tokens with low liquidity
This service uses the collected data on the volumes of purchases and sales on the cryptocurrency exchange and, on the basis of the received data, makes a forecast regarding price changes.

**This project does not work without collected data (without dataCollector)!!!**
- Doker
- Java/Spring
- REST

## Dependencies

- Data on MySQL. Use dataCollector (https://github.com/zhenyagit/hackathon_dataCollector)
- Docker or JVM
- mvn to build

## How to use
**First run dataCollector, then run this project**
clone repo:
```sh 
git clone https://github.com/zhenyagit/calculator_sure
```

In root directory build project:
```sh
mvn package -Dmaven.test.skip
```

(If you use JVM):
go to /target and run:
```sh
java -jar calculator_sure-x.x.x-SNAPSHOT.jar
```
where "x.x.x" is the application version

(If you use Docker):
- Create folder to build docker container
- Create file with name "Dokerfile"
- Paste this into Dockerfile:
```sh
FROM openjdk:8-jdk-alpine
CMD ["mkdir", "app"]
WORKDIR app/
ARG JAR_FILE
COPY ${JAR_FILE} app/app.jar
ENTRYPOINT ["java","-jar","app/app.jar"]
```
To build:
```sh
sudo docker build --build-arg JAR_FILE=/path/to/App.jar -t your_nickname/calculator_sure .
```
To run:
```sh
 sudo docker run -d -it -p 8080:8080 --network hackathon_project --name calculator_sure your_nickname/calculator_sure
```
"hackathon_project" - docker network with MySQL db with data 
