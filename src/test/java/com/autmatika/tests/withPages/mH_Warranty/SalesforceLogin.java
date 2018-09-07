package com.autmatika.tests.withPages.mH_Warranty;

import com.autmatika.tests.withPages.theInternet.LoginPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SalesforceLogin {

    @FindBy(id = "username")
    private SelenideElement userNameText;

    @FindBy(id = "password")
    private SelenideElement passwordText;

    @FindBy(id = "login")
    private SelenideElement signInBtn;

    @FindBy(id = "phSearchInput")
    private SelenideElement searchText;


    public SalesforceLogin loginToSalesforce(String username, String password) {

        userNameText.setValue(username);
        passwordText.setValue(password);
        signInBtn.click();

        Reporter.log("Entered username " + username + " and "  + " password " + password);
        return this;
    }

    /*public boolean validateSearchTextIsDisplayed() {
        //Using this to validate that we've landed on the SF landing page.
        return searchText.isDisplayed();
    }*/

}
