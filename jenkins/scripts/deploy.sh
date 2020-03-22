docker build -t teamwiki .
docker stop teamwiki
docker run --name teamwiki --rm --detach \
 -p 8081:8081 \
 -v teamwiki-data:/var/data/teamwiki \
 -v teamwiki-log:/var/log/teamwiki \
 teamwiki