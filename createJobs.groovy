pipelineJob('Test pipeline Job') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}

pipelineJob('bicycle-docker') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/viosif/bicycle.git'
                    }
                    branch 'master'
                    credentialsId '6148930-ff5a-430e-9e08-016d81ed7058'
                    scriptPath('jenkinsfile')
                }
            }
        }
    }
}