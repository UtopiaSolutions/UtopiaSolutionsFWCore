package com.meritage.tests.menuOptions;

import com.codeborne.selenide.Condition;
import com.meritage.pages.HomePage;
import com.meritage.pages.HomesSubMenus;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class MenuOptionsTest {

    public static final String MERITAGE_URL = "http://uat.meritagehomes.com";

    @Test
    public void testArizonaSubmenuOptionTakingToArizonaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.ARIZONA);


        assertTrue(title().contains("Arizona"));
        assertTrue(url().contains("Arizona"));
        $("title").shouldHave(Condition.text("Arizona"));

//        searchPage.titleOfResult(1).shouldHave(text("Austin, TX"));
//        searchPage.urlOfResult(1).shouldHave(text("tx/austin"));
//        searchPage.excerptOfResult(1).shouldHave(text("Austin’s top-notch festivals"));
    }
}
