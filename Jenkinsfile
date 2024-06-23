

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

 stage('Result') {

               // Collect artifacts or perform cleanup
               // For example, archive the test results
               archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts artifacts: 'target/surefire-reports/*.png'



       }

}




