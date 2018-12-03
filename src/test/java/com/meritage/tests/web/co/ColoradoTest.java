package com.meritage.tests.web.co;

import com.meritage.pages.web.ArizonaPage;
import com.meritage.pages.web.ColoradoPage;
import com.meritage.pages.web.HomePage;
import com.meritage.pages.web.HomesSubMenus;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Arrays;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.meritage.utils.ConfigurationReader.getConfigValue;

public class ColoradoTest {

    @Test
    public void testColoradoSubMenuNavigationAndPageDetails() {

        HomePage homePage = open(getConfigValue("meritage_homes_url"), HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.COLORADO);

        page(ColoradoPage.class)
                .hasFollowingCommunities(Arrays.asList("Denver, CO Metro"));

        page(ColoradoPage.class)
                .community("Denver, CO")
                .hasCities("Aurora", "Brighton", "Broomfield", "Castle Pines", "Centennial", "Commerce City", "Erie", "Lafayette", "Littleton", "Longmont", "Parker", "Thornton")
                .hasCityAreas("Denver Metro Area", "Front Range")
                .hasCommunitiesEqualsTo(26)
                .hasFloorPlansEqualsTo(97)
                .hasQuickMovieInHomesEqualsTo(101);

    }
}
