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

public class HotelByClassNameTest {

    private final Faker faker = new Faker();
    private WebDriver driver;

    private final By signInLink = By.className("user_login");
    private final By emailAddressInput = By.className("account_input");
    private final By createAnAccountButton = By.id("SubmitCreate");
    private final By customerFirstnameInput = By.id("customer_firstname");

//    private final By radioButtonMr = By.id("id_gender1");
//    private final By radioButtonMrs = By.id("id_gender2");


    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void hotelClassName_test() {

        clickButton(driver, signInLink);
        fillInput(driver, emailAddressInput, faker.internet().emailAddress());
        clickButton(driver, createAnAccountButton);

        SeleniumHelper.waitForUrlContains(driver, 5, "account-creation");
        Assert.assertTrue(driver.findElement(customerFirstnameInput).isDisplayed());

//        selectRadioButton(driver, radiobuttonMr, "checked");
//        selectRadioButton(driver, radiobuttonMrs, "checked");

    }

    @After
    public void teardown() {
        driver.quit();
    }
}