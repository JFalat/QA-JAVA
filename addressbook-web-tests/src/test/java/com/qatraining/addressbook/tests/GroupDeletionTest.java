package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.GroupData;
import com.qatraining.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod

  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size()==0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.group().all();
    GroupData deletedGroup=before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(),equalTo(before.size()-1));
    Groups after = app.group().all();
    assertThat(after,equalTo(before.without(deletedGroup)));
  }


}
