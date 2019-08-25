FROM jdk_coretto: 11
EXPOSE 8080
ADD citizenlab/out/citizen-lab.jar
ENTRYPOINT ["java","-jar","/citizen-lab.jar"]
