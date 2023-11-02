package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class SuiteListener implements ITestListener{

	public void captureScreenshot(ITestResult result) {
		try {
		String filename = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		File f1 = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(f1, new File(filename+ ".png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		catch(Exception e) {
			
		}
	}
}
