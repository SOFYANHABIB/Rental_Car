# Rental Car App

I)PROJECT DESCRIPTION:

It's a Spring Boot API for Rental Car agencies allowing them to manage cars reservations & clients bookings and manipulate data through database by creating, reading, updating and deleting data.  

* ERD DESIGN:

<img width="680" alt="ERD Rental Car" src="https://user-images.githubusercontent.com/95347464/153390304-ba4c0758-3a53-436b-a4b1-2bf1185065c5.png">

In this project I focused on building the Rental table part. My aim is to continue later on buliding the other tables and make the connection between them.
<img width="145" alt="ERD Rental Table" src="https://user-images.githubusercontent.com/95347464/153391644-5a644a05-26f6-4092-bc7c-f66b70d0f2a7.png">

* JIRA BOARD:
https://mehdihabib.atlassian.net/jira/software/projects/QA/boards/1


II) BUILDING PROCESS:

I used Eclipse IDE to create the project. I opened a folder with Spring Starter Project where I specified the name of the project, the group, the package, the Artifact. Then I added all the dependencies needed (Spring Data Jpa, Spring Web, Spring Boot DevTools, MySQL Driver, H2 Database and Lombok).

I created a GitHub repository and Initialised a git repo on my source code and connected it with the remote one in GitHub.

In this project, I'm using the Feature-Branch Model. I created a dev branch for production then I created a feature-branch for each package. In each feauture-branch, I commit every change then I push to GitHub. Then I merge the feature-branch to the dev branch in GitHub and I pull back to the dev origin source and create a new feature-branch. And finally when my project is done,  I build the .jar file then I merge the dev branch to the main branch.

III) APP CONSTRUCTION BREAKDOWN:

There are three main parts in this project:
- Creating the Domain, Service and Controller classes.
- Doing the Unit Test for each class then the Integration Test for the whole app.
- Packaging the application into a .jar file then merging the dev branch into the main branch.

1) Main Classes Creation Process:

* I created the domain package and the Rental class, where I set all the variables, generated the constructors, the setters & getters and the Hash code & Equals.
* I created a Repo class by extending the JpaRepository where there are all the queries commands to interact with the database.
* I created the Service Interface where I set the CRUD methods (Create, Read/Read by id, Update and Delete).
* I created the Service class by implenting the Service Interface and initialising the Repo class then I finished all the CRUD methods.
* I created the Controller class and I initialised the service class in it then I set all the HTTP Requests methods (Get, GetById, Post, Put and Delete).

I did the configuration of MySQL database for production in the application-prod.properties and connected it to my app.

I used POSTMAN to test every HTTP Request in my Controller class:
* POST request
<img width="1440" alt="Postman Post" src="https://user-images.githubusercontent.com/95347464/153416787-da32485c-e6dd-41b5-a79d-ab8e08dc6bf3.png">

* GET request
<img width="1440" alt="Postman Get" src="https://user-images.githubusercontent.com/95347464/153416902-91a3d1f0-44f1-4e02-a468-bec0307408b7.png">

* GET BY ID request
<img width="1440" alt="Postman GetById" src="https://user-images.githubusercontent.com/95347464/153416998-644bd40c-65f8-4769-9f33-de8624f7e204.png">

* UPDATE request
<img width="1440" alt="Postman Update" src="https://user-images.githubusercontent.com/95347464/153417118-3b69fd6b-80ae-4c08-be2a-080c9d4c6383.png">

* DELETE request
<img width="1440" alt="Postman Delete" src="https://user-images.githubusercontent.com/95347464/153417250-2718954c-8a22-4be1-a5b4-e9aa343954af.png">

Data from POSTMAN were perfectly sent to my RentalCarDB database.
<img width="1440" alt="RentalCarDB database" src="https://user-images.githubusercontent.com/95347464/153417969-9f2574a2-a0d2-4382-934a-c1a0c058d1ce.png">

2) Unit Test and Integration Test for classes:

I did the configuration of H2 database for testing in the application-test.properties and I added JUnit4 dependency in my POM file.

* I did the Unit Test for the domain class.
<img width="1440" alt="Domain test" src="https://user-images.githubusercontent.com/95347464/153418486-292aa40a-6cfb-40bb-9f10-7a47ab576c9f.png">

* I did the Unit Test for each CRUD method in the Service class:
- Create test
<img width="1440" alt="ServiceCreate Test" src="https://user-images.githubusercontent.com/95347464/153419019-82a5b475-cb71-4c59-9a4f-769dcab1cc58.png">

- Read test
<img width="1440" alt="ServiceGet test" src="https://user-images.githubusercontent.com/95347464/153419140-ee4d427d-54c9-4206-ba83-23bd9b464430.png">

- Read By Id test
<img width="1440" alt="ServiceGetById test" src="https://user-images.githubusercontent.com/95347464/153419272-6b432d89-be22-4d0a-90c1-aae2cafafad0.png">

- Update test
<img width="1440" alt="ServiceUpdtate test" src="https://user-images.githubusercontent.com/95347464/153419381-02accbbc-d816-4b09-aa1d-c97454c52242.png">

- Delete test
<img width="1440" alt="ServiceDelete test" src="https://user-images.githubusercontent.com/95347464/153419461-6fd0c139-7d74-4c55-9c2d-aca18065b88f.png">

* I did the Unit Test for each HTTP Request method in the Controller class using Mockito:
- POSTt test
<img width="1440" alt="ControllerPost test" src="https://user-images.githubusercontent.com/95347464/153419861-4ccc2263-765c-4cc0-9f76-010a2c447902.png">

- GET test
<img width="1440" alt="ControllerGet test" src="https://user-images.githubusercontent.com/95347464/153419963-93c63ebb-dd0e-48c2-ab73-a02b1d41c309.png">

- GET BY ID test
<img width="1440" alt="ControllerGetById test" src="https://user-images.githubusercontent.com/95347464/153420062-1768f1bd-a61d-4592-821f-9fa9912df837.png">

- PUT test
<img width="1440" alt="ControllerPut test" src="https://user-images.githubusercontent.com/95347464/153420240-0d3b3913-0fd6-4624-b297-62fbff85f8e8.png">

- DELETE test
<img width="1440" alt="ControllerDelete test" src="https://user-images.githubusercontent.com/95347464/153420338-4e302a14-a418-493a-b43b-59fd794edabe.png">

* I did the Integration test and checked the coverage which is %96.8 for the src/main/java.
<img width="1440" alt="Test Coverage" src="https://user-images.githubusercontent.com/95347464/153420757-165cb78b-556b-4967-b8a4-d3b288f615ab.png">

3) The final building stage:
Packaging the project into a .jar file using Maven clean and install. Then doing the last git push of the project to the dev branch and merge it with main branch.

<img width="1023" alt="Git Graph" src="https://user-images.githubusercontent.com/95347464/153508655-a6a0d3a0-ba11-4772-9abc-6c94ab27aa88.png">

IV) RISK ASSESSMENT

<img width="1440" alt="Risk Assessment" src="https://user-images.githubusercontent.com/95347464/153510051-bbbe59a0-4dbd-4eaa-a2a7-0c789af7efdc.png">
