package bank.account;

/**
 * Account is a value class with IBAN and balance of money.
 */
public class Account {
  private String IBAN;
  private double balance = 0.0;

  public Account(String IBAN) {
    this.IBAN = IBAN;
  }

  public Account(Account account) {
    this.IBAN = account.IBAN;
    this.balance = account.balance;
  }

  public String getIBAN() {
    return IBAN;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
