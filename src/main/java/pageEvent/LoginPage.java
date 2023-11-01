package pageEvent;

import org.testng.Assert;

import pageObject.LoginPageElements;
import utils.Element_Fetch;

public class LoginPage {
	
	Element_Fetch ele = new Element_Fetch();
	public void verifyIfLoginPageIsLoaded() {
		Assert.assertTrue(ele.getElements("ID", LoginPageElements.LoginTest).size() > 0,"Element not found");
	}
	
	public void enterCredentialsInpatient() {
		ele.getElement("XPATH", LoginPageElements.UserName).sendKeys("Admin");
		ele.getElement("XPATH", LoginPageElements.PasswordField).sendKeys("Admin123");
		ele.getElement("XPATH", LoginPageElements.InpatientWard).click();
		ele.getElement("XPATH", LoginPageElements.LoginTest).click();
		
		
	}
	
	public void enterCredentialsIsolation() {
		ele.getElement("XPATH", LoginPageElements.UserName).sendKeys("Admin");
		ele.getElement("XPATH", LoginPageElements.PasswordField).sendKeys("Admin123");
		ele.getElement("XPATH", LoginPageElements.IsolationWard).click();
		ele.getElement("XPATH", LoginPageElements.LoginTest).click();
		
	}
	
	public void enterCredentialsLaboratory() {
		ele.getElement("XPATH", LoginPageElements.UserName).sendKeys("Admin");
		ele.getElement("XPATH", LoginPageElements.PasswordField).sendKeys("Admin123");
		ele.getElement("XPATH", LoginPageElements.Laboratory).click();
		ele.getElement("XPATH", LoginPageElements.LoginTest).click();
		
	}
	
}
