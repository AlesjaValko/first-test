package com.gmail.valkoalesja.pages;

import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocPage extends PageBase {

    public LocPage(WebDriver currentDriver) {
        this.driver = currentDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath="//*[@id='city__front-input']")
    private WebElement LocLine;

    @FindBy(css="form#form__a11y")
    private WebElement Form;

    private void pressEnterWithDelay() {
        try {
            Thread.sleep(1000);

            LocLine.sendKeys(Keys.RETURN);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void inputLocation(String text) {
        LocLine.clear();
        LocLine.sendKeys(text);

        this.pressEnterWithDelay();
    }

}
