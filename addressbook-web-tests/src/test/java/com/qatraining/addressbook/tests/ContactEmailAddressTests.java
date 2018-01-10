package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test").withHomephone("111").withMobile("222").withWork("333")
              .withEmail("aaa").withEmail2("bbb").withEmail3("ccc"));
    }
  }

  @Test(enabled = true)
  public void testEmailAdress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    System.out.println("cont " + contactInfoFromEditForm);

    assertThat(contact.getAddress(), equalTo(cleanedTxt(contactInfoFromEditForm.getAddress())));
    assertThat(contact.getEmail(), equalTo(cleanedTxt(contactInfoFromEditForm.getEmail())));
    assertThat(contact.getEmail2(), equalTo(cleanedTxt(contactInfoFromEditForm.getEmail2())));
    assertThat(contact.getEmail3(), equalTo(cleanedTxt(contactInfoFromEditForm.getEmail3())));

  }

  public String cleanedTxt(String txt) {
    return txt.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
