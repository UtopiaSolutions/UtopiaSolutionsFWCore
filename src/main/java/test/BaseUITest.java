package test;

import com.usf.TestLogHelper;
import com.usf.utils.ConfigurationReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseUITest {

    private final Logger log = LoggerFactory.getLogger(BaseUITest.class);

    @BeforeTest
    public void beforeTest() {
        try {
            ConfigurationReader.readConfigurations("client_config");
        } catch (Exception e) {
            log.warn("No Configuration File found!");
        } finally {
            log.debug("Starting test class...");
        }
    }

    @AfterTest
    public void afterTest() {
        log.debug("Ending test class...");
        TestLogHelper.stopTestLogging();
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) throws Exception {
        TestLogHelper.startTestLogging(result.getMethod().getMethodName());
        log.info("Execution of test method {} has started....", result.getMethod().getTestClass() + "." + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        try {
            if (!testResult.isSuccess()) {
                log.error("Test method has failed",testResult.getThrowable());
            }

            log.info("Test method {} has passed", testResult.getMethod().getMethodName());
        } finally {
            TestLogHelper.stopTestLogging();
        }
    }
}
