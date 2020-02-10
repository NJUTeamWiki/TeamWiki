FROM java:8-alpine
VOLUME ["/var/data/teamwiki", "/var/log/teamwiki"]
ADD "/target/TeamWiki-0.0.1-SNAPSHOT.jar" "teamwiki.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar", "teamwiki.jar"]