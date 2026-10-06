pipeline{
	agent any
	
	stages{
		stage('Build'){
			steps{
				bat 'mvn clean package'
			}
		}
		stage('Test'){
			steps{
				bat 'mvn test'
			}
		}
		stage('Package'){
			steps{
				bat 'mvn package -DskipTests'
			}
		}
	}
}
