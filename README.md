# TeamWiki
TeamWiki后端

SpringBoot项目，打包成Docker Image上传到Docker Hub，以实现Run Everywhere with Docker。

## URL
- Git: https://github.com/NJUTeamWiki/TeamWiki.git
- GitHub: https://github.com/NJUTeamWiki/TeamWiki
- Server Host: http://172.19.241.57/
- Api: http://172.19.241.57:8081/
- Swagger: http://172.19.241.57:8081/swagger-ui.html
- Jenkins: http://172.19.241.57:8080/
- Docker Hub: https://hub.docker.com/repository/docker/xuyangchen/teamwiki
- SonarQube: http://172.19.241.57:9000/
- MySQL: jdbc:mysql:172.19.241.57:3306/team_wiki
- Redis: 172.19.241.57:6379

## Workflow
### 拉取代码
```shell script
git clone https://github.com/NJUTeamWiki/TeamWiki.git

cd TeamWiki

git checkout -b dev-sample
```

### 本地开发测试
本项目通过使用Maven Profile和SpringBoot Profile共同实现本地开发（`dev`）和远程部署（`prod`）的不同配置（`properties`）。

#### TDD 测试驱动开发
在本地测试时，涉及到文件存储的类，需要在测试执行前将`SystemConfig`中的存储路径改为本地的临时目录，测试结束后删除临时目录。
- 可参考`BaseServiceTest`(目前实现方式不够优雅，有待改进。。。)

#### JOOQ数据类生成
**注意`jooq_config.xml`中指定的数据库地址，以防错误覆盖了原来的代码。**

```shell script
mvn jooq-codegen:generate
```

#### 本地构建运行
注意：非Linux环境需要在`docker-compose.yml`中修改对应的挂载路径。
```shell script
mvn -DskipTests clean package

docker-compose down --rmi local

docker-compose up --force-recreate
```
### 上传代码
```shell script
git add .
git commit -m 'Sample commit'
# 
git checkout master
git pull

git checkout dev-sample
git rebase master
git push
```
### 合并到master分支
- 通过Github `Settings` -> `Branches` -> `Branch protection rules`，对`master`分支进行保护，不能直接对`master`分支进行push操作，需要在本地分支push之后提交Pull Request，合并到`master`分支。
- 通过对Pull Request加上若干check，保证合入`master`的代码质量。
    - 当前已有的check：
        - `Action`: Maven build。如果build失败，无法成功merge（以此保证master分支的代码总是build成功的）

### Jenkins CI/CD
Jenkins部署在服务器上，以容器化方式运行。
Jenkins设定为定时对`master`分支进行集成和部署，包括Maven构建，打包docker镜像以及部署在Jenkins服务器上。
详细的CI/CD步骤参考`Jenkinsfile`和`Dockerfile`。

服务器以容器化方式运行jenkins参考：[Build a Java app with Maven](https://jenkins.io/doc/tutorials/build-a-java-app-with-maven/)

### SonarQube
SonarQube也使用Docker方式运行。

安装配置References:
- [sonarqube - Dokcer Hub](https://hub.docker.com/_/sonarqube)
- [Linux下部署SonarQube+PostgreSQL+sonnar-scanner](https://blog.csdn.net/qq_42207325/article/details/100998453)
- [How to Install PostgreSQL 11 on Ubuntu 18.04 & 16.04 LTS](https://tecadmin.net/install-postgresql-server-on-ubuntu/)

### 数据库
项目使用MySQL作为数据库，Jooq作为ORM框架。

**更换数据库需要修改`JooqConfig.xml`和`application.properties`中的MySQL地址。**


## 其它
### docker容器运行时配置端口映射
```shell script
docker stop A
docker commit A imageA #将容器commit提交成为一个镜像
docker rm A #删除原镜像
docker run -d -p 80:80 --name A imageA #启动新镜像
```

_有想法随时交流，遇到的问题和坑的解决思路可以写在文档里(^ . ^)_


