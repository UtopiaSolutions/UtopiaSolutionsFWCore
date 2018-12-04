package com.meritage.tests.web;

import com.meritage.pages.web.*;
import com.meritage.tests.BaseUITest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MenuOptionsTest  extends BaseUITest {

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

    @Test
    public void testGeorgiaSubmenuOptionTakingToGeorgiaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.GEORGIA);

        page(GeorgiaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }

    @Test
    public void testNorthCarolinaSubmenuOptionTakingToNorthCarolinaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.NORTH_CAROLINA);

        page(NorthCarolinaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }

    @Test
    public void testSouthCarolinaSubmenuOptionTakingToSouthCarolinaPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.SOUTH_CAROLINA);

        page(SouthCarolinaPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }

    @Test
    public void testTennesseeSubmenuOptionTakingToTennesseePage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.TENNESSEE);

        page(TennesseePage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }
    @Test

    public void testTexasSubmenuOptionTakingToTexasPage() {

        HomePage homePage = open(MERITAGE_URL, HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.TEXAS);

        page(TexasPage.class)
                .verifyTitle()
                .verifyURL()
                .verifyHeading();
    }
}
