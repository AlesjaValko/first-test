package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class NavigTest extends TestBase {
    private SearchPage searchPage = new SearchPage(this.driver);

    @Test
    public void test() {
        this.driver.get("https://www.yandex.ru/");

        ArrayList<WebElement> tabs = searchPage.homeTabs();

        for (WebElement tab: tabs) {
            String href = tab.getAttribute("href");

            tab.click();

            String url = driver.getCurrentUrl();

            driver.navigate().back();

            Assert.assertEquals(url.contains(href), true);
        }
    }

}
