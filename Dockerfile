FROM openjdk:8-jdk

ENV NAME bbl-1.0-SNAPSHOT




RUN pwd

RUN echo pwd

ENV PORT 8085

ENV PROFILES dev

WORKDIR /compose

ADD /build/libs/$NAME.war $NAME.war

ENV WARNAME /$NAME.war

EXPOSE ${PORT}

CMD ["/bin/sh", "-c", "java -jar  -Dspring.profiles.active=${PROFILES} -Dserver.port=${PORT} -Duser.timezone=Asia/Seoul /bbl-1.0-SNAPSHOT.war"]
