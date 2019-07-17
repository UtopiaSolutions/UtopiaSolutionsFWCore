package com.usf.utils.reporting.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.usf.utils.reporting.ExtentManager;
import com.usf.utils.reporting.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseUITest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
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
//        try {
//            //Take base64Screenshot screenshot.
//            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).
//                    getScreenshotAs(OutputType.BASE64);
//            ExtentTestManager.getTest().log(Status.FAIL, "Click for image details --> ",
//                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//        } catch (IOException e) {
//            log.error("Screenshot could not be captured.");
//            ExtentTestManager.getTest().fail("Screenshot could not be captured.");
//        }
        String targetLocation = null;
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        String testClassName = result.getClass().toString();
        String testMethodName = result.getName().trim();
        String screenShotName = testMethodName + "_" + timeStamp + ".png";
        String FILE_SEPARATOR = System.getProperty("file.separator");
        String FOLDER_PATH = System.getProperty("user.dir") + FILE_SEPARATOR + "reports" + FILE_SEPARATOR + "screenshots";
        log.info("Screen shots reports path - " + FOLDER_PATH);


        try {
            File file = new File(FOLDER_PATH + FILE_SEPARATOR + testClassName); // Set screenshots folder
            if (!file.exists()) {
                if (file.mkdirs()) {
                    log.info("Directory: " + file.getAbsolutePath() + " is created!");
                } else {
                    log.info("Failed to create directory: " + file.getAbsolutePath());
                }

            }

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            targetLocation = FOLDER_PATH + FILE_SEPARATOR + testClassName + FILE_SEPARATOR + screenShotName;// define location
            File targetFile = new File(targetLocation);
            log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
            log.info("Target File location - " + targetFile.getAbsolutePath());
            FileHandler.copy(screenshotFile, targetFile);

        } catch (FileNotFoundException e) {
            log.error("File not found exception occurred while taking screenshot " + e.getMessage());
        } catch (Exception e) {
            log.error("An exception occurred while taking screenshot " + e.getCause());
        }

        // attach screenshots to report
        try {
            ExtentTestManager.getTest().fail("Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
        } catch (IOException e) {
            log.error("An exception occured while taking screenshot " + e.getCause());
        }
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
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

}