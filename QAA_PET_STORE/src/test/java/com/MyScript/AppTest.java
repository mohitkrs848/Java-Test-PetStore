package com.MyScript;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PetStore_Mohit_Kumar.pages.PageTest1;
import com.PetStore_Mohit_Kumar.pages.PageTest2;
import com.PetStore_Mohit_Kumar.pages.PageTest3;
import com.PetStore_Mohit_Kumar.pages.PageTest4;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AppTest {
	WebDriver wd;

	PageTest1 p1 = new PageTest1();
	PageTest2 p2 = new PageTest2();
	PageTest3 p3 = new PageTest3();
	PageTest4 p4 = new PageTest4();

	static ExtentTest test;
	static ExtentReports rep;

	@BeforeTest
	public void driverPathSet() {
		System.out.println("Select the browser you want to use:\nEnter '1' for Chrome\nEnter '2' for Firefox");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 1) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			wd = new ChromeDriver();
		} else if (choice == 2) {
			System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
			wd = new FirefoxDriver();
		}
		rep = new ExtentReports(System.getProperty("user.dir") + "./Reports/PetStoreReport.html");
		test = rep.startTest("JpetScript");

	}

	@Test(priority = 1)
	public void launch() throws InterruptedException {
		Thread.sleep(2000);
		p1.init_pagetest_1(wd);
		p1.launch_app_pt1();
		test.log(LogStatus.PASS, "User has successfully launched the application");
	}

	@Test(priority = 2)
	public void launch_store() throws InterruptedException {
		Thread.sleep(2000);
		p1.enter_store();
		test.log(LogStatus.PASS, "User has successfully launched the store");
	}

	@Test(priority = 3)
	public void signin_store() throws InterruptedException {
		Thread.sleep(2000);
		p2.init_pagetest_2(wd);
		p2.open_signin_page();
		test.log(LogStatus.PASS, "User has successfully sign in into the store");
	}

	@Test(priority = 4)
	public void login_page_test() throws InterruptedException, IOException {
		p3.init_pagetest_3(wd);
		Thread.sleep(2000);
		p3.enter_username();
		Thread.sleep(2000);
		p3.enter_password();
		Thread.sleep(2000);
		p3.click_login();
		test.log(LogStatus.PASS, "User has successfully entered the login credentials");
	}

	@Test(priority = 4)
	public void validate_login() throws InterruptedException, IOException {
		Thread.sleep(2000);
		p4.init_pagetest_4(wd);
		p4.loginValidation();
		test.log(LogStatus.PASS, "User has successfully login into the application");
	}

	@AfterTest
	public void postcondition() throws InterruptedException {
		wd.manage().deleteAllCookies();
		Thread.sleep(4000);
		wd.close();
		rep.endTest(test);
		rep.flush();
	}
}
