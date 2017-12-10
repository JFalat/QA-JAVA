package com.qatraining.addressbook.appmanager;

import com.qatraining.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GroupHelper {
  private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd=wd;
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  public void deleteSelectedGroups() {
      new Actions(wd).doubleClick(wd.findElement(By.name("delete"))).build().perform();
  }

  public void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
  }
}
