package com.qatraining.mantis.appmanager;

import com.qatraining.mantis.tests.TestBase;
import org.openqa.selenium.By;

public class ChangePasswordHelper extends HelperBase {

  public ChangePasswordHelper(ApplicationManager app){
    super(app);
  }

  public void start() throws InterruptedException {
    wd.get(app.getProperty("web.baseUrl")+"/login_page.php");
    type(By.name("username"),app.getProperty("web.adminLogin"));
    type(By.name("password"),app.getProperty("web.adminPassword"));
    click(By.cssSelector("input[value='Login']"));
  }

  public String modifyPassword() throws InterruptedException {
    click(By.xpath("/html/body/div[2]/p/span[1]/a"));
    String s = wd.findElement(By.xpath("/html/body/table[3]/tbody/tr[4]/td[1]/a")).getText();
    click(By.xpath("/html/body/table[3]/tbody/tr[4]/td[1]/a"));
    click(By.cssSelector("input[value='Reset Password']"));
    return s;
  }

  public void finish(String confirmationLink, String password){
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }


}


