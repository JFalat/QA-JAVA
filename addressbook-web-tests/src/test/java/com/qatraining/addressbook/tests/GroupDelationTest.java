package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.tests.TestBase;
import org.testng.annotations.Test;


public class GroupDelationTest extends TestBase {

    @Test
    public void testGroupDelation() {
        app.wd.get("http://localhost/addressbook/");

        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }


}
