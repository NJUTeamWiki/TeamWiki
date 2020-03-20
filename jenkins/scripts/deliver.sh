mvn -Pprod -DskipTests clean package
docker build -t xuyangchen/teamwiki .
docker push xuyangchen/teamwiki
docker rmi xuyangchen/teamwiki