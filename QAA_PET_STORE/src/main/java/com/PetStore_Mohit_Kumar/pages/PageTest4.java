package com.PetStore_Mohit_Kumar.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.io.Files;

public class PageTest4 {
	WebDriver wd;

	public void init_pagetest_4(WebDriver wd) {
		this.wd = wd;
	}

	public void loginValidation() throws IOException {
		WebElement valid_login = wd.findElement(By.xpath("//a[@href=\"/actions/Account.action?editAccountForm=\"]"));
		String exp = "My Account";
		String act = valid_login.getText();
		Assert.assertEquals(act, exp, "Login Error");
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./ScreenShots/LoginValidation.png"));
	}
}
