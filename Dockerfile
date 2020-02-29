FROM java:8-alpine
VOLUME ["/var/data/teamwiki", "/var/log/teamwiki"]
ADD "/target/TeamWiki-1.0.0.jar" "teamwiki.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar", "teamwiki.jar"]