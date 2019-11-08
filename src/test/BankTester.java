package test;

import bank.Bank;
import bank.address.Address;

public class BankTester {

  public static void main(String[] args) {
    Address bankAddress = new Address("Mainzer Landstraße", "151"
        , "60327 Frankfurt am Main");
    String bankName = "Commerzbank";
    String bankBIC = "COBADEFF";
    Bank bank = Bank.getInstance(bankName, bankBIC, bankAddress);
    bank.run();
  }
}
