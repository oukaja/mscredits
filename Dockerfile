FROM openjdk:8
ADD /var/lib/docker/tmp/docker-builder988364858/target/app.ja app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]
