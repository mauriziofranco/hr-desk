# cerepro.persistence.spring

Persistence sub-module for the hr-desk project.
It contains entities, repositories and test classes(unit testsModulo di persistenza contenente entità, repository e classi di test dei repository,
relativamente alla persistenza del progetto HR-DESK

Requisites:
1) create local database, executing resources/sql/01_schema_&_db_users.sql and resources/sql/02_tables.sql files, or connect to a already existent database
2) ensure src/test/resources/logback.xml has correct log files paths
3) ensure src/test/resources/application.properties has correct database credentials
2) execute tests with maven: mvn test
4) install the project with maven install command: mvn install

