package com.usf.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.switchTo;

public class ElementUtils {
    private static final Logger log = LoggerFactory.getLogger(ElementUtils.class);


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
        log.debug("Driver switched to frame " + frameNo);
    }
}
