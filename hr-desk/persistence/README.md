# HR-DESK - persistence module

Persistence sub-module for the hr-desk project.
It contains entities, repositories and test classes 
for the persistence module of the HR-DESK project

Requisites:
1) create local database, executing resources/sql/01_schema_&_db_users.sql and resources/sql/02_tables.sql files, or connect to a already existent database
2) set src/test/resources/logback.xml for the right log file path
3) set src/test/resources/application.properties for the right database parameters and credentials
4) execute tests with maven: mvn test
5) install the project library with maven install command: mvn install

