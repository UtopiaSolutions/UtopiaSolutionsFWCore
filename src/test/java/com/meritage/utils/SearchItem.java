package com.meritage.utils;

public class SearchItem {

    private String searchTitle;
    private String url;
    private String excerpt;

    public SearchItem(String searchTitle, String url, String excerpt) {
        this.searchTitle = searchTitle;
        this.url = url;
        this.excerpt = excerpt;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public String getUrl() {
        return url;
    }


    public String getExcerpt() {
        return excerpt;
    }

}
