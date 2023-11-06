package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import utils.Constant;



public class BaseTest {
	

public static WebDriver driver;
public ExtentSparkReporter sparkReporter;
public ExtentReports extent;
public ExtentTest logger;
	
	
	@BeforeTest
	public void beforeTestMethod() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"TestReports.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Test Report");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforMethod(String browser, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constant.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +"- Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +"- Test Case Failed", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +"- Test Case Skipped", ExtentColor.ORANGE));
			}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() +"- Test Case Pass", ExtentColor.GREEN));
		}
			
		driver.quit();
	}
	@AfterTest
	public void aftertest() {
		extent.flush();
	}
	public void setupDriver(String browser) {
		if(browser.equals("chrome")) {
			 driver = new ChromeDriver();
		}
	}

}
