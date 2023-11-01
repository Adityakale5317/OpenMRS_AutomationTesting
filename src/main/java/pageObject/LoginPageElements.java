package pageObject;

public interface LoginPageElements {
	
	String LoginTest = "//input[@id='loginButton']";
	String UserName = "//input[@id = 'username']";
	String PasswordField = "//input[@id = 'password']";
	String InpatientWard = "//li[text() = 'Inpatient Ward']";
	String IsolationWard = "//li[text() = 'Isolation WardIsolation Ward']";
	String Laboratory = "//li[text() = 'Laboratory']";
}
