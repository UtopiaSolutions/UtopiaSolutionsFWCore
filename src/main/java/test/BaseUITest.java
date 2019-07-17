package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.usf.utils.ConfigurationReader;
import com.usf.utils.logging.TestLogHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseUITest {
    private final Logger log = LoggerFactory.getLogger(BaseUITest.class);

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest extentTest;

    @BeforeClass
    public void readConfigs() {
        log.debug("Executing @BeforeClass...");
        try {
            ConfigurationReader.readConfigurations("client_config");
        } catch (Exception e) {
            ConfigurationReader.readConfigurations();
            log.warn("No Configuration File found!");
        } finally {
            log.debug("Configurations loaded.");

            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\reports\\test-results.html");
            extent = new ExtentReports(); // create new Extent Report Object
            extent.attachReporter(htmlReporter);

            htmlReporter.config().setDocumentTitle("Test Automation Report"); // Tittle of Report
            htmlReporter.config().setReportName("Test Results"); // Name of the report
            htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

        }
    }

    @BeforeTest
    public void setupTestReport() {
        log.debug("Executing @BeforeTest...");

        String name = "";
        String desc = "";
        Method[] methods = this.getClass().getMethods();

        Annotation annotation = methods[0].getAnnotation(Test.class);
        if (annotation instanceof Test) {
            Test testAnnotation = (Test) annotation;
            name = testAnnotation.testName();
            desc = testAnnotation.description();
        }
        if (!name.equals("")) {
            extentTest = extent.createTest(name, desc);
        } else {
            extentTest = extent.createTest(methods[0].getName(), "");
        }
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) throws Exception {
        TestLogHelper.startTestLogging(result.getMethod().getMethodName());
        log.info("Execution of test method {} has started....", result.getMethod().getTestClass() + "." + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            //MarkupHelper is used to display the output in different colors
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName() + " - Test Case Failed", ExtentColor.RED));
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
            //Get driver from BaseTest and assign to local webDriver variable.
            WebDriver webDriver = getWebDriver();
            //Take base64Screenshot screenshot.
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).
                    getScreenshotAs(OutputType.BASE64);
            extentTest.fail("Test Case Failed Snapshot is below " + extentTest.addScreenCaptureFromBase64String(base64Screenshot));
        } else if (testResult.getStatus() == ITestResult.SKIP) {
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (testResult.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
        }

        TestLogHelper.stopTestLogging();

    }

    @AfterTest
    public void afterTest() {
        log.debug("Executing @AfterTest...");
        TestLogHelper.stopTestLogging();
    }

}