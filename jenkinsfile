pipeline
{
agent any
stages{
stage('Compile Stage')
    {
  step{
          withMaven(maven:'MAVEN_HOME')
        {
            sh 'mvn clean compile'

         }
      }
    }
  stage('Testing Stage'){
        step{
                withMaven(mvn:'MAVEN_HOME')
                {
                    sh 'mvn test'
                 }
              }
           }

  stage('Deployment Stage'){
    step{
              withMaven(mvn:'MAVEN_HOME')
                  {
                      sh 'mvn deploy'
                   }
                }
             }
      }
 }