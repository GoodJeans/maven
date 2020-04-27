# Maven
* Maven is a site and documentation tool
* Maven extends Ant to let you download dependencies
* Maven is a set of reusable Ant scriptlets



## Installation
```
Open SQLdump file and import to MySQL, open maven file with netbeans, import maven.postman_collection to postman, download tomcat port 8084
```

## Usage

```python
Key: Content-Type, Value: Application/json
Request: Get
API-url: http://localhost:8084/maven/res/api/
Functionality: Retrieve all user's data
JSON: -NIL USE URL

Request: Get
API-url:http://localhost:8084/maven/res/api/user/2
Functionality: Retrieve individual user data
JSON: -NIL USE URL

Request: Post
API-url:http://localhost:8084/maven/res/api/create
Functionality: Create user
JSON:{
    "id": 5,
    "mobileNumber": "98712345",
    "userName": "alien4"
}

Request:Delete
API-url:http://localhost:8084/maven/res/api/delete/5
Functionality: Delete user
JSON: -NIL USE URL

Request:Update
API-url:http://localhost:8084/maven/res/api/update
Functionality: Update user Info
JSON: {
    "id": 2,
    "mobileNumber": "1231232",
    "userName": "alien3"
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
None
© GuanJi"# maven" 
