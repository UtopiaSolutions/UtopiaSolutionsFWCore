package com.usf;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.codeborne.selenide.impl.ScreenShotLaboratory;
import org.testng.ITestResult;
import java.io.IOException;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class ExtentListenerAdapter extends ExtentITestListenerClassAdapter {

    public synchronized void onTestFailure(ITestResult result) {
        try {
            ExtentTestManager.getTest(result).fail(result.getThrowable());
            ExtentTestManager.getTest(result).addScreenCaptureFromPath(ScreenShotLaboratory.getInstance().takeScreenShot(driver(), result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
