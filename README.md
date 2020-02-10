# News Api Java
## A Sport news RESTAPI with spring boot, JAVA framework.

This is a microservice for creating, reading, updating and deleting news, also manipulating with admins that are responsible for mentioned
functions.

Project is consisted about two major entities: admin and news and they have a relationship between them; 
admin can manipulate with these news.

All the needed dependencies can be found in `pom.xml` file

## Getting Started

***1.*** Clone the project using this command:

    git clone https://github.com/bedircaushi/NewsApiJava.git

***2.*** Create a database for the microservice

***3.*** Import the sql file at your database. The file can be found [here](https://github.com/bedircaushi/NewsApiJava/blob/add/ddl/news.sql)

***4.*** Configure the application.properties file with your mysql credentials:

```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:<port_number>/<database_name>?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username = <username>
spring.datasource.password = <password>


## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

You are all set and can run the `NewsApplication` file and can use the application and see the result on `http://localhost:8080/`


## Usage

For better user experience, we prefer to use Postman, to better see the result and make changes.
As we defined earlier, our project support crud services. We will define endpoints briefly.

### News endpoints

**1.** URL: ```http://localhost:8080/news``` Get all news - METHOD = GET

*Response - List of News objects*
```
[
    {
        "hash": "b6c998e511782c45881637516b38cc0430a38fa1ac7e550f8656e675",
        "title": "Test title",
        "description": "Test description",
        "sport": "Football",
        "teamCode": "TEST",
        "image": "test image",
        "league": "Test league",
        "team": "Test team",
        "link": "test link",
        "publishedAt": "08/02/2020 16:43",
        "username": "test"
    }
]
```

**2.** URL: ```http://localhost:8080/news/<sport>``` Get all news from specific sport - METHOD = GET

*Response - List of News objects*
```
[
    {
        "hash": "b6c998e511782c45881637516b38cc0430a38fa1ac7e550f8656e675",
        "title": "Test title",
        "description": "Test description",
        "sport": "Football",
        "teamCode": "TEST",
        "image": "test image",
        "league": "Test league",
        "team": "Test team",
        "link": "test link",
        "publishedAt": "08/02/2020 16:43",
        "username": "test"
    }
]
```

**3.** URL: ```http://localhost:8080/news/<sport>/<league>``` Get all news from specific sport and league - METHOD = GET

*Response - List of News objects*
```
[
    {
        "hash": "b6c998e511782c45881637516b38cc0430a38fa1ac7e550f8656e675",
        "title": "Test title",
        "description": "Test description",
        "sport": "Football",
        "teamCode": "TEST",
        "image": "test image",
        "league": "Test league",
        "team": "Test team",
        "link": "test link",
        "publishedAt": "08/02/2020 16:43",
        "username": "test"
    }
]
```

**4.** URL: ```http://localhost:8080/news/add ``` Add news if admin is logged in - METHOD POST, expects JSON body input

*JSON body - News input object*
``` 
{
	"title": "Test title",
	"descr": "Test description",
	"sport": "Football",
	"team_code": "TEST",
	"image": "test image",
	"league": "Test league",
	"team": "Test team",
	"link": "test link",
	"publishedAt": "08/02/2020 16:43"
}
```

*Response - News object*
```
{
  "hash": "b6c998e511782c45881637516b38cc0430a38fa1ac7e550f8656e675",
  "title": "Test title",
  "description": "Test description",
  "sport": "Football",
  "teamCode": "TEST",
  "image": "test image",
  "league": "Test league",
  "team": "Test team",
  "link": "test link",
  "publishedAt": "08/02/2020 16:43",
  "username": "test"
}
```


**5.** URL: ```http://localhost:8080/news/update/<hash>``` Update news with specific hash - METHOD = POST, expects JSON body input

*JSON body - News input object*
``` 
{
	"title": "Test title",
	"descr": "Test description",
	"sport": "Football",
	"team_code": "TEST",
	"image": "test image",
	"league": "Test league",
	"team": "Test team",
	"link": "test link",
	"publishedAt": "08/02/2020 16:43"
}
```

*Response - News object*
```
{
  "hash": "b6c998e511782c45881637516b38cc0430a38fa1ac7e550f8656e675",
  "title": "Test title",
  "description": "Test description",
  "sport": "Football",
  "teamCode": "TEST",
  "image": "test image",
  "league": "Test league",
  "team": "Test team",
  "link": "test link",
  "publishedAt": "08/02/2020 16:43",
  "username": "test"
}
```

**6.** URL: ```http://localhost:8080/news/<hash>``` Delete news by hash


### Admin endpoints

**1.** URL: ```http://localhost:8080/admins``` Get all admins - METHOD = GET

*Response - List of admin objects*
```
[
  {
    "username": "test",
    "name": "test",
    "surname": "test",
    "address": "test",
    "email": "test@mail.com",
    "password": "123456"
  },
  {
      "username": "test1",
      "name": "test1",
      "surname": "test1",
      "address": "test1",
      "email": "test1@mail.com",
      "password": "123456"
    }
]
```

**2.** URL: ```http://localhost:8080/admin/logout``` Admin log out - METHOD = GET

**3.** URL: ```http://localhost:8080/admin/news``` Get all news posted from logged in admin - METHOD = GET

*Response - List of News objects*

```
[
    {
        "hash": "b6c998e511782c45881637516b38cc0430a38fa1ac7e550f8656e675",
        "title": "Test title",
        "description": "Test description",
        "sport": "Football",
        "teamCode": "TEST",
        "image": "test image",
        "league": "Test league",
        "team": "Test team",
        "link": "test link",
        "publishedAt": "08/02/2020 16:43",
        "username": "test"
    }
]
```

**4.** URL: ```http://localhost:8080/admin/login``` Login with email password of admin already signed up - METHOD = POST, expects JSON body input

*JSON body - Admin login credentials* 
```
{
	"email": "test@mail.com",
	"password": "123456"
}
```

*Response - Admin object*
```
{
  "username": "test",
  "name": "test",
  "surname": "test",
  "address": "test",
  "email": "test@mail.com",
  "password": "123456"
}
```
**5.** URL:```http://localhost:8080/admin/signup```  Sign up an admin defining all attributes - METHOD = POST, expects JSON body input

*JSON body - Admin signup info*
```
{
	"email": "test1@mail.com",
	"password": "123456",
	"username": "test1",
	"name": "Test1",
	"surname": "Test1",
	"address": "Test"
}
```

*Response - Admin object*
```
{
  "username": "test1",
  "name": "Test1",
  "surname": "Test1",
  "address": "Test",
  "email": "test1@mail.com",
  "password": "123456"
}
```

**6.** URL:```http://localhost:8080/admin/update``` Update a logged in admin - METHOD = POST, expects JSON body input

*JSON body - Admin update info*
```
{
	"email": "test1@mail.com",
	"password": "123456",
    "newPassword": "12345678",
	"username": "test1",
	"name": "Test1",
	"surname": "Test1",
	"address": "Test"
}
```

*Response - Admin object*
```
{
  "username": "test1",
  "name": "Test1",
  "surname": "Test1",
  "address": "Test",
  "email": "test1@mail.com",
  "password": "123456"
}
```

**7.** URL:```http://localhost:8080/admin/unregister``` Delete an admin - METHOD = POST
