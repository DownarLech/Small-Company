# Small-Company

## This is web application to management a small business. 

To develop this application, I have used a Spring Boot framework with embedded Tomcat server. 
From Spring family, my application contains also Spring Security and Spring Data. 
Lombok has been implemented for facilitating further code writting.
Structure of the application is the MVC design pattern.
Tool choosen for managing database is MySQL and for mapping object-relational - Hibernate.
This app has been written in Intellij IDEA. Apache Maven makes sure the code functions properly at all times. 

Front-end has been built with template engine Thymeleaf and, understandably, with tools such as HTML, CSS, Bootstrap, JQuery and JavaScript. 
I wish to stress that the back-end side of my app was even more crusial for me than the front-end. That is why I have chosen to modify template owned by Blackrock Digital LLC. That has been done in compliance with the MIT licence. 
(MIT is located in  "smallCompany.target.classes.static" packet).

#### Application functionalities.

There are three user roles available: administrator, manager and worker.

Admin can:
- create and remove a user accounts. Password and username are created automatically. 
- 
Manager can: 
- skim over each worker's tasks list.
- add a new tasks to worker (topic, deadline and description).
- remove task.
- 
Worker can:
- skim over own tasks list.
- mark tasks that has been made.

#### To run application localy:
- clone from git.
- create schema "small_company" in Mysql Workbench.
- in file "application.properties", if necessary, change username and password.
- run app.
- the application will be available on http://localhost:8080
