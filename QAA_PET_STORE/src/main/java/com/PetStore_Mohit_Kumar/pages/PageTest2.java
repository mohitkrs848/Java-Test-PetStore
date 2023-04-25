package com.PetStore_Mohit_Kumar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTest2 {
	WebDriver wd;

	public void init_pagetest_2(WebDriver wd) {
		this.wd = wd;
	}

	public void open_signin_page() {
		WebElement signin = wd.findElement(By.linkText("Sign In"));
		if (signin.isDisplayed()) {
			signin.click();
			System.out.println("The user clicked on the sign in button successfully.");
		} else {
			System.out.println("Sign in button is not visible.");
		}
	}

}
