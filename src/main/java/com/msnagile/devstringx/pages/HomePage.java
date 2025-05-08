package com.msnagile.devstringx.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/app-root/app-landing-page/div/div[1]/div/div[2]/button")
    private WebElement tryForFree;

    public HomePage() {        
        PageFactory.initElements(driver, this);
    }

    public boolean verifyTryForFreePresent(){
    WebElement element = wait.until(ExpectedConditions.visibilityOf(tryForFree));
    System.out.println("Try for free found!");
    return element.isDisplayed();
    }

    public void clickOnTryForFree(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(tryForFree));
        element.click();
    }

}
