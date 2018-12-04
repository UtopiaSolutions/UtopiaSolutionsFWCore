package com.meritage.pages.warranty;

import com.codeborne.selenide.SelenideElement;
import com.meritage.pages.web.HomePage;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.meritage.utils.ConfigurationReader.getConfigValue;

public class SalesforceLoginPage {

    private final Logger log = LoggerFactory.getLogger(SalesforceLoginPage.class);

    @FindBy(id = "username")
    private SelenideElement userNameText;

    @FindBy(id = "password")
    private SelenideElement passwordText;

    @FindBy(id = "Login")
    private SelenideElement signInBtn;


    /**
     * Login to Salesforce application
     * @param username
     * @param password
     * @return
     */
    public SalesforceLoginPage loginToSalesforce(String username, String password) {

        log.info("Enter username {}", username );
        userNameText.setValue(username);

        log.info("Enter password {}", password );
        passwordText.setValue(password);

        log.info("Click submit button");
        signInBtn.click();

        Reporter.log("Entered username " + username + " and "  + " password " + password);
        return this;
    }


    /**
     * Login to warranty page
     * @param name
     * @param password
     */
    public void loginToSalesforceWarranty(String name, String password) {

        SalesforceLoginPage salesforceLoginPage = open(getConfigValue("app_url"), SalesforceLoginPage.class);

        salesforceLoginPage.loginToSalesforce(name, password);

        page(SalesforceHomePage.class).verifyHomePage();
    }

}
