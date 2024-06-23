

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

        stage('Build') {
            steps {
                // Build the project using Maven
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run the tests using Maven
                bat 'mvn test'
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

        stage('Deploy') {
            steps {
                // Deploy the application
                bat 'scp target/your-artifact.jar user@your-server:/path/to/deploy'
            }
        }
    }


}

