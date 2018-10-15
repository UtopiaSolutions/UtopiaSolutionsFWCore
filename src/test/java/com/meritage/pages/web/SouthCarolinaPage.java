package com.meritage.pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class SouthCarolinaPage {

    String state = HomesSubMenus.SOUTH_CAROLINA.getState();
    String stateCode = HomesSubMenus.SOUTH_CAROLINA.getStateCode();

    @FindBy(css = "h1.prohibition")
    private SelenideElement heading;

    public SouthCarolinaPage verifyTitle(){
        assertTrue(title().contains(state), "Title does not contains " + state);
        return this;
    }

    public SouthCarolinaPage verifyHeading(){
        heading.shouldHave(Condition.text(state));
        return this;
    }

    public SouthCarolinaPage verifyURL(){
        assertTrue(url().contains(stateCode), "Page URL does not contain "+ stateCode);
        return this;
    }
}
