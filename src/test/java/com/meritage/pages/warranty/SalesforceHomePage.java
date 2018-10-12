package com.meritage.pages.warranty;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

public class SalesforceHomePage {


    @FindBy(id = "ext-gen33")
    private SelenideElement upperLeftBtn;

    @FindBy(xpath = "//span[@class='sd_widget_btn_text_positioner'][contains(text(),'Warranty Search')]")
    private SelenideElement warrantySearchBtn; //Warranty Search Button, but may have other purposes so we've generically named it.

    @FindBy(xpath = "//span[@class='tabText' and contains(text(), 'External Page')]")
    private SelenideElement externalPageTab;

    /**
     * Verify whether we successfully logged in
     * @return
     */
    public SalesforceHomePage verifyHomePage(){
        //This is the button that appears in the upper left below the Meritage Homes logo.
        upperLeftBtn.shouldBe(visible);
        return this;
    }

    /**
     * Open warranty search page by clicking at the bottom
     */
    public void openWarrantySearch(){
        warrantySearchBtn.click();
    }

    public ExternalPage selectExternalPage(){
        externalPageTab.click();
        return page(ExternalPage.class);
    }

    public boolean isExternalPageTabPresent(){
        switchTo().defaultContent();
        if(externalPageTab.exists()){
            return externalPageTab.isDisplayed();
        }
        return false;
    }


}
