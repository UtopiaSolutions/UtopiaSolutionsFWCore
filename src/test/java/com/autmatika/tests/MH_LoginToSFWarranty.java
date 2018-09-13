package com.autmatika.tests;

import com.autmatika.tests.withPages.mH_Warranty.SalesforceLoginPage;
import com.autmatika.tests.withPages.theInternet.HomePage;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utopia.sphnx.dataconversion.datagen.generator.DataGenerator;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MH_LoginToSFWarranty {

    @Test(dataProvider = "Authentication", description = "This is not a Meritage Homes test. This is used to smoke test the Warranty portal using the Selenide framework.", groups = "")
    public void invalidAuthenticationWithRandomData(String name, String password) {

        SalesforceLoginPage salesforceLoginPage = open("http://test.salesforce.com", HomePage.class);

        salesforceLoginPage.loginToSalesforce(name, password);
           /*     .loginWithUserNameAndPassword(name, password)
                .getSuccessMessage()
                .shouldHave(text("You logged into a secure area!")); //Sample of Declarative Assertion using Selenide (USF-7)*/
    }


}
