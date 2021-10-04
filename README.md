Codility Test
=============
Built using Java, Selenium-Gradle, Cucumber.

Exercise on testscriptdemo.com website

### **Scenarios covered**
1. Order a T-shirt and verify in order history
2. Update personal information (first name) in My Account.

### **How To Run Tests**
**Gradle Wrapper Command Line Test Runs** 
- Open your `Terminal/Powershell`(if you open the terminal from intelliJ you don't need to cd) and `cd`(_**change directory**_) to `project path` on your system
- Example: `C:\Users\yourUserHere\git-projects\projectName`
    - now that we are in the project directory we can use `gradlew tasks` to get more info about the project and how to run tests with it. Scroll up and locate the cucumber groups for project info!  
        - **NOTE:** use `.\gradlew` with powershell !!!
- Run the project with this command
    ```
    gradlew clean build practiceEnv runTest cucumber
    ```            
**IntelliJ**

Create a run configuration. This will allow you to run Scenarios by right clicking them and selecting run in IntelliJ
- Create new Cucumber Java run configuration: `Run` > `Edit Configurations` > `Templates` > `Cucumber Java`
    - Main class: `io.cucumber.core.cli.Main`
    - Glue: `Com.Test.Codility.setup Com.Test.Codility.test.steps`
    - Program Arguments _(copy and paste this into the program arguments after expanding)_
    ```
    -p
    pretty
    --add-plugin
    de.monochromata.cucumber.report.PrettyReports:TestResults/Reports/cucumber-html
    -p
    json:TestResults/Reports/cucumber-report.json
    ```
    - Feature or folder path: `/path/to/features`
        - Example `/Users/your_username/project_name/src/test/resources/features`

### **Test Results**
- Reports and screenshots are located here for local viewing!!! ```C:\Users\yourUserHere\git-projects\projectName\TestResults```
- Cucumber report attached
![CodilityExerciseCucumberReport](https://user-images.githubusercontent.com/83782547/117734694-e3127280-b1eb-11eb-86b1-27d709225a99.PNG)

### **Author**
**_Arwin_**
