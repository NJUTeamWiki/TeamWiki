FROM java:8-alpine
VOLUME ["/var/data/teamwiki", "/var/log/teamwiki"]
ADD "/target/TeamWiki-0.0.1-SNAPSHOT.jar" "TeamWiki.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "TeamWiki.jar"]