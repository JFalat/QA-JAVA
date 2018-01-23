package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
    public void ensurePreconditions() {

    if (app.db().contacts().size()==0){
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test"));
    }
  }

    @Test
    public void testContactModification() {
      Contacts before = app.db().contacts();
      ContactData modifiedContact=before.iterator().next();
      ContactData contact = new ContactData()
              .withId(modifiedContact.getId()).withFirstName("Joanna").withLastName("Test").withEmail("email").withAddress("address");
      app.goTo().homePage();
      app.contact().modify(contact);
      assertThat(app.contact().count(),equalTo(before.size()));
      Contacts after = app.db().contacts();
      assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));
    }
  }


