FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

COPY build/libs/delogic-eval.jar /app/delogic-eval.jar

EXPOSE 8080

CMD ["java", "-jar", "delogic-eval.jar"]