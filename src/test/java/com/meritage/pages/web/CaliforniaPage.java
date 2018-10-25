package com.meritage.pages.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.meritage.pages.web.az.CommunityData;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class CaliforniaPage  extends BaseUITestPage{

    String state = HomesSubMenus.CALIFORNIA.getState();
    String stateCode = HomesSubMenus.CALIFORNIA.getStateCode();
    private List<CommunityData> communityDataList = new ArrayList<>();
    private CommunityData activeCommunity;


    @FindBy(css = "h1.prohibition")
    private SelenideElement heading;

    public CaliforniaPage verifyTitle(){
        assertTrue(title().contains(state), "Title does not contains " + state);
        return this;
    }

    public CaliforniaPage verifyHeading(){
        heading.shouldHave(Condition.text(state));
        return this;
    }

    public CaliforniaPage verifyURL(){
        assertTrue(url().contains(stateCode), "Page URL does not contain "+ stateCode);
        return this;
    }

    public CaliforniaPage hasFollowingCommunities(List<String> communities){
        $$("h3.community--name").shouldHave(CollectionCondition.textsInAnyOrder(communities));
        return this;
    }

    public CaliforniaPage community(String communityAriaLabel){
        activeCommunity = getCommunityDataObject(communityAriaLabel);
        return this;
    }

    public CaliforniaPage hasCities(String ... cities){
        activeCommunity.getCities().replaceAll(String::trim);
        assertThat(activeCommunity.getCities(), Matchers.is(Arrays.asList(cities)));
        return this;
    }

    public CaliforniaPage hasCityAreas(String ... cityAreas){
        activeCommunity.getCityAreas().replaceAll(String::trim);
        assertThat(activeCommunity.getCityAreas(), Matchers.is(Arrays.asList(cityAreas)));
        return this;
    }

    public CaliforniaPage hasCommunitiesEqualsTo(int communities){
        assertThat(activeCommunity.getCommunities(), equalTo(communities));
        return this;
    }

    public CaliforniaPage hasFloorPlansEqualsTo(int floorPlans){
        assertThat(activeCommunity.getFloorPlans(), equalTo(floorPlans));
        return this;
    }

    public CaliforniaPage hasQuickMovieInHomesEqualsTo(int moveInHomes){
        assertThat(activeCommunity.getQuickMoveInHomes(), equalTo(moveInHomes));
        return this;
    }


}

