FROM openjdk:8-jdk

ENV NAME bbl-1.0-SNAPSHOT

ADD /build/libs/$NAME.war $NAME.war

ENV PORT 8085

ENV PROFILES dev

WORKDIR /tmp

ENV WARNAME /$NAME.war

EXPOSE ${PORT}

CMD ["/bin/sh", "-c", "java -jar -Dpinpoint.agentId=PGADMIN-${PROFILES} -Dpinpoint.applicationName=PGADMIN-${PROFILES} -Dspring.profiles.active=${PROFILES} -Dserver.port=${PORT} -Duser.timezone=Asia/Seoul /bbl-1.0-SNAPSHOT.war"]
