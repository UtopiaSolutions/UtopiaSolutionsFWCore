package com.usf;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.codeborne.selenide.impl.ScreenShotLaboratory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import java.io.IOException;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class ExtentListenerAdapter extends ExtentITestListenerClassAdapter {

    private static final Logger log = LoggerFactory.getLogger(TestLogHelper.class);

    public synchronized void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
    }

    public synchronized void onTestStart(ITestResult result){
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);

        TestLogHelper.startTestLogging(result.getMethod().getMethodName());
        log.info("Running" + result.getMethod().getMethodName());
    }


    public synchronized void onTestFailure(ITestResult result) {
        try {
            ExtentTestManager.getTest(result).fail(result.getThrowable());
            ExtentTestManager.getTest(result).addScreenCaptureFromPath(ScreenShotLaboratory.getInstance().takeScreenShot(driver(), result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    public synchronized void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
        TestLogHelper.stopTestLogging();
    }

    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest(result).pass("Test passed");
    }

    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest(result).skip(result.getThrowable());
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
}
