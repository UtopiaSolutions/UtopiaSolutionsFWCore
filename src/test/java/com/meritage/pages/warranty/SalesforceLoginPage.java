package com.meritage.pages.warranty;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SalesforceLoginPage {

    @FindBy(id = "username")
    private SelenideElement userNameText;

    @FindBy(id = "password")
    private SelenideElement passwordText;

    @FindBy(id = "Login")
    private SelenideElement signInBtn;


    public SalesforceLoginPage loginToSalesforce(String username, String password) {

        userNameText.setValue(username);
        passwordText.setValue(password);
        signInBtn.click();

        Reporter.log("Entered username " + username + " and "  + " password " + password);
        return this;
    }

    public void loginToSalesforceWarranty(String name, String password) {

        SalesforceLoginPage salesforceLoginPage = open("http://test.salesforce.com", SalesforceLoginPage.class);

        salesforceLoginPage.loginToSalesforce(name, password);

        page(SalesforceHomePage.class).verifyHomePage();
    }

}
