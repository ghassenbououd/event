FROM java:8

MAINTAINER bououdghassen@gmail.com

WORKDIR /apps/event

COPY target/event.jar /apps/event/event.jar

EXPOSE 8080

CMD java -jar event.jar