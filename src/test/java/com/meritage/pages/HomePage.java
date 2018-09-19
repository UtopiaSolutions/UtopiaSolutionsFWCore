package com.meritage.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(id = "quick-home-search--search-field")
    public SelenideElement searchBox;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public SelenideElement searchButton;

    @FindBy(css = "a[href='/homes']")
    public SelenideElement homesMenuLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/az']")
    public SelenideElement arizonaSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/ca']")
    public SelenideElement californiaSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/co']")
    public SelenideElement coloradoSubLink;

    public HomePage typeSearchKeyword(String keyword) {
        searchBox.setValue(keyword);
        return this;
    }

    public HomePage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public SearchResultsPage searchWith(String keyword) {
        typeSearchKeyword(keyword)
                .clickSearchButton();
        return page(SearchResultsPage.class);
    }

    public void selectHomeSubMenuOption(HomesSubMenus subMenuName) {
        homesMenuLink.hover();

        switch (subMenuName) {

            case ARIZONA:
                arizonaSubLink.click();
                break;
            case COLORADO:
                coloradoSubLink.click();
                break;
            case CALIFORNIA:
                californiaSubLink.click();
                break;
        }
    }


}
