package com.meritage.pages.web.az;

import java.util.List;

public class CommunityData {

    private String communityName;
    private List<String> cities;
    private List<String> cityAreas;
    private int communities, floorPlans, quickMoveInHomes;

    public CommunityData(String communityName, List<String> cities, List<String> cityAreas, int communities, int floorPlans, int quickMoveInHomes) {
        this.communityName = communityName;
        this.cities = cities;
        this.cityAreas = cityAreas;
        this.communities = communities;
        this.floorPlans = floorPlans;
        this.quickMoveInHomes = quickMoveInHomes;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getCityAreas() {
        return cityAreas;
    }

    public void setCityAreas(List<String> cityAreas) {
        this.cityAreas = cityAreas;
    }

    public int getCommunities() {
        return communities;
    }

    public void setCommunities(int communities) {
        this.communities = communities;
    }

    public int getFloorPlans() {
        return floorPlans;
    }

    public void setFloorPlans(int floorPlans) {
        this.floorPlans = floorPlans;
    }

    public int getQuickMoveInHomes() {
        return quickMoveInHomes;
    }

    public void setQuickMoveInHomes(int quickMoveInHomes) {
        this.quickMoveInHomes = quickMoveInHomes;
    }
}
