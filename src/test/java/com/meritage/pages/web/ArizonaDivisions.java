package com.meritage.pages.web;

public enum ArizonaDivisions {
    ACTIVE_ADULT_METRO("Active Adult Metro", "active-adult", "Find your Active Adult home"),
    PHOENIX_AZ_METRO("Phoenix, AZ Metro", "phoenix", "Find your Phoenix, AZ home"),
    TUCSON_AZ_METRO("Tucson, AZ Metro", "tucson", "Find your Tucson, AZ home");

    private String divisionName, metroName, buttonText;

    private ArizonaDivisions(String divisionName, String metroName, String buttonText){
        this.divisionName = divisionName;
        this.metroName = metroName;
        this.buttonText = buttonText;
    }

    public String getDivisionName(){
        return this.divisionName;
    }

    public String getMetroName(){
        return this.metroName;
    }

    public String getButtonText(){
        return this.buttonText;
    }


}
