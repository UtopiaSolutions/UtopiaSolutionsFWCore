package com.meritage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.meritage.SearchItem;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {

    @FindBy(xpath = "//div[@class='row align-center results-count']//span")
    public SelenideElement resultCountLabel;


    @FindBy(css = "li.result")
    public ElementsCollection searchResults;

    public String getReultsCountLabel(){
        return resultCountLabel.getText();
    }

    public SelenideElement searchResult(){
        return resultCountLabel;
    }

    public SearchItem getResultWithIndex(int index){

        String resultTitle = searchResults.get(index).$(By.cssSelector("h5.result--title")).getText();
        String resultUrl = searchResults.get(index).$(By.cssSelector("span.result--url")).getText();
        String resultExcerpt = searchResults.get(index).$(By.cssSelector("p.result--excerpt")).getText();

        return new SearchItem(resultTitle, resultUrl, resultExcerpt);
    }

    public SelenideElement titleOfResult(int index){
        return searchResults.get(index).$(By.cssSelector("h5.result--title"));
    }

    public SelenideElement urlOfResult(int index){
        return searchResults.get(index).$(By.cssSelector("span.result--url"));
    }

    public SelenideElement excerptOfResult(int index){
        return searchResults.get(index).$(By.cssSelector("p.result--excerpt"));
    }
}
