# spring-boot-docker
springboot学习demo，docker学习demo

### 准备工作
- 在使用docker学习springboot项目之前，需要先在你的阿里云服务器上安装jdk，docker，maven
- 安装完成以后，把代码上传到阿里云服务器。然后切换到项目目录下面

### 打包运行
```
#打包
mvn clean package
#启动
java -jar target/spring-boot-docker-1.0.jar
```
看到 Spring Boot 的启动日志后表明环境配置没有问题，接下来我们使用 DockerFile 构建镜像。
```
mvn package docker:build
```
第一次构建可能有点慢，当看到以下内容的时候表明构建成功：
```
...
Step 1 : FROM openjdk:8-jdk-alpine
 ---> 224765a6bdbe
Step 2 : VOLUME /tmp
 ---> Using cache
 ---> b4e86cc8654e
Step 3 : ADD spring-boot-docker-1.0.jar app.jar
 ---> a20fe75963ab
Removing intermediate container 593ee5e1ea51
Step 4 : ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
 ---> Running in 85d558a10cd4
 ---> 7102f08b5e95
Removing intermediate container 85d558a10cd4
Successfully built 7102f08b5e95
[INFO] Built springboot/spring-boot-docker
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 54.346 s
[INFO] Finished at: 2018-03-13T16:20:15+08:00
[INFO] Final Memory: 42M/182M
[INFO] ------------------------------------------------------------------------
```

使用docker images命令查看构建好的镜像：
```
REPOSITORY                      TAG                 IMAGE ID            CREATED             SIZE
springboot/spring-boot-docker   latest              aa47f23c3284        16 hours ago        118 MB
```

springboot/spring-boot-docker 就是我们构建好的镜像，下一步就是运行该镜像
```
docker run -p 8080:8080 -t springboot/spring-boot-docker
```

启动完成之后我们使用docker ps查看正在运行的镜像：
```
docker ps
CONTAINER ID        IMAGE                           COMMAND                  CREATED             STATUS              PORTS                    NAMES
049570da86a9        springboot/spring-boot-docker   "java -Djava.security"   30 seconds ago      Up 27 seconds       0.0.0.0:8080->8080/tcp   determined_mahavira
```

可以看到我们构建的容器正在在运行，访问浏览器：http://30paotui.com:9999/
说明使用 Docker 部署 Spring Boot 项目成功！



