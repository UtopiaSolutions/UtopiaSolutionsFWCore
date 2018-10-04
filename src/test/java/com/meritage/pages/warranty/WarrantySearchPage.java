package com.meritage.pages.warranty;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;

public class WarrantySearchPage {
    //@FindBy(id = "j_id0:j_id3:Warrantysearch:j_id10:j_id11")
    //private SelenideElement searchNowBtn;

    //@FindBy(id = "j_id0:j_id3:Warrantysearch:j_id17:j_id36:Email")
    //private SelenideElement customerEmailAddress;

    public WarrantySearchPage searchWarrantyByCustomerEmail(String email) {

//Switch to inner frame
        Selenide.switchTo().defaultContent();
        WebDriverRunner.getWebDriver().switchTo().frame("ext-comp-1011");

//Set Email Address
        $(By.cssSelector("input[id*='Email']")).setValue("hemant@example.com");

//Click Search Now
        $(By.cssSelector("div.pbBottomButtons input[id*='Warrantysearch']")).click();

        Reporter.log("Entered email in Warranty Search Email field " + email);
        return this;
    }

    /*public boolean validateSearchTextIsDisplayed() {
        //Using this to validate that we've landed on the SF landing page.
        return searchText.isDisplayed();
    }*/


}
