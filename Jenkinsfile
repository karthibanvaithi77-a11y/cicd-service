pipeline {

    agent any

    environment {
        APP_NAME = "cicd-service"
        IMAGE = "cicd-service:latest"
    }

    tools {
        maven 'Maven-3'
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

        stage('Debug Workspace') {
            steps {
                sh 'pwd'
                sh 'ls -la'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '/usr/local/bin/docker build -t cicd-service:${BUILD_NUMBER} .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '/usr/local/bin/kubectl apply -f k8s/deployment.yaml'
                sh '/usr/local/bin/kubectl apply -f k8s/service.yaml'
            }
        }

    }

}