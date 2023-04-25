package com.PetStore_Mohit_Kumar.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTest3 {
	WebDriver wd;
	FileReader fr;
	Properties p = new Properties();

	By usr = By.xpath("//input[@name =\"username\"]");
	By pwd = By.xpath("//input[@name =\"password\"]");
	By login_btn = By.xpath("//input[@name =\"signon\"]");

	public void init_pagetest_3(WebDriver wd) {
		this.wd = wd;
	}

	public void enter_username() throws IOException {
		if (wd.findElement(usr).isDisplayed()) {
			fr = new FileReader(".//TestData//TestData.properties");
			p.load(fr);
			wd.findElement(usr).clear();
			wd.findElement(usr).sendKeys(p.getProperty("userName"));
		} else {
			System.out.println("Username input space is not available.");
		}

	}

	public void enter_password() throws IOException {
		if (wd.findElement(pwd).isDisplayed()) {
			fr = new FileReader(".//TestData//TestData.properties");
			p.load(fr);
			wd.findElement(pwd).clear();
			wd.findElement(pwd).sendKeys(p.getProperty("password"));
		} else {
			System.out.println("Password input space is not available.");
		}

	}

	public void click_login() throws IOException {
		if (wd.findElement(login_btn).isDisplayed()) {
			wd.findElement(login_btn).click();
		} else {
			System.out.println("Login button is not available.");
		}

	}
}