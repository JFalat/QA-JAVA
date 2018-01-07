package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before=app.contact().all();
    ContactData contact=new ContactData().withFirstName("Joanna").withLastName("Test").withGroup("test1");
    app.contact().create(contact);
    Contacts after=app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
    assertThat(after.size(), equalTo(before.size() + 1));

  }

}