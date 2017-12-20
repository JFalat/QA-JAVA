package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.GroupDataContact;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
  @Test
   public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().clickEdit();
    app.getContactHelper().fillContactForm(new GroupDataContact("firstname","middlename","email","homephone",null),false);
    app.getContactHelper().submitContactChanges();
    app.getContactHelper().clickLink();
    app.getSessionHelper().logout();
  }
}
