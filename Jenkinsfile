pipeline{
	agent any
	
	stages{
		stage('Build'){
			steps{
				sh 'chmod +x mvnw'
				sh './mvnw clean package -DskipTests'
			}
		}
		stage('Test'){
			steps{
				sh './mvnw test'
			}
		}
		stage('Docker Build'){
			steps{
			sh 'docker build -t student-backend .'
		}
	  }
	  stage('Dcoker Push'){
		steps{
			withCredentials([[
				$class:'UsernamePasswordMultiBinding',
				credentialsId:'2ddce8ed-b53d-461e-9dc2-621f85f9e0b4',
				usernameVariable:'DOCKER_USERNAME',
				passwordVariable:'DOCKER_PASSWORD'
			]]){
				sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
				sh 'docker tag student-backend anishkumar02/student-backent:latest'
				sh 'docker push anishkumar02/student-backend:latest'
			}
		}
	  }
	}
}