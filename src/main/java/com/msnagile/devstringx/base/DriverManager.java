package com.msnagile.devstringx.base;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {}

    public static void initializeDriver(String pathChromeDriver) throws MalformedURLException {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", pathChromeDriver); 
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
