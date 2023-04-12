pipeline {
    agent any
    tools {
        maven '3.9.1'
//        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }
    environment{
        dockerhub=credentials('docker')
    }
    stages {
        stage('Which Java?') {
            steps {
                sh 'java --version'
                sh 'mvn --version'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test -f pom.xml'
            }
        }
        stage('Build maven') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker build -t gurtoc/devops-integration .'
            }
        }
        stage('Push image to DockerHub') {
            steps {
                script {
                    sh 'docker login -u $dockerhub_USR --password-stdin'


                    sh 'docker push gurtoc/devops-integration'
                }
            }
        }
    }
}