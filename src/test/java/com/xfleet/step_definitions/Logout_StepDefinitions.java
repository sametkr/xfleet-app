package com.xfleet.step_definitions;

import com.xfleet.pages.HomePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;;
import org.junit.Assert;


public class Logout_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    String currentURL;

    @Given("user is already logged as a {string}")
    public void user_is_already_logged_as_a(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginWithValidCredentials(string);
    }

    @When("user clicks username dropdown and clicks Logout button")
    public void user_clicks_username_dropdown_and_clicks_logout_button() {
        homePage.waitUntilLoaderScreenDisappear();
        homePage.userMenuDropdown.click();
        homePage.logOutButton.click();
    }

    @Then("user should land on login page")
    public void user_should_land_on_login_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigurationReader.getProperty("url"));
    }

    @When("user clicks step back button")
    public void user_clicks_step_back_button() {
        Driver.getDriver().navigate().back();
    }

    @When("user closes the all tabs without using logout function")
    public void user_closes_the_all_tabs_without_using_logout_function(){
        homePage.waitUntilLoaderScreenDisappear();
        currentURL = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().close();
        Driver.setDriver(null);
    }

    @When("user navigates to the profile page")
    public void user_navigates_to_the_profile_page() {
        Driver.getDriver().get(currentURL);
    }

    @Then("user should land on login page without logged in")
    public void user_should_land_on_login_page_without_logged_in() {
        Assert.assertNotEquals(currentURL, ConfigurationReader.getProperty("url"));
    }

}
