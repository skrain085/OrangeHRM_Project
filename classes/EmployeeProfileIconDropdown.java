package com.OrangeHRM_Application.classes;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeProfileIconDropdown extends LoginFunctionality{
	
	@BeforeMethod
	public void loginToApplication() {
		try {
			 driverInitialize();
			 loadProperty();
			 loginFunction();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void viewAboutInfo() {
		try {
			Thread.sleep(2000);
			//Getting input from properties file
			Properties p = loadProperty();
			String ProfileIconDropdown_locator = p.getProperty("ProfileIconDropdown_locator");
			String ProfileIconDropdown_About_locator = p.getProperty("ProfileIconDropdown_About_locator");
		    //ClickOn Profile Dropdown
		    driver.findElement(By.xpath(ProfileIconDropdown_locator)).click();
		    Thread.sleep(2000);
		    //ClickOn About
		    driver.findElement(By.linkText(ProfileIconDropdown_About_locator)).click();
		    Thread.sleep(2000);
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 1)
	public void viewSupportInfo() {
		try {
			Thread.sleep(2000);
			//Getting input from properties file
			Properties p = loadProperty();
			String ProfileIconDropdown_locator = p.getProperty("ProfileIconDropdown_locator");
			String ProfileIconDropdown_Support_locator = p.getProperty("ProfileIconDropdown_Support_locator");
		    //ClickOn Profile Dropdown
		    driver.findElement(By.xpath(ProfileIconDropdown_locator)).click();
		    Thread.sleep(2000);
		    //ClickOn Support
		    driver.findElement(By.linkText(ProfileIconDropdown_Support_locator)).click();
		    Thread.sleep(2000);
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 2)
	public void logoutTheApplication() {
		try {
			Thread.sleep(2000);
			//Getting input from properties file
			Properties p = loadProperty();
			String ProfileIconDropdown_locator = p.getProperty("ProfileIconDropdown_locator");
			String ProfileIconDropdown_Logout_locator = p.getProperty("ProfileIconDropdown_Logout_locator");
		    //ClickOn Profile Dropdown
		    driver.findElement(By.xpath(ProfileIconDropdown_locator)).click();
		    Thread.sleep(2000);
		    //ClickOn Logout
		    driver.findElement(By.linkText(ProfileIconDropdown_Logout_locator)).click();
		    Thread.sleep(2000);
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void closingTheApplication() {
		driver.close();
	}
	

}
