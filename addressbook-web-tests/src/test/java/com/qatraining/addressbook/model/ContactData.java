package com.qatraining.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String email;
  private final String homephone;
  private String group;

  public ContactData(String firstname, String middlename, String email, String homephone, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.email = email;
    this.homephone = homephone;
    this.group=group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getEmail() {
    return email;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getGroup() { return group; }
}
