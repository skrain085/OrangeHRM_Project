package com.OrangeHRM_Application.classes;
import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyInfoEmergencyContacts extends LoginFunctionality {
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
	public void addingEmployeeEmergencyContacts() {
		try {
			Thread.sleep(2000);
			enterIntoMyInfoEmergencyContacts();
			Thread.sleep(2000);
			addingEmergencyContacts();
			Thread.sleep(2000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void addValidAttachment() {
		try {
			//Getting input from properties file
			String myinfo_emergencycontacts_validfile = p.getProperty("myinfo_emergencycontacts_validfile");
			Thread.sleep(2000);
			enterIntoMyInfoEmergencyContacts();
			Thread.sleep(2000);
			uploadingFile(myinfo_emergencycontacts_validfile);
			Thread.sleep(2000);
			clickOnSaveButton();
			Thread.sleep(2000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void addAttachmentWithComment() {
		try {
			//Getting input from properties file
			String myinfo_emergencycontacts_validfile = p.getProperty("myinfo_emergencycontacts_validfile");
			Thread.sleep(2000);
			enterIntoMyInfoEmergencyContacts();
			Thread.sleep(2000);
			uploadingFile(myinfo_emergencycontacts_validfile);
			Thread.sleep(2000);
			enteringComment();
			Thread.sleep(2000);
			clickOnSaveButton();
			Thread.sleep(2000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=4)
	public void addInvalidAttachment() {
		try {
			//Getting input from properties file
			String myinfo_emergencycontacts_invalidfile = p.getProperty("myinfo_emergencycontacts_invalidfile");
			Thread.sleep(2000);
			enterIntoMyInfoEmergencyContacts();
			Thread.sleep(2000);
			uploadingFile(myinfo_emergencycontacts_invalidfile);
			Thread.sleep(5000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=5)
	public void downloadAttachment() {
		try {
			Thread.sleep(2000);
			enterIntoMyInfoEmergencyContacts();
			Thread.sleep(2000);
			downloadTheAttachment();
			Thread.sleep(2000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@AfterMethod
	public void closingTheApplication() {
		driver.close();
	}
	
	public void enterIntoMyInfoEmergencyContacts() {
		try {
			//Getting input from properties file
			String myinfo_locator = p.getProperty("myinfo_locator");
			String emergencycontacts_locator = p.getProperty("emergencycontacts_locator");
			Thread.sleep(2000);
			//Click On MyInfo
			driver.findElement(By.xpath(myinfo_locator)).click();
			Thread.sleep(2000);
			//ClickOn Emergency Contacts
			driver.findElement(By.linkText(emergencycontacts_locator)).click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void downloadTheAttachment() {
		//Getting input from properties file
		String myinfo_emergencycontacts_download_locator = p.getProperty("myinfo_emergencycontacts_download_locator");
		//Download attachment
		driver.findElement(By.xpath(myinfo_emergencycontacts_download_locator)).click();
	}

	public void enteringComment() {
		//Getting input from properties file
		String myinfo_emergencycontacts_comment_locator = p.getProperty("myinfo_emergencycontacts_comment_locator");
		String myinfo_emergencycontacts_comment = p.getProperty("myinfo_emergencycontacts_comment");
		//Entering Comment
		driver.findElement(By.xpath(myinfo_emergencycontacts_comment_locator)).sendKeys(myinfo_emergencycontacts_comment);
	}

	public void addingEmergencyContacts(){
		try {
			//Getting input from properties file	
			String myinfo_emergencycontacts_add_button_locator = p.getProperty("myinfo_emergencycontacts_add_button_locator");
			String myinfo_emergencycontacts_name_locator = p.getProperty("myinfo_emergencycontacts_name_locator");
			String myinfo_emergencycontacts_name = p.getProperty("myinfo_emergencycontacts_name");
			String myinfo_emergencycontacts_relationship_locator = p.getProperty("myinfo_emergencycontacts_relationship_locator");
			String myinfo_emergencycontacts_relationship = p.getProperty("myinfo_emergencycontacts_relationship");
			String myinfo_emergencycontacts_hometelephone_locator = p.getProperty("myinfo_emergencycontacts_hometelephone_locator");
			String myinfo_emergencycontacts_hometelephone = p.getProperty("myinfo_emergencycontacts_hometelephone");
			String myinfo_emergencycontacts_submitbutton_locator = p.getProperty("myinfo_emergencycontacts_submitbutton_locator");
			//ClickOn +Add button
			driver.findElement(By.xpath(myinfo_emergencycontacts_add_button_locator)).click();
			//Enter the Name
			driver.findElement(By.xpath(myinfo_emergencycontacts_name_locator)).sendKeys(myinfo_emergencycontacts_name);
			Thread.sleep(2000);
			//Enter the Relationship
			driver.findElement(By.xpath(myinfo_emergencycontacts_relationship_locator)).sendKeys(myinfo_emergencycontacts_relationship);
			Thread.sleep(2000);
			//Enter the HomeTelephone
			driver.findElement(By.xpath(myinfo_emergencycontacts_hometelephone_locator)).sendKeys(myinfo_emergencycontacts_hometelephone);
			Thread.sleep(2000);
			//ClickOn Submit Button
			driver.findElement(By.xpath(myinfo_emergencycontacts_submitbutton_locator)).click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void clickOnSaveButton() {
		//Getting input from properties file
		String myinfo_emergencycontacts_savebutton_locator = p.getProperty("myinfo_emergencycontacts_savebutton_locator");
		//ClickOn Save button
		driver.findElement(By.xpath(myinfo_emergencycontacts_savebutton_locator)).click();
	}

	public void uploadingFile(String filename){
		//Getting input from properties file
		String autoitScript_path= p.getProperty("autoitScript_path");
		String myinfo_emergencycontacts_attachment_add_button_locator= p.getProperty("myinfo_emergencycontacts_attachment_add_button_locator");
		String myinfo_emergencycontacts_browse_locator= p.getProperty("myinfo_emergencycontacts_browse_locator");
		try {
			String autoitScript = new File(autoitScript_path).getAbsolutePath();
			String filePath = new File(filename).getAbsolutePath();
			
			//ClickOn +Add button
			driver.findElement(By.xpath(myinfo_emergencycontacts_attachment_add_button_locator)).click();
			//ClickOn Browse
			WebElement browse = driver.findElement(By.xpath(myinfo_emergencycontacts_browse_locator));
			//Javascript To Click the WebElement
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", browse);
			Thread.sleep(2000);
			//AutoitScript to upload the file
			Runtime.getRuntime().exec(autoitScript+" "+filePath);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	 
}
