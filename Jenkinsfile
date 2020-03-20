#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'jdk8'
    }
    environment {
        PROJECT_NAME = "teamwiki"
        SERVER_IP = "172.19.241.57"

        // Maven
        IMAGE = readMavenPom().getArtifactId()
        VERSION = readMavenPom().getVersion()

        // Docker
        IMAGE_NAME = "xuyangchen/${PROJECT_NAME}"
        IMAGE = "${IMAGE_NAME}:${VERSION}"
        DATA_VOLUME = "/var/data/${PROJECT_NAME}"
        LOG_VOLUME = "/var/log/${PROJECT_NAME}"
        EXPOSE_PORT = 8081
    }
    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                '''
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn -Ptest clean package'
            }
        }
        stage('SonarQube') {
            steps{  
                sh "mvn sonar:sonar -Dsonar.host.url=http://${SERVER_IP}:9000"
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker rmi -f ${PROJECT_NAME} || true"
                sh "docker build -t ${PROJECT_NAME} ."
            }
        }
        stage('Deploy') {
            steps {
                sh "docker rm -f ${PROJECT_NAME} || true"
                sh "docker run --name ${PROJECT_NAME} -p ${EXPOSE_PORT}:${EXPOSE_PORT} -v ${DATA_VOLUME}:${DATA_VOLUME} -v ${LOG_VOLUME}:${LOG_VOLUME} -d ${PROJECT_NAME}"
            }
        }
        stage('Push to Docker Hub') {
            steps {
                sh 'mvn -Pprod -DskipTests clean package'
                sh "docker build -t ${IMAGE} ."
                sh "docker push ${IMAGE}"
                sh "docker rmi ${IMAGE}"
            }
        }
    }
}