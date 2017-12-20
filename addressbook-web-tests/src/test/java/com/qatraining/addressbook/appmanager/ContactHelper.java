package com.qatraining.addressbook.appmanager;

import com.qatraining.addressbook.model.GroupDataContact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(GroupDataContact groupDataContact, boolean cretaion) {
    type(By.name("firstname"), groupDataContact.getFirstname());
    type(By.name("middlename"), groupDataContact.getMiddlename());
    type(By.name("home"), groupDataContact.getHomephone());
    type(By.name("email"), groupDataContact.getEmail());

    if(cretaion){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDataContact.getGroup());
    }else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void submitContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void confirmAlert() {
    wd.switchTo().alert().accept();
  }

  public void clickEdit() {
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactChanges() {
    click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
  }

  public void clickLink() {
    click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
  }
}
