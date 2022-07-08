package com.xfleet.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageSubtitle;

    @FindBy(xpath = "//li/a[@class='dropdown-toggle']")
    public WebElement userMenuDropdown;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOutButton;

    LoginPage loginPage = new LoginPage();

    public void verifyUserPageTitle(String subTitle) {
        if (subTitle.equals("Dashboard") || subTitle.equals("Quick Launchpad")) {
            waitUntilLoaderScreenDisappear();
            Assert.assertEquals("Subtitles are not match!", pageSubtitle.getText(), subTitle);
        } else {
            waitUntilLoaderScreenDisappear();
            Assert.assertEquals("Subtitles are not match!", loginPage.forgotPasswordHeader.getText(), subTitle);
        }
    }

}
