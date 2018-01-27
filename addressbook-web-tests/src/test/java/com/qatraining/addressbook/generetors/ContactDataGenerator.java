package com.qatraining.addressbook.generetors;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qatraining.addressbook.model.ContactData;
import com.qatraining.addressbook.model.GroupData;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ContactDataGenerator {


  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXML(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getLastName(), contact.getAddress()));
    }
    writer.close();
  }


  private List<ContactData> generateContacts(int count) throws IOException {
    List<ContactData> contacts = new ArrayList<ContactData>();

//    List<GroupData> groups = new ArrayList<>();
//    groups = getGroups();

    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("FirstName %s", i))
              .withLastName(String.format("LastName %s", i)).withAddress(String.format("Address %s", i)));
    }
    return contacts;
  }

//  public List<GroupData> getGroups() throws IOException {
//    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
//    String xml = "";
//    String line = reader.readLine();
//    while (line != null) {
//      xml += line;
//      line = reader.readLine();
//    }
//    XStream xstream = new XStream();
//    xstream.processAnnotations(GroupData.class);
//    List<GroupData> groups = new ArrayList<>();
//    return groups = (List<GroupData>) xstream.fromXML(xml);
//  }
}
