package com.gmail.valkoalesja.pages;

import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Array;

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

    public void inputSearch(String text) {
        SearchLine.sendKeys(text);
    }

    public void clickSearchButton() {
        SearchButton.click();
    }

    public void clickLocButton() { LocButton.click(); }

    public void clickMoreButton() { MoreButton.click();}

}