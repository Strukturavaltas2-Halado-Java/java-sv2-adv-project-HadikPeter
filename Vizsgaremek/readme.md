# Alkalmazás futtatása

Az alkalmazásunk lebildelése mavennel:
```shell
mvn clean package 
```
A clean parancs hatására letörli a target könyvtárat, a package
hatására pedig létrejön maga az alkalmazásunk, egy JAR állomány.

Alkalmazás docker image-nek buildelése:

```shell
docker build -t image neve .
```


A lebildelt docker image a következő Docker paranccsal indítható:

```shell
docker run -d -p 8080:8080 spring-vizsgaremek
```

A feladatleírást olvasd el részletesen, és

Test mariaDB adatbázis elindítása a 3307-es porton

```shell
docker run -d -e MYSQL_DATABASE=location -e MYSQL_USER=location -e MYSQL_PASSWORD=location -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3307:3306 --name test-mariadb mariadb
```