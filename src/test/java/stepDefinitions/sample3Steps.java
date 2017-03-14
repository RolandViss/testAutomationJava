package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import pageObjects.PageWithLinksPage;
import util.Driver;
import cucumber.api.java.en.Then;

public class sample3Steps {

    private Driver driver;
    private PageWithLinksPage pageWithLinksPage;

    public sample3Steps(Driver driver) {
        this.driver = driver;
        pageWithLinksPage = PageFactory.initElements(driver, PageWithLinksPage.class);
        pageWithLinksPage.setDriver(driver);
    }
    
    @Then("^I click \"More\" on (\\d+)$")
    public void i_should_see_sample_text(int articleNumber) throws Throwable {
    	pageWithLinksPage.clickMoreOnArticle(articleNumber);
    }

    @Then("^I click \"Back\" on article page$")
    public void i_click_back_on_article_page() throws Throwable {
    	pageWithLinksPage.getBackLink().click();
    }

    @Then("^I am taken back to \"Page with Links\"$")
    public void i_am_taken_back_to_page_with_links() throws Throwable {
    	assertEquals(pageWithLinksPage.getPageUrl(), driver.getCurrentUrl());
    	assertEquals("Lorem ipsum", pageWithLinksPage.getPageHeaderText());
    }
}
