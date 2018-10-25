package com.meritage.tests.web.az;

import com.meritage.pages.web.ArizonaPage;
import com.meritage.pages.web.HomePage;
import com.meritage.pages.web.HomesSubMenus;
import org.testng.annotations.Test;
import java.util.Arrays;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.meritage.utils.ConfigurationReader.getConfigValue;

public class ArizonaTest {

    @Test
    public void testArizonaSubmenuOptionTakingToArizonaPage() {

        HomePage homePage = open(getConfigValue("meritage_homes_url"), HomePage.class);

        homePage
                .selectHomeSubMenuOption(HomesSubMenus.ARIZONA);

        page(ArizonaPage.class)
                .hasFollowingCommunities(Arrays.asList("Active Adult Metro", "Phoenix, AZ Metro", "Tucson, AZ Metro"));

        page(ArizonaPage.class)
                .community("Active Adult")
                .hasCities("Casa Grande", "Green Valley", "Maricopa")
                .hasCityAreas("")
                .hasCommunitiesEqualsTo(6)
                .hasFloorPlansEqualsTo(29)
                .hasQuickMovieInHomesEqualsTo(27);

        page(ArizonaPage.class)
                .community("Phoenix, AZ")
                .hasCities("Buckeye", "Cave Creek", "Chandler", "Goodyear", "Maricopa", "Maricopa County",
                        "Mesa", "Peoria", "Phoenix", "Rio Verde", "San Tan Valley", "Surprise", "Tolleson")
                .hasCityAreas("East Valley", "North Phoenix", "North Scottsdale", "West Valley")
                .hasCommunitiesEqualsTo(31)
                .hasFloorPlansEqualsTo(153)
                .hasQuickMovieInHomesEqualsTo(246);

        page(ArizonaPage.class)
                .community("Tucson, AZ")
                .hasCities("Casa Grande", "Marana", "Oro Valley", "Sahuarita", "Tucson", "Vail")
                .hasCityAreas("Marana", "North Tucson", "Oro Valley", "Sahuarita", "South Tucson", "Tucson")
                .hasCommunitiesEqualsTo(15)
                .hasFloorPlansEqualsTo(49)
                .hasQuickMovieInHomesEqualsTo(77);
    }
}
