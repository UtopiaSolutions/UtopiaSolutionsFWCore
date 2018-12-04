package com.meritage.tests.web.ca;

import com.meritage.pages.web.CaliforniaPage;
import com.meritage.pages.web.HomePage;
import com.meritage.pages.web.HomesSubMenus;
import com.meritage.tests.BaseUITest;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.meritage.utils.ConfigurationReader.getConfigValue;

public class CaliforniaTest  extends BaseUITest {

    @Test
    public void testArizonaSubmenuOptionTakingToCaliforniaPage() {

        HomePage homePage = open(getConfigValue("meritage_homes_url"), HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.CALIFORNIA);

        page(CaliforniaPage.class)
                .hasFollowingCommunities(Arrays.asList("Bay Area, CA Metro", "Sacramento, CA Metro", "Southern California Metro"));

        page(CaliforniaPage.class)
                .community("Bay Area, CA")
                .hasCities("Antioch", "Brentwood", "Dublin", "Fairfield", "Hayward", "Manteca", "Mountain House", "Pleasanton", "San Juan Bautista", "San Leandro")
                .hasCityAreas("Central Valley")
                .hasCommunitiesEqualsTo(14)
                .hasFloorPlansEqualsTo(50)
                .hasQuickMovieInHomesEqualsTo(56);

        page(CaliforniaPage.class)
                .community("Sacramento, CA")
                .hasCities("Elk Grove", "Rocklin", "Roseville")
                .hasCityAreas("")
                .hasCommunitiesEqualsTo(3)
                .hasFloorPlansEqualsTo(12)
                .hasQuickMovieInHomesEqualsTo(17);

        page(CaliforniaPage.class)
                .community("Southern California")
                .hasCities("Calimesa", "Costa Mesa", "Covina", "Huntington Beach", "Irvine", "Menifee", "Northridge",
                        "Rancho Mission Viejo", "San Diego", "Winchester", "Winnetka")
                .hasCityAreas("Los Angeles", "Orange County", "Riverside", "San Diego", "SoCal", "Southern California")
                .hasCommunitiesEqualsTo(13)
                .hasFloorPlansEqualsTo(34)
                .hasQuickMovieInHomesEqualsTo(44);
    }
}
