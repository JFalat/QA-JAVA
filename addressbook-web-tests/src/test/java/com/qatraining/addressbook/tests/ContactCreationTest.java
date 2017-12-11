package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.GroupDataContact;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().fillContactForm(new GroupDataContact("Joanna", "test1", "joanna@test1.com", "12345678"));
    app.getContactHelper().submitContact();
    app.getSessionHelper().logout();
  }

}