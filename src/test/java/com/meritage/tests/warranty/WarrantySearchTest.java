package com.meritage.tests.warranty;

import com.meritage.pages.warranty.SalesforceHomePage;
import com.meritage.pages.warranty.SalesforceLoginPage;
import com.meritage.pages.warranty.WarrantySearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class WarrantySearchTest {

    @Test(dataProvider = "SalesforceWarrantySearchParameters")
    public void testWarrantySearch(String name, String password, String warrantySearchEmail) {

        SalesforceLoginPage salesforceLoginPage = open("http://test.salesforce.com", SalesforceLoginPage.class);

        salesforceLoginPage.loginToSalesforce(name, password);

        page(SalesforceHomePage.class)
                .verifyHomePage()
                .openWarrantySearch();

        page(WarrantySearchPage.class)
                .searchWarrantyByCustomerEmail(warrantySearchEmail);

    }


    @DataProvider(name = "SalesforceWarrantySearchParameters")
    private Object[][] getWarrantySearchParameters() {

        return new Object[][]{{"sanantonio.coordinator@meritagehomes.com.uat", "Meritage17", "XYZ_Placeholder@gmail.com"}};
    }

}
