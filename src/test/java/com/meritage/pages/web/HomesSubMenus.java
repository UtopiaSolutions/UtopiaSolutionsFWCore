package com.meritage.pages.web;

public enum  HomesSubMenus {

    ARIZONA("Arizona", "az"),
    CALIFORNIA("California", "ca"),
    COLORADO("Colorado", "co"),
    FLORIDA("Florida", "fl"),
    GEORGIA("Georgia", "ga"),
    NORTH_CAROLINA("North Carolina", "nc"),
    SOUTH_CAROLINA("South Carolina", "sc"),
    TENNESSEE("Tennessee", "tn"),
    TEXAS("Texas", "tx");

    private String state, stateCode;

    private HomesSubMenus(String state, String stateCode){
        this.state = state;
        this.stateCode = stateCode;
    }

    public String getState(){
        return this.state;
    }

    public String getStateCode(){
        return this.stateCode;
    }

}
