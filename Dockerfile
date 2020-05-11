FROM java:8-alpine
COPY warehouse/mentoring/src /usr/src/app/src
WORKDIR /usr/src/app
ADD warehouse/mentoring/mariadb-java-client-2.5.4.jar mariadb-java-client-2.5.4.jar
RUN mkdir bin && javac src/mentoring/Main.java -d bin -classpath "src:mariadb-java-client-2.5.4.jar"

ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

CMD sh -c "/wait && java -cp \"bin:mariadb-java-client-2.5.4.jar\" mentoring.Main"