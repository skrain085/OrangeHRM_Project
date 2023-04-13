package com.OrangeHRM_Application.classes;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyInfoDependents extends LoginFunctionality{
	Properties p = loadProperty();
	@BeforeMethod
	public void loginToApplication() {
		try {
			driverInitialize();
	        loadProperty();
	        loginFunction(); 
	        Thread.sleep(2000);
	 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=1)
	public void addingDependent() {
		try {
			enterIntoMyInfoDependents();
			Thread.sleep(2000);
			clickOnAddButton();
			Thread.sleep(2000);
			enteringName();
			Thread.sleep(2000);
			selectRelationship();
			Thread.sleep(2000);
			selectDateOfBirth();
			Thread.sleep(2000);
		    clickOnSaveButton();
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void editDependent() {
		try {
			enterIntoMyInfoDependents();
			Thread.sleep(2000);
			clickOnEditIcon();
			editingFullName();
			Thread.sleep(2000);
			clickOnSaveButton();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void cancelEditDependent() {
		try {
			enterIntoMyInfoDependents();
			Thread.sleep(2000);
			clickOnEditIcon();
			editingFullName();
			Thread.sleep(2000);
			clickOnCancelButton();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=4)
	public void deleteDependent() {
		try {
			enterIntoMyInfoDependents();
			Thread.sleep(2000);
			clickOnDeleteIcon();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@AfterMethod
	public void closingTheApplication() {
		driver.close();
	}
	

	public void clickOnDeleteIcon() {
		//Getting input from properties file
		String myinfo_dependents_delete_icon_locator = p.getProperty("myinfo_dependents_delete_icon_locator");
		String myinfo_dependents_delete_button_locator = p.getProperty("myinfo_dependents_delete_button_locator");
		//ClcikOn Delete icon
		driver.findElement(By.xpath(myinfo_dependents_delete_icon_locator)).click();
		//ClickOn Yes,Delete Button
		driver.findElement(By.xpath(myinfo_dependents_delete_button_locator)).click();
	}

	public void clickOnCancelButton() {
		//Getting input from properties file
		String myinfo_dependents_cancel_button_locator = p.getProperty("myinfo_dependents_cancel_button_locator");
		//ClickOn Cancel Button
		driver.findElement(By.xpath(myinfo_dependents_cancel_button_locator)).click();
	}

	public void editingFullName() {
		//Getting input from properties file
		String myinfo_dependents_edit_fullname_locator = p.getProperty("myinfo_dependents_edit_fullname_locator");
		String myinfo_dependents_fullname = p.getProperty("myinfo_dependents_fullname");
		//Editing Full Name
		WebElement name = driver.findElement(By.xpath(myinfo_dependents_edit_fullname_locator));
		name.sendKeys(myinfo_dependents_fullname);
	}

	public void clickOnEditIcon() {
		//Getting input from properties file
		String myinfo_dependents_edit_icon_locator = p.getProperty("myinfo_dependents_edit_icon_locator");
		//ClickOn edit icon
		driver.findElement(By.xpath(myinfo_dependents_edit_icon_locator)).click();
	}

	
	public void enterIntoMyInfoDependents() {
		try {
			//Getting input from properties file
			String myinfo_locator = p.getProperty("myinfo_locator");
			String dependents_locator = p.getProperty("dependents_locator");
			//Click On MyInfo
			driver.findElement(By.xpath(myinfo_locator)).click();
			Thread.sleep(2000);
			//ClickOn Dependents
			driver.findElement(By.linkText(dependents_locator)).click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void clickOnAddButton() {
		//Getting input from properties file
		String myinfo_dependents_add_button_locator = p.getProperty("myinfo_dependents_add_button_locator");
		//Click On +Add
		driver.findElement(By.xpath(myinfo_dependents_add_button_locator)).click();
	}

	public void enteringName(){
		try {
			//Getting input from properties file
			String myinfo_dependents_name_locator = p.getProperty("myinfo_dependents_name_locator");
			String myinfo_dependents_name = p.getProperty("myinfo_dependents_name");
			//Entering Name
			driver.findElement(By.xpath(myinfo_dependents_name_locator)).sendKeys(myinfo_dependents_name);
			Thread.sleep(2000);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		}
	}

	public void selectRelationship(){
		try {
			//Getting input from properties file
			String myinfo_dependents_relationship_locator = p.getProperty("myinfo_dependents_relationship_locator");
			String myinfo_dependents_relationshiplist_locator = p.getProperty("myinfo_dependents_relationshiplist_locator");
			String myinfo_dependents_relationship = p.getProperty("myinfo_dependents_relationship");
			//Select Relationship
			driver.findElement(By.xpath(myinfo_dependents_relationship_locator)).click();
			Thread.sleep(2000);
			//Select Relationship from the List
			List <WebElement> relationship_list = driver.findElements(By.xpath(myinfo_dependents_relationshiplist_locator));
			for(WebElement relationship : relationship_list) {
				if(relationship.getText().equalsIgnoreCase(myinfo_dependents_relationship)) {
					relationship.click();
					break;
				}
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectDateOfBirth() {
		//Getting input from properties file
		String myinfo_dependents_dateofbirth_locator = p.getProperty("myinfo_dependents_dateofbirth_locator");
		String myinfo_dependents_year_locator = p.getProperty("myinfo_dependents_year_locator");
		String myinfo_dependents_yearlist_locator = p.getProperty("myinfo_dependents_yearlist_locator");
		String myinfo_dependents_year = p.getProperty("myinfo_dependents_year");
		String myinfo_dependents_day_locator = p.getProperty("myinfo_dependents_day_locator");
		String myinfo_dependents_day = p.getProperty("myinfo_dependents_day");
		//Select Date of Birth
		driver.findElement(By.xpath(myinfo_dependents_dateofbirth_locator)).click();
		//Select Year
		driver.findElement(By.xpath(myinfo_dependents_year_locator)).click();
		List <WebElement> year_list = driver.findElements(By.xpath(myinfo_dependents_yearlist_locator));
		System.out.println(year_list.size());
		for(WebElement year : year_list) {
			if(year.getText().equalsIgnoreCase(myinfo_dependents_year)) {
				year.click();
				break;
			}
		}
		//Select Day
		List <WebElement> day_list = driver.findElements(By.xpath(myinfo_dependents_day_locator));
		System.out.println(day_list.size());
		for(WebElement day : day_list) {
			if(day.getText().equalsIgnoreCase(myinfo_dependents_day)) {
				day.click();
				break;
			}
		}
	}

	public void clickOnSaveButton() {
		String myinfo_dependents_save_button_locator = p.getProperty("myinfo_dependents_save_button_locator");
		//ClickOn Save Button
		driver.findElement(By.xpath(myinfo_dependents_save_button_locator)).click();
	}
		
}
