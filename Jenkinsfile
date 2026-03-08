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


         stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Code Coverage (JaCoCo)') {
            steps {
                sh 'mvn jacoco:report'
           }
        }

        stage('SonarQube Analysis') {
            steps {
                sh '''
                mvn sonar:sonar \
                -Dsonar.projectKey=cicd-service \
                -Dsonar.host.url=http://localhost:9001 \
                -Dsonar.login=sqa_ed00a4a88c8534403e9618e08daa37b19db8b6d4
                '''
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
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