package stepDefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.support.PageFactory;

import pageObjects.*;

import util.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sample22CaptureSteps {

    private Driver driver;
    private HomePage homePage;
    private GenericPage page;
    private LocatorsPage locatorsPage;
    private PageWithLinksPage pageWithLinksPage;
    private ActionsPage actionsPage;
//    private List<String> asd;
    
    public sample22CaptureSteps(Driver driver) {
        this.driver = driver;
        page = PageFactory.initElements(driver, GenericPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        locatorsPage = PageFactory.initElements(driver, LocatorsPage.class);
        locatorsPage.setDriver(driver);
        actionsPage = PageFactory.initElements(driver, ActionsPage.class);
        pageWithLinksPage = PageFactory.initElements(driver, PageWithLinksPage.class);
    }

    @Given("^I am on the \"(.*)\" page$")
    public void i_am_on_the_page(String pageName) throws Throwable {
//    	asd = 
    	String pageURL = "";
    	switch (pageName) {
	        case "Home":  
	        	pageURL = homePage.getPageUrl();
	        	break;
	        case "Locators":  
	        	pageURL = locatorsPage.getPageUrl();
	        	break;
	        case "Page with Links":  
	        	pageURL = pageWithLinksPage.getPageUrl();
	        	break;	
	        case "Actions":  
	        	pageURL = actionsPage.getPageUrl();
	        	break;	         	
            default: 
                fail("No such page!");
                break;
    	}
        driver.get(pageURL);
    }

    @Then("^I should see \"(.*)\" header text$")
    public void i_should_see_header_text(String text) throws Throwable {
        assertEquals(text, page.getPageHeaderText());
    }

    @Then("^I should see sample text (\\d+)$")
    public void i_should_see_sample_text(int textNumber) throws Throwable {
        assertEquals("sample text " + textNumber, locatorsPage.getSampleTextByNumber(textNumber - 1));
    }

    @Then("^I (?:should|can) see \"(unbelievable|amazing|dummy)\" text$")
    public void i_see_text(String textType) throws Throwable {
    	if (textType.equals("dummy")) {
    		assertEquals(textType + " text", locatorsPage.getSampleTextById(textType));
    	} else {
    		assertEquals(textType + " sample text", locatorsPage.getSampleTextByClass(textType));
    	}
    }
}