![Service Lodge Logo](src/main/resources/static/img/logo/cover.png)
# Service Lodge App
Service Lodge is an application solves the delayed communications between traveling service members and supervisors when it comes to service-related hotel reservations. Members can quickly view their upcoming reservations, create calendar events, and request/cancel future reservations. Administrators are notified of reservation requests, can track hotel usage trends, maintain contracted hotel lists, add/remove members, and manage reservations across their unit and wing.

Technologies:  HTML, CSS, JavaScript, Java, Spring Boot, MySQL 8, Thymeleaf, Bootstrap 4, Tomcat, Microsoft Excel
<br>Domain Name: [servicelodge.net](https://servicelodge.net:8080)
<br>Contact Us: servicelodge.net@gmail.com

## Setup Instructions
1. Fork this repository to make a copy on your own GitHub account.
2. Make sure that your browser is showing this project in your own repositories list in your own account.
3. Click the green `< > Code` button on the right.
4. The clone address should look like git@github.com:your-github-username/service-lodge-capstone.git, where your-github-username is actually your own username on GitHub.
5. Create a local project and initialize it in the command line: 
  ```
   % git init
   % git add .gitignore
   % git commit -m "adding git ignore"
   % git branch -M main
   % git remote add origin git@github.com:you-github-username/service-lodge-capstone.git
   % git push -u origin main
   ```
5. Create your application.properties file using examples.properties as a reference.
6. Start your server and verify the application automatically populates the database.
7. If your database did not populate, uncomment the MySQL lines in the mysqlSeeding.sql script and locally run the seeder file.
8. In the browser navigate to `https://localhost:8080` and login using seeder credentials: 
   - ADMIN: `admin-name@codeup.com : password`
   - MEMBER: `member-name@codeup.com : password`

  
## Project Organization
```
project-root-directory
  └──src
  │  └──main
  │  │  └──java
  │  │    └── net
  │  │       └── servicelodge
  │  │         ├── controllers
  │  │         ├── models
  │  │         ├── repositories
  │  │         └── services
  │  │         └── mySQL Seeder
  │  │         └── Security Configuration
  │  └──resources
  │     └──static
  │     │   ├── css
  │     │   ├── img
  │     │   ├── js
  │     └──templates
  │         ├── drills
  │         ├── hotels
  │         ├── partials
  │         ├── reservations
  │         ├── users
  │         ├── dashboard.html
  │         ├── error.html
  │         ├── index.html
  │         ├── login.html
  │         ├── profile.html
  │     ├──application.properties
  │     └──example.properties
  └── target
  ├── .gitignore
  ├── LICENSE
  ├── mvnw
  ├── mvnw.cmd
  ├── pom.xml
  └── README.md
```

