# Test Automation Framework

This is a java based test automation framework.

The framework leverages varios libraries and tools to facilitate data driven testing, logging, reporting and integration with cloud based testing platforms like lambdatest.


## Author

- [@ShraddhaU23](https://github.com/ShraddhaU23)
- EmailAddress : umredkarshraddha97@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/ShraddhaU23)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shraddha-umredkar/)




## 🚀 About Me
Hi, My name is Shraddha Umredkar and I have 5+ years of experience in Automation using Selenium with Java and Manual Testing.

My expertise is in creating,building and maintaining robost web based automation framework using Selenium and Java, Maven, TestNG, Data driven testing using apache poi, json.


## Prerequisites

Before running this framework, ensure the following software is installed on your system:

- Java 11 - Make sure Java is installed and the JAVA_HOME     environment variable is set.
 - Maven - Ensure Maven is installed and added to the system path.
 - Download Link : https://maven.apache.org/download.cgi

## Features
 - **Data-Driven Testing**: Using Apache POI and Gson for reading test data from Excel files and JSON.
 - **Cross-Browser Testing**: Supports running tests on different browsers.
 - **Headless Mode**: Faster execution by running tests in headless mode.
 - **Cloud Testing**: Integrated with LambdaTest to run tests on the cloud.
 - **Logging**: Uses Log4j for detailed logs.
 - **Reporting**: Generates detailed reports using Extent Reports.

 ## Techonologies Used
 - Java 11
 - TestiNG
 - Gson
 - Apache POI
 - Faker
 - Lambdatest
 - Log4j
 - Extent Reports  



## Setup Instructions

**Clone the Repository**

```bash
git clone https://github.com/ShraddhaU23/ui-automation-project.git
cd ui-automation-project
```

**Running test on LambdaTest**

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
```

## Reports and Logs
- Reports : After exceution a detailed HTML report will be generated at ./report.html.

- The report contains information about test cases exceuted, passed, failed and skipped along with screenshots for failed test cases.

## Logs
- Logs are created during the test exceution and stored in the ./logs/directory.

## Integrated the project with GitHub Actions
- This automation framework is integrated with GitHub Actions




