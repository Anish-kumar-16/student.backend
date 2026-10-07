pipeline{
	agent any
	
	stages{
		stage('Build'){
			steps{
				echo 'Building student.backend'
			}
		}
		stage('Test'){
			steps{
				echo 'Running Test'
			}
		}
		stage('Docker Build'){
			steps{
			sh 'docker build -t student-backend .'
		}
		}
	}
}