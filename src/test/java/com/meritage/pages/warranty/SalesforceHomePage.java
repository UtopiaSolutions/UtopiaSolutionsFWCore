package com.meritage.pages.warranty;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Condition.visible;

public class SalesforceHomePage {

    @FindBy(id = "ext-gen33")
    private SelenideElement upperLeftBtn;

    @FindBy(xpath = "//span[@class='sd_widget_btn_text_positioner'][contains(text(),'Warranty Search')]")
    private SelenideElement warrantySearchBtn; //Warranty Search Button, but may have other purposes so we've generically named it.

    public SalesforceHomePage verifyHomePage(){
        //This is the button that appears in the upper left below the Meritage Homes logo.
        upperLeftBtn.shouldBe(visible);
        return this;
    }
    public void openWarrantySearch(){
        //This clicks on the Warranty Search button.
        warrantySearchBtn.click();
    }
}
