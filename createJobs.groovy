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
                    scriptPath('jenkinsfile')
                }
            }
        }
    }
}