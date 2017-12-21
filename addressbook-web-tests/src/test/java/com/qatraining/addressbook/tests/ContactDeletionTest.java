package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToContactPage();;
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createClient(new ContactData("Joanna",null,null,null,"test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmAlert();
    app.getSessionHelper().logout();

  }
}
