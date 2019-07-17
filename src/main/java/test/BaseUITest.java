package test;

import com.usf.utils.ConfigurationReader;
import com.usf.utils.logging.TestLogHelper;
import com.usf.utils.reporting.ExtentTestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BaseUITest {
    private final Logger log = LoggerFactory.getLogger(BaseUITest.class);

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
        }
    }

    @BeforeTest
    public void beforeTest() {
        log.debug("Executing @BeforeTest...");
        String name = "";
        String desc = "";
        Method[] methods = this.getClass().getMethods();

        Annotation annotation = methods[0].getAnnotation(Test.class);
        if(annotation instanceof Test) {
            Test testAnnotation = (Test) annotation;
            name = testAnnotation.testName();
            desc = testAnnotation.description();
        }
        if(!name.equals("")) {
            ExtentTestManager.startTest(name, desc);
        } else {
            ExtentTestManager.startTest(methods[0].getName(), "");
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