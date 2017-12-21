package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
  @Test
   public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createClient(new ContactData("Joanna",null,null,null,null));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("firstname","middlename","email","homephone",null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().clickLink();
    app.getSessionHelper().logout();
  }
}
