package pageEvent;

import org.testng.Assert;

import base.BaseTest;
import pageObject.LoginPageElements;
import utils.Element_Fetch;

public class LoginPage{

	Element_Fetch ele = new Element_Fetch();

	public void verifyIfLoginPageIsLoaded() {
		Assert.assertTrue(ele.getElements("ID", LoginPageElements.LoginTest).size() > 0, "Element not found");
	}

	public void enterCredentialsInpatient() {
		ele.getElement("XPATH", LoginPageElements.UserName).sendKeys("Admin");
		ele.getElement("XPATH", LoginPageElements.PasswordField).sendKeys("Admin123");
		ele.getElement("XPATH", LoginPageElements.InpatientWard).click();
		ele.getElement("XPATH", LoginPageElements.LoginTest).click();
		String expectedTitle = "Logged in as Super User (admin) at Inpatient Ward.";
		String ActualTitle = (ele.getElement("XPATH", LoginPageElements.LoginTitle).getText());
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

		ele.getElement("XPATH", LoginPageElements.FindpatientRecord).click();
		ele.getElement("XPATH", LoginPageElements.SearchbyID).sendKeys("a a");
		Thread.sleep(3000);
		
		if(ele.getElement("XPATH", LoginPageElements.FirsttableElemnt).isDisplayed()) {
			ele.getElement("XPATH", LoginPageElements.FirsttableElemnt).click();
		}
		else {
			System.out.println("No result found !!");
			ele.getElement("XPATH", LoginPageElements.NoMatchingRecord).getText();
		    
		}
	}

	public void registerPatient() throws InterruptedException {
		enterCredentialsInpatient();

		ele.getElement("XPATH", LoginPageElements.ClickRegisterPatient).click();
		ele.getElement("XPATH", LoginPageElements.GivenName).sendKeys("Neymar");
		ele.getElement("XPATH", LoginPageElements.MiddleName).sendKeys("Sr Neymar");
		ele.getElement("XPATH", LoginPageElements.LastName).sendKeys("da Silva Santos");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();

		ele.getElement("XPATH", LoginPageElements.GenderSelect).click();
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		Thread.sleep(5000);
		ele.getElement("XPATH", LoginPageElements.BirthdateDay).sendKeys("5");
		ele.getElement("XPATH", LoginPageElements.BirthdateMonth).click();
		ele.getElement("XPATH", LoginPageElements.BirthdateYear).sendKeys("1990");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();

		ele.getElement("XPATH", LoginPageElements.AddressLocator).sendKeys("Sao Paulo Brazil");
		;
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.PhoneNumber).sendKeys("111111111");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		Thread.sleep(3000);

		ele.getElement("XPATH", LoginPageElements.PatientRelation).click();
		ele.getElement("XPATH", LoginPageElements.PersonName).sendKeys("Dyabala");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();

