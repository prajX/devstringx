package com.msnagile.devstringx.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.msnagile.devstringx.utils.FetchMail;

import org.openqa.selenium.WebElement;

public class EmailConfirmPage extends BasePage {

    @FindBy(xpath = "/html/body/app-root/app-email-confirmation/body/div/div/div[2]/div[4]/div/div[2]/div/h5/a")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-email-confirmation/body/div/div/div[2]/div[6]/div/button")
    private WebElement backToSite;

    public EmailConfirmPage() {        
        PageFactory.initElements(driver, this);
    }

    public boolean verifyEmailFieldPresent(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(emailField));
    System.out.println(element.getText());
    return element.isDisplayed();
    }

    public boolean verifyBackToSitePresent(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(backToSite));
        return element.isDisplayed();
        }

    public void clickOnEmailField(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailField));
        element.click();
    }

    public void fetchConfirmationLink(String host,String username,String password){
        FetchMail mailLink=new FetchMail(host,username,password);
        String link=mailLink.fetch();
        driver.get(link);
    }


}