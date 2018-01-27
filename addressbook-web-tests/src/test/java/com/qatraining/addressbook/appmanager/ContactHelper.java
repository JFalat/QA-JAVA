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

  private Contacts contactCache = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
//    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public int selectContactAndReturnID(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    return Integer.parseInt(wd.findElements(By.name("selected[]")).get(index).getAttribute("id"));
  }

  private void selectContactById(int id) {
    WebElement table = wd.findElement(By.xpath("//*[@id=\"maintable\"]"));
    WebElement row = table.findElement(By.xpath("//tr/td/*[@id='" + id + "']"));
    row.findElement(By.xpath("//td[8]/a/img")).click();

  }

  private void selectDetailsById(int id) {
    WebElement table = wd.findElement(By.xpath("//*[@id=\"maintable\"]"));
    WebElement row = table.findElement(By.xpath("//tr/td/*[@id='" + id + "']"));
    row.findElement(By.xpath("//td[7]/a/img")).click();

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

  public void clickContactDetails() {
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[7]/a/img"));
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
    contactCache = null;
    clickLink();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    confirmAlert();
    contactCache = null;
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
// if (contactCache != null) {
//return new Contacts(contactCache);
//  }
    contactCache = new Contacts();
    //Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
      String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
      String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName)
              .withAllPhones(allPhones).withAddress(address)
              .withAllEmails(allEmails);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromDetailsPage(ContactData contact) {
    selectDetailsById(contact.getId());
    ContactData contactDetails = new ContactData();
//    String[] allTekst = wd.findElement(By.xpath("//*[@id=\"content\"]")).getText().split("\n");

    String allTekst = wd.findElement(By.xpath("//*[@id=\"content\"]")).getText();

//    for (int i = 0; i < allTekst.length; i++) {
//     // System.out.println(allTekst[i]);
//    }

//    String[] names = allTekst[0].split(" ");
//    String address = allTekst[1];
//    String homePhone = allTekst[3].replaceAll("[^0-9]", "");
//    String mobilePhone = allTekst[4].replaceAll("[^0-9]", "");
//    String workPhone = allTekst[5].replaceAll("[^0-9]", "");
//    String email = allTekst[7];
//    String email2 = allTekst[8];
//    String email3 = allTekst[9];
//    String[] groups = allTekst[12].split(" ");

//    System.out.println("mob: " + mobilePhone);

//    contactDetails.withFirstName(names[0]).withLastName(names[1]).withAddress(address).withHomephone(homePhone).withMobile(mobilePhone)
//            .withWork(workPhone).withEmail(email).withEmail2(email2).withEmail3(email3).withGroup(groups[2]);

    contactDetails.withAllDetails(allTekst);

    wd.navigate().back();
    return contactDetails;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    selectContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withHomephone(home).withMobile(mobile).withWork(work).withAddress(address);
  }

  public List<GroupData> groupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@id=\"content\"]/form[2]/div[4]/select/option"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.getAttribute("value"));
      GroupData group = new GroupData().withId(id).withName(name);
      groups.add(group);
    }
    return groups;
  }


  public void click(By locator) {
    wd.findElement(locator).click();
  }


  public void selectGroupAdd(String name) {
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(name);
  }

  public void selectGroupRemove(String name) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(name);
  }

}


