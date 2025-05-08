package com.msnagile.devstringx;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.msnagile.devstringx.pages.HomePage;

public class HomeTest extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    public void setup(){
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void tryForFreeButtonPresent(){
        Assert.assertEquals(homePage.verifyTryForFreePresent(), true);
    }

    @Test(priority = 2)
    public void clickIconTryForFree(){
        homePage.clickOnTryForFree();
    }

}