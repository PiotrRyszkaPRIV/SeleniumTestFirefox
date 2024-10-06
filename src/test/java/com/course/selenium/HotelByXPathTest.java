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

import javax.xml.namespace.QName;

import static com.course.selenium.Helper.ElementHelper.*;


public class HotelByXPathTest {

    private final Faker faker = new Faker();
    private WebDriver driver;

    private static final By signInLink = org.openqa.selenium.By.className("user_login");
    private static final By emailAddressInput = By.className("account_input");
    private static final By createAnAccountButton = By.id("SubmitCreate");
    private static final By customerFirstnameInput = By.id("customer_firstname");


    private static final By EMAIL_ADDRESS_INPUT = By.xpath("//input[@id='email_create']");
    private static final By CREATE_AN_ACCOUNT_BUTTON = By.xpath("//button[@id='SubmitCreate']");
    // Create Account
    private static final By MR_RADIOBUTTON = By.xpath("//input[@id='id_gender1']");
    private static final By MRS_RADIOBUTTON = By.xpath("//input[@id='id_gender2']");
    private static final By FIRST_NAME_INPUT = By.xpath("//input[@id='customer_firstname']");
    private static final By LAST_NAME_INPUT = By.xpath("//input[@id='customer_lastname']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='passwd']");
    private static final By DAYS_SELECT = By.xpath("//select[@id='days']");
    private static final By MONTH_SELECT = By.xpath("//select[@id='months']");
    private static final By YEARS_SELECT = By.xpath("//select[@id='years']");
    private static final By SUBMIT_ACCOUNT_BUTTON = By.xpath("//button[@id='submitAccount']");

    private static final By MY_PERSONAL_INFORMATION = By.className("icon-user");

    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void hotelXPath_test() {

        // # kroki z poprzedniego
        clickButton(driver, signInLink);
        fillInput(driver, emailAddressInput, faker.internet().emailAddress());
        clickButton(driver, createAnAccountButton);

        SeleniumHelper.waitForUrlContains(driver, 5, "account-creation");
        Assert.assertTrue(driver.findElement(customerFirstnameInput).isDisplayed());

        // aktualny test
        selectRadioButton(driver, MR_RADIOBUTTON, "selected");

        clickButton(driver, FIRST_NAME_INPUT);
        fillInput(driver, FIRST_NAME_INPUT, faker.name().firstName());

        clickButton(driver, LAST_NAME_INPUT);
        fillInput(driver, LAST_NAME_INPUT, faker.name().lastName());

        // pre wypełniony
//        clickButton(driver, EMAIL_ADDRESS_INPUT);
//        fillInput(driver, EMAIL_ADDRESS_INPUT, faker.internet().emailAddress());

        clickButton(driver, PASSWORD_INPUT);
        fillInput(driver, PASSWORD_INPUT, faker.internet().password());

        clickButton(driver, SUBMIT_ACCOUNT_BUTTON);

//        SeleniumHelper.waitForUrlContains(driver, 5, "My personal information");
//        Assert.assertTrue(driver.findElement(MY_PERSONAL_INFORMATION).isDisplayed());

//        selectRadioButton(driver, radiobuttonMr, "checked");
//        selectRadioButton(driver, radiobuttonMrs, "checked");

    }

    @After
    public void teardown() {
        driver.quit();
    }
}