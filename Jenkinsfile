

pipeline {
    agent any

    environment {
        SCREENSHOT_DIR = 'screenshots'
    }



        stage('Test') {
            steps {
                // Run the tests using Maven
                sh 'mvn test'
            }
            post {
                always {
                    // Archive the test results
                    junit 'target/surefire-reports/*.xml'

                    // Archive the screenshots
                    archiveArtifacts artifacts: "${env.SCREENSHOT_DIR}/*.png", allowEmptyArchive: true
                }
            }
        }


    }

    post {
        always {
            // Clean up after the build
            cleanWs()
        }

        success {
            // Notify success
            echo 'Build, test, and deployment successful!'
        }

        failure {
            // Notify failure
            echo 'Build, test, or deployment failed.'
        }
    }
}

