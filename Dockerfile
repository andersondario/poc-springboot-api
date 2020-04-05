FROM openjdk:8-jdk-alpine

RUN apk update && apk upgrade
RUN mkdir -p /usr/local/app

ADD target/acai-manager-latest.jar /usr/local/app/
ADD run.sh run.sh

RUN chmod +x run.sh
CMD ./run.sh
