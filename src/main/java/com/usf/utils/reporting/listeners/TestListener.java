package com.usf.utils.reporting.listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.usf.utils.reporting.ExtentManager;
import com.usf.utils.reporting.ExtentTestManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseUITest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener extends BaseUITest implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("*** Test Suite " + context.getName() + " started ***");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("*** Test Suite " + context.getName() + " ending ***");
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("*** Running test method " + result.getMethod().getMethodName() + "...");
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        WebDriver driver = getWebDriver();
        try {
            String screenshot = captureScreen(driver, generateFileName(result));

            ExtentTestManager.getTest().fail("Screenshot: " + ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot));
        } catch (IOException e) {
            ExtentTestManager.getTest().fail("Could not capture screenshot.");
            log.error("Could not capture screenshot.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    public static String captureScreen(WebDriver driver, String screenName) throws IOException{

        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String FILE_SEPARATOR = System.getProperty("file.separator");
        String dest = System.getProperty("user.dir") + FILE_SEPARATOR
                + "reports" + FILE_SEPARATOR
                + "screenshots" + FILE_SEPARATOR
                + screenName + ".png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);

        return dest;
    }

    public static String generateFileName(ITestResult result){
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
        Date date = new Date();
        String fileName = result.getName()+ "_" + dateFormat.format(date);
        return fileName;
    }

}