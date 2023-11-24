<h1>RELEASES NOTES</h1>
<h2>0.3</h2>
Refactored database sql scripts.
Changed default frontend logo and application image.
<h2>0.2</h2>
Substituted default mariadb development database, with single-file database with H2.
Provided into sources download default dev, test and demo databases already created(and with just soe data)
Added standalone/target folder that provides demo release files.
From now give mvn package from project root and after packaging all modules, demo version file will produced also.
<h2>0.1</h2>
On the top of CeRePro project, entire sources are moved into this development trunk. Now CeRePro has moved to HrDesk.
Single projects MailManager, Cerepro.Persistence, Cerepro.Backend and Cerepro.hr.rjs.frontend have been moved into a Maven multi module project.

<h1>TARGET RELEASES</h1>
<h2>0.4</h2>
# Frontend QUESTION entity section: for now allowed: list, insert and delete operations
# Upgrading SPRING BOOT to last available version
# default used JDK version upgraded to 17
# default spring-boot starter partent version upgraded to 3.1.5 
<h2>0.5</h2>
# recover hsqdb compatibility
# recover handleValidationError method into RestValidationHandler class
# recover tests in backend module
# recover tests in persistence module
# mail properties have to been moved into application.properties so user can change it
# JWT instead Basic Authentication
# upgrade JDK to 21
# Startup dialog for customizing application logo and name(perhaps into xml file?)
# Define separation for "Community Edition" and "Enterprise Edition"
# Target lines for product site
# Redmine installation for bug tracking and community requests (BUNNYSHELL???)
# Frontend internazionalization
# Frontend - Question section: avoid delete buttons rendering if question already associated to a survey
           - Question section: implementing update modal   

<h1>BUGS</h1>
# DEMO packaged version, fronted home page(login) show browser dialog for login...
# CoursePage entity, frontend section: into update dialog, select component for the position owner doesn't accept default starting value.
# Candidate frontend section: cv icon(for cv download) has to been show only if cv has to been charged
# On pdf generation points have to be instead of i.e. "52 points", a percentage i.e. 52/100


<h1>DEVELOPMENT HOW-TO</h1>
<h2>COMPILE, PACKAGING AND EXECUTE FROM SOURCES</h2>
from root execute the following:
mvn package
to execute compilation, test, packaging of all sub-modules and demo file build, into $project_dir/target/standalone
During the backend generate-resources phase, react frontend(under webapp submodule), the "production files", compiled with the packaging execution fo webapp module, will be copied under ${project.build.directory}/classes/public (/backend/target/public/classes)
and will be included into backend submodule package. So ready for the production, it would be startupped directly, with backend and frontend all together. 
After all packages are built, from backend directory you can give the following command to execute the application(startup frontend and backend):
java -jar ./target/hr-desk.backend.jar
Then you can point to frontend from the following url:
http://localhost:8080/index.html

<h2>DEVELOPMENT ENVIRONMENT, EXECUTE FRONTEND AND BACKEND SERVERS SEPARATELY</h2>
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
