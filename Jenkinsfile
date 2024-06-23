 environment {
        SCREENSHOT_DIR = 'screenshots'
    }

node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/YoussefAbdellah2023/SumergeTask.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        archiveArtifacts artifacts: '**/target/surefire-reports/**/*.png'
    }
}

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

