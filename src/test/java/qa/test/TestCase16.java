package qa.test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvent.LoginPage;
import utils.DataProviders;
import utils.Element_Fetch;

public class TestCase16 extends BaseTest {
Element_Fetch ele = new Element_Fetch();
LoginPage loginPage = new LoginPage();
@Test(dataProvider = "registerPatientExcelData", dataProviderClass = DataProviders.class)
  public void registerPatientUsingExcelData(String given, String middle, String familyName, String day, String year, String address, String phone, String personName) throws IOException, InterruptedException {
	  loginPage.registerPatientUsingExcelSheet(given,middle,familyName, day,year,address, phone,personName);
  }
}
