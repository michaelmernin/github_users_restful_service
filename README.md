# Github User Data
Restful service that exposes user Github data to HTTP requests
### Technical Components

  - Java 8 (AdoptOpenJDK)
  - Springboot (Microservice framework)
  - Apache Camel (Integration Patterns)
  - Jackson (JSON)
  - OkHttp3 (HTTP client)
  - Gradle (Build automation)

# Components deciding factors
### Java 8 (AdoptJDK)
  - Open source JDK
  - Common Java version used within industry
  - Able to leverage Java 8 lambdas
### Springboot (Microservice framework)
  - Built in server
  - Quick and lightweight development
  - Starter libraries ease dependency management
### Apache Camel (Integration Patterns)
  - Easily extendable and compatible with core Java programming
  - Component based architecture, providing seemless route writing
  - Provides a reproducible code base
### Jackson (JSON)
  - High performance JSON processor
  - Apache provides built in Jackson support for marshalling/unmarshalling
### OkHttp3 (HTTP client)
  - Ease of use
  - Recommended by Apache Camel's main contributor

 

# Running application from terminal
### Clone repository
```sh
git clone https://github.com/michaelmernin/github_users_restful_service.git
```

### Build JAR with gradle wrapper
```sh
> {project_directory} gradlew build
```
### Run JAR
```sh
> {project_directory} java -jar build/libs/gitusers-0.0.1-SNAPSHOT.jar
```

# Making Request (GET)
### Supported Methods
GET: /git/username/{username}  
returns git data for given username

### Parameters
| param | type | description | required | example |
| ------ |------ |------ |------ |------ |
| username | string | username of target | yes | michaelmernin |
### Example, from POSTMAN or BROWSER
REQUEST: http://localhost:8080/git/username/michaelmernin
RESPONSE:  
```json
{
    "user_name": "michaelmernin",
    "display_name": "Michael Mernin",
    "avatar": "https://avatars1.githubusercontent.com/u/23459391?v=4",
    "geo_location": "Minneapolis, MN",
    "email": null,
    "url": "https://api.github.com/users/michaelmernin",
    "created_at": "2016-11-14 17:32:05",
    "repos": [
        {
            "name": "AndroidContacts",
            "url": "https://api.github.com/repos/michaelmernin/AndroidContacts"
        },
        {
            "name": "ants",
            "url": "https://api.github.com/repos/michaelmernin/ants"
        },
        {
            "name": "apache_camel_patterns",
            "url": "https://api.github.com/repos/michaelmernin/apache_camel_patterns"
        },
        {
            "name": "auto-sync",
            "url": "https://api.github.com/repos/michaelmernin/auto-sync"
        },
        {
            "name": "camel_server_replications",
            "url": "https://api.github.com/repos/michaelmernin/camel_server_replications"
        },
        {
            "name": "distributable_matrix_proto",
            "url": "https://api.github.com/repos/michaelmernin/distributable_matrix_proto"
        },
        {
            "name": "EconCalc",
            "url": "https://api.github.com/repos/michaelmernin/EconCalc"
        },
        {
            "name": "emailAutomator",
            "url": "https://api.github.com/repos/michaelmernin/emailAutomator"
        },
        {
            "name": "flask_saml_validator",
            "url": "https://api.github.com/repos/michaelmernin/flask_saml_validator"
        },
        {
            "name": "github_users_restful_service",
            "url": "https://api.github.com/repos/michaelmernin/github_users_restful_service"
        },
        {
            "name": "hannibalLecturer",
            "url": "https://api.github.com/repos/michaelmernin/hannibalLecturer"
        },
        {
            "name": "IronGram2",
            "url": "https://api.github.com/repos/michaelmernin/IronGram2"
        },
        {
            "name": "jython_mq_browser",
            "url": "https://api.github.com/repos/michaelmernin/jython_mq_browser"
        },
        {
            "name": "MicroBlog",
            "url": "https://api.github.com/repos/michaelmernin/MicroBlog"
        },
        {
            "name": "MicroBlogSessions",
            "url": "https://api.github.com/repos/michaelmernin/MicroBlogSessions"
        },
        {
            "name": "MicroblogSpring",
            "url": "https://api.github.com/repos/michaelmernin/MicroblogSpring"
        },
        {
            "name": "Minicraft",
            "url": "https://api.github.com/repos/michaelmernin/Minicraft"
        },
        {
            "name": "oneNote",
            "url": "https://api.github.com/repos/michaelmernin/oneNote"
        },
        {
            "name": "peopleWebNew",
            "url": "https://api.github.com/repos/michaelmernin/peopleWebNew"
        },
        {
            "name": "pi-shrink",
            "url": "https://api.github.com/repos/michaelmernin/pi-shrink"
        },
        {
            "name": "Purchases",
            "url": "https://api.github.com/repos/michaelmernin/Purchases"
        },
        {
            "name": "purchases-closure",
            "url": "https://api.github.com/repos/michaelmernin/purchases-closure"
        },
        {
            "name": "Review",
            "url": "https://api.github.com/repos/michaelmernin/Review"
        },
        {
            "name": "saml_validator",
            "url": "https://api.github.com/repos/michaelmernin/saml_validator"
        },
        {
            "name": "scraper",
            "url": "https://api.github.com/repos/michaelmernin/scraper"
        },
        {
            "name": "skills-proto-ansible-role",
            "url": "https://api.github.com/repos/michaelmernin/skills-proto-ansible-role"
        },
        {
            "name": "SkillsMatrixProto",
            "url": "https://api.github.com/repos/michaelmernin/SkillsMatrixProto"
        },
        {
            "name": "skills_dev_environment",
            "url": "https://api.github.com/repos/michaelmernin/skills_dev_environment"
        },
        {
            "name": "taxEval",
            "url": "https://api.github.com/repos/michaelmernin/taxEval"
        },
        {
            "name": "Tracker",
            "url": "https://api.github.com/repos/michaelmernin/Tracker"
        },
        {
            "name": "tutorials",
            "url": "https://api.github.com/repos/michaelmernin/tutorials"
        },
        {
            "name": "umapi-client.py",
            "url": "https://api.github.com/repos/michaelmernin/umapi-client.py"
        },
        {
            "name": "user-sync.py",
            "url": "https://api.github.com/repos/michaelmernin/user-sync.py"
        },
        {
            "name": "user-update",
            "url": "https://api.github.com/repos/michaelmernin/user-update"
        },
        {
            "name": "ust-configapp",
            "url": "https://api.github.com/repos/michaelmernin/ust-configapp"
        },
        {
            "name": "UST-Install-Scripts",
            "url": "https://api.github.com/repos/michaelmernin/UST-Install-Scripts"
        },
        {
            "name": "ust-oneroster",
            "url": "https://api.github.com/repos/michaelmernin/ust-oneroster"
        },
        {
            "name": "UST_Install_Scripts",
            "url": "https://api.github.com/repos/michaelmernin/UST_Install_Scripts"
        },
        {
            "name": "workDocuments",
            "url": "https://api.github.com/repos/michaelmernin/workDocuments"
        }
    ]
}
```