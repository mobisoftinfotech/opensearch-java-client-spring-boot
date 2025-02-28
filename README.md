# OpenSearch Java client with Spring Boot

## Getting Started

### Prerequisites

- Java
- Docker
- Docker Compose

### Running the opensearch

```bash
docker compose -f docker/opensearch-compose.yaml -p opensearch up 
```

### Running the application

```bash
docker compose up
```


### Get opensearch self signed certificate

```bash
openssl s_client -connect localhost:9200 -servername localhost -showcerts < /dev/null 2>/dev/null | openssl x509 -outform PEM > /tmp/opensearch.crt
```

### Import the certificate to the java truststore

```bash
keytool -importcert -file /tmp/opensearch.crt -alias opensearch -keystore src/main/resources/opensearch-truststore.jks -storepass changeit -noprompt
```
