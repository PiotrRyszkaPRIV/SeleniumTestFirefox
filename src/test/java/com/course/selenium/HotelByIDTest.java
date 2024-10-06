package com.course.selenium;

import com.course.selenium.DriverFactory.BrowserFactory;
import com.course.selenium.DriverFactory.BrowserType;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.course.selenium.Helper.ElementHelper.fillInput;

public class HotelByIDTest {

    Faker faker = new Faker();

    private WebDriver driver;

    private final By hotelInput = By.id("hotel_location");
    private final By searchNowButton = By.id("search_room_submit");
    private final By notificationEmailInput = By.id("newsletter-input");

    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);
        driver.get("https://hotel-testlab.coderslab.pl/en/");

    }

    @Test
    public void byID_test() {
        fillInput(driver,hotelInput, "Warsaw");
        fillInput(driver,notificationEmailInput,faker.internet().emailAddress());

//                SeleniumHelper
//                        .waitForElementVisible(driver, hotelInput, 10)
//                        .sendKeys("Warsaw");
//                SeleniumHelper
//                        .waitForElementVisible(driver, notificationEmailInput, 10)
//                        .sendKeys(faker.internet().emailAddress());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}