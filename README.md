# OpenSearch Java client with Spring Boot

This repository contains the code for the tutorial: <a href="https://mobisoftinfotech.com/resources/blog/opensearch-java-client-spring-boot-search-integration">Using OpenSearch Java Client and Spring Boot for Powerful Search Integration</a> published by <a href="https://mobisoftinfotech.com/services/web-application-development-company">Mobisoft - Web Application Development Company, Houston</a>


## Getting Started

### Prerequisites

- Java
- Maven
- Spring Tool Suite (STS)
- Docker
- Docker Compose

### Running the opensearch

```bash
docker compose -f docker/opensearch-compose.yaml -p opensearch up 
```

### Running the application

```bash
mvn clean package
docker compose up
```


### Get opensearch self signed certificate

You might need to get the self signed certificate from the opensearch container. You can use the following command to get the certificate:
```bash
openssl s_client -connect localhost:9200 -servername localhost -showcerts < /dev/null 2>/dev/null | openssl x509 -outform PEM > /tmp/opensearch.crt
```

### Import the certificate to the java truststore
Once you have the certificate, you need to import it to the java truststore using the following command:

```bash
keytool -importcert -file /tmp/opensearch.crt -alias opensearch -keystore src/main/resources/opensearch-truststore.jks -storepass changeit -noprompt
```
