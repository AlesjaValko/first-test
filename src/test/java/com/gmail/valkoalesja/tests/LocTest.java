package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.LocPage;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Test;
import org.junit.Assert;

public class LocTest extends TestBase {

    @Test
    public void Set(){
        this.driver.get("https://www.yandex.by/");
        SearchPage searchPage = new SearchPage(this.driver);
        LocPage locPage = new LocPage(this.driver);

        //actions for London
        searchPage.clickLocButton();
        locPage.inputLocation("Лондон");

        searchPage.clickMoreButton();
        String londonMore = searchPage.moreItemsString();
        Object[] londonMoreArray = searchPage.moreItemsArray();

        //actions for Paris
        searchPage.clickLocButton();
        locPage.inputLocation("Париж");

        searchPage.clickMoreButton();
        String parisMore = searchPage.moreItemsString();
        Object[] parisMoreArray = searchPage.moreItemsArray();

        Assert.assertEquals(londonMore, parisMore);
        Assert.assertArrayEquals(londonMoreArray, parisMoreArray);
    }
}

