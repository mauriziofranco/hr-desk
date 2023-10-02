pipeline {
    agent { 
	    label 'Locale-Master-Node' 
	}	
    stages {        
        stage("Compile") {
            steps {
            
                sh "./mvnw -v"    
                sh "./mvnw clean compile -e -X"
            }
        }
        stage("Provides application property file for Integration tests") {
            steps {
                sh "rm ./src/test/resources/application.properties"
                echo "Original ./src/test/resources/application.properties successfully removed!!"
                sh "cp /cerepro_resources/properties/cerepro.persistence.spring/application.test.properties ./src/test/resources/application.properties"
            }
        }
        stage("Unit And Integration tests") {
            steps {
                sh "./mvnw test"
            }
        }
        stage("Code coverage") {
            steps {              
				jacoco(execPattern: 'target/jacoco.exec')
				publishHTML (target: [
				        reportDir: 'target/site/jacoco',
				        reportFiles: 'index.html',
				        reportName: "JaCoCo Report"
				    ]
				)
            }
        }
        stage("Build and publish code check-style report") {
            steps {
                sh "./mvnw site"
                publishHTML (target: [
					reportDir: 'target/site/',
					reportFiles: 'checkstyle.html',
					reportName: "Checkstyle Report"
				])
            }
        }
        stage("Install for All Environments") {
            steps {
                          
				sh "./mvnw install -DskipTests"
            }
        }
    }
    post {
		always {
		
			emailext body: 'A Test EMail from cerepro.persistence.spring', 
				recipientProviders: [[$class: 'DevelopersRecipientProvider'], 
					[$class: 'RequesterRecipientProvider']], 
					subject: 'Test'
		}
	}
}