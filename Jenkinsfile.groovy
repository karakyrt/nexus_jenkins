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
                ws("${workspace}/root/.jenkins/workspace/nexus_terraform/nexus_terraform/nexus_jenkins"){
                    sh "terraform init"
                }
            }
        }
        stage("Plan"){
            steps{
                ws("${workspace}/root/.jenkins/workspace/nexus_terraform/nexus_terraform/nexus_jenkins"){
                    sh "terraform plan"
                }  
            }
        }
        stage("Apply"){
            steps{
                ws("${workspace}/root/.jenkins/workspace/nexus_terraform/nexus_terraform/nexus_jenkins"){
                    sh "terraform apply -auto-approve"
                }
            }
        }           
    }
}
