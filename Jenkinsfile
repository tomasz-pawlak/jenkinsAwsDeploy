pipeline {
    agent any
    tools {
        maven '3.9.1'
//        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }
    environment{
        AWS_ACCOUNT_ID="410958652748"
        AWS_DEFAULT_REGION="eu-central-1"
        CLUSTER_NAME="CHANGE_ME"
        SERVICE_NAME="CHANGE_ME"
        TASK_DEFINITION_NAME="CHANGE_ME"
        DESIRED_COUNT="CHANGE_ME"
        IMAGE_REPO_NAME="CHANGE_ME"
        IMAGE_TAG="${env.BUILD_ID}"
        REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
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
        stage('Setup') {
            steps {
                dir ('bin') {
                    deleteDir()
                }
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
//                sh 'docker build -t demo .'
//                sh 'docker tag demo:latest 410958652748.dkr.ecr.eu-central-1.amazonaws.com/demo:latest '
//            }
//        }
        stage('Docker push to ECR') {
            steps {
                sh 'aws ecr get-login-password --region eu-central-1 | docker login --username $registryCredential --password-stdin 410958652748.dkr.ecr.eu-central-1.amazonaws.com'
                sh 'docker push 410958652748.dkr.ecr.eu-central-1.amazonaws.com/demo:latest '
            }
        }
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
