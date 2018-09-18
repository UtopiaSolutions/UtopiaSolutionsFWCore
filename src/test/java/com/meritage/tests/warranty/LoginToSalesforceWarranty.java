package com.meritage.tests.warranty;

import com.meritage.pages.warranty.SalesforceLoginPage;
import com.autmatika.tests.withPages.theInternet.HomePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginToSalesforceWarranty {

    @Test(dataProvider = "Authentication", description = "This is a Meritage Homes test. This is used to smoke test the Warranty portal using the Selenide framework.", groups = "")
    public void invalidAuthenticationWithRandomData(String name, String password) {

        SalesforceLoginPage salesforceLoginPage = open("http://test.salesforce.com", SalesforceLoginPage.class);

        salesforceLoginPage.loginToSalesforce(name, password);
           /*     .loginWithUserNameAndPassword(name, password)
                .getSuccessMessage()
                .shouldHave(text("You logged into a secure area!")); //Sample of Declarative Assertion using Selenide (USF-7)*/
    }


}
