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
		String expectedTitle = "Logged in as Super User (admin) at Inpatient Ward.";
		String ActualTitle =(ele.getElement("XPATH", LoginPageElements.LoginTitle).getText()); 
		Assert.assertEquals(expectedTitle, ActualTitle);
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
	
	public void findPatientRecord() throws InterruptedException {
		enterCredentialsInpatient();
		Thread.sleep(5000);
		ele.getElement("XPATH", LoginPageElements.FindpatientRecord).click();
		ele.getElement("XPATH", LoginPageElements.SearchbyID).sendKeys("a a");
		ele.getElement("XPATH", LoginPageElements.FirsttableElemnt).click();
		
	}
	
	public void registerPatient() throws InterruptedException {
		enterCredentialsInpatient();
		
		ele.getElement("XPATH", LoginPageElements.ClickRegisterPatient).click();
		ele.getElement("XPATH",LoginPageElements.GivenName).sendKeys("Neymar");
		ele.getElement("XPATH",LoginPageElements.MiddleName).sendKeys("Sr Neymar");
		ele.getElement("XPATH",LoginPageElements.LastName).sendKeys("da Silva Santos");
		ele.getElement("XPATH",LoginPageElements.NextButton).click();
		
		ele.getElement("XPATH",LoginPageElements.GenderSelect).click();
		ele.getElement("XPATH",LoginPageElements.NextButton).click();
		Thread.sleep(5000);
		ele.getElement("XPATH",LoginPageElements.BirthdateDay).sendKeys("5");
		ele.getElement("XPATH",LoginPageElements.BirthdateMonth).click();
		ele.getElement("XPATH",LoginPageElements.BirthdateYear).sendKeys("1990");
		ele.getElement("XPATH",LoginPageElements.NextButton).click();
		
		ele.getElement("XPATH",LoginPageElements.AddressLocator).sendKeys("Sao Paulo Brazil");;
		ele.getElement("XPATH",LoginPageElements.NextButton).click();
		Thread.sleep(3000);
		ele.getElement("XPATH",LoginPageElements.PhoneNumber).sendKeys("111111111");
		ele.getElement("XPATH",LoginPageElements.NextButton).click();
		Thread.sleep(3000);
		
		ele.getElement("XPATH",LoginPageElements.PatientRelation).click();
		ele.getElement("XPATH",LoginPageElements.PersonName).sendKeys("Dyabala");
		ele.getElement("XPATH",LoginPageElements.NextButton).click();
		
		ele.getElement("XPATH",LoginPageElements.ConfirmButton).click();
		Thread.sleep(3000);
		verifyPatinetIDGenerated();
	}
	
	public void verifyPatinetIDGenerated() {
	   ele.getElement("XPATH",LoginPageElements.verifyPatinetID).isDisplayed();
		System.out.println(ele.getElement("XPATH",LoginPageElements.verifyPatinetID).getText());
	}
	
}
