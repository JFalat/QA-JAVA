package com.qatraining.addressbook.appmanager;

import com.qatraining.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("email"), contactData.getEmail());

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void submitContact() {
    click(By.name("submit"));
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

  public void clickLink() {
    click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
  }
   public void initContactCreation() {click(By.linkText("add new"));}
  public void initContactModification(){click(By.cssSelector("img[alt='Edit']"));}
  public void returnToHomePage() {click(By.linkText("home page"));}
  public void submitContactModification(){click(By.name("update"));}

  public void createClient(ContactData contact) {
    initContactCreation();
    fillContactForm(contact,true);
    submitContact();
    returnToHomePage();

  }

  public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
    }
  }


