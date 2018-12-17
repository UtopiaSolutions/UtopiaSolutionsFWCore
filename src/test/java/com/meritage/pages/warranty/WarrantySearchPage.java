package com.meritage.pages.warranty;


import com.codeborne.selenide.SelenideElement;
import com.meritage.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class WarrantySearchPage {

    @FindBy(css = "div.pbBottomButtons input[id*='Warrantysearch']")
    public SelenideElement searchNowBtn;

    @FindBy(xpath = "//span[@class='sd_widget_btn_text_positioner'][contains(text(),'Warranty Search')]")
    public SelenideElement warrantySearchBtn;

    @FindBy(css = "input[id*='Email']")
    public SelenideElement customerEmailAddress;


    /**
     * Search with Customer Email
     * @param email
     * @return
     */
    public WarrantySearchPage searchWarrantyByCustomerEmail(String email) {

        warrantySearchBtn.click();
        new ElementUtils().switchToRightFrame(customerEmailAddress);
        customerEmailAddress.setValue(email);
        searchNowBtn.click();

        Reporter.log("Entered email in Warranty Search Email field " + email);
        return this;
    }


    /**
     *
     * @return array of Headings
     */
    public String[] getTableHeadings(){
        return $("table.list>thead").getText().split("\n");
    }

    /**
     * Get table cell element
     * @param row
     * @param col
     * @return WebElement corresponding to required cell
     */
    public WebElement getTableCellElement(int row, int col){
        return $("table.list")
                .findElements(By.tagName("tr"))
                .get(row)
                .findElements(By.tagName("td"))
                .get(col);
    }

    /**
     * Open New Warranty when it's already open on not
     * @param row
     * @return
     */
    public ExternalPage openNewWarrantyCase(int row){
        if(page(SalesforceHomePage.class).isExternalPageTabPresent()){
            return page(SalesforceHomePage.class).selectExternalPage();
        }

        getTableCellElement(row,0).click();
        return page(ExternalPage.class);
    }




}
