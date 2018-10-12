package com.meritage.tests.warranty;

import com.meritage.pages.warranty.SalesforceHomePage;
import com.meritage.pages.warranty.SalesforceLoginPage;
import com.meritage.pages.warranty.WarrantySearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.meritage.utils.ConfigurationReader.getConfigValue;

public class WarrantySearchTest {

    @DataProvider(name = "SalesforceWarrantySearchParameters")
    private Object[][] getWarrantySearchParameters() {

        return new Object[][]{{"sanantonio.coordinator@meritagehomes.com.uat", "Meritage17", "qa.utopia.two+1@gmail.com"}};
    }

    @Test(dataProvider = "SalesforceWarrantySearchParameters")
    public void testWarrantySearch(String name, String password, String warrantySearchEmail) {

        SalesforceLoginPage salesforceLoginPage = open(getConfigValue("app_url"), SalesforceLoginPage.class);

        salesforceLoginPage.loginToSalesforce(name, password);

        page(SalesforceHomePage.class)
                .verifyHomePage()
                .openWarrantySearch();

        page(WarrantySearchPage.class)
                .searchWarrantyByCustomerEmail(warrantySearchEmail)
                .openNewWarrantyCase(1)
                .setDescription("Utopia");

    }



}
