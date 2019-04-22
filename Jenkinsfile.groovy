node {
    stage ('Git Pull') {
        sh "git clone https://github.com/karakyrt/nexus_jenkins.git"
    }
    stage("Terraform init") {
        sh "terraform init"
    }
    stage("terraform Plan") {
        sh "terraform plan"
    }
    stage("terraform Apply") {
        sh "terraform appy"
  }
}    