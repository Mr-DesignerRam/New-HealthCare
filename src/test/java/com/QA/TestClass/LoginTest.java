package com.QA.TestClass;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.QA.BaseClass.BaseClass;
import com.QA.Listener.MyListener;
import com.QA.POMClass.LoginPOM;
import com.QA.Util.UtilityClass;


@Listeners(MyListener.class)
public class LoginTest extends BaseClass {

	SoftAssert SAssert = new SoftAssert();

	@BeforeMethod
	public void setup() throws IOException {
		launchBrowser();
	}
	
	

	@Test
	public void welcomeTest() {
		System.out.println("Welcome to Our Health Care Domain Project");
		String expectedResult = prop.getProperty("LoginTitle");
		String Actual = driver.getTitle();
		SAssert.assertEquals(expectedResult, Actual);
	}
	
	@DataProvider(name="PassData")
	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
		Object[][] result = UtilityClass.fetchDataFromExcel();
		return result;
	}

	@Test(dataProvider = "PassData")
	public void loginDetails(Map<String, Object> data) {
		
		System.out.println(data);
		LoginPOM login = new LoginPOM();
		login.valueOfUsername(data.get("Username").toString());
		login.valueOfPass(data.get("Password").toString());
		login.selectProfession(data.get("Profession").toString());
		login.pressLogIn();
//		-
	}
}
