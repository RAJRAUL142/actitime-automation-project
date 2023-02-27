package com.actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
          @FindBy(xpath ="//div[.='Tasks']")
          private WebElement  taskLink;
          
          @FindBy(id="logoutLink")
          private WebElement logoutLink;
          
          public homepage (WebDriver driver ) {
        	  PageFactory.initElements(driver, this);
          }
          public WebElement getTasklink() {
			return taskLink;
          }
          
          public WebElement getlogoutlink() {
			return logoutLink;
          }
}
