package com.course.selenium;

import com.course.selenium.DriverFactory.BrowserFactory;
import com.course.selenium.DriverFactory.BrowserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = BrowserFactory.initializeDriver(BrowserType.CHROME);
        driver.get("http://www.google.com");

    }
    @Test
    public void googleSearch_test() {
        WebElement elementCookiesWindow = driver.findElement(By.xpath("//button/*[contains(text(),'Zaakceptuj')]"));
        elementCookiesWindow.click();

        WebElement element = driver.findElement(By.name("q"));

        element.clear();
        element.sendKeys("Coderslab");
        element.submit();
    }

    @After
    public void teardown(){
        driver.quit();
    }
}