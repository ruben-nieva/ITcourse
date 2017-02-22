FROM alpine-jre_1.8
VOLUME /tmp
ADD target/ITCourse*.jar /ITCourse.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ITCourse.jar"]
