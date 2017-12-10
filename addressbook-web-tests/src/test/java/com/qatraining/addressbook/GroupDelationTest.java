package com.qatraining.addressbook;

import org.testng.annotations.Test;


public class GroupDelationTest extends TestBase{

    @Test
    public void testGroupDelation() {
        wd.get("http://localhost/addressbook/");

        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }


}
