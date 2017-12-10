package com.qatraining.addressbook.model;

public class GroupDataContact {
  private final String firstname;
  private final String middlename;
  private final String email;
  private final String homephone;

  public GroupDataContact(String firstname, String middlename, String email, String homephone) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.email = email;
    this.homephone = homephone;
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
}
