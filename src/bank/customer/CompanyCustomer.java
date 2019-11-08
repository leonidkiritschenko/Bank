package bank.customer;

import bank.address.Address;

public class CompanyCustomer extends Customer {
  private static int customerNumberCounter = 1001;
  private String customerNumber;
  private String companyName;
  private ContanctPerson contanctPerson;

  public CompanyCustomer(String companyName, ContanctPerson contanctPerson, String phone, String email, Address address) {
    super(phone, email, address);
    customerNumber = "F" + customerNumberCounter++;
    this.companyName = companyName;
    this.contanctPerson = new ContanctPerson(contanctPerson);
  }

  public CompanyCustomer(CompanyCustomer companyCustomer) {
    super(companyCustomer.getPhone(), companyCustomer.getEmail(), companyCustomer.getAddress());
    this.customerNumber = companyCustomer.customerNumber;
    this.companyName = companyCustomer.companyName;
    this.contanctPerson = new ContanctPerson(companyCustomer.contanctPerson);
  }

  public String getCustomernumber() {
    return customerNumber;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public ContanctPerson getContanctPerson() {
    return new ContanctPerson(contanctPerson);
  }

  public void setContanctPerson(ContanctPerson contanctPerson) {
    this.contanctPerson = new ContanctPerson(contanctPerson);
  }
}
