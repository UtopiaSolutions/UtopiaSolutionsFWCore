package com.meritage.pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class GeorgiaPage {
    String state = HomesSubMenus.GEORGIA.getState();
    String stateCode = HomesSubMenus.GEORGIA.getStateCode();

    @FindBy(css = "h1.prohibition")
    private SelenideElement heading;

    public GeorgiaPage verifyTitle(){
        assertTrue(title().contains(state), "Title does not contains " + state);
        return this;
    }

    public GeorgiaPage verifyHeading(){
        heading.shouldHave(Condition.text(state));
        return this;
    }

    public GeorgiaPage verifyURL(){
        assertTrue(url().contains(stateCode), "Page URL does not contain "+ stateCode);
        return this;
    }
}
