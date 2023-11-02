package pageObject;

public interface LoginPageElements {
	
	String LoginTest = "//input[@id='loginButton']";
	String UserName = "//input[@id = 'username']";
	String PasswordField = "//input[@id = 'password']";
	String InpatientWard = "//li[text() = 'Inpatient Ward']";
	String IsolationWard = "//li[text() = 'Isolation WardIsolation Ward']";
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
	
	
	
}
