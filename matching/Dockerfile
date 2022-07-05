FROM openjdk:8-jdk

ENV NAME matching-1.0-SNAPSHOT

ADD /build/libs/$NAME.war ./$NAME.war

ENV PORT 8082

ENV PROFILES dev

WORKDIR /compose



ENV WARNAME /$NAME.war

EXPOSE ${PORT}

CMD ["/bin/sh", "-c", "java -jar  -Dspring.profiles.active=${PROFILES} -Dserver.port=${PORT} -Duser.timezone=Asia/Seoul /matching-1.0-SNAPSHOT.war"]
