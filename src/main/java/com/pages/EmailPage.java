package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.common.PageObject;

public class EmailPage extends PageObject {

	String emailTextBox = "//form[@name=\"myForm\"]/input";

	String validationLabel = "//input[@type=\"email\"]//following::h1";

	PageObject pageObject = new PageObject();

	public EmailPage moveToResultFrame() throws FileNotFoundException, IOException {
		pageObject.launcPage();
		driver.switchTo().frame("iframeResult");
		return this;
	}

	public EmailPage enterEmail(String email) {
		driver.findElement(By.xpath(emailTextBox)).sendKeys(email);

		return this;
	}

	public String readStatus() {
		return driver.findElement(By.xpath(validationLabel)).getText();

	}

}
