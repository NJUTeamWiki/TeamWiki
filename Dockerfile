FROM java:8-alpine

# 安装中文字体
COPY fonts/SIMSUN.ttf /usr/share/fonts/

RUN apk update && \
    apk add libreoffice && \
    fc-cache -fv

VOLUME ["/var/data/teamwiki", "/var/log/teamwiki"]
COPY "/target/TeamWiki-1.0.0.jar" "teamwiki.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar", "teamwiki.jar"]