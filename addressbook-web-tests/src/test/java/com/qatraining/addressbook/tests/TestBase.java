package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.appmanager.ApplicationManager;
import com.qatraining.addressbook.model.GroupDataContact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();
  FirefoxDriver wd;


  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }


  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
