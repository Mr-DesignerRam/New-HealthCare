package com.QA.POMClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseClass.BaseClass;
import com.QA.Util.UtilityClass;

public class LoginPOM extends BaseClass {

	public LoginPOM() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//ul[@id='sessionLocation']/li")
	private List<WebElement> listOfProfession;

	@FindBy(xpath = "//input[@id='loginButton']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[@id='cantLogin']")
	private WebElement cantLoginButton;

	public void valueOfUsername(Object object) {
		username.sendKeys(object.toString());
//		UtilityClass.setText(username, "admin");
	}

	public void valueOfPass(Object object) {
		password.sendKeys(object.toString());

//		UtilityClass.setText(password, "Admin123");
	}

	public void selectProfession(String str) {
		for (WebElement ele : listOfProfession) {
			if (ele.getText().equalsIgnoreCase(str)) {
				ele.click();

			}
		}

	}

	public void pressLogIn() {
		UtilityClass.clickWebElement(loginButton);
	}

	public void pressCanotLogIn() {
		UtilityClass.clickWebElement(cantLoginButton);
	}

}
