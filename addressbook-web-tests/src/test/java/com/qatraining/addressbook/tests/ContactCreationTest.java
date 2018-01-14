package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before=app.contact().all();
        File photo=new File("src/test/resources/stru.png");
    ContactData contact=new ContactData().withFirstName("Joanna").withLastName("Test").withHomephone("111").withMobile("222").withWork("333")
            .withAddress("address").withEmail("aaa").withEmail2("bbb").withEmail3("ccc").withGroup("test1").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Set<ContactData> after=app.contact().all();
//    assertThat(after, equalTo(
//            before.withAdded(contact.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));


  }

  }
