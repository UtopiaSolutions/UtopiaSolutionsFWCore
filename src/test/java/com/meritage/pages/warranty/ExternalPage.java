package com.meritage.pages.warranty;


import com.codeborne.selenide.SelenideElement;
import com.meritage.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;


public class ExternalPage {

    @FindBy(css = "div.requiredInput textarea")
    public SelenideElement descriptionInput;


    /**
     * Sets the text in the Description text box
     * @param description
     */
    public void setDescription(String description){
        new ElementUtils().switchToRightFrame(descriptionInput);
        descriptionInput.setValue(description);
    }
}
