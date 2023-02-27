package com.actitime.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
          static {
        	  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
          }
          public static WebDriver driver;
          
          @BeforeSuite
          public void databaseConnection() {
        	  Reporter.log("database connected",true);
          }
          @AfterSuite
          public void databaseDisConnected() {
        	  Reporter.log("database dis-connected",true);
          }
          @BeforeClass
          public void launchBrowser() {
        	driver =   new ChromeDriver();
        	driver.manage().window().maximize();
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	driver.get("https://demo.actitime.com");
        	Reporter.log("browser launch successfully",true);
          }
          @AfterClass
          public void closeBrowser() {
        	  driver.close();
        	  Reporter.log("logout successfully",true);
          }
          @BeforeMethod
          public void loginactitime() {
        	  driver.findElement(By.id("username")).sendKeys("admin");
        	  driver.findElement(By.name("pwd")).sendKeys("manager");
        	  driver.findElement(By.xpath("//div[.='Login ']")).click();
        	  Reporter.log("logged in successfully",true);
          }
          @AfterMethod
          public void logoutactitime() {
        	  Reporter.log("logged out successfully",true);
          }
}
