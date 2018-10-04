package com.meritage.tests.web;

import com.meritage.pages.web.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MenuOptionsTest {

    //public static final String MERITAGE_URL = "http://uat.meritagehomes.com";
    public static final String MERITAGE_URL = "http://meritagehomes.com";

    @Test
    public void testArizonaSubmenuOptionTakingToArizonaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.ARIZONA);

        page(ArizonaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }

    @Test
    public void testCaliforniaSubmenuOptionTakingToCaliforniaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.CALIFORNIA);

        page(CaliforniaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }

    @Test
    public void testColoradoSubmenuOptionTakingToColoradoPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.COLORADO);

        page(ColoradoPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }

    @Test
    public void testFloridaSubmenuOptionTakingToFloridaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.FLORIDA);

        page(FloridaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }
}
