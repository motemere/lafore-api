FROM openjdk:17-slim

RUN apt-get update && apt-get install -y make

COPY . /usr/src/api
WORKDIR /usr/src/api

RUN make build

CMD ["java", "-jar","build/libs/lafore-api-0.0.2.jar"]
