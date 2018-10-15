package com.meritage.pages.web;

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

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/fl']")
    public SelenideElement floridaSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/ga']")
    public SelenideElement georgiaSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/nc']")
    public SelenideElement northcarolinaSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/sc']")
    public SelenideElement southcarolinaSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/tn']")
    public SelenideElement tennesseeSubLink;

    @FindBy(css = "ul.vertical.nav--submenu a[href='/state/tx']")
    public SelenideElement texasSubLink;

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
            case FLORIDA:
                floridaSubLink.click();
                break;
            case GEORGIA:
                georgiaSubLink.click();
                break;
            case NORTH_CAROLINA:
                northcarolinaSubLink.click();
                break;
            case SOUTH_CAROLINA:
                southcarolinaSubLink.click();
                break;
            case TENNESSEE:
                tennesseeSubLink.click();
                break;
            case TEXAS:
                texasSubLink.click();
                break;
    }
    }


}
