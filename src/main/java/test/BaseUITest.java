package test;

import com.usf.utils.ConfigurationReader;
import com.usf.utils.logging.TestLogHelper;
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
    public void readConfigs() {
        log.debug("Executing readConfigs()...");
        try {
            ConfigurationReader.readConfigurations("client_config");
        } catch (Exception e) {
            ConfigurationReader.readConfigurations();
            log.warn("No Configuration File found!");
        } finally {
            log.debug("Configurations loaded.");
        }
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

    @AfterTest
    public void afterTest() {
        log.debug("Executing @AfterTest...");
        TestLogHelper.stopTestLogging();
    }

}