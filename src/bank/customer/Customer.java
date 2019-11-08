package bank.customer;

import bank.account.Account;
import bank.address.Address;

import java.util.ArrayList;

/**
 * Customer is abstract class with the general customer data.
 * Customer can only have 10 accounts.
 */
public abstract class Customer implements Comparable {
  private String phone;
  private String email;
  private Address address;

  // max 10 accounts
  private ArrayList<Account> accounts = new ArrayList<>();

  Customer(String phone, String email, Address address) {
    this.phone = phone;
    this.email = email;
    this.address = address;
  }

  /**
   * Abstract getter method for customer number.
   * @return String customer number.
   */
  public abstract String getCustomernumber();

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getAddress() {
    return new Address(address);
  }

  public void setAddress(Address address) {
    this.address = new Address(address);
  }

  public ArrayList<Account> getAccounts() {
    return new ArrayList<>(this.accounts);
  }

  /**
   * Adds an account to the customer, but only if there are no more than 10
   * @param account to be added to customer
   * @return true if account been added; false if there are to many
   */
  public boolean addAccount(Account account) {
    if (this.accounts.size() < 10) {
      this.accounts.add(new Account(account));
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int compareTo(Object o) {
    Customer customer = (Customer) o;
    return Integer.valueOf(this.getCustomernumber().substring(1)) - Integer.valueOf(customer.getCustomernumber().substring(1));
  }
}
