package com.qatraining.addressbook.tests;

import com.qatraining.addressbook.model.GroupData;
import com.qatraining.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list=new ArrayList<Object[]>();
    list.add(new Object[] {"test1","header1","footer1"});
    list.add(new Object[]{"test2","header2","footer2"});
    list.add(new Object[]{"test3","header3","footer3"});
    return list.iterator();
  }
  @Test
  public void testGroupCreation() {
    String[]names=new String[]{"test1","test2","test3"};
    for (String name:names)
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));

  }


}
