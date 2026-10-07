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
			echo 'Building docler image'
		}
	}
}