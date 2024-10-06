package com.course.selenium.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    public static WebElement waitForElementVisible(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.ignoring(StaleElementReferenceException.class)
                        .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static Boolean waitForUrlContains(WebDriver driver, int seconds, String urlTest) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.urlContains(urlTest));
    }
}