pipeline{
    agent any
    stages{
        stage("Git Pull"){
            steps{
                git 'https://github.com/karakyrt/nexus_jenkins.git'
            }
        }
        stage("Initialization"){
            steps{
                sh "terraform init"
                }
            }
        }
        stage("Plan"){
            steps{
                sh "terraform plan"
                }  
            }
        }
        stage("Apply"){
            steps{
                sh "terraform apply -auto-approve"
                }
            }
        }           
    }
}