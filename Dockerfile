# build container
FROM gradle:8.9.0-jdk21-alpine AS temp_build_image

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY build.gradle settings.gradle $APP_HOME
COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src

USER root

RUN chown -R gradle /home/gradle/src

COPY . .

RUN gradle clean build -x test -x checkstyleMain -x checkstyleTest

# target container
FROM openjdk:21-slim

ARG BUILD_VERSION

ENV ARTIFACT_NAME=lafore-api-${BUILD_VERSION}.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=temp_build_image $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8080

ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
