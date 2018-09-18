package com.meritage.pages.web;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(id = "quick-home-search--search-field")
    public SelenideElement searchBox;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public SelenideElement searchButton;

    public HomePage typeSearchKeyword(String keyword){
        searchBox.setValue(keyword);
        return this;
    }

    public HomePage clickSearchButton(){
        searchButton.click();
        return this;
    }

    public SearchResultsPage searchWith(String keyword){
        typeSearchKeyword(keyword)
        .clickSearchButton();
        return page(SearchResultsPage.class);
    }




}
