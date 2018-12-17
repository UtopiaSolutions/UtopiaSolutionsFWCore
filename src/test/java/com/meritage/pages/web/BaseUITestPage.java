package com.meritage.pages.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.meritage.pages.web.az.CommunityData;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class BaseUITestPage {

    protected CommunityData getCommunityDataObject(String ariaLabel){
        SelenideElement activeAdultElement = $(String.format("div[aria-label='%s']", ariaLabel ));

        String activeAdultCommunityName = activeAdultElement.find("h3.community--name>a").getText().trim();
        String cities = activeAdultElement.find("p.community--description").getText().trim();
        String cityAreas = activeAdultElement.findElements(By.cssSelector("p.community--description")).get(1).getText().trim();
        int communitiesCount = Integer.valueOf(activeAdultElement.findElements(By.cssSelector("span.community--community-count--item>strong")).get(0).getText().trim());
        int floorPlans = Integer.valueOf(activeAdultElement.findElements(By.cssSelector("span.community--community-count--item>strong")).get(1).getText().trim());
        int quickMoveInHomes = Integer.valueOf(activeAdultElement.findElements(By.cssSelector("span.community--community-count--item>strong")).get(2).getText().trim());

        List<String> citiesList = Arrays.asList("");
        List<String> cityAreasList = Arrays.asList("");

        if (cities.split(":").length > 1) {
            citiesList = Arrays.asList(cities.split(":")[1].split(","));
        }

        if (cityAreas.split(":").length > 1) {
            cityAreasList = Arrays.asList(cityAreas.split(":")[1].split(","));
        }

        return new CommunityData(activeAdultCommunityName,citiesList, cityAreasList, communitiesCount, floorPlans, quickMoveInHomes );

    }

}
