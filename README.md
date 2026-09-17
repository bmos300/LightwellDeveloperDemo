# Lightwell Developer Demo

## Overview
This demo illustrates the end-to-end integration flow from the **Red Hat Lightwell Repository** to **JFrog Artifactory**, and ultimately to the **Java Developer** using Maven for builds. 

The primary goal is to demonstrate what happens when an underlying application package changes—showing both the impact on downstream builds and how this workflow empowers developers with seamless dependency updates.

## Architecture Slide

<embed src="./docs/LightwelltoArtifactorytoVSCode.pdf" type="application/pdf" width="100%" height="600px" />%

---

## Getting Started

### Prerequisites
Before running this demo, ensure you have the following installed and configured on your local machine:

* **Java Development Kit (JDK):** Version 11 or higher
* **Apache Maven:** Version 3.8+ configured for local builds
* **Podman Desktop:** Downloaded, installed, and running locally
* **Red Hat Lightwell Repository Access:** Active account credentials/tokens configured to pull from the Red Hat Lightwell Registry
* **JFrog Artifactory Access:** Server URL and authentication token for artifact resolution

---

## Environment Setup

## 1. Setting up JFrog (Mac)

On your own download releases-docker.jfrog.io/jfrog/artifactory-oss:7.77.10
Run the following commands to create the environment directory:

```bash
rm -rf $HOME/jfrog
mkdir -p $HOME/jfrog
cd $HOME/jfrog
```

## 2. Start JFrog Artifactory
Spin up the service container using Podman Compose:

```bash
podman compose up -d
podman logs -f artifactory
podman logs artifactory | grep -i "successfully started"
```

> **Note:** Access the web interface at **http://localhost:8082** (main JFrog Gateway) rather than port 8081.

## 3. Connect Lightwell to Artifactory
> 🎬 **Note:** Due to file size limits, the video walkthrough cannot be played inline. 
> Please [download and watch the screen recording here](./Lightwell%20Repo%20Auth%20&%20Mirroring.mp4).%  

## 4. Configure Maven Integration to Maven Central and your local Artifactory

1. Move the `settings.xml` file into your local Maven directory (`~/.m2/settings.xml`):

```bash
mkdir -p ~/.m2
cp settings.xml ~/.m2/settings.xml
```

*Be sure to update `settings.xml` with your personal encrypted password or token.*

## 5. Run the Application

First take the my-app.tar.gz and uncompress and then bringup in vscode.
```bash
tar -xzf my-app.tar.gz
```

Build and execute the Java application from within vscode.:

```bash
mvn clean package
mvn exec:java -Dexec.mainClass="com.example.App"
```


[def]: ./docs/LightwelltoArtifactorytoVSCode.pdf