package bank.customer;

public class ContanctPerson {
  private String firstName;
  private String lastName;
  private String phone;

  public ContanctPerson(String firstName, String lastName, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
  }

  ContanctPerson(ContanctPerson contanctPerson) {
    this.firstName = contanctPerson.firstName;
    this.lastName = contanctPerson.lastName;
    this.phone = contanctPerson.phone;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

}
