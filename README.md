# Spring Boot with couchbase multi-bucket

## Couchbase

### Docker container

```bash
docker run -d -p 8091-8094:8091-8094 -p 11210:11210 couchbase:4.6.2 /entrypoint.sh couchbase-server
```

### Bucket configuration

Create two bucket:

#### People
Create a bucket with "people" as name, and configure a view:
Map functions:
```javascript
function (doc, meta) { if(doc._class == "com.innocv.multibucket.domain.People") { emit(meta.id, null); } }
```
And Reduce functions:
```javascript
_count
```

#### Team
Create a bucket with "team" as name, and configure a view:

Map functions:
```javascript
function (doc, meta) { if(doc._class == "com.innocv.multibucket.domain.Team") { emit(meta.id, null); } }
```
And Reduce functions:
```javascript
_count
```

## To run
```bash
mvn spring-boot:run
```

Swagger index: [here](http://localhost:8080/swagger-ui.html)
