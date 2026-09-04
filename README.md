# Credo Authorization Tests

Selenium tests covering negative login scenarios for the form at
https://mycredo.ge/landing/main/authorization, run across 3 languages.

## Stack
Selenium 4, TestNG, WebDriverManager (bonigarcia), Allure, Maven Surefire, RandomStringUtils.
Page Object Model, no implicit waits (explicit waits only), SoftAssert, TestNG DataProvider,
Allure Step and Feature annotations.

## Structure
* `base` : DriverFactory (ThreadLocal, WebDriverManager) and BaseTest (TestNG lifecycle)
* `pages` : AuthorizationPage (opens the page and wires components together),
  AuthorizationPageElements (every locator on the page in one class)
* `pages/components` : LoginForm, ErrorBanner, LanguageSwitcher, one class per component
* `data` : DataProvider supplying every scenario across all 3 languages
* `utils` : RandomDataGenerator, random values via RandomStringUtils
* `tests` : AuthorizationTest

## Negative cases covered
1. Username empty, password filled
2. Password empty, username filled
3. Both fields empty
4. Both fields filled with random, wrong credentials
5. SQL injection string in both fields (`' OR 1=1 --`)
6. XSS payload in both fields (`<script>alert(1)</script>`), also checks no JavaScript
   alert actually fires
7. Username with leading and trailing whitespace

Each case runs once per language (Georgian, English, Russian), 21 test runs total.
The language switch itself is also verified (the language button label is checked
after switching, not just clicked and assumed to work).

