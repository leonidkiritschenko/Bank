package bank.customer;

import bank.address.Address;

import java.time.LocalDate;
/**
 * PrivateCustomer is a value class.
 * Customer number will be assigned automatically, starts with "F" and is unique.
 */
public class PrivateCustomer extends Customer {
  private static int customerNumberCounter = 1001;
  private String customerNumber;
  private String firstName;
  private String lastName;
  private LocalDate birthday;

  public PrivateCustomer(String firstName, String lastName, String telefon, String email, LocalDate birthday,
                         Address address) {
    super(telefon, email, address);
    this.customerNumber = "P" + customerNumberCounter++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
  }

  public PrivateCustomer(PrivateCustomer privateCustomer) {
    super(privateCustomer.getPhone(), privateCustomer.getEmail(), privateCustomer.getAddress());
    this.customerNumber = privateCustomer.customerNumber;
    this.firstName = privateCustomer.firstName;
    this.lastName = privateCustomer.lastName;
    this.birthday = privateCustomer.birthday;
  }

  public String getCustomernumber() {
    return customerNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthday() {
    return birthday;
  }
}
