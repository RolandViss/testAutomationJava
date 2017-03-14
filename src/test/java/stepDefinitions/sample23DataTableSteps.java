package stepDefinitions;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import pageObjects.*;
import util.Driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class sample23DataTableSteps {

    private LocatorsPage locatorsPage;
    private ActionsPage actionsPage;
    
    public sample23DataTableSteps(Driver driver) {
        locatorsPage = PageFactory.initElements(driver, LocatorsPage.class);
        locatorsPage.setDriver(driver);
        actionsPage = PageFactory.initElements(driver, ActionsPage.class);
        actionsPage.setDriver(driver);
    }

    @When("^I select options:$")
    public void i_select_options(List<String> optionTable) throws Throwable {
        for (String optionToSelect : optionTable) {
        	actionsPage.selectOption(optionToSelect);
        }
    }

    @Then("^I see options checked:$")
    public void i_see_options_checked(DataTable optionTable) throws Throwable {
    	for (Map<String, String> map : optionTable.asMaps(String.class, String.class)) {
            String name = map.get("text");
            String value = map.get("is checked");
    		assertTrue(actionsPage.isOptionSelected(name) == value.equals("checked"));
        }
    }    
    
    @Then("^I see default values:$")
    public void i_see_default_values(Map<String, String> defaultValues) throws Throwable {
    	if (defaultValues.containsKey("text box")) 
    		assertEquals(defaultValues.get("text box"), actionsPage.getTextBoxText());
    	if (defaultValues.containsKey("number box")) 
    		assertEquals(defaultValues.get("number box"), actionsPage.getNumberBoxText());
    	if (defaultValues.containsKey("text area")) 
    		assertEquals(defaultValues.get("text area"), actionsPage.getTextAreaText());
    	if (defaultValues.containsKey("select")) 
    		assertEquals(defaultValues.get("select"), actionsPage.getSelectFieldText());
    	if (defaultValues.containsKey("url")) 
    		assertEquals(defaultValues.get("url"), actionsPage.getUrlFieldText());
    }
}