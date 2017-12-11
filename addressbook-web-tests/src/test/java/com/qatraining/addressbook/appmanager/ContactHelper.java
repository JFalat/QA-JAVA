package com.qatraining.addressbook.appmanager;

import com.qatraining.addressbook.model.GroupDataContact;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactForm(GroupDataContact groupDataContact) {
    type(By.name("firstname"), groupDataContact.getFirstname());
    type(By.name("middlename"), groupDataContact.getMiddlename());
    type(By.name("home"), groupDataContact.getHomephone());
    type(By.name("email"), groupDataContact.getEmail());
  }


  public void submitContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


}
