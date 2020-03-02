# Kafka Training
This project is a training exercise just to learn about Kafka and Avro.

#### To build and run de app
 ```
$ mvn clean install
$ mvn spring-boot:run
 ```

#### Description:
The application has one sigle enpoint "/kafka/publish" which publishes the info provided in request body with this structure:
```
{
  "name": string,
  "age" : string,
  "address": string
}
```

Additionally there's a Kafka consumer that reads the published event and logs into the console.