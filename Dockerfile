FROM openjdk:8
VOLUME /tmp
EXPOSE 8030
ADO ./traget/ServiceTeacher-0.0.1-SNAPSHOT.jar service-teacher.jar
ENTRYPOINT ["java","-jar","/service-teacher.jar"]