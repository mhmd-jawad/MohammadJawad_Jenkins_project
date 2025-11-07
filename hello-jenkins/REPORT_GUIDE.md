# Lab Report Guide – Jenkins CI

Use this checklist to produce your submission. Replace placeholders with your own screenshots and notes.

## Project and Environment
- Java version output:
  - Screenshot: `java -version`
- Maven version output:
  - Screenshot: `mvn -version`
- Git version output:
  - Screenshot: `git --version`

## Jenkins Configuration
1. Global Tool Configuration
   - Screenshot: Manage Jenkins > Tools showing:
     - JDK installations: name `JDK17` and home/version
     - Maven installations: name `Maven3` and home/version
2. Plugins
   - Screenshot: Manage Jenkins > Plugins > Installed (highlight Pipeline, Git, JaCoCo)

## Job Setup
3. Job Creation
   - Screenshot: New Item dialog selecting "Pipeline"
   - Screenshot: Job configuration page – "Pipeline script from SCM" with your Git URL
   - Screenshot: Branch specifier and Jenkinsfile path (default `Jenkinsfile`)

## Build Evidence
4. First Successful Build
   - Screenshot: Build history with #1 succeeded (green)
   - Screenshot: Console Output (header + where Maven tests run)
5. Test Results
   - Screenshot: Test Result page (3 tests passed)
6. Code Coverage
   - Screenshot: JaCoCo report summary (class/method/line coverage)
   - Optional: HTML report snippet (`target/site/jacoco/index.html` opened in browser)
7. Artifacts
   - Screenshot: Archived artifacts panel with JAR listed

## Source Control
8. Repository
   - Screenshot: GitHub repository page with files and recent commit
   - Optional: Webhook delivery log showing 200 (Settings > Webhooks)

## Notes and Observations
- What each stage does and any issues you fixed.
- One improvement you would add next (e.g., static analysis, pipeline library, parallel stages).

