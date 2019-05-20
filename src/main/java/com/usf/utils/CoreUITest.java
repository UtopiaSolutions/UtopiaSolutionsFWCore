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

        log.debug("Running test: " + result.getTestName());
    }

    @BeforeMethod
    public void methodSetUp(ITestResult result) throws Exception {
        //start logging to test specific log file
        TestLogHelper.startTestLogging(result.getMethod().getMethodName());

        log.debug("Running method: " + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void methodCleanUp(ITestResult result) throws Exception {
        try {
            //
            //Do some cleanup specific stuff here
            //
        } finally {
            //stop method logging to test specific file
            TestLogHelper.stopTestLogging();
        }
    }

    @AfterTest
    public void testCleanUp(ITestResult result) throws Exception {
        String testResult;

        if(result.getStatus() == result.SUCCESS)

        try {
            log.debug("Ending test: " + result.getTestName() + " Test result: " + getTestResultText(result.getStatus()));
        } finally {
            //stop test logging to test specific file
            TestLogHelper.stopTestLogging();
        }
    }

    public String getTestId() {
        return ((testId == null) ? (this.getClass().getName()) : testId);
    }

    public String getTestResultText(Integer result) {

        String resultText = "";

        switch (result) {
            case ITestResult.SUCCESS:
                resultText = "PASS";
                // my expected functionality here when passed

            case ITestResult.FAILURE:
                resultText = "FAIL";
                // my expected functionality here when passed

            case ITestResult.SKIP:
                resultText = "SKIP";
                // my expected functionality here when passed

            default:
                //throw new RuntimeException("INVALID STATUS");
                resultText = "INVALID STATUS";
        }
        return resultText;
    }

}
