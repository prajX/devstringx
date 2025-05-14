package com.msnagile.devstringx;

import com.msnagile.devstringx.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeMethod;
// import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    protected static Properties p;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        p=new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(Paths.get("src", "test", "resources", "config.properties").toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverManager.initializeDriver(p.getProperty("browser"),p.getProperty("driver.path"));
        driver=DriverManager.getDriver();
        driver.get(p.getProperty("app.baseurl"));
        driver.manage().window().maximize();
    }

    // @BeforeMethod
    // public void startTest(Method method) {
    //         }

    // @AfterMethod
    // public void captureResult(ITestResult result) {
        
    // }

    // @AfterSuite
    // public void tearDown() {
    //     DriverManager.quitDriver();
    // }
}