package com.gmail.valkoalesja.pages;

import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends PageBase {

    public ResultPage(WebDriver currentDriver) {
        this.driver = currentDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class='serp-item'][@data-cid='0']//*[@class='organic__url-text']")
    private WebElement ResultString;

    public String Textget() {
        String result = ResultString.getText();
        return result;
    }
}