package com.qatraining.mantis.tests;

import com.qatraining.mantis.model.MailMessage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
    public void testChangePassword() throws IOException, MessagingException, InterruptedException {

    app.change().start();
    String clickedUsr=app.change().modifyPassword();
    String email = String.format("%s@localhost.localdomain",clickedUsr);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.change().finish(confirmationLink,"test123" );
    Assert.assertTrue(app.newSession().login(clickedUsr, "test123"));
  }


  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage=mailMessages.stream().filter((m)->m.to.equals(email)).findFirst().get();
    VerbalExpression regex= VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}




