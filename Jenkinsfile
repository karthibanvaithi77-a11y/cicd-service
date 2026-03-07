pipeline {

    agent any

    environment {
        APP_NAME = "cicd-service"
        IMAGE = "cicd-service:latest"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/karthibanvaithi77-a11y/cicd-service.git'
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t cicd-service:latest springboot-app/'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }

    }

}