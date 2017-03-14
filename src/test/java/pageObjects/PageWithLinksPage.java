package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Driver;

public class PageWithLinksPage extends GenericPage {

	private Driver driver;

    @FindBy(how = How.XPATH, using = "//a[text()='<< Back']")
    private WebElement backLink;
    
    
	public PageWithLinksPage() throws Exception{
		super();
		pageURL = pageURL + "/examples/po";
	}
	
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
	
    public String getPageUrl() throws IOException {
        return pageURL;
    }
    
    public WebElement getBackLink() {
    	return backLink;
    }
    
    public void clickMoreOnArticle(int articleNumber) {
    	driver.findElement(By.xpath("(//a[text()='More >> '])[" + articleNumber + "]")).click();
    }
}
