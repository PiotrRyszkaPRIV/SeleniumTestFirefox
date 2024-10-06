package com.course.selenium.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver initializeDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME: {

                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless"); // test na serwerze bez otwierania przeglądarki, ale nie wiem czy poprawna składnia

                WebDriver driver = new ChromeDriver(options);
                setUpDriver(driver);
                return driver;
            }
            case FIREFOX: {

                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");         // test na serwerze bez otwierania przelądarki

                WebDriver driver = new FirefoxDriver(options);
                setUpDriver(driver);
                return driver;
            }
            case SAFARI: {
                WebDriver driver = new SafariDriver();
                setUpDriver(driver);
                return driver;
            }
            case EDGE: {
                WebDriver driver = new EdgeDriver();
                setUpDriver(driver);
                return driver;
            }
            default:
                throw new WebDriverException("-> error: Browser name not found! Cannot initialize browser driver");

        }
    }

    private static void setUpDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
