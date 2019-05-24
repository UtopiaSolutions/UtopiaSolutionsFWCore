package com.usf.utils;

import com.usf.TestLogHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CoreUITest {

    private final Logger log = LoggerFactory.getLogger(CoreUITest.class);

    protected String testId ="";

    @BeforeTest
    public void testSetUp(ITestResult result) throws Exception {
        //Log that we are going to start a test
        TestLogHelper.startTestLogging(result.getTestName());
        log.debug("Starting test class: " + result.getTestClass());
    }

    @BeforeMethod
    public void methodSetUp(ITestResult result) throws Exception {
        //start logging to test specific log file
        TestLogHelper.startTestLogging(result.getMethod().getMethodName());
        log.info("Execution of test {} has started....", result.getMethod().getMethodName());
    }

    @AfterMethod
    public void methodCleanUp(ITestResult result) throws Exception {
        try {
            log.info("Ending test: " + result.getMethod().getMethodName());
            log.info("Test result: " + getTestResultText(result));
        } finally {
            TestLogHelper.stopTestLogging();
        }
    }

    @AfterTest
    public void testCleanUp(ITestResult result) throws Exception {
        log.debug("Ending test class: " + result.getTestName());
        //stop test logging to test specific file
        TestLogHelper.stopTestLogging();
    }

    public String getTestId() {
        return ((testId == null) ? (this.getClass().getName()) : testId);
    }

    public String getTestResultText(ITestResult result) {

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASS";
            case ITestResult.FAILURE:
                return "FAIL";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "INVALID STATUS";
        }
    }

}
