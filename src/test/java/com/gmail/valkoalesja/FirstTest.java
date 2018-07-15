package com.gmail.valkoalesja;

import com.google.common.base.Verify;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.hamcrest.core.StringContains;

import static org.hamcrest.CoreMatchers.containsString;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru/");
    }

    public boolean anyOneWordContains(String sourceString, String targetString) {
        for (String word : targetString.split(" ")) {
            if(sourceString.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void Search() {
        WebElement SearchLine = driver.findElement(By.cssSelector("input[id='text']"));
        SearchLine.clear();

        String expectedString = "погода пенза";

        SearchLine.sendKeys(expectedString);
        WebElement SearchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        SearchButton.click();

        WebElement Results = driver.findElement(By.cssSelector(".serp-item[data-cid=\"0\"] .organic__url-text"));
        String resultString = Results.getText();

        Assert.assertEquals(anyOneWordContains(resultString, expectedString), true);
    }
}
