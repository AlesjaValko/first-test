package com.gmail.valkoalesja.pages;

import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver currentDriver) {
        this.driver = currentDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath="//input[@id = 'text']")
    private WebElement SearchLine;

    @FindBy(xpath= "//button[@type = 'submit']")
    private WebElement SearchButton;

    public void inputSearch(String text) {
        SearchLine.sendKeys(text);
    }

    public void clickSearchButton() {
        SearchButton.click();
    }

}