package com.gmail.valkoalesja.pages;


import com.gmail.valkoalesja.bases.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(css=".select__button")
    private WebElement SelectButton;

    @FindBy(xpath=".//span[contains(text(), 'Показывать по 12') and contains(@class, 'select__text')]/..")
    private WebElement Show12Option;

    @FindBy(xpath=".//span[contains(text(), 'Показывать по 48') and contains(@class, 'select__text')]/..")
    private WebElement Show48Option;

    @FindBy(xpath = ".//a[contains(text(), 'по цене')]")
    private WebElement SortPriceLink;

    public void clickSortPrice() {
        SortPriceLink.click();
    }

    public void goToTablets() {
        ComputersLink.click();
        TabletsLink.click();
    }

    public void waitResults() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated (By.className("n-snippet-card2")));
    }

    By PRICE_LOCATOR = By.cssSelector("a > div.price");

    public List<Integer> getListPrices() {
        waitResults();
        List<WebElement> priceElements;
        List<Integer> prices = new ArrayList<Integer>();

        try {
            priceElements = driver.findElements(PRICE_LOCATOR);
            for(int i=0; i<priceElements.size(); i++){
                prices.add(Integer.parseInt(priceElements.get(i).getText().replaceAll("\\D+","")));
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            priceElements = driver.findElements(PRICE_LOCATOR);
            for(int i=0; i<priceElements.size(); i++){
                prices.add(Integer.parseInt(priceElements.get(i).getText().replaceAll("\\D+","")));
            }
        }

        return prices;

//        List<WebElement> priceElements = driver.findElements(PRICE_LOCATOR);
//        List<String> prices = new ArrayList<String>();
//
//        for(int i=0; i<priceElements.size(); i++){
//            prices.add(priceElements.get(i).getText());
//        }
//
//        return new String[prices.size()];
    }

    public Integer countResults() {
        waitResults();

        List<WebElement> results = this.driver.findElements(By.className("n-snippet-card2"));

        return  results.size();
    }

    public void scrollToElement(WebElement element) {
        actions.moveToElement(element);
        actions.perform();
    }

    public void waitSelectButton() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("select__button")));
    }

    public void scrollToSelect() {
        scrollToElement(SelectButton);
    }

    public void clickToSelect() {
        SelectButton.click();
    }

    public void show12() {
        Show12Option.click();
    }

    public void show48() {
        Show48Option.click();
    }
}
