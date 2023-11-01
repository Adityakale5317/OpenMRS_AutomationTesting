package OpenEMR_Automation_Test.OpenEMR_Automation_Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LauchBrowsers {
	
	@Test
	public void LaunchChrome () throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	

}
