package com.msnagile.devstringx.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"fullname\"]")
    private WebElement fullName;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"domainName\"]")
    private WebElement siteUrl;

    @FindBy(xpath = "//*[@id=\"couponCode\"]")
    private WebElement referral;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div/div[9]/button")// 
    private WebElement submit;

    public CreateAccountPage() {        
        PageFactory.initElements(driver, this);
    }

    public boolean verifyFullnamePresent(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(fullName));
    System.out.println("Full Name found!");
    return element.isDisplayed();
    }

    public boolean verifyemailPresent(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(email));
        System.out.println("Email found!");
        return element.isDisplayed();
        }

    public boolean verifypasswordPresent(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(password));
        System.out.println("Password found!");
        return element.isDisplayed();
    }

    public boolean verifysiteurlPresent(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(siteUrl));
        System.out.println("SiteUrl found!");
        return element.isDisplayed();
    }

    public boolean verifysubmitPresent(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(submit));
        System.out.println("Submit found!");
        return element.isDisplayed();
    }

    public void enterFullName(String fn){
        wait.until(ExpectedConditions.elementToBeClickable(fullName));
         fullName.click();
         fullName.clear();
         fullName.sendKeys(fn);
     }

     public void enterEmail(String em){
        wait.until(ExpectedConditions.elementToBeClickable(email));
         email.click();
         email.clear();
         email.sendKeys(em);
     }

     public void enterPassword(String ps){
        wait.until(ExpectedConditions.elementToBeClickable(password));
         password.click();
         password.clear();
         password.sendKeys(ps);
     }

     public void enterSiteUrl(String su){
         siteUrl.click();
         siteUrl.clear();
         siteUrl.sendKeys(su);

     }

     public void enterReferral(String re){
        referral.click();
        referral.clear();
        System.out.println("Done till here");
        referral.sendKeys(re);
        referral.sendKeys(Keys.TAB);

    }

     public void clickSubmit(){
        //  wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
      }

}
