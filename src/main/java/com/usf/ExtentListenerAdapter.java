package com.usf;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.drivercommands.WebDriverWrapper;
import com.codeborne.selenide.impl.ScreenShotLaboratory;
import com.codeborne.selenide.impl.WebElementWrapper;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

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
