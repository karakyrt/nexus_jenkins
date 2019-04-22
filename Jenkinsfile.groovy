
node {
    properties([parameters([string(defaultValue: 'Apply', description: 'What parameters you want to use??', name: 'Terraform_Plan_Apply_Destroy', trim: true)])])
    stage("git pull"){
        sh "git clone 'https://github.com/karakyrt/nexus_jenkins.git'"
    }
    stage("Terraform init"){
        sh "terraform init" --auto-approve"
    }
    stage("terraform Plan"){
        sh "terraform plan --auto-approve"
    }
    stage("terraform Apply"){
        sh "terraform appy --auto-approve"
  }
}  