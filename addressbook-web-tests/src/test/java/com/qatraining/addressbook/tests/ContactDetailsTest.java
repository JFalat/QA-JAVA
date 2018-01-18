package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDetailsTest extends TestBase {



  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test").withHomephone("111").withMobile("222").withWork("333")
              .withEmail("aaa").withEmail2("bbb").withEmail3("ccc"));
    }
  }

  @Test(enabled = true)
  public void testDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
//   assertThat(mergeAll(contactInfoFromEditForm), equalTo(contactInfoFromDetailsPage.getAllDetails()));
  }

  private String mergeAll(ContactData contact) {
    String result = "";
    if (contact.getFirstname() != null) {
      result = result + contact.getFirstname();
    }
    if (contact.getLastName() != null) {
      result = result + " " + contact.getLastName();
    }
    if (contact.getAddress() != null) {
      result = result + "\n\n" + contact.getAddress();
    }
    if (contact.getHomephone() != null || contact.getMobile() != null || contact.getWork() != null) {
      result = result + "\n";
      if (contact.getHomephone() != null) {
        result = result + "\n" + "H: " + contact.getHomephone();
      }
      if (contact.getMobile() != null) {
        result = result + "\n" + "M: " + contact.getMobile();
      }
      if (contact.getWork() != null) {
        result = result + "\n" + "W: " + contact.getWork();
      }
    }

    if (contact.getEmail() != null || contact.getEmail2() != null || contact.getEmail3() != null) {
      result = result + "\n";
    }
    if (contact.getEmail() != null) {
      result = result + "\n" + (contact.getEmail());
    }
    if (contact.getEmail2() != null) {
      result = result + "\n" + contact.getEmail2();
    }
    if (contact.getEmail3() != null) {
      result = result + "\n" + contact.getEmail3();
    }

    return result;

  }

}


