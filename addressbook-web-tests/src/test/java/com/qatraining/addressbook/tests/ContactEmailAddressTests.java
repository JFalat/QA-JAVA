package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.stream.Collectors;

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

    assertThat(contact.getAddress(), equalTo(cleanedTxt(contactInfoFromEditForm.getAddress())));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactEmailAddressTests::cleanedTxt)
            .collect(Collectors.joining("\n"));

  }


  public static String cleanedTxt(String txt) {
    return txt.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

