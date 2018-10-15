package com.meritage.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.switchTo;

public class ElementUtils {

    /**
     * It switch the driver to the right frame according to the element
     * @param element
     */
    public void switchToRightFrame(SelenideElement element){
        //Switch to the right frame
        switchTo().defaultContent();
        int frameNo = 0;
        while (!element.exists()) {
            switchTo().defaultContent();
            WebDriverRunner.getWebDriver().switchTo().frame(frameNo++);
        }
    }

    public void clickOnElement(SelenideElement element){
        element.click();
    }
}
