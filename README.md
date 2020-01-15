# News Api Java
## A Sport news RESTAPI with spring boot, JAVA framework.

This is a microservice for creating, reading, updating and deleting news, also manipulating with admins that are responsible for mentioned
functions.

Project is consisted about two major entities: admin and news and they have a relationship between them; 
admin can manipulate with these news.

Web scrapping scripts for desgning a database can be found [here](https://github.com/bedircaushi/JavaApiWebScrapping).

Data definiton language cen be found [here](https://github.com/bedircaushi/JavaApiWebScrapping/blob/master/news/news/news.sql).

All the needed dependencies can be found in `pom.xml` file

## Getting Started

Initially in an empty folder clone the project using this command:

    git clone https://github.com/bedircaushi/NewsApiJava.git
    
You can run the `NewsApplication` file and can use the application and see the result on `http://localhost:8080/`

## Usage

For better user experience, we prefer to use Postman, to better see the result and make changes.
As we defined earlier, our project support crud services. We will define endpoints briefly.

### GET METHOD NEWS:


```
http://localhost:8080/news  //get all news

http://localhost:8080/news/<sport> //get all news from specific <sport>

http://localhost:8080/news/<sport>/<league> //get all news from specific <sport> and <league>

```

### GET METHOD ADMIN

```
http://localhost:8080/admins //get all admins

http://localhost:8080/admin/logout //log out signed in admin

http://localhost:8080/admin/news //get all news posted from logged in admin

```

### DELETE METHOD NEWS 

```
http://localhost:8080/news/<hash> //delete news whith this <hash>
```

### POST METHOD ADMIN AND NEWS

```
http://localhost:8080/news/add //add news if logged in

http://localhost:8080/news/update/<hash> //update news with specific <hash>

http://localhost:8080/admin/login //login with email password of admin already signed up

http://localhost:8080/admin/signup  //sign up an admin defining all attributes

http://localhost:8080/admin/update //update a logged in admin

http://localhost:8080/admin/unregister //delete an admin

```

  
