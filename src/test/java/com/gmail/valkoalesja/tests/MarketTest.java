package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.MarketPage;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class MarketTest extends TestBase {
    private SearchPage searchPage = new SearchPage(this.driver);
    private MarketPage marketPage = new MarketPage(this.driver);

    @Test
    public void CountResults() {
        this.driver.get("https://www.yandex.ru/");

        searchPage.clickMarketLink();

        marketPage.goToTablets();

        Integer countResults;

        marketPage.scrollToSelect();
        marketPage.clickToSelect();
        marketPage.show12();

        countResults = marketPage.countResults();
        Assert.assertTrue("Counts != 12", countResults == 12);

        marketPage.waitSelectButton();

        marketPage.scrollToSelect();
        marketPage.clickToSelect();
        marketPage.show48();

        countResults = marketPage.countResults();
        Assert.assertTrue("Counts != 48", countResults == 48);

    }

    @Test
    public void sorting() {
        this.driver.get("https://www.yandex.ru/");

        searchPage.clickMarketLink();

        marketPage.goToTablets();

        marketPage.clickSortPrice();

        driver.navigate().refresh();

        Assert.assertTrue(marketPage.isSorted(marketPage.getListPrices()));
    }

    @Test
    public void compare() {
        this.driver.get("https://www.yandex.ru/");

        searchPage.clickMarketLink();

        marketPage.goToTablets();

        marketPage.addFirstTwoResultsToCompare();

        marketPage.clickToCompareLink();

        int countItemsInCompare = marketPage.countItemsInCompare();
        Assert.assertEquals(2, countItemsInCompare);

        marketPage.removeItemsFromCompare();
        Assert.assertEquals(true, marketPage.isEmptyCompare());
    }
}
