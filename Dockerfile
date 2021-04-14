FROM openjdk:11-alpine
COPY ./build/libs/*.jar siamese.jar

ENTRYPOINT ["java", "-Xmx500m", "-jar", "-Duser.timezone=Asia/Seoul", "/siamese.jar"]
