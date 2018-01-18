package com.qatraining.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
@XStreamAlias("contact")

public class ContactData {
  @XStreamOmitField
  private int id= Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String lastName;
  private String email;
  private String email2;
  private String email3;
  private String homephone;
  private String group;
  private String mobile;
  private String work;
  @Expose
  private String address;
  private String allPhones;
  private String allEmails;
  private String allDetails;
  private File photo;



  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllDetails() {
    return allDetails;
  }

  public ContactData withAllDetails(String allDetails) {
    this.allDetails = allDetails;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withAllPhones (String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail (String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {return email2; }

  public String getEmail3() { return email3;}

  public String getHomephone() {
    return homephone;
  }

  public String getGroup() {
    return group;
  }

  public int getId() { return id;}

  public String getAllPhones() {return allPhones; }

  public String getAllEmails() {return allEmails; }

  public String getMobile() {return mobile;}

  public String getWork() {return work; }

  public String getAddress() { return address; }

  public File getPhoto() {
    return photo;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", homephone='" + homephone + '\'' +
            ", group='" + group + '\'' +
            ", mobile='" + mobile + '\'' +
            ", work='" + work + '\'' +
            ", address='" + address + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", allDetails='" + allDetails + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

}
