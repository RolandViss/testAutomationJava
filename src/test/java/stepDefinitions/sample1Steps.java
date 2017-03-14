package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import util.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sample1Steps {

    private Driver driver;
    private HomePage homePage;

    public sample1Steps(Driver driver) {
        this.driver = driver;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
    	driver.get(homePage.getPageUrl());
    }
    
    @Then("^I should see home page header$")
    public void i_should_see_home_page_header() throws Throwable {
    	assertEquals("This is a home page", homePage.getPageHeaderText());
    }
}
