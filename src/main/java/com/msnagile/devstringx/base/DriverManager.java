package com.msnagile.devstringx.base;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {}

    public static void initializeDriver(String browser,String pathDriver) throws MalformedURLException {
        if (driver == null) {
            
            if(browser.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", pathDriver); 
                driver = new ChromeDriver();
            }
            if(browser.equals("firefox")){
                System.setProperty("webdriver.gecko.driver", pathDriver);
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver(options);
            }

            
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
