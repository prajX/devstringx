package com.msnagile.devstringx.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "/html/body/app-root/app-register/html/body/div/div/div/app-modern-sass-header/section/div[1]/div/div/div/div[1]/div/form/div/div[4]/button/b")
    private WebElement signUpWithEmail;

    public RegisterPage() {        
        PageFactory.initElements(driver, this);
    }

    public boolean verifySignUpWithEmailPresent(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(signUpWithEmail));
    System.out.println("Sign up with email found!");
    return element.isDisplayed();
    }

    public void clickOnSignUpWithEmail(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(signUpWithEmail));
        element.click();
    }

}
