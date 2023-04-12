FROM openjdk:17-alpine
EXPOSE 8080
ADD targt/devops-integration.jar devops-integration.jar

ENTRYPOINT ["java","-jar","devops-integration.jar"]