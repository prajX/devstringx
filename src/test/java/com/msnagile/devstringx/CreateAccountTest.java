package com.msnagile.devstringx;

// import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.msnagile.devstringx.pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest{

    private CreateAccountPage createAccountPage;

    @BeforeClass
    public void setup(){
        createAccountPage = new CreateAccountPage();
    }

    @Test(priority = 1)
    public void enterFullNameField(){
        if(createAccountPage.verifyFullnamePresent()==true){
            createAccountPage.enterFullName(p.getProperty("user.fullname"));
        }
    }

    @Test(priority = 2)
    public void enterEmailField(){
        if(createAccountPage.verifyemailPresent()==true){
            createAccountPage.enterEmail(p.getProperty("app.email"));
        }
    }

    @Test(priority = 3)
    public void enterPasswordField(){
        if(createAccountPage.verifypasswordPresent()==true){
            createAccountPage.enterPassword(p.getProperty("user.password"));
        }
    }

    @Test(priority = 4)
    public void enterSiteUrlField(){
        if(createAccountPage.verifysiteurlPresent()==true){
            createAccountPage.enterSiteUrl(p.getProperty("user.siteurl"));
        }
    }

    @Test(priority = 5)
    public void fetchMailLink(){
        createAccountPage.clickSubmit();
    }



}