pipeline {
    agent any
    tools {
        maven '3.9.1'
//        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }
    environment{
        dockerhub=credentials('docker')
        registryCredential = credentials('aws')
    }
    stages {
        stage('Which Java?') {
            steps {
                sh 'java --version'
                sh 'mvn --version'
                echo 'hello world'
//                echo '$registryCredential'
                echo 'amazon id:'
                echo AWS_ACCESS_KEY_ID
                echo 'amazon key:'
                echo AWS_SECRET_ACCESS_KEY
                echo 'DOCKER id:'
                echo dockerhub_USR
                echo 'DOCKER PASS:'
                echo dockerhub_PSW
            }
        }
//        stage('test') {
//            steps {
//                sh 'mvn test -f pom.xml'
//            }
//        }
//        stage('Build maven') {
//            steps {
//                sh 'mvn clean package'
//            }
//        }
//        stage('Build docker image') {
//            steps {
//                sh 'docker build -t gurtoc/devops-integration .'
//            }
//        }
//        stage('Push image to DockerHub') {
//            steps {
//                script {
//                    sh 'docker login -u $dockerhub_USR -p $dockerhub_PSW'
//
//
//                    sh 'docker push gurtoc/devops-integration'
//                }
//            }
//        }
    }
}
