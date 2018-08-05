package com.gmail.valkoalesja.pages;

import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

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
        WebDriverWait wait = new WebDriverWait(this.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("popup_visibility_visible")));

        LocLine.sendKeys(Keys.RETURN);
    }

    public void clearInput() {
        LocLine.clear();
    }

    public void submitForm() {
        this.pressEnterWithDelay();
    }

    public void setLocationToInput(String text) {
        LocLine.sendKeys(text);
    }

}
