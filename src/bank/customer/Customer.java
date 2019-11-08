package bank.customer;

import bank.account.Account;
import bank.address.Address;

import java.util.ArrayList;

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
