package com.gmail.valkoalesja.tests;

import com.gmail.valkoalesja.bases.TestBase;
import com.gmail.valkoalesja.pages.ResultPage;
import com.gmail.valkoalesja.pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ResultTest extends TestBase {

    public boolean anyOneWordContains(String sourceString, String targetString) {
        for (String word : targetString.split(" ")) {
            if(sourceString.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void search() {

        SearchPage searchPage = new SearchPage(this.driver);
        ResultPage resultPage = new ResultPage(this.driver);

        searchPage.inputSearch("погода пенза");
        searchPage.clickSearchButton();

        String expectedString = "погода пенза";
        String results = resultPage.Textget();

        Assert.assertEquals(anyOneWordContains(results, expectedString), true);
    }
}