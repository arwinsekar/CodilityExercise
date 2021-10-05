Codility Test
=============
Built using Java, Selenium-Gradle, Cucumber.

Exercise on testscriptdemo.com website

### **Scenarios covered**
    Given I add four "<SearchCategory>" different products to my wishlist
    When I view my wishlist table and find total four "<ItemCount>" selected items in my wishlist
    And I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in cart

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
-p
html:TestResults/Reports/cucumber-report.html
-p
json:TestResults/Reports/cucumber-report.json
    ```
    - Feature or folder path: `/path/to/features`
        - Example `/Users/your_username/project_name/src/test/resources/features`

### **Test Results**
- Reports and screenshots are located here for local viewing!!! ```C:\Users\yourUserHere\git-projects\projectName\TestResults```
- Cucumber report attached
![cucumber report](https://user-images.githubusercontent.com/66088198/136119320-974cd55b-a5a4-4abe-b127-a905915d5e0e.png)


### **Author**
**_Arwin_**
