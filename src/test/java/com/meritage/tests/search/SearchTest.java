package com.meritage.tests.search;

import com.meritage.pages.HomePage;
import com.meritage.pages.SearchResultsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SearchTest {

    public static final String MERITAGE_URL = "http://uat.meritagehomes.com";

    @Test
    public void testSearchResultsShownWithValidData() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .searchWith("Austin")
                .searchResult()
                .shouldHave(text("831 Results for 'Austin'"));

        SearchResultsPage searchPage = page(SearchResultsPage.class);

        searchPage.titleOfResult(1).shouldHave(text("Austin, TX"));
        searchPage.urlOfResult(1).shouldHave(text("tx/austin"));
        searchPage.excerptOfResult(1).shouldHave(text("Austin’s top-notch festivals"));
    }
}
