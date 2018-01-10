package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test").withHomephone("111").withMobile("222").withWork("333"));
    }
  }

  @Test(enabled = true)
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact=app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm=app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomephone(),equalTo(cleaned(contactInfoFromEditForm.getHomephone())));
    assertThat(contact.getMobile(),equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWork(),equalTo(cleaned(contactInfoFromEditForm.getWork())));


  }
  public String cleaned (String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");

  }
}
