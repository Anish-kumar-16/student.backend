pipeline{
	agent any
	
	stages{
		stage('Build'){
			tools{
				maven 'Maven-3'
			}
			steps{
				sh 'bash mvn clean package'
			}
		}
		stage('Test'){
			steps{
				sh 'mvnw test'
			}
		}
		stage('Package'){
			steps{
				sh 'package -DskipTests'
			}
		}
		stage('Docker Build'){
			steps{
				sh 'docker build -t student-backend:latest .'
			}
		}
	}
}
