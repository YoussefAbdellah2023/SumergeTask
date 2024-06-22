pipeline {
    agent any

    environment {
        // Define the local paths for your frontend and backend projects

        E2E_TESTS_PATH = 'C:/Users/Youssef Abdellah/Desktop/Sumerge_Task'
    }

    stages {
        stage('Prepare') {
            steps {
                // Clean workspace
                cleanWs()
                // Copy or sync the local repository to the Jenkins workspace
                // You might need to adjust these commands based on your OS and file structure
                
                
                
            }
        }
        



        stage('Run E2E Tests') {
            steps {
               script {
						bat """						
							cd /d "${E2E_TESTS_PATH}"                    
							mvn test
						"""
                }
            }
        }
    }
    post {
        always {
            // Collect artifacts or perform cleanup
            // For example, archive the test results
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
}
