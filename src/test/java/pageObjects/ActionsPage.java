package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import util.Driver;

public class ActionsPage extends GenericPage {

	private Driver driver;
	
    @FindBy(how = How.TAG_NAME, using = "p")
    private List<WebElement> allParagraphs;
    @FindBy(how = How.CSS, using = "input#vfb-9[type='text']")
    private WebElement textBox;
    @FindBy(how = How.CSS, using = "input[type='number']")
    private WebElement numberBox;
    @FindBy(how = How.TAG_NAME, using = "textarea")
    private WebElement textArea;
    @FindBy(how = How.CSS, using = "#vfb-12")
    private WebElement selectField;
    @FindBy(how = How.CSS, using = "input[type=url]")
    private WebElement urlField;
    
	public ActionsPage() throws Exception{
		super();
		pageURL = pageURL + "/examples/act";
	}
	
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
	
    public String getPageUrl() throws IOException {
        return pageURL;
    }    

    public void selectOption(String option) throws IOException {
    	driver.findElement(By.cssSelector(".w3-check[value='" + option + "'][type='checkbox']")).click();
    }

    public boolean isOptionSelected(String option) throws IOException {
    	return driver.findElement(By.cssSelector(".w3-check[value='" + option + "'][type='checkbox']")).isSelected();
    }
    
    public String getSampleTextByClass(String className) throws IOException {
        return driver.findElement(By.cssSelector("p." + className)).getText();
    }

    public String getSampleTextById(String idName) throws IOException {
        return driver.findElement(By.cssSelector("p#" + idName)).getText();
    }
    
    public String getTextBoxText() {
        return textBox.getAttribute("value");
    }
    
    public String getNumberBoxText() {
        return numberBox.getAttribute("value");
    }
    
    public String getTextAreaText() {
        return textArea.getText();
    }
    
    public String getSelectFieldText() {
    	Select dropdown = new Select(selectField);
        return dropdown.getFirstSelectedOption().getText();
    }
    
    public String getUrlFieldText() {
        return urlField.getAttribute("value");
    }
}
