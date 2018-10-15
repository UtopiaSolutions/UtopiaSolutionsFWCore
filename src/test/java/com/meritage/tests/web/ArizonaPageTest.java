package com.meritage.tests.web;

import com.meritage.pages.web.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ArizonaPageTest {

    //public static final String MERITAGE_URL = "http://uat.meritagehomes.com";
    public static final String MERITAGE_URL = "http://meritagehomes.com";

    @Test
    public void testArizonaSubmenuOptionTakingToArizonaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.ARIZONA);
        //This is a duplicate of the validations in the MenuOptionsTest
        page(ArizonaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();

    }


}
