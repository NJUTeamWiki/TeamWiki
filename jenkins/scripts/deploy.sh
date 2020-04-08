docker build -t teamwiki:latest .
docker stop teamwiki
docker rm teamwiki
docker run --name teamwiki --network teamwiki --detach \
 -p 8081:8081 \
 -v teamwiki-data:/var/data/teamwiki \
 -v teamwiki-log:/var/log/teamwiki \
 teamwiki:latest