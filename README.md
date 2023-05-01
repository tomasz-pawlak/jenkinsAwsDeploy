# jenkinsAwsDeploy
Simple JavaApp which is auto deployed on AWS by Jenkins.
Jenkins is deployed on AWS EC2 instance.
App is tested, builded and then docker images is created.
Image is pushed to AWS ECR.
Last step is deploy by ECS Fargate based on ECR image.
