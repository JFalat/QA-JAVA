package com.qatraining.addressbook.tests;

import org.testng.annotations.Test;


public class GroupDelationTest extends TestBase {

    @Test
    public void testGroupDelation() {
//        app.getGroupHelper().get("http://localhost/addressbook/");
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
