package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.GroupData;
import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDelation() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null,null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
