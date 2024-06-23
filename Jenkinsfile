
pipeline {
    agent any

    environment {
        SCREENSHOT_DIR = 'screenshots'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git url: 'https://github.com/YoussefAbdellah2023/SumergeTask.git'

                mvnHome = tool 'MAVEN_HOME'
            }
        }


        stage('Test') {
            steps {
                // Run the tests using Maven
                withEnv(["MVN_HOME=$mvnHome"]) {
                            if (isUnix()) {
                                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
                            } else {
                                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
                            }
                        }
            }
            post {
                always {
                    // Archive the test results
                    junit 'target/surefire-reports/*.xml'

                    // Archive the screenshots
                    archiveArtifacts artifacts: "${env.SCREENSHOT_DIR}/*.png", allowEmptyArchive: true
                     archiveArtifacts artifacts: '**/target/surefire-reports/**/*.png'
                }
            }
        }


    }


}

