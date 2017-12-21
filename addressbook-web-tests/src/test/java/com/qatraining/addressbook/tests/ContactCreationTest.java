package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createClient(new ContactData("Joanna", null, null, null,"test1"));

  }

}