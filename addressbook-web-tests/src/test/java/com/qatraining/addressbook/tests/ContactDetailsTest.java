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
    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);

    assertThat(contact.getFirstname(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getFirstname())));
    assertThat(contact.getLastName(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getLastName())));
    assertThat(contact.getMobile(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getMobile())));
    assertThat(contact.getWork(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getWork())));
    assertThat(contact.getAddress(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getAddress())));
    assertThat(contact.getEmail(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getEmail())));
    assertThat(contact.getEmail2(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getEmail2())));
    assertThat(contact.getEmail3(), equalTo(cleanedTxt(contactInfoFromDetailsPage.getEmail3())));

  }

  public String cleanedTxt(String txt) {
    return txt.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}


