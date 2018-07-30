package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.ResultPage;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;

public class ResultTest extends TestBase {

    @Test
    public void search() {
        this.driver.get("https://www.yandex.ru/");

        SearchPage searchPage = new SearchPage(this.driver);
        ResultPage resultPage = new ResultPage(this.driver);

        searchPage.inputSearch("погода пенза");
        searchPage.clickSearchButton();

        String expectedString = "погода пенза";
        String results = resultPage.Textget();

        Assert.assertEquals(searchPage.anyOneWordContains(results, expectedString), true);
    }
    
}