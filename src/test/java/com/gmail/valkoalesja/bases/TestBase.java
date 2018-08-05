package com.gmail.valkoalesja.bases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeTestCase() {
        System.setProperty("webdriver.chrome.driver", "/home/revich2/Public/first-test/drivers/chromedriver_v40");

        ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterTestCase() {
        driver.quit();
    }
}