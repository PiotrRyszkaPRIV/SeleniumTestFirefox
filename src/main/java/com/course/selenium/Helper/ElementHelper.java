package com.course.selenium.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {

    public static void selectRadioButton(WebDriver driver, By locator, String parentText) {

        WebElement element = driver.findElement(locator);
        WebElement parent = element.findElement(By.xpath(".."));
        String parentAttribute = parent.getAttribute("class");

        if (!parentAttribute.contains(parentText)) {
            element.click();
        } else {
            System.out.println("radioButton is selected");
        }
    }

    public static void fillInput(WebDriver driver, By locator, String text) {
        WebElement ele = SeleniumHelper
                .waitForElementVisible(driver, locator, 10);

        ele.clear();
        ele.sendKeys(text);
    }

    public static void clickButton(WebDriver driver, By locator) {
        WebElement ele = SeleniumHelper
                .waitForElementVisible(driver, locator, 10);

        ele.click();
    }

}