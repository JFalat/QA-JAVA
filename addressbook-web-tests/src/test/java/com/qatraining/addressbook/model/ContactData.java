package com.qatraining.addressbook.model;

public class ContactData {
  private int id;
  private final String firstname;
  private final String lastName;
  private final String email;
  private final String homephone;
  private String group;


  public ContactData(int id, String firstname, String lastName, String email, String homephone, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastName = lastName;
    this.email = email;
    this.homephone = homephone;
    this.group = group;
  }


  public ContactData(String firstname, String lastName, String email, String homephone, String group) {
    this.id = Integer.MAX_VALUE;

    this.firstname = firstname;
    this.lastName = lastName;
    this.email = email;
    this.homephone = homephone;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

}
