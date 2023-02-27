package com.actitime.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.GenericLibrary.BaseClass;
import com.actitime.GenericLibrary.FileLibrary;
import com.actitime.POM.TaskPage;
import com.actitime.POM.homepage;

public class createCustomer extends BaseClass {
	        FileLibrary  fi=   new FileLibrary();
                 @Test
                 public void createCust() throws EncryptedDocumentException, IOException, InterruptedException {
                	homepage hp = new homepage(driver);
                	hp.getTasklink().click();
                	
                  TaskPage tp = new TaskPage(driver);
            String custname = fi.readDataFromExcelFile("Sheet1", 2, 1);
            String description = fi.readDataFromExcelFile("Sheet1", 1, 2);
            tp.completetask(custname, description);
            String expected = custname;
            System.out.println(expected);
            String actual = driver.findElement(By.xpath("//div[@title='BOM_001']")).getText();
            SoftAssert s = new SoftAssert();     
            s.assertEquals(expected, actual);
            Reporter.log("assertion pass",true);
            s.assertAll();
                 }
}
