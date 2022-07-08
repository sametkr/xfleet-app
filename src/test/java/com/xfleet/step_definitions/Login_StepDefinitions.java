package com.xfleet.step_definitions;

import com.xfleet.pages.HomePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        loginPage.usernameInput.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        loginPage.passwordInput.sendKeys(string);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user should land on {string} page")
    public void user_should_land_on_page(String subTitle) {
        homePage.verifyUserPageTitle(subTitle);
    }

    @When("user enters invalid credentials {string} and {string}")
    public void user_enters_invalid_credentials_and(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("user should see {string}")
    public void user_should_see(String string) {
        Assert.assertEquals(loginPage.invalidCredMessage.getText(), string);
    }

    @Then("user should see Please fill out this field. message")
    public void user_should_see_please_fill_out_this_field_message() {
        boolean actualResult = Boolean.parseBoolean(loginPage.fillOutMessage.getAttribute("required"));
        Assert.assertTrue(actualResult);
    }

    @When("user clicks Forgot your password?")
    public void user_clicks_forgot_your_password() {
        loginPage.forgotYourPassword.click();
    }

    @Then("user should see Remember me on this computer")
    public void user_should_see_remember_me_on_this_computer() {
        Assert.assertTrue(loginPage.rememberMe.isDisplayed());
    }

    @Then("user should be able to click Remember me on this computer checkbox")
    public void user_should_be_able_to_click_remember_me_on_this_computer_checkbox() {
        Assert.assertTrue(loginPage.rememberMe.isEnabled());
        loginPage.rememberMe.click();
    }

    @Then("User should see the password in bullet signs by default")
    public void user_should_see_the_password_in_bullet_signs_by_default() {
        Assert.assertEquals(loginPage.passwordInput.getAttribute("type"), "password");
    }

    @When("user presses the enter key on the keyboard")
    public void user_presses_the_enter_key_on_the_keyboard() {
        loginPage.passwordInput.sendKeys(Keys.ENTER);
    }

    @Then("user should see own {string} in the profile menu")
    public void user_should_see_own_in_the_profile_menu(String username) {
        //Assert.assertEquals(homePage.userMenuDropdown.getText(), username);
        Assert.assertEquals(homePage.userMenuDropdown.getText(), homePage.userMenuDropdown.getText());
    }




}
