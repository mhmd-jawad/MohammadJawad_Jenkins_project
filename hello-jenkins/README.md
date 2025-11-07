# Hello Jenkins Lab Project

A minimal Java 17 Maven project used to demonstrate a Jenkins CI pipeline with build, test, code coverage (JaCoCo), and artifact archiving.

## Project Structure
```
hello-jenkins/
  pom.xml
  Jenkinsfile
  src/main/java/com/example/app/App.java
  src/test/java/com/example/app/AppTest.java
```

## Prerequisites (Local)
- Install Java JDK 17 and ensure `java -version` shows 17.
- Install Maven (or use the Maven wrapper if added later).
- Ensure Git is installed and configured.

## Build & Test Locally (PowerShell)
```powershell
mvn -B -V clean test
```
Expected output: Surefire summary with 3 tests passing.

Generate coverage report (already bound to `verify` phase):
```powershell
mvn -B verify
```
Coverage HTML will be under `target/site/jacoco/index.html`.

Run the app:
```powershell
mvn -q -DskipTests exec:java -Dexec.mainClass="com.example.app.App"
```
(Add exec plugin if needed.) For now you can run the compiled class:
```powershell
java -cp target/classes com.example.app.App
```

## Jenkins Setup Steps
1. Global Tools Configuration:
   - Add JDK named `JDK17` (point to installed JDK or install via Jenkins plugin).
   - Add Maven named `Maven3` (point to Maven 3.x).
2. Plugins to install (Manage Jenkins > Plugins):
   - Pipeline
   - Git / Git client (usually preinstalled)
   - JaCoCo
   - JUnit (core) – included
   - (Optional) Blue Ocean for a nicer Pipeline view
3. Create a Git repository:
   - Initialize: `git init`, add remote (GitHub or local).
   - Commit all files and push.
4. In Jenkins create a new item:
   - Choose "Pipeline".
   - Definition: "Pipeline script from SCM".
   - SCM: Git, enter repository URL, credentials if private.
   - Script Path: `Jenkinsfile`.
5. Save & Build Now.
6. After build: Verify stages (Checkout, Build, Test, Package). Open "Test Results" and "JaCoCo" coverage.
7. Archive artifacts: See `target/hello-jenkins-1.0.0-SNAPSHOT.jar` under build.

## Webhook (Optional for Auto-Build)
- In GitHub: Settings > Webhooks: URL `http://<jenkins-host>:8080/github-webhook/` content type `application/json`.
- Install "GitHub Integration" plugin if needed.

## Report Evidence / Screenshots
Capture the following:
1. Jenkins Global Tool Configuration showing JDK17 & Maven3.
2. Installed Plugins page (list with JaCoCo highlighted).
3. Pipeline configuration page (SCM settings).
4. First successful build console log (top and test summary section).
5. Test Results page (3 tests green).
6. JaCoCo coverage summary page.
7. Artifact list showing the built JAR.
8. GitHub repository page with files & recent commit history.
9. Optional: Webhook delivery log (successful POST) if configured.

## Troubleshooting
- Tool not found: Ensure the names in Jenkinsfile match Global Tool names exactly (`JDK17`, `Maven3`).
- Git checkout fails: Check credentials or repository URL.
- JaCoCo report empty: Ensure tests run; do not skip tests in Test stage.
- Path issues on Windows agents: Ensure Jenkins agent is running with proper JAVA_HOME and MAVEN_HOME or rely on tool installers.

## Next Improvements
- Add Maven Wrapper.
- Add exec plugin for easier run: `mvn exec:java`.
- Add static analysis: SpotBugs or Checkstyle.
- Add branch build strategy and PR checks.
