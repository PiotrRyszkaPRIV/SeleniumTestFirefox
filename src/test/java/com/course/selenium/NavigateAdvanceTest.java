package com.course.selenium;

import com.course.selenium.DriverFactory.BrowserFactory;
import com.course.selenium.DriverFactory.BrowserType;
import com.course.selenium.Helper.SeleniumHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NavigateAdvanceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);

    }

    @Test
    public void navigateAdvanceTest() {
        // wejdź na google.com
        driver.get("https://www.google.com");
        SeleniumHelper.waitForUrlContains(driver, 10, "google");
        Assert.assertEquals("https://www.google.com/", driver.getCurrentUrl());

        // wejdź na coderslab.pl
        driver.get("https://www.coderslab.pl/pl");
        Assert.assertEquals("https://coderslab.pl/pl", driver.getCurrentUrl());

        // navigate back to google.com
        driver.navigate().back();
        SeleniumHelper.waitForUrlContains(driver, 10, "google");
        Assert.assertEquals("https://www.google.com/", driver.getCurrentUrl());

        // wejdz na mystore
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php", driver.getCurrentUrl());

        // navgate back to google.com
        driver.navigate().back();
        SeleniumHelper.waitForUrlContains(driver, 10, "google");
        Assert.assertEquals("https://www.google.com/", driver.getCurrentUrl());

        // navigate forward to mystore
        driver.navigate().forward();
        SeleniumHelper.waitForUrlContains(driver, 10, "mystore");
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php", driver.getCurrentUrl());

        // refresh mystore
        driver.navigate().refresh();
        SeleniumHelper.waitForUrlContains(driver, 10, "mystore");
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php", driver.getCurrentUrl());

    }

    @After
    public void teardown() {
        driver.quit();
    }
}