package com.meritage.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ArizonaPage {

    @FindBy(css = "h1.prohibition")
    public SelenideElement searchBox;

    public String getHeading(){

        return "";
    }


}
