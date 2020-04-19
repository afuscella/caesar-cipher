# Dockerfile
FROM openjdk:8-jdk
ADD target/*.jar caesar-cipher.jar
CMD java $JAVA_OPTS -jar /caesar-cipher.jar
