pipeline {
    agent any
    tools {
        maven '3.9.1'
//        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }
    environment{
        AWS_ACCOUNT_ID="410958652748"
        AWS_DEFAULT_REGION="eu-central-1"
        CLUSTER_NAME="custom"
        SERVICE_NAME="myTask"
        TASK_DEFINITION_NAME="spring2"
        DESIRED_COUNT="1"
        IMAGE_REPO_NAME="demo"
//         IMAGE_TAG="${env.BUILD_ID}"
        IMAGE_TAG="latest"
        REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
        registryCredential = credentials('aws')
    }
    stages {

        stage('Setup') {
            steps {
                dir ('bin') {
                    deleteDir()
                }
            }
        }
       stage('test') {
           steps {
               sh 'mvn test -f pom.xml'
           }
       }
       stage('Build maven') {
           steps {
               sh 'mvn clean package -DskipTests'
           }
       }
       stage('Build docker image') {
           steps {
               sh 'docker build -t demo .'
               sh 'docker tag demo:latest 410958652748.dkr.ecr.eu-central-1.amazonaws.com/demo:latest '
           }
       }
        stage('Docker push to ECR') {
            steps {
//                sh 'aws ecr get-login-password --region eu-central-1 | docker login --username AWS --password-stdin 410958652748.dkr.ecr.eu-central-1.amazonaws.com'
                sh 'aws ecr get-login-password --region eu-central-1 | docker login --username AWS --password-stdin $AWS_ACCOUNT_ID.dkr.ecr.eu-central-1.amazonaws.com'
                sh 'docker push $AWS_ACCOUNT_ID.dkr.ecr.eu-central-1.amazonaws.com/demo:latest '
            }
        }
             stage('Deploy') {
                steps{
                       withAWS(credentials: 'aws', region: "${AWS_DEFAULT_REGION}") {
                           script {
           			sh './script.sh'
                           }
                       }
                   }
                 }

    }
}
