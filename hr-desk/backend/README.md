#DEVELOPMENT HOW-TO

#COMPILE, PACKAGING AND EXECUTE FROM SOURCES
from hr-desk package execute this command to execute compilation, test and packaging of all sub-modules:
mvn package
during the backend generate-resources phase, react frontend(under webapp submodule), the "production files", compiled with the packaging execution fo webapp module, will be copied under ${project.build.directory}/classes/public (/backend/target/public/classes)
and will be included into backend submodule package. So ready for the production, it would be startupped directly, with backend and frontend all together. 
After all packages are built, from backend directory you can give the following command to execute the application(startup frontend and backend):
java -jar ./target/hr-desk.backend.jar
Then you can point to frontend from the following url:
http://localhost:8080/index.html


#DEVELOPMENT ENVIRONMENT, EXECUTE FRONTEND AND BACKEND SERVERS SEPARATELY
For development we suggest to startup separately backend and frontend servers.
So for the frontend, move into webapp directory, and execute(after npm install):
npm start
this startup the local server under the under the port 3000, so you can point from the browser with the following url:
http://loaclhost:3000
From default it points to backend microservices at http://localhost:8080/api/v1/ url

to startup backend server, move into backend and execute:
mvn spring-boot:run
It provides to startup locale server at the port 8080 so you can point to microservices(browser, soapui, postman, ecc)
pointing to:
http://localhost:8080/api/v1/*
where * should be substituted with the final path of the api to call.
We remember that all the api are accessible under authentication, so you should have to insert a valid user account details.
