package com.msnagile.devstringx;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.msnagile.devstringx.pages.EmailConfirmPage;

public class EmailConfirmTest extends BaseTest{

    private EmailConfirmPage emailConfirmPage;

    @BeforeClass
    public void setup(){
        emailConfirmPage = new EmailConfirmPage();
    }

    @Test(priority = 1)
    public void emailFieldPresent(){
        Assert.assertEquals(emailConfirmPage.verifyEmailFieldPresent(), true);
    }

    @Test(priority = 2)
    public void fetchMailConfirmationLink(){
        
        try{
            Thread.sleep(10000);
        }
        catch(Exception e){
            System.out.println("Exception occured");
        }
        
        String email = p.getProperty("app.email");
        String password = p.getProperty("app.password");
        String host = p.getProperty("app.imap_host");
        emailConfirmPage.fetchConfirmationLink(host, email, password); 
    }

}
