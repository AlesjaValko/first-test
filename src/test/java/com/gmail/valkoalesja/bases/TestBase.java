package com.gmail.valkoalesja.bases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeTestCase() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterTestCase() {
        driver.quit();
    }
}