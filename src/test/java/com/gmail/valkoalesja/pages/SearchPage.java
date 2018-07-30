package com.gmail.valkoalesja.pages;

import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver currentDriver) {
        this.driver = currentDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath="//input[@id = 'text']")
    private WebElement SearchLine;

    @FindBy(xpath= "//button[@type = 'submit']")
    private WebElement SearchButton;

    @FindBy(css = ".home-tabs__more-switcher")
    private WebElement MoreButton;

    @FindBy(css= ".geolink")
    private WebElement LocButton;

    @FindBy(css=".home-tabs__more")
    private WebElement MoreContainer;

    @FindBy(css=".home-tabs__more-item")
    private WebElement MoreItems;

    @FindBy(css="a[data-id=\"market\"]")
    private WebElement MarketLink;

    //home tabs
    @FindBy(css="a[data-id=\"maps\"]")
    private WebElement HomeTabMaps;

    @FindBy(css="a[data-id=\"market\"]")
    private WebElement HomeTabMarket;

    @FindBy(css="a[data-id=\"video\"]")
    private WebElement HomeTabVideo;

    @FindBy(css="a[data-id=\"images\"]")
    private WebElement HomeTabImages;

    @FindBy(css="a[data-id=\"news\"]")
    private WebElement HomeTabNews;

    @FindBy(css="a[data-id=\"translate\"]")
    private WebElement HomeTabTranslate;

    @FindBy(css="a[data-id=\"music\"]")
    private WebElement HomeTabMusic;

    public ArrayList<WebElement> homeTabs() {
        ArrayList<WebElement> tabs = new ArrayList<WebElement>();

        tabs.add(HomeTabMaps);
        tabs.add(HomeTabMarket);
        tabs.add(HomeTabVideo);
        tabs.add(HomeTabImages);
        tabs.add(HomeTabNews);
        tabs.add(HomeTabTranslate);
        tabs.add(HomeTabMusic);

        return tabs;
    }

    public String moreItemsString() {
        System.out.println(this.moreItemsArray());
        return MoreContainer.getAttribute("innerHTML");
    }

    public String[] moreItemsArray() {
        List<WebElement> myList=driver.findElements(By.className("home-tabs__more-item"));
        List<String> allElementsText=new ArrayList<String>();

        for(int i=0; i<myList.size(); i++){
            allElementsText.add(myList.get(i).getText());
        }

        return new String[allElementsText.size()];
    }

    public boolean anyOneWordContains(String sourceString, String targetString) {
        for (String word : targetString.split(" ")) {
            if(sourceString.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public void inputSearch(String text) {
        SearchLine.sendKeys(text);
    }

    public void clickSearchButton() {
        SearchButton.click();
    }

    public void clickLocButton() { LocButton.click(); }

    public void clickMoreButton() { MoreButton.click();}

    public void clickMarketLink() { MarketLink.click(); }

}