package com.msnagile.devstringx;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.msnagile.devstringx.pages.RegisterPage;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;

    @BeforeClass
    public void setup(){
        registerPage = new RegisterPage();
    }

    @Test(priority = 1)
    public void signUpPresent(){
        Assert.assertEquals(registerPage.verifySignUpWithEmailPresent(), true);
    }

    @Test(priority = 2)
    public void clickIconSignUp(){
        registerPage.clickOnSignUpWithEmail();
    }

    

}