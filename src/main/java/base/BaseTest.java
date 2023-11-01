package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import utils.Constant;



public class BaseTest {
	
	public static WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void beforMethod(String browser, Method testMethod) {
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constant.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void setupDriver(String browser) {
		if(browser.equals("chrome")) {
			 driver = new ChromeDriver();
		}
	}
}
