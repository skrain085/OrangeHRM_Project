package com.OrangeHRM_Application.classes;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class DirectoryFunctionality extends LoginFunctionality{
	Properties p = loadProperty();
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
	public void searchEmployeeByEmployeeName() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");
		
		searchEmployee(employee_name,null,null);
	}
	
	@Test(priority=1)
	public void searchEmployeeByEmployeeNameAndValidJobTitle() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");  
		String valid_jobtitle = p.getProperty("directory_valid_jobtitle");  
		
		searchEmployee(employee_name,valid_jobtitle,null);
	}
	
	@Test(priority=2)
	public void searchEmployeeByEmployeeNameAndInvalidJobTitle() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");  
		String invalid_jobtitle = p.getProperty("directory_invalid_jobtitle"); 
		
		searchEmployee(employee_name,invalid_jobtitle,null);
	}
	
	@Test(priority=3)
	public void searchEmployeeByEmployeeName_ValidJobTitleAndValidLocation() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");  
		String valid_jobtitle = p.getProperty("directory_valid_jobtitle"); 
		String valid_location = p.getProperty("directory_valid_location");
		
		searchEmployee(employee_name,valid_jobtitle,valid_location);
	}
	
	@Test(priority=4)
	public void searchEmployeeByEmployeeName_InvalidJobTitleAndValidLocation() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");  
		String invalid_jobtitle = p.getProperty("directory_invalid_jobtitle");
		String valid_location = p.getProperty("directory_valid_location");
		
		searchEmployee(employee_name,invalid_jobtitle,valid_location);
	}
	
	@Test(priority=5)
	public void searchEmployeeByEmployeeName_ValidJobTitleAndInvalidLocation() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");
		String valid_jobtitle = p.getProperty("directory_valid_jobtitle");
		String invalid_location = p.getProperty("directory_invalid_location");
		
		searchEmployee(employee_name,valid_jobtitle,invalid_location);
	}
	
	@Test(priority=6)
	public void searchEmployeeByEmployeeName_InvalidJobTitleAndInvalidLocation() {
		//Getting input from properties file
		String employee_name = p.getProperty("directory_employee_name");
		String invalid_jobtitle = p.getProperty("directory_invalid_jobtitle");
		String invalid_location = p.getProperty("directory_invalid_location");
		
		searchEmployee(employee_name,invalid_jobtitle,invalid_location);
	}
	
	@Test(priority=7)
	public void searchEmployeeByJobTitle() {
		//Getting input from properties file
		String invalid_jobtitle = p.getProperty("directory_invalid_jobtitle");
		
		searchEmployee(null,invalid_jobtitle, null);
	}
	
	@Test(priority=8)
	public void searchEmployeeByLocation() {
		//Getting input from properties file
		String invalid_location = p.getProperty("directory_invalid_location");
		
		searchEmployee(null,null,invalid_location);
	}
	
	@Test(priority=9)
	public void clickOnHideIcon() {
		try {
			//Getting input from properties file
			String hide_icon_button_locator = p.getProperty("directory_hide_icon_button_locator");
			Thread.sleep(2000);
			clickOnDirectory();
			Thread.sleep(2000);
			driver.findElement(By.xpath(hide_icon_button_locator)).click();
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test(priority=10)
	public void resetTheSelectedValues() {
		try {
		    //Getting input from properties file
			String invalid_jobtitle = p.getProperty("directory_invalid_jobtitle");
			String reset_button_locator = p.getProperty("directory_reset_button_locator");
			searchEmployee(null,invalid_jobtitle, null);
			Thread.sleep(2000);
			driver.findElement(By.xpath(reset_button_locator)).click();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	
	@Test(priority=11)
	public void viewEmployeeInfo() {
		try {
			//Getting input from properties file
			String image_locator = p.getProperty("directory_image_locator");
			Thread.sleep(2000);
			clickOnDirectory();
			Thread.sleep(2000);
			driver.findElement(By.xpath(image_locator)).click();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	@AfterMethod
	public void closingTheApplication() {
		driver.close();
	}
	
	public void searchEmployee(String name, String job_title, String location) {
		boolean isNameValid = name!=null && !name.isBlank() && !name.isEmpty();
		boolean isJobTitleValid = job_title!=null&& !job_title.isBlank() && !job_title.isEmpty();
		boolean isLocationValid = location!=null&& !location.isBlank() && !location.isEmpty();
		
		try {
			// three conditions criteria should be kept top in the order
			if(isNameValid && isJobTitleValid && isLocationValid) {
				Thread.sleep(2000);
				clickOnDirectory();
			    Thread.sleep(2000);
			    selectEmployeeName(name);
			    Thread.sleep(2000);
			    selectJobTitle(job_title);
			    Thread.sleep(2000);
			    selectLocation(location);
			    Thread.sleep(2000);
			    clickOnSearchButton();
			    Thread.sleep(2000);
			}
			
			//two conditions criteria should be kept next in the order
			else if(isNameValid && isJobTitleValid ) {
				Thread.sleep(2000);
				clickOnDirectory();
			    Thread.sleep(2000);
			    selectEmployeeName(name);
			    Thread.sleep(2000);
			    selectJobTitle(job_title);
			    Thread.sleep(2000);
			    clickOnSearchButton();
			    Thread.sleep(2000);
			}
			
			//one condition criteria should be kept next in the order
			else if(isNameValid) {
				Thread.sleep(2000);
				clickOnDirectory();
			    Thread.sleep(2000);
			    selectEmployeeName(name);
			    Thread.sleep(2000);
			    clickOnSearchButton();
			    Thread.sleep(2000);
			}
			else if (isJobTitleValid) {
				Thread.sleep(2000);
				clickOnDirectory();
			    Thread.sleep(2000);
			    selectJobTitle(job_title);
			    Thread.sleep(2000);
			    clickOnSearchButton();
			    Thread.sleep(2000);
			}
			else if(isLocationValid) {
				   Thread.sleep(2000);
				   clickOnDirectory();
			       Thread.sleep(2000);
			       selectLocation(location);
			       Thread.sleep(2000);
			       clickOnSearchButton();
			       Thread.sleep(2000);
			}
			else{
			    System.out.println("Invalid Input");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void clickOnDirectory(){
		//Getting input from properties file
		String directory_locator = p.getProperty("directory_locator");
		//ClickOn Directory
		driver.findElement(By.xpath(directory_locator)).click();
	}
	
	public void selectEmployeeName(String name) {
		//Getting input from properties file
		String employeename_locator = p.getProperty("directory_employeename_locator");
		String employeename_list_locator = p.getProperty("directory_employeename_list_locator");
		//Select Employee Name
		WebElement employee = driver.findElement(By.xpath(employeename_locator));
		employee.click();
		employee.sendKeys(name);
        //Select Employee from Employee List
		List <WebElement> employee_list = driver.findElements(By.xpath(employeename_list_locator));
		for(WebElement employeename : employee_list) {
			if(employeename.getText().startsWith(name)) {
				employeename.click();
				break;
			}
		}
	}
	
	public void clickOnSearchButton() {
		//Getting input from properties file
		String search_button_locator = p.getProperty("directory_search_button_locator");
		//ClickOn Search Button
		driver.findElement(By.xpath(search_button_locator)).click();
	}
	
	public void selectJobTitle(String job_title) {
		//Getting input from properties file
		String jobtitle_locator = p.getProperty("directory_jobtitle_locator");
		String jobtitle_list_locator = p.getProperty("directory_jobtitle_list_locator");
	    //Select JobTitle
		driver.findElement(By.xpath(jobtitle_locator)).click();
	    //Select JobTitle from List
		List <WebElement> jobtitle_list = driver.findElements(By.xpath(jobtitle_list_locator));
	  		for(WebElement jobtitle : jobtitle_list) {
	  			if(jobtitle.getText().equalsIgnoreCase(job_title)) {
	  				jobtitle.click();
	  				break;
	  			}
	  		}
   }
	
	public void selectLocation(String location) {
		//Getting input from properties file
		String location_locator = p.getProperty("directory_location_locator");
		String location_list_locator = p.getProperty("directory_location_list_locator");
		//Select Location
		driver.findElement(By.xpath(location_locator)).click();
		List <WebElement> location_list = driver.findElements(By.xpath(location_list_locator));
  		for(WebElement location_val : location_list) {
  			if(location_val.getText().equalsIgnoreCase(location)) {
  				location_val.click();
  				break;
  			}
  		}
	}
}
