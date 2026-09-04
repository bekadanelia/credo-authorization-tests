# Credo Authorization Tests

Selenium 4 + TestNG negative login tests for https://mycredo.ge/landing/main/authorization

## Stack
Selenium 4, TestNG, WebDriverManager (bonigarcia), Allure, Maven Surefire, RandomStringUtils

## Structure
* base : DriverFactory (ThreadLocal, WebDriverManager) and BaseTest (TestNG lifecycle)
* pages : AuthorizationPage, with LoginForm and ErrorBanner as separate components (POM)
* data : LoginCredentialsDataProvider, the 4 required scenarios
* utils : RandomDataGenerator, random username/password via RandomStringUtils
* tests : AuthorizationTest, one data driven test method covering all 4 scenarios

## Run
```
mvn clean test
```

## Allure report
Install the Allure commandline tool, then:
```
allure serve target/allure-results
```

