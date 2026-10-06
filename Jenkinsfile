pipeline{
	agent any
	
	stages{
		stage('Build'){
			steps{
				sh 'bash mvnw clean package'
			}
		}
		stage('Test'){
			steps{
				sh 'mvn test'
			}
		}
		stage('Package'){
			steps{
				sh 'mvn package -DskipTests'
			}
		}
	}
}
