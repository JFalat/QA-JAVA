package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
    public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test"));
    }
  }

    @Test
    public void testContactModification() {
      Contacts before = app.contact().all();
      ContactData modifiedContact=before.iterator().next();
      ContactData contact = new ContactData()
              .withId(modifiedContact.getId()).withFirstName("Joanna").withLastName("Test").withEmail("email").withHomephone("homephone");
      app.contact().modify(contact);
      assertThat(app.contact().count(),equalTo(before.size()));
      Contacts after = app.contact().all();
      assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));



    }
  }


