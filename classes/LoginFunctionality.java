package com.OrangeHRM_Application.classes;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class LoginFunctionality {
	public static WebDriver driver;

	public Properties loadProperty(){
		try {
			//Making Connection with input.properties file
			FileInputStream fis = new FileInputStream("C:\\Users\\sasir\\OneDrive\\Desktop\\Sasi\\Workspace\\OrangeHRM_Application\\src\\test\\java\\com\\OrangeHRM_Application\\utils\\input.properties");
			Properties p = new Properties();
			p.load(fis);
			return p;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void driverInitialize() {
		try {
			//Opening Firefox Browser and maximize it
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//Getting input from properties file
			Properties p = loadProperty();
			String urlLink = p.getProperty("login_url");
			//Launch the Application using URL
			driver.get(urlLink);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}

	
	void loginFunction() {
		try {
			//Getting input from properties file
			Properties p = loadProperty();
			String username = p.getProperty("login_username");
			String password = p.getProperty("login_password");
			String username_locator = p.getProperty("login_username_locator");
			String password_locator = p.getProperty("login_password_locator");
			String loginbutton_locator = p.getProperty("login_loginbutton_locator");
			//UserName
			driver.findElement(By.xpath(username_locator)).sendKeys(username);
			Thread.sleep(2000);
			//Password
			driver.findElement(By.name(password_locator)).sendKeys(password);
			Thread.sleep(2000);
			//LoginButton
			driver.findElement(By.xpath(loginbutton_locator)).click();
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	

}
