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
    stage('Run E2E Tests') {

        sh 'mvn test'
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        archiveArtifacts artifacts: '**/target/surefire-reports/**/*.png'
         archiveArtifacts artifacts: '${env.SCREENSHOT_DIR}/*.png', allowEmptyArchive: true
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

