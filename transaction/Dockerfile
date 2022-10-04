FROM gradle:jdk17-alpine

COPY . /app

WORKDIR /app

RUN gradle build

EXPOSE 8080

CMD ["sh", "start.sh"]