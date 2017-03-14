package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Driver;

public class LocatorsPage extends GenericPage {

	private Driver driver;
	
    @FindBy(how = How.TAG_NAME, using = "p")
    private List<WebElement> allParagraphs;
    
	public LocatorsPage() throws Exception{
		super();
		pageURL = pageURL + "/examples/loc";
	}
	
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
	
    public String getPageUrl() throws IOException {
        return pageURL;
    }    

    public String getSampleTextByNumber(int textNumber) throws IOException {
        return allParagraphs.get(textNumber).getText();
    }

    public String getSampleTextByClass(String className) throws IOException {
        return driver.findElement(By.cssSelector("p." + className)).getText();
    }    

    public String getSampleTextById(String idName) throws IOException {
        return driver.findElement(By.cssSelector("p#" + idName)).getText();
    }
}
