package stepDefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.support.PageFactory;

import pageObjects.*;

import util.Driver;
import cucumber.api.java.en.Then;

public class sample21ExactSteps {

    private HomePage homePage;
    
    public sample21ExactSteps(Driver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    
    @Then("some text should be seen")
    public void some_text_should_be_seen() throws Throwable {
    	assertTrue(homePage.getParagraphText().contains("Lorem ipsum dolor sit amet"));
    }
}