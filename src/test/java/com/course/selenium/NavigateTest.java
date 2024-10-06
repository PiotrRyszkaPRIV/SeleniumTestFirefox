package com.course.selenium;

import com.course.selenium.DriverFactory.BrowserFactory;
import com.course.selenium.DriverFactory.BrowserType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NavigateTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);

    }

    @Test
    public void navigateTest() {

        // wejdź na coderslab.pl
        driver.get("https://www.coderslab.pl/pl");
        Assert.assertEquals("https://coderslab.pl/pl", driver.getCurrentUrl());

        // wejdz na mystore
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php", driver.getCurrentUrl());

        // wejdz na mystore
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        Assert.assertEquals("https://hotel-testlab.coderslab.pl/en/", driver.getCurrentUrl());

    }

    @After
    public void teardown() {
        driver.quit();
    }
}