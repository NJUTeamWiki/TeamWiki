FROM java:8-alpine

VOLUME ["/var/data/teamwiki", "/var/log/teamwiki"]

# 安装中文字体
COPY lib/fonts/SIMSUN.ttf /usr/share/fonts/

RUN apk update && \
    apk add libreoffice && \
    fc-cache -fv

COPY "/target/TeamWiki-*.jar" "teamwiki.jar"

EXPOSE 8081

ENTRYPOINT ["java","-jar","teamwiki.jar"]