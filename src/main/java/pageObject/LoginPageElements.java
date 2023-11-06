package pageObject;

public interface LoginPageElements {
	
	String LoginTest = "//input[@id='loginButton']";
	String UserName = "//input[@id = 'username']";
	String PasswordField = "//input[@id = 'password']";
	String InpatientWard = "//li[text() = 'Inpatient Ward']";
	String IsolationWard = "//li[@id='Isolation Ward']";
	String Laboratory = "//li[text() = 'Laboratory']";
	String LoginTitle = "//div/h4[contains(text(),  'Logged in as Super User (admin) at Inpatient Ward.')]";
	String FindpatientRecord = "//a/i[@class='icon-search']";
	String SearchbyID = "//input[@placeholder='Search by ID or Name']";
	String FirsttableElemnt = "//tr/td[2]";
	String ClickRegisterPatient = "//i[@class='icon-user']";
	String GivenName = "//input [@name='givenName']";
	String  MiddleName= "//input[@name='middleName']";
	String LastName = "//input[@name='familyName']";
	String NextButton = "//button[@id='next-button']";
	String GenderSelect = "//select[@id='gender-field']/option[1]";
	String BirthdateDay = "//input[@name='birthdateDay']";
	String BirthdateMonth = "//select/option[contains(text(),'March')]";
	String BirthdateYear = "//input[@name='birthdateYear']";
	String AddressLocator = "//input[@id='address1']";
	String PhoneNumber = "//input[@name='phoneNumber']";
	String PatientRelation = "//select/option[contains(text(),'Parent')]";
	String PersonName = "//input[@placeholder='Person Name']";
	String ConfirmButton = "//input[@id = 'submit']";
	String verifyPatinetID = "//div[@class='float-sm-right']/span";
	String AppoinmentSchedulerIcon = "//a[@id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']";
	String ManageServicesIcon = "//a[@id='appointmentschedulingui-manageAppointmentTypes-app']";
	String NewServiceTypebutton = "//button[@class='confirm appointment-type-label right']";
	String NameField = "//input[@id='name-field']";
	String DurationField = "//input[@id='duration-field']";
	String DescriptionField = "//textarea[@id='description-field']";
	String SaveServiceType = "//input[@id='save-button']";
	String NoMatchingRecord = "//td[text()='No matching records found']";
	String MandotryField = "//span[@id = 'fr1155']";
	String ManageAppointmenet = "//a[@id='appointmentschedulingui-manageAppointments-app']";
	String SearchPatient = "//input[@id='patient-search']";
	String AppointmentRequest = " //a[@id='appointmentschedulingui-appointmentRequests-app']";
	String PatientName = "//tr/td[1]";
	String ReturnAppointScheduling = "/html/body/header/nav/div[1]/a";
	String ClickOnFirstElementManageAppointment = "//*[@id=\"patient-search-results-table\"]/tbody/tr/td[1]";
	String noAppointmentLocator = "//span/p[contains(text(),'No appointment requests')]";
	
	
}
