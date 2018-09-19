package com.meritage.pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class CaliforniaPage {

    String state = HomesSubMenus.CALIFORNIA.getState();
    String stateCode = HomesSubMenus.CALIFORNIA.getStateCode();

    @FindBy(css = "h1.prohibition")
    private SelenideElement heading;

    public CaliforniaPage verifyTitle(){
        assertTrue(title().contains(state), "Title does not contains " + state);
        return this;
    }

    public CaliforniaPage verifyHeading(){
        heading.shouldHave(Condition.text(state));
        return this;
    }

    public CaliforniaPage verifyURL(){
        assertTrue(url().contains(stateCode), "Page URL does not contain "+ stateCode);
        return this;
    }

}
