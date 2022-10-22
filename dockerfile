FROM openjdk:8
EXPOSE 8090
ADD /target/article-0.0.1-SNAPSHOT.jar article.jar
ENTRYPOINT ["java" , "-jar" , "article.jar"]