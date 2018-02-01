package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.GroupData;
import com.qatraining.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletingFromGroup extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contacts().size()==0){
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test"));
    }
  }

  @BeforeMethod
  public void ensurePreconditions2() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @BeforeMethod
  public void ensurePrecondition3(){
    List<GroupData> list = app.db().groups().stream().collect(Collectors.toList());
    boolean condition=false;

    for(GroupData g : list){
      if(g.getContacts().size()>0){
        condition=true;
      }
    }

    if(condition==false){
      app.contact().create(new ContactData().withFirstName("Joanna").withLastName("Test").inGroup(list.get(0)));
    }
  }

  @Test
  public void testContactDeletingFromGroup() {
    app.goTo().homePage();
    Groups groups=app.db().groups();

    contactRemoval(groups.size());
  }


  public void contactRemoval(int x){

    Groups groups=app.db().groups();
    GroupData selectedGroup = groups.stream().collect(Collectors.toList()).get(x-1);

    if(selectedGroup.getContacts().size()>0){
      app.contact().selectGroupRemove(selectedGroup.getName());
      Integer id=app.contact().selectContactAndReturnID(0);
      ContactData contact=app.db().getContact(id);
      app.contact().click(By.name("remove"));
      app.goTo().homePage();
      Set<GroupData> after = contact.getGroups();
      after.remove(selectedGroup);
      assertThat(app.db().getContact(id).getGroups(),
              equalTo(contact.getGroups().without(selectedGroup)));
    }
    else{
      x--;
      contactRemoval(x);
    }
  }



}

