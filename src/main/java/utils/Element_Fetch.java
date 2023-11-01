package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class Element_Fetch {
	
	public WebElement getElement(String identifiertype, String identifiervalue) {
		
		switch(identifiertype) {
		
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifiervalue));	
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifiervalue));
		case "Name":
			return BaseTest.driver.findElement(By.name(identifiervalue));
		case "ID":
			return BaseTest.driver.findElement(By.id(identifiervalue));
			
		
			default:
				return null;
		}
	}
	
	public List<WebElement> getElements(String identifiertype, String identifiervalue) {
		
		switch(identifiertype) {
		
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifiervalue));	
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifiervalue));
		case "Name":
			return BaseTest.driver.findElements(By.name(identifiervalue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifiervalue));
			
		
			default:
				return null;
		}
	}
}
