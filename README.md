# Student registration api

this is an example of springboot api with java that simulates student registration
## you are able :
- **GET**    -> get list of students that in database
- **POST**   -> register new student
- **PUT**    -> update student name or email
- **DELETE** -> delete a student by ID


#### **[Swagger](https://swagger.io/)**
you can use [swagger](http://localhost:9000/swagger-ui/#/) to test all GET, POST, PUT and DELETE requests.


## Database
Database is **MySQL**
- Username : you can change it in `application.properties` *Default is `root`*
- Password : you can change it in `application.properties` *Default is `toor`*
- default port `3306`

## server
- 127.0.0.1:9000/api/v1/student

*Use postman to GET, POST, PUT and DELETE*
