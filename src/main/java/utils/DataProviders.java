package utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider
	public Object[][] registerPatientExcelData() throws IOException {
 
		Object[][] main = ExcelUtils.sheetIntoObjectArray("datafiles/RegisterPatient.xlsx",
				"RegisterPatientExcelDPTest");
		return main;
	}
}
