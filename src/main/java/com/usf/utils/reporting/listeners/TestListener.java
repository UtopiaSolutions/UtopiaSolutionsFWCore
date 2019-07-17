package com.usf.utils.reporting.listeners;

import com.aventstack.extentreports.Status;
import com.usf.utils.reporting.ExtentManager;
import com.usf.utils.reporting.ExtentTestManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseUITest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener extends BaseUITest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        try {
            logWithScreenshot(Status.FAIL, "Test " + result.getMethod().getMethodName()
                    + " has failed:    " + result.getThrowable());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(Status.FAIL, "Unable to capture screenshot of " + result.getMethod().getMethodName()
                    + " failure:    " + result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }


    private static void logWithScreenshot(Status status, String message) throws Exception {
        try {
            ExtentTestManager.getTest().log(status, message, createScreenCaptureFromPath(getBase64ScreenShot()).build());
        } catch (IOException e) {
            throw new Exception("There was an error capturing a screenshot for the log.");
        }
    }
    private static String getBase64ScreenShot() throws Exception {
        WebDriver driver = getWebDriver();

        Dimension screenDimensions = driver.manage().window().getSize();
        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        Rectangle screen = new Rectangle(x, y, screenDimensions.getWidth(), screenDimensions.getHeight());

        BufferedImage screenCapture;
        String base64Encoded;

        try {
            screenCapture = new Robot().createScreenCapture(screen);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenCapture, "png", baos);
            baos.flush();
            byte[] encodeBase64 = Base64.getEncoder().encode(baos.toByteArray());
            base64Encoded = new String(encodeBase64);
            baos.close();
        } catch (AWTException awte) {
            throw new Exception("There was an error converting the image to base64.");
        } catch (IOException ioe) {
            throw new Exception("There was an error capturing the screen image.");
        }

        return base64Encoded;
    }
}