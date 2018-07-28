package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.MarketPage;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Test;
import org.junit.Assert;

public class MarketTests extends TestBase {
    private SearchPage searchPage = new SearchPage(this.driver);
    private MarketPage marketPage = new MarketPage(this.driver);

    @Test
    public void CountResults    () {
        this.driver.get("https://www.yandex.ru/");

        searchPage.clickMarketLink();

        marketPage.goToTablets();
    }
}
