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

    @FindBy(css = ".header2-menu__item_type_compare")
    private WebElement CompareLink;

    @FindBy(css = ".n-compare-toolbar__action-clear")
    private WebElement ClearCompareBtn;

    public boolean isEmptyCompare() {
        waitClickableElement(driver.findElement(By.className("n-compare-empty__content")));
        try {
            driver.findElement(By.className("n-compare-empty__content"));
            return true;
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex) {
            return false;
        }
    }

    public void removeItemsFromCompare() {
        ClearCompareBtn.click();
    }

    public int countItemsInCompare() {
        List<WebElement> itemsInCompare = driver.findElements(By.className("n-compare-cell_js_inited"));

        return itemsInCompare.size();
    }

    public void clickSortPrice() {
        SortPriceLink.click();
    }

    public void goToTablets() {
        ComputersLink.click();
        TabletsLink.click();
    }

    public void waitResults() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated (By.className("n-snippet-card2")));
    }

    By PRICE_LOCATOR = By.cssSelector("a > div.price");

    public void addFirstTwoResultsToCompare() {
        ArrayList<WebElement> firstTwoResults = new ArrayList<WebElement>();

        int index = 0;
        for(WebElement result: driver.findElements(By.className("n-snippet-card2"))) {
            index++;
            if(index <= 2) {
                firstTwoResults.add(result);
            }
        }

        for(WebElement result: firstTwoResults) {
            WebElement btnForCompare = result.findElement(By.cssSelector(".n-product-toolbar__item.n-user-lists_type_compare"));
            actions.moveToElement(result).moveToElement(btnForCompare).click().build().perform();
        }
    }

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

    public void waitClickableElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitClickableElements(By webElements) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((webElements)));
    }

    public boolean isSorted(List<Integer> prices) {
        Boolean isSortedAsc = true;
        Boolean isSortedDesc = true;

        for(int i=1; i < prices.size() -1; i++){
            if(prices.get(i-1) > prices.get(i)){
                isSortedDesc = false;
            }
        }

        for(int i=1; i < prices.size()-1; i++){
            if(prices.get(i-1) < prices.get(i)){
                isSortedAsc = false;
            }
        }

        return isSortedAsc || isSortedDesc;
    }

    public void waitSelectButton() {
        waitClickableElement(SelectButton);
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

    public void clickToCompareLink() {
        waitClickableElement(CompareLink);

        CompareLink.click();
    }
}