		ele.getElement("XPATH", LoginPageElements.ConfirmButton).click();
		Thread.sleep(3000);
		verifyPatinetIDGenerated();
	}

	public void verifyPatinetIDGenerated() {
		ele.getElement("XPATH", LoginPageElements.verifyPatinetID).isDisplayed();
		System.out.println(ele.getElement("XPATH", LoginPageElements.verifyPatinetID).getText());
	}

	// Appointment scheduling
	public void createNewservicesManageServicetype() throws InterruptedException {
		enterCredentialsInpatient();
		ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
		ele.getElement("XPATH", LoginPageElements.ManageServicesIcon).click();
		ele.getElement("XPATH", LoginPageElements.NewServiceTypebutton).click();
		ele.getElement("XPATH", LoginPageElements.NameField).clear();
		ele.getElement("XPATH", LoginPageElements.NameField).sendKeys("Sergio Ramos");
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.DurationField).sendKeys("90");
		ele.getElement("XPATH", LoginPageElements.DescriptionField).sendKeys("Surgical department");
		ele.getElement("XPATH", LoginPageElements.SaveServiceType).click();
		Thread.sleep(3000);

	}

	// Isolation Ward
	public void findPatientRecordIsolationWard() throws InterruptedException {
		enterCredentialsIsolation();
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.FindpatientRecord).click();
		ele.getElement("XPATH", LoginPageElements.SearchbyID).sendKeys("Muhammad Rian Ardianto");
		ele.getElement("XPATH", LoginPageElements.FirsttableElemnt).click();
	}

	public void registerPatientIsolationWard() throws InterruptedException {
		enterCredentialsIsolation();
		ele.getElement("XPATH", LoginPageElements.ClickRegisterPatient).click();
		ele.getElement("XPATH", LoginPageElements.GivenName).sendKeys("Neymar");
		ele.getElement("XPATH", LoginPageElements.MiddleName).sendKeys("Sr Neymar");
		ele.getElement("XPATH", LoginPageElements.LastName).sendKeys("da Silva Santos");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();

		ele.getElement("XPATH", LoginPageElements.GenderSelect).click();
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.BirthdateDay).sendKeys("5");
		ele.getElement("XPATH", LoginPageElements.BirthdateMonth).click();
		ele.getElement("XPATH", LoginPageElements.BirthdateYear).sendKeys("1990");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();

		ele.getElement("XPATH", LoginPageElements.AddressLocator).sendKeys("Sao Paulo Brazil");
		;
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.PhoneNumber).sendKeys("111111111");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		Thread.sleep(3000);

		ele.getElement("XPATH", LoginPageElements.PatientRelation).click();
		ele.getElement("XPATH", LoginPageElements.PersonName).sendKeys("Dyabala");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();

		ele.getElement("XPATH", LoginPageElements.ConfirmButton).click();
		Thread.sleep(3000);
		verifyPatinetIDGenerated();
	}

	public void registerPatientwithoutMandotory() {
		enterCredentialsIsolation();
		ele.getElement("XPATH", LoginPageElements.ClickRegisterPatient).click();
		ele.getElement("XPATH", LoginPageElements.GivenName).sendKeys("Neymar");
		ele.getElement("XPATH", LoginPageElements.MiddleName).sendKeys("Sr Neymar");
		ele.getElement("XPATH", LoginPageElements.NextButton).click();
		boolean isEnable =  ele.getElement("XPATH", LoginPageElements.MandotryField).isEnabled();
		if(isEnable) {
			System.out.print("We can not proceed without Mandotry feild");
		}
		
	}
	
	public void createNewservicesManageServicetypeinIsolation() throws InterruptedException {
		enterCredentialsIsolation();
		ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
		ele.getElement("XPATH", LoginPageElements.ManageServicesIcon).click();
		ele.getElement("XPATH", LoginPageElements.NewServiceTypebutton).click();
		ele.getElement("XPATH", LoginPageElements.NameField).clear();
		ele.getElement("XPATH", LoginPageElements.NameField).sendKeys("Sergio Ramos");
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.DurationField).sendKeys("90");
		ele.getElement("XPATH", LoginPageElements.DescriptionField).sendKeys("Surgical department");
		ele.getElement("XPATH", LoginPageElements.SaveServiceType).click();
		Thread.sleep(3000);

	}
	
	public void findAppointmenetsInIsolation() throws InterruptedException {
		enterCredentialsIsolation();
		ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
		ele.getElement("XPATH", LoginPageElements.AppointmentRequest).click();
		String PatientName = ele.getElement("XPATH", LoginPageElements.PatientName).getText();
		ele.getElement("XPATH", LoginPageElements.ReturnAppointScheduling).click();
		ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
		ele.getElement("XPATH", LoginPageElements.ManageAppointmenet).click();
		ele.getElement("XPATH", LoginPageElements.SearchPatient).sendKeys(PatientName);
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.ClickOnFirstElementManageAppointment).click();
		Thread.sleep(3000);
		
		
		System.out.print(PatientName);
		/*
		 * 
		 * ele.getElement("XPATH",
		 * LoginPageElements.SearchPatient).sendKeys("Shaiful Family");
		 */
	}
	
	//Laboratory
	
		public void findPatientRecordLaboratory() throws InterruptedException {
			enterCredentialsLaboratory();
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.FindpatientRecord).click();
			ele.getElement("XPATH", LoginPageElements.SearchbyID).sendKeys("Muhammad Edwin Pratomo");
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.FirsttableElemnt).click();
		}
	
		public void registerPatientLaboratory() throws InterruptedException {
			enterCredentialsLaboratory();
			ele.getElement("XPATH", LoginPageElements.ClickRegisterPatient).click();
			ele.getElement("XPATH", LoginPageElements.GivenName).sendKeys("Neymar");
			ele.getElement("XPATH", LoginPageElements.MiddleName).sendKeys("Sr Neymar");
			ele.getElement("XPATH", LoginPageElements.LastName).sendKeys("da Silva Santos");
			ele.getElement("XPATH", LoginPageElements.NextButton).click();

			ele.getElement("XPATH", LoginPageElements.GenderSelect).click();
			ele.getElement("XPATH", LoginPageElements.NextButton).click();
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.BirthdateDay).sendKeys("5");
			ele.getElement("XPATH", LoginPageElements.BirthdateMonth).click();
			ele.getElement("XPATH", LoginPageElements.BirthdateYear).sendKeys("1990");
			ele.getElement("XPATH", LoginPageElements.NextButton).click();

			ele.getElement("XPATH", LoginPageElements.AddressLocator).sendKeys("Sao Paulo Brazil");
			;
			ele.getElement("XPATH", LoginPageElements.NextButton).click();
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.PhoneNumber).sendKeys("111111111");
			ele.getElement("XPATH", LoginPageElements.NextButton).click();
			Thread.sleep(3000);

			ele.getElement("XPATH", LoginPageElements.PatientRelation).click();
			ele.getElement("XPATH", LoginPageElements.PersonName).sendKeys("Dyabala");
			ele.getElement("XPATH", LoginPageElements.NextButton).click();

			ele.getElement("XPATH", LoginPageElements.ConfirmButton).click();
			Thread.sleep(3000);
			verifyPatinetIDGenerated();
		}
		public void createNewservicesManageServicetypeinLaboratory() throws InterruptedException {
			enterCredentialsLaboratory();
			ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
			ele.getElement("XPATH", LoginPageElements.ManageServicesIcon).click();
			ele.getElement("XPATH", LoginPageElements.NewServiceTypebutton).click();
			ele.getElement("XPATH", LoginPageElements.NameField).clear();
			ele.getElement("XPATH", LoginPageElements.NameField).sendKeys("Sergio Ramos");
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.DurationField).sendKeys("90");
			ele.getElement("XPATH", LoginPageElements.DescriptionField).sendKeys("Surgical department");
			ele.getElement("XPATH", LoginPageElements.SaveServiceType).click();
			Thread.sleep(3000);

		}
		
		public void findAppointmenetsInLaboratory() throws InterruptedException {
			enterCredentialsLaboratory();
			ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
			ele.getElement("XPATH", LoginPageElements.AppointmentRequest).click();
			if(ele.getElement("XPATH", LoginPageElements.noAppointmentLocator).isDisplayed() == true) {
				System.out.println("No Appointments are present");
				
			}
			else{String PatientName = ele.getElement("XPATH", LoginPageElements.PatientName).getText();
			ele.getElement("XPATH", LoginPageElements.ReturnAppointScheduling).click();
			ele.getElement("XPATH", LoginPageElements.AppoinmentSchedulerIcon).click();
			ele.getElement("XPATH", LoginPageElements.ManageAppointmenet).click();
			ele.getElement("XPATH", LoginPageElements.SearchPatient).sendKeys(PatientName);
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.ClickOnFirstElementManageAppointment).click();
			Thread.sleep(3000);
			
			
			System.out.print(PatientName);
			}
		}
}
