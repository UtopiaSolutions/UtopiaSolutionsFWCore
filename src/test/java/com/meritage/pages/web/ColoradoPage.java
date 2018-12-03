package com.meritage.pages.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.meritage.pages.web.az.CommunityData;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertTrue;

public class ColoradoPage extends BaseUITestPage {

    private String state = HomesSubMenus.COLORADO.getState();
    private String stateCode = HomesSubMenus.COLORADO.getStateCode();
    private List<CommunityData> communityDataList = new ArrayList<>();
    private CommunityData activeCommunity;

    @FindBy(css = "h1.prohibition")
    private SelenideElement heading;

    public ColoradoPage verifyTitle(){
        assertTrue(title().contains(state), "Title does not contains " + state);
        return this;
    }

    public ColoradoPage verifyHeading(){
        heading.shouldHave(Condition.text(state));
        return this;
    }

    public ColoradoPage verifyURL(){
        assertTrue(url().contains(stateCode), "Page URL does not contain "+ stateCode);
        return this;
    }

    public ColoradoPage hasFollowingCommunities(List<String> communities){
        $$("h3.community--name").shouldHave(CollectionCondition.textsInAnyOrder(communities));
        return this;
    }

    public ColoradoPage community(String communityAriaLabel){
        activeCommunity = getCommunityDataObject(communityAriaLabel);
        return this;
    }

    public ColoradoPage hasCities(String ... cities){
        activeCommunity.getCities().replaceAll(String::trim);
        assertThat(activeCommunity.getCities(), Matchers.is(Arrays.asList(cities)));
        return this;
    }

    public ColoradoPage hasCityAreas(String ... cityAreas){
        activeCommunity.getCityAreas().replaceAll(String::trim);
        assertThat(activeCommunity.getCityAreas(), Matchers.is(Arrays.asList(cityAreas)));
        return this;
    }

    public ColoradoPage hasCommunitiesEqualsTo(int communities){
        assertThat(activeCommunity.getCommunities(), equalTo(communities));
        return this;
    }

    public ColoradoPage hasFloorPlansEqualsTo(int floorPlans){
        assertThat(activeCommunity.getFloorPlans(), equalTo(floorPlans));
        return this;
    }

    public ColoradoPage hasQuickMovieInHomesEqualsTo(int moveInHomes){
        assertThat(activeCommunity.getQuickMoveInHomes(), equalTo(moveInHomes));
        return this;
    }

    public ColoradoPage gatherCommunitiesData(){

        communityDataList.add(getCommunityDataObject("Denver, CO"));

        return this;
    }

}
