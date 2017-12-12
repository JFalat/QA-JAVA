package com.qatraining.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToContactPage() {
    click(By.linkText("add new"));
  }

  public void returnToHomePage() {
    click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
  }
}
