package com.meritage.pages.warranty;


import com.codeborne.selenide.SelenideElement;
import com.meritage.utils.ElementUtils;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class WarrantySearchPage {

    @FindBy(css = "div.pbBottomButtons input[id*='Warrantysearch']")
    public SelenideElement searchNowBtn;

    @FindBy(xpath = "//span[@class='sd_widget_btn_text_positioner'][contains(text(),'Warranty Search')]")
    public SelenideElement warrantySearchBtn;

    @FindBy(css = "input[id*='Email']")
    public SelenideElement customerEmailAddress;


    public WarrantySearchPage searchWarrantyByCustomerEmail(String email) {

        warrantySearchBtn.click();
        new ElementUtils().switchToRightFrame(customerEmailAddress);
        customerEmailAddress.setValue(email);
        searchNowBtn.click();

        Reporter.log("Entered email in Warranty Search Email field " + email);
        return this;
    }

    /*public boolean validateSearchTextIsDisplayed() {
        //Using this to validate that we've landed on the SF landing page.
        return searchText.isDisplayed();
    }*/




}
