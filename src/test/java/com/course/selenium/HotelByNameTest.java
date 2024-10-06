package com.course.selenium;

import com.course.selenium.DriverFactory.BrowserFactory;
import com.course.selenium.DriverFactory.BrowserType;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.course.selenium.Helper.ElementHelper.clickButton;
import static com.course.selenium.Helper.ElementHelper.fillInput;

public class HotelByNameTest {

    private final Faker faker = new Faker();
    private WebDriver driver;

    private final By hotelInput = By.name("hotel_location");
    private final By searchNowButton = By.name("search_room_submit");
    private final By notificationEmailInput = By.name("email");
    private final By subscribeButton = By.name("submitNewsletter");

    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void hotelName_test() {
        fillInput(driver, hotelInput, "Warsaw");
        fillInput(driver, notificationEmailInput, faker.internet().emailAddress());

        clickButton(driver, searchNowButton);

        Assert.assertTrue(driver.findElement(hotelInput).getAttribute("class").contains("error_border"));


    }


    @After
    public void teardown() {
        driver.quit();
    }
}