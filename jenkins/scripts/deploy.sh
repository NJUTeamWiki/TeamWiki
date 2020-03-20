docker rmi -f teamwiki
docker build -t teamwiki .
docker run --name teamwiki --rm --detach \
 -p 8081:8081 \
 -v teamwiki-data:${DATA_VOLUME} \
 -v teamwiki-log:${LOG_VOLUME} \
 teamwiki