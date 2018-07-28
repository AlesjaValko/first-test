package com.gmail.valkoalesja.pages;


import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class MarketPage extends PageBase {
    private Actions actions = new Actions(driver);

    public MarketPage(WebDriver currentDriver) {
        this.driver = currentDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css="li[data-department=\"Компьютеры\"]")
    private WebElement ComputersLink;

    @FindBy(xpath=".//a[contains(text(), 'Планшеты') and contains(@class, 'catalog-menu__list-item')]")
    private WebElement TabletsLink;

    public void goToTablets() {
        ComputersLink.click();
        TabletsLink.click();
    }
}
