package com.qatraining.addressbook.appmanager;

import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.Contacts;
import com.qatraining.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectContactById(int id) {

    WebElement table = wd.findElement(By.xpath("//*[@id=\"maintable\"]"));

    WebElement row = table.findElement(By.xpath("//tr/td/*[@id='"+id+"']"));

    row.findElement(By.xpath("//td[8]/a/img")).click();

  }


  public void deleteSelectedContact() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

  public void confirmAlert() {
    if (isAlertPresent()) {
      wd.switchTo().alert().accept();
    }
  }

  public void clickLink() {
    click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }


  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  private Contacts contactCache=null;

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContact();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache=null;
    clickLink();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    confirmAlert();
    contactCache=null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName);
      contacts.add(contact);
    }
    return contacts;
  }

  public Contacts all() {
    if(contactCache!=null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName);
      contactCache.add(contact);
    }
    return contactCache;
  }
}


