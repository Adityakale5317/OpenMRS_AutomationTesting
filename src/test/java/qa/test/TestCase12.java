package qa.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvent.LoginPage;
import utils.Element_Fetch;

public class TestCase12 extends BaseTest{
Element_Fetch ele = new Element_Fetch();
LoginPage loginPage = new LoginPage();
  @Test
  public void verifyUsercreatingNewservicesinManageServicesTypeLaboratory() throws InterruptedException {
	  loginPage.createNewservicesManageServicetypeinLaboratory();
  }
}
