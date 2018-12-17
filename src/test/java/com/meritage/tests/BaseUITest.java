package com.meritage.tests;

import com.meritage.pages.web.ArizonaPage;
import com.usf.TestLogHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseUITest {

    private final Logger log = LoggerFactory.getLogger(ArizonaPage.class);

    protected String testId ="";
    @BeforeMethod
    public void testSetUp(ITestResult result) throws Exception {
        //start logging to test specific log file
        TestLogHelper.startTestLogging(result.getMethod().getMethodName());

        //
        //Do some setup specific stuff here
        //
    }

    @AfterMethod
    public void testCleanUp(ITestResult result) throws Exception {
        try {
            //
            //Do some cleanup specific stuff here
            //
        } finally {
            //stop test logging to test specific file
            TestLogHelper.stopTestLogging();
        }
    }

    public String getTestId() {
        return ((testId == null) ? (this.getClass().getName()) : testId);
    }

}
