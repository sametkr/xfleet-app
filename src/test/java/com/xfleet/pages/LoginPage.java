package com.xfleet.pages;

import com.xfleet.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='_username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='_password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@name='_submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement invalidCredMessage;

    @FindBy(xpath = "//input[@required='required']")
    public WebElement fillOutMessage;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPassword;

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement forgotPasswordHeader;

    @FindBy(xpath = "//label[@class='custom-checkbox absolute']")
    public WebElement rememberMe;

    public void loginWithValidCredentials(String userType){
        if (userType.equalsIgnoreCase("driver")){
            usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
            loginButton.click();
        }else if (userType.equalsIgnoreCase("sales manager")){
            usernameInput.sendKeys(ConfigurationReader.getProperty("salesManager_username"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("salesManager_password"));
            loginButton.click();
        }else if (userType.equalsIgnoreCase("store manager")){
            usernameInput.sendKeys(ConfigurationReader.getProperty("storeManager_username"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("storeManager_password"));
            loginButton.click();
        }
    }
}
