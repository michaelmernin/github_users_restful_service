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
  "url": "https://github.com/michaelmernin",
  "created_at": "2016-11-14 17:32:05",
  "repos": [
    {
      "name": "AndroidContacts",
      "url": "https://github.com/michaelmernin/AndroidContacts"
    },
    {
      "name": "ants",
      "url": "https://github.com/michaelmernin/ants"
    },
    {
      "name": "apache_camel_patterns",
      "url": "https://github.com/michaelmernin/apache_camel_patterns"
    },
    {
      "name": "auto-sync",
      "url": "https://github.com/michaelmernin/auto-sync"
    },
    {
      "name": "camel_server_replications",
      "url": "https://github.com/michaelmernin/camel_server_replications"
    },
    {
      "name": "distributable_matrix_proto",
      "url": "https://github.com/michaelmernin/distributable_matrix_proto"
    },
    {
      "name": "EconCalc",
      "url": "https://github.com/michaelmernin/EconCalc"
    },
    {
      "name": "emailAutomator",
      "url": "https://github.com/michaelmernin/emailAutomator"
    },
    {
      "name": "flask_saml_validator",
      "url": "https://github.com/michaelmernin/flask_saml_validator"
    },
    {
      "name": "github_users_restful_service",
      "url": "https://github.com/michaelmernin/github_users_restful_service"
    },
    {
      "name": "hannibalLecturer",
      "url": "https://github.com/michaelmernin/hannibalLecturer"
    },
    {
      "name": "IronGram2",
      "url": "https://github.com/michaelmernin/IronGram2"
    },
    {
      "name": "jython_mq_browser",
      "url": "https://github.com/michaelmernin/jython_mq_browser"
    },
    {
      "name": "MicroBlog",
      "url": "https://github.com/michaelmernin/MicroBlog"
    },
    {
      "name": "MicroBlogSessions",
      "url": "https://github.com/michaelmernin/MicroBlogSessions"
    },
    {
      "name": "MicroblogSpring",
      "url": "https://github.com/michaelmernin/MicroblogSpring"
    },
    {
      "name": "Minicraft",
      "url": "https://github.com/michaelmernin/Minicraft"
    },
    {
      "name": "oneNote",
      "url": "https://github.com/michaelmernin/oneNote"
    },
    {
      "name": "peopleWebNew",
      "url": "https://github.com/michaelmernin/peopleWebNew"
    },
    {
      "name": "pi-shrink",
      "url": "https://github.com/michaelmernin/pi-shrink"
    },
    {
      "name": "Purchases",
      "url": "https://github.com/michaelmernin/Purchases"
    },
    {
      "name": "purchases-closure",
      "url": "https://github.com/michaelmernin/purchases-closure"
    },
    {
      "name": "Review",
      "url": "https://github.com/michaelmernin/Review"
    },
    {
      "name": "saml_validator",
      "url": "https://github.com/michaelmernin/saml_validator"
    },
    {
      "name": "scraper",
      "url": "https://github.com/michaelmernin/scraper"
    },
    {
      "name": "skills-proto-ansible-role",
      "url": "https://github.com/michaelmernin/skills-proto-ansible-role"
    },
    {
      "name": "SkillsMatrixProto",
      "url": "https://github.com/michaelmernin/SkillsMatrixProto"
    },
    {
      "name": "skills_dev_environment",
      "url": "https://github.com/michaelmernin/skills_dev_environment"
    },
    {
      "name": "taxEval",
      "url": "https://github.com/michaelmernin/taxEval"
    },
    {
      "name": "Tracker",
      "url": "https://github.com/michaelmernin/Tracker"
    },
    {
      "name": "tutorials",
      "url": "https://github.com/michaelmernin/tutorials"
    },
    {
      "name": "umapi-client.py",
      "url": "https://github.com/michaelmernin/umapi-client.py"
    },
    {
      "name": "user-sync.py",
      "url": "https://github.com/michaelmernin/user-sync.py"
    },
    {
      "name": "user-update",
      "url": "https://github.com/michaelmernin/user-update"
    },
    {
      "name": "ust-configapp",
      "url": "https://github.com/michaelmernin/ust-configapp"
    },
    {
      "name": "UST-Install-Scripts",
      "url": "https://github.com/michaelmernin/UST-Install-Scripts"
    },
    {
      "name": "ust-oneroster",
      "url": "https://github.com/michaelmernin/ust-oneroster"
    },
    {
      "name": "UST_Install_Scripts",
      "url": "https://github.com/michaelmernin/UST_Install_Scripts"
    },
    {
      "name": "workDocuments",
      "url": "https://github.com/michaelmernin/workDocuments"
    }
  ]
}
```
