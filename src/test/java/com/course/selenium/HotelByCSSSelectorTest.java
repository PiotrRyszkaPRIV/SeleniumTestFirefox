package com.course.selenium;

import com.course.selenium.DriverFactory.BrowserFactory;
import com.course.selenium.DriverFactory.BrowserType;
import com.course.selenium.Helper.SeleniumHelper;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.course.selenium.Helper.ElementHelper.clickButton;
import static com.course.selenium.Helper.ElementHelper.fillInput;

// DOKOŃCZ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class HotelByCSSSelectorTest {

    private final Faker faker = new Faker();
    private WebDriver driver;

    private static final By MY_PERSONAL_INFORMATION = By.cssSelector(".myaccount-link-list > li:nth-child(5) > a");
    private static final By MY_ADDRESS = By.cssSelector(".myaccount-link-list > li:nth-child(4) > a");


    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void hotelXPath_test() {

        SeleniumHelper.waitForUrlContains(driver, 5, "My personal information");
        Assert.assertTrue(driver.findElement(MY_PERSONAL_INFORMATION).isDisplayed());

        SeleniumHelper.waitForUrlContains(driver, 5, "My addresses");
        Assert.assertTrue(driver.findElement(MY_ADDRESS).isDisplayed());

//        selectRadioButton(driver, radiobuttonMr, "checked");
//        selectRadioButton(driver, radiobuttonMrs, "checked");

    }

    @After
    public void teardown() {
        driver.quit();
    }
}