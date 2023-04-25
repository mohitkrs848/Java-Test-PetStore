package com.PetStore_Mohit_Kumar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTest1 {
	WebDriver wd;

	public void init_pagetest_1(WebDriver wd) {
		this.wd = wd;
	}

	public void launch_app_pt1() {
		wd.get("https://petstore.octoperf.com/");
		wd.manage().window().maximize();
		String exp_web_title = "JPetStore Demo";
		String act_web_title = wd.getTitle();
		if (act_web_title.equals(exp_web_title)) {
			System.out.println("PetStore web Application Launched successfully.");
		} else {
			System.out.println("Error while launching the PetStore Web Application.");
		}
	}

	public void enter_store() {
		wd.findElement(By.linkText("Enter the Store")).click();
	}
}
