pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
            echo 'Building..'
	            withMaven(){
	            sh mvn clean install -Dmaven.test.skip=true
	            }
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}