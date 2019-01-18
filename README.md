# USF
Utopia Selenium Framework

A super cool and easy to use browser and Rest api tests automation framework in Java. It has all the feature which a developer or a quality engineer would like to have in his toolbox.

1. Selenide - A test framework to keep you away from all the hassels of Selenium setup.
2. Extent Report - A beautiful and useful HTML report to analyze you test runs.
3. Logging - Generate log messages for every test in seperate files to simplify analysis.
4. RestAssured - To enable its users to write RESTApi tests.
5. Selenim Grid - Along with local machine tests can be executed on Grid hosted on Zalenium or SauceLabs.

Pre-requisites:
1. Java > 1.8
2. Maven
3. Git
4. Desired browser installed

How to run tests:

Move to your terminal in root folder.

To run only API tests
`mvn clean test -PAllApiTests`

To run only UI tests
`mvn clean test -PAllUiTests`

To run all tests
`mvn clean test -PAll`

To run tests on Selenium Grid
`mvn clean test -Dselenide.remote=http://52.23.15.221:4444/wd/hub`

To run tests on specific browser
`mvn clean test -Dselenide.browser=chrome`


Find your execution reports at
`test-output/HtmlReport/ExtentHtml.html`

Find your logs at
`target/logs`
# SampleApplication
