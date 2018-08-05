package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.LocPage;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Test;
import org.junit.Assert;

public class LocTest extends TestBase {
    private SearchPage searchPage = new SearchPage(this.driver);
    private LocPage locPage = new LocPage(this.driver);

    @Test
    public void Set(){
        this.driver.get("https://www.yandex.by/");

        //actions for London
        searchPage.clickLocButton();
        locPage.clearInput();
        locPage.setLocationToInput("Лондон");
        locPage.submitForm();

        searchPage.clickMoreButton();
        String londonMore = searchPage.moreItemsString();
        Object[] londonMoreArray = searchPage.moreItemsArray();

        //actions for Paris
        searchPage.clickLocButton();
        locPage.clearInput();
        locPage.setLocationToInput("Париж");
        locPage.submitForm();

        searchPage.clickMoreButton();
        String parisMore = searchPage.moreItemsString();
        Object[] parisMoreArray = searchPage.moreItemsArray();

        Assert.assertEquals(londonMore, parisMore);
        Assert.assertArrayEquals(londonMoreArray, parisMoreArray);
    }
}

