# Student registration api

This is an example of springboot api with java that simulates student registration With: 


- **Request log system**
- **Swagger UI**
- **Error controller**

## you are able :
- **GET**    -> get list of students that in database
- **POST**   -> register new student
- **PUT**    -> update student name or email
- **DELETE** -> delete a student by ID

## Database
Database is **MySQL**
- Username : you can change it in `application.properties` *Default is `root`*
- Password : you can change it in `application.properties` *Default is `toor`*
- default port `3306`

## API address
- 127.0.0.1:9000/api/v1/student


*Use **Postman** or built in [**swaggerUI**](http://localhost:9000/swagger-ui/) to **GET**, **POST**, **PUT** and **DELETE***


## TODO
- [ ] Security
- [ ] Pagination
- [ ] Frontend
