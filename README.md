# JFrog Lightwell Demo

## Prerequisites
Ensure Podman and Maven are installed on your machine before setup[cite: 1].

## 1. Environment Setup (Mac)
Run the following commands to create the environment directory[cite: 1]:

```bash
rm -rf $HOME/jfrog
mkdir -p $HOME/jfrog
cd $HOME/jfrog
```

## 2. Start JFrog Artifactory
Spin up the service container using Podman Compose[cite: 1]:

```bash
podman compose up -d
podman logs -f artifactory
podman logs artifactory | grep -i "successfully started"
```

> **Note:** Access the web interface at **http://localhost:8082** (main JFrog Gateway) rather than port 8081[cite: 1].

## 3. Configure Maven Integration
1. Connect Lightwell to JFrog and connect your editor (VS Code) to JFrog[cite: 1].
2. Move the `settings.xml` file into your local Maven directory (`~/.m2/settings.xml`)[cite: 1]:

```bash
mkdir -p ~/.m2
cp settings.xml ~/.m2/settings.xml
```

*Be sure to update `settings.xml` with your personal encrypted password or token[cite: 1].*

## 4. Run the Application
Build and execute the Java application[cite: 1]:

```bash
mvn clean package
mvn exec:java -Dexec.mainClass="com.example.App"
```