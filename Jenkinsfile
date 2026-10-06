pipeline{
	agent any
	
	stages{
		stage('Build'){
			steps{
				sh 'chmod +x mvnw && ./mvnw clean package'
			}
		}
		stage('Test'){
			steps{
				sh './mvnw test'
			}
		}
		stage('Package'){
			steps{
				sh './mvnw package -DskipTests'
			}
		}
		stage('Docker Build'){
			steps{
				sh 'docker build -t student-backend:latest .'
			}
		}
	}
}
