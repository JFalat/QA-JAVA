package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before=app.getContactHelper().getContactList();
    ContactData contact=new ContactData("Joanna", "Test", null, null,"test1");
    app.getContactHelper().createClient(contact);
    List<ContactData> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
    before.add(contact);
    Comparator<? super ContactData> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}