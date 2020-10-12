# RequestAPItests
[![Java](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/382/h/5bd0eebcc3905821fec61d8c0c44ce8f.png)](https://www.java.com/ru/)[![Intellij Idea](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/273/h/0e0dd7da86f0500b69c2dba32af2617f.png)](https://www.jetbrains.com/ru-ru/idea/)[![Gradle](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/226/h/2c70fbe90e3ab7e01bfb0f40377519c1.png)](https://gradle.org/)[![JUnit](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/163/h/f781569bb3df25f16f9c84d3307fb274.png)](https://junit.org/junit5/)[![RestAssured](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/258/h/b958fe9e3654849a2b47c7e3bc6c2ac4.png)](https://rest-assured.io/)[![Allure](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/244/h/d044238683b3e8dad15ffb7060ee5c9c.png)](https://docs.qameta.io/allure/)[![Jenkins](https://fs.getcourse.ru/fileservice/file/download/a/159627/sc/135/h/54c3bb650bb68d170c809e5c8b1f1620.png)](https://www.jenkins.io/)
---------------

This project is implemented such as technologies and libraries as:

  - Java
  - Gradle
  - JUnit5
  - Rest Assured
  - Allure Reports (logs, screenshots)
  - Jenkins
  
 ## Test execution 
 
Test objective: https://reqres.in/

Tests created using test case scenarios and implemented Rest Assured using **GET, POST, PUT, DELETE, UPDATE** methods.
 
 In addition, you can check tests case by the link:
- https://drive.google.com/file/d/1UJteu1ReXuR1IuAkXugizHp81oC20yLG/view?usp=sharing

**During tests execution was created Allure Reports that have logs, HTTP requests**

![AllureRepurt](https://user-images.githubusercontent.com/61629124/95727608-0fc8d080-0c83-11eb-9e24-8ecb39cf1302.png)

http://192.168.0.216:63436/index.html#suites/9a8f2b1f5648a17340f3902eebd0eeab/cb59a248ce9db762/

For review test execution, you can check Jenkins implementation https://jenkins.autotests.cloud/job/RestAssuredTests/
----
## Results

![allureGraph](https://user-images.githubusercontent.com/61629124/95737966-29711480-0c91-11eb-8589-3635e7dc2ebc.png)


The result of the test execution is three failed tests that shows exist bugs such as :
- Opportunity to find already delete user;
- Free access to update info by unregistered user;
- Opportunity to login without password and login;


