package pageEvent;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	public void findPatientbyNameinCaptureVitals() throws InterruptedException {
		enterCredentialsInpatient();
		ele.getElement("XPATH", LoginPageElements.CaptureVitalIcon).click();
		Thread.sleep(3000);
		String Name = ele.getElement("XPATH", LoginPageElements.NameCaptureVitals).getText();
		ele.getElement("XPATH", LoginPageElements.NameInVitalCaptureBox).sendKeys(Name);
		//System.out.println("Entered Name :" +Name);
		ele.getElement("XPATH", LoginPageElements.FirstnameInVital).click();
		Thread.sleep(3000);
		String ExpectedName = ele.getElement("XPATH", LoginPageElements.PatientNameInVital).getText();
		//System.out.println("Expected Name: "+ExpectedName);
		Assert.assertEquals(Name , ExpectedName);
		
	}
	
	public void findPatientbyIDinCaptureVitals() throws InterruptedException {
		enterCredentialsInpatient();
		ele.getElement("XPATH", LoginPageElements.CaptureVitalIcon).click();
		Thread.sleep(3000);
		String ID = ele.getElement("CSS", LoginPageElements.IdinVital).getText();
		String InputID = ID.substring(0, 5);
		System.out.print(InputID);
		ele.getElement("XPATH", LoginPageElements.NameInVitalCaptureBox).sendKeys(InputID);
		Thread.sleep(3000);
		ele.getElement("XPATH", LoginPageElements.FirstnameInVital).click();
	}
	
	public void registerPatientUsingExcelSheet(String given, String middle, String familyName, String day, String year, String address, String phone, String personName) throws IOException, InterruptedException {
		
		enterCredentialsInpatient();
		ele.getElement("XPATH", LoginPageElements.ClickRegisterPatient).click();
		/*
		 * FileInputStream fis = new FileInputStream(
		 * "C:\\Users\\Minfy.DESKTOP-KB2S39B\\eclipse-workspace\\OpenEMR_Automation_Test\\datafiles\\RegisterPatient.xlsx"
		 * ); XSSFWorkbook workbook = new XSSFWorkbook(fis); XSSFSheet sheet =
		 * workbook.getSheet("Sheet1"); int rowcount = sheet.getLastRowNum(); int
		 * colcount = sheet.getRow(1).getLastCellNum();
		 * System.out.println("rowccount :"+rowcount+"colcount :"+colcount);
		 * 
		 * for(int i =1;i<=rowcount;i++) { XSSFRow celldata = sheet.getRow(i); String
		 * given = celldata.getCell(0).getStringCellValue(); String middle =
		 * celldata.getCell(1).getStringCellValue(); String familyName =
		 * celldata.getCell(2).getStringCellValue(); String day =
		 * celldata.getCell(3).getStringCellValue(); String year =
		 * celldata.getCell(4).getStringCellValue(); String address =
		 * celldata.getCell(5).getStringCellValue(); String phone =
		 * celldata.getCell(6).getStringCellValue(); String personName =
		 * celldata.getCell(7).getStringCellValue();
		 */
				
			
			ele.getElement("XPATH", LoginPageElements.GivenName).sendKeys(given);
			ele.getElement("XPATH", LoginPageElements.MiddleName).sendKeys(middle);
			ele.getElement("XPATH", LoginPageElements.LastName).sendKeys(familyName);
			ele.getElement("XPATH", LoginPageElements.NextButton).click();

			ele.getElement("XPATH", LoginPageElements.GenderSelect).click();
			ele.getElement("XPATH", LoginPageElements.NextButton).click();
			Thread.sleep(5000);
			ele.getElement("XPATH", LoginPageElements.BirthdateDay).sendKeys(day);
			ele.getElement("XPATH", LoginPageElements.BirthdateMonth).click();
			ele.getElement("XPATH", LoginPageElements.BirthdateYear).sendKeys(year);
			ele.getElement("XPATH", LoginPageElements.NextButton).click();

			ele.getElement("XPATH", LoginPageElements.AddressLocator).sendKeys(address);
			;
			ele.getElement("XPATH", LoginPageElements.NextButton).click();
			Thread.sleep(3000);
			ele.getElement("XPATH", LoginPageElements.PhoneNumber).sendKeys(phone);
			ele.getElement("XPATH", LoginPageElements.NextButton).click();
			Thread.sleep(3000);

			ele.getElement("XPATH", LoginPageElements.PatientRelation).click();
			ele.getElement("XPATH", LoginPageElements.PersonName).sendKeys(personName);
			ele.getElement("XPATH", LoginPageElements.NextButton).click();

			ele.getElement("XPATH", LoginPageElements.ConfirmButton).click();
			Thread.sleep(3000);
			verifyPatinetIDGenerated();

		}
	
	
	public void recordVitals() throws InterruptedException {
		findPatientbyNameinCaptureVitals();
		
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
