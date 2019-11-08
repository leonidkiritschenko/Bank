package bank;

import bank.account.Account;
import bank.customer.ContanctPerson;
import bank.customer.CompanyCustomer;
import bank.customer.Customer;
import bank.address.Address;
import bank.customer.PrivateCustomer;
import bank.util.ConsoleReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Bank is the main class of the bank application.
 * run() is used to start the
 */
public class Bank {

  private static final Bank INSTANCE = new Bank();
  private String name = "";
  private String BIC = "";
  private Address address;

  private ArrayList<PrivateCustomer> privateCustomers = new ArrayList<>();
  private ArrayList<CompanyCustomer> companyCustomers = new ArrayList<>();
  private ArrayList<Account> accounts = new ArrayList<>();

  private Bank() {
  }

  /**
   * Singleton getInstance
   *
   * @return bank instance
   */
  public static Bank getInstance() {
    return INSTANCE;
  }

  /**
   * Singleton getInstance with parameters
   *
   * @param name    of the bank
   * @param BIC     of the bank
   * @param address of the bank
   * @return bank instance
   */
  public static Bank getInstance(String name, String BIC, Address address) {
    INSTANCE.name = name;
    INSTANCE.BIC = BIC;
    INSTANCE.address = address;
    return INSTANCE;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBIC() {
    return BIC;
  }

  public void setBIC(String BIC) {
    this.BIC = BIC;
  }

  public Address getAddress() {
    return new Address(address);
  }

  public void setAddress(Address address) {
    this.address = new Address(address);
  }

  /**
   * Execute run to work with the bank
   */
  public void run() {
    int input;
    while (true) {
      showMenu();
      List<Integer> options = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      input = ConsoleReader.readNumber("Bitte eine Zahl zwischen 1 und 10", options);
      pickMenu(input);
    }
  }

  /**
   * Helper method to show the menu
   */
  private void showMenu() {
    System.out.println("(01) Privatkunde anlegen");
    System.out.println("(02) Firmenkunde anlegen");
    System.out.println("(03) Konto anlegen und Kundennummer zuordnen");
    System.out.println("(04) Kunde mit Konten anzeigen (Auswahl durch Kundennummer)");
    System.out.println("(05) Kunde mit Konten anzeigen (Auswahl durch Name)");
    System.out.println("(06) Konto anzeigen (Auswahl durch IBAN)");
    System.out.println("(07) Alle Kunden unsortiert anzeigen");
    System.out.println("(08) Alle Kunden sortiert nach aufsteigender Kundenummer anzeigen");
    System.out.println("(09) Alle Konten unsortiert anzeigen");
    System.out.println("(10) Beenden");
  }

  /**
   * Input helper method to pick option from menu
   */
  private void pickMenu(int input) {
    switch (input) {
      case 1:
        createPrivateCustomer();
        break;
      case 2:
        createCompanyCustomer();
        break;
      case 3:
        createAccount();
        break;
      case 4:
        showCustomerAccountOfCustomerNumber();
        break;
      case 5:
        showCustomerAccountOfName();
        break;
      case 6:
        showAccountOfIBAN();
        break;
      case 7:
        showAllCustomers();
        break;
      case 8:
        showAllCustomersSorted();
        break;
      case 9:
        showAllAccounts();
        break;
      case 10:
        shutDown();
        break;
    }
  }

  /**
   * Input helper method to create a private customer
   */
  private void createPrivateCustomer() {

    System.out.println("Für einen neuen Privatkunden brauchen wir folgende Angaben:");

    System.out.println("Vorname: ");
    String firstName = ConsoleReader.readString("Bitte Vorname angeben.");

    System.out.println("Nachname: ");
    String lastName = ConsoleReader.readString("Bitte Nachnamen angeben.");

    System.out.println("Telefonnummer: ");
    String phone = ConsoleReader.readString("Bitte Telefonnummer angeben.");

    System.out.println("Email: ");
    String email = ConsoleReader.readString("Bitte Email angeben.");

    System.out.println("Geburtsdatum (yyyy-mm-dd): ");
    LocalDate birthday = ConsoleReader.readDate("Bitte Geburtsdatum angeben.");

    while (true) {
      System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
      List<String> options = List.of("j", "n");
      String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
      if (input.equalsIgnoreCase("j")) {
        System.out.println("Welche Angaben wollen Sie korrigieren?");
        System.out.println("(01) Vorname: " + firstName);
        System.out.println("(02) Nachname: " + lastName);
        System.out.println("(03) Telefonnummer: " + phone);
        System.out.println("(04) Email: " + email);
        System.out.println("(05) Geburtsdatum: " + birthday);
        List<Integer> optionsNum = List.of(1, 2, 3, 4, 5);
        int inputNum = ConsoleReader.readNumber("Bitte 1-5 als Option angeben.", optionsNum);
        switch (inputNum) {
          case 1:
            System.out.println("Vorname: ");
            firstName = ConsoleReader.readString("Bitte Vorname angeben.");
            break;
          case 2:
            System.out.println("Nachname: ");
            lastName = ConsoleReader.readString("Bitte Nachname angeben.");
            break;
          case 3:
            System.out.println("Telefonnummer: ");
            phone = ConsoleReader.readString("Bitte Telefonnummer angeben.");
            break;
          case 4:
            System.out.println("Email: ");
            email = ConsoleReader.readString("Bitte Email angeben.");
            break;
          case 5:
            System.out.println("Geburtsdatum: ");
            birthday = ConsoleReader.readDate("Bitte Geburtsdatum angeben.");
            break;
          default:
            assert false;
        }
      } else {
        System.out.println("Die Angaben zum Privatkunden werden übernommen.");
        break;
      }
    }

    Address address = createAddress();
    PrivateCustomer privateCustomer = new PrivateCustomer(firstName, lastName, phone, email, birthday, address);
    this.privateCustomers.add(privateCustomer);
    System.out.println("Neuen Privatkunden mit Kundennumer " + privateCustomer.getCustomernumber() +
        " erfolgreich angelet.");
  }

  /**
   * Input helper method to create a company customer
   */
  private void createCompanyCustomer() {
    System.out.println("Für einen neuen Firmenkunde brauchen wir folgende Angaben:");

    System.out.println("Firmennamen: ");
    String companyName = ConsoleReader.readString("Bitte Firmennamen angeben.");

    System.out.println("Telefonnummer: ");
    String phone = ConsoleReader.readString("Bitte Telefonnummer angeben.");

    System.out.println("Email: ");
    String email = ConsoleReader.readString("Bitte Email angeben.");

    while (true) {
      System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
      List<String> options = List.of("j", "n");
      String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
      if (input.equalsIgnoreCase("j")) {
        System.out.println("Welche Angaben wollen Sie korrigieren?");
        System.out.println("(01) Firmenname: " + companyName);
        System.out.println("(02) Telefonnummer: " + phone);
        System.out.println("(03) Email: " + email);
        List<Integer> optionsNum = List.of(1, 2, 3);
        int inputNum = ConsoleReader.readNumber("Bitte 1-3 als Option angeben.", optionsNum);
        switch (inputNum) {
          case 1:
            System.out.println("Firmenname: ");
            companyName = ConsoleReader.readString("Bitte Firmenname angeben.");
            break;
          case 2:
            System.out.println("Telefonnummer: ");
            phone = ConsoleReader.readString("Bitte Telefonnummer angeben.");
            break;
          case 3:
            System.out.println("Email: ");
            email = ConsoleReader.readString("Bitte Email angeben.");
            break;
          default:
            assert false;
        }
      } else {
        System.out.println("Die Angaben zum Firmenkunde werden übernommen.");
        break;
      }
    }

    ContanctPerson contanctPerson = createContactPerson();

    Address address = createAddress();

    CompanyCustomer companyCustomer = new CompanyCustomer(companyName, contanctPerson, phone, email, address);
    this.companyCustomers.add(companyCustomer);
    System.out.println("Neuer Firmenkunde mit Kundennumer " + companyCustomer.getCustomernumber() +
        " erfolgreich angelet.");
  }

  /**
   * Input helper method to create an account and assign to customer by customer number
   */
  private void createAccount() {
    System.out.println("Konto anlegen.");

    System.out.println("Zu welchem Kunden wird das Konto zugeordnet?");
    System.out.println("Kundennummer fängt mit 'P' oder 'F' an: ");
    String input = ConsoleReader.readString("Kundennummer fängt mit 'P' oder 'F' an.");
    Customer customer = searchCustomerByCustomerNumber(input);
    PrivateCustomer pKunde;
    CompanyCustomer fKunde;
    if (customer != null) {

      System.out.println("Bitte geben sie die IBAN an: ");
      String iban = ConsoleReader.readString("Bitte IBAN angeben.");

      Account account = new Account(iban);
      customer.addAccount(account);
      accounts.add(account);

      System.out.println("Konto mit IBAN " + account.getIBAN() + " erfolgreich hinzugefügt.");
    } else {
      System.out.println("Keinen Kunden mit der Kundennummer " + input + " gefunden!");
    }
  }

  /**
   * Input helper method to show account with customer number and corresponding accounts
   */
  private void showCustomerAccountOfCustomerNumber() {
    System.out.println("Kunde mit Konten anzeigen (Auswahl durch Kundennummer).");

    System.out.println("Zu welchem Kunden das Konto anzeigen?");
    System.out.println("Kundennummer fängt mit 'P' oder 'F' an: ");
    String input = ConsoleReader.readString("Kundennummer fängt mit 'P' oder 'F' an.");

    Customer customer = searchCustomerByCustomerNumber(input);
    if (customer != null) {
      if (customer instanceof PrivateCustomer) {
        showPrivateCustomers((PrivateCustomer) customer);
      }

      if (customer instanceof CompanyCustomer) {
        showCompanyCustomers((CompanyCustomer) customer);
      }
      showAccounts(customer.getAccounts().toArray(Account[]::new));
    } else {
      System.out.println("Keinen Kunden mit der Kundennummer " + input + " gefunden!");
    }
  }

  /**
   * Input helper method to show account with specific name and corresponding accounts
   */
  private void showCustomerAccountOfName() {
    System.out.println("Kunde mit Konten anzeigen (Auswahl durch Name)");

    System.out.println("Zu welchem Kunden das Konto anzeigen?");
    System.out.println("Kundenname (Firma, Vor-, Nachname): ");
    String input = ConsoleReader.readString("Kundenname (Firma, Vor-, Nachname): ");

    Customer customer = searchCustomerByName(input);

    if (customer != null) {

      if (customer instanceof PrivateCustomer) {
        showPrivateCustomers((PrivateCustomer) customer);
      }

      if (customer instanceof CompanyCustomer) {
        showCompanyCustomers((CompanyCustomer) customer);
      }
      showAccounts(customer.getAccounts().toArray(Account[]::new));

    } else {
      System.out.println("Keinen Kunden mit dem Namen " + input + " gefunden!");
    }
  }

  /**
   * Input helper method to show account with specific IBAN
   */
  private void showAccountOfIBAN() {
    System.out.println("Konto anzeigen (Auswahl durch IBAN)");

    System.out.println("Zu welcher IBAN suchen Sie das Konto?");
    System.out.println("IBAN: ");
    String input = ConsoleReader.readString("IBAN bitte.");

    Account account = searchAccountsByIBAN(input);
    if (account != null) {
      showAccounts(account);
    } else {
      System.out.println("Kein Konto mit der IBAN " + input + " gefunden!");
    }
  }

  /**
   * Shows all customers (private & company) unsorted
   */
  private void showAllCustomers() {
    System.out.println("Alle Kunden unsortiert anzeigen");

    showPrivateCustomers(privateCustomers.toArray(PrivateCustomer[]::new));
    showCompanyCustomers(companyCustomers.toArray(CompanyCustomer[]::new));
  }

  /**
   * Shows all customers (private & company) sorted by the customer number
   */
  private void showAllCustomersSorted() {
    System.out.println("Alle Kunden sortiert nach aufsteigender Kundenummer anzeigen");
    Collections.sort(privateCustomers);
    showPrivateCustomers(privateCustomers.toArray(PrivateCustomer[]::new));
    Collections.sort(companyCustomers);
    showCompanyCustomers(companyCustomers.toArray(CompanyCustomer[]::new));
  }

  /**
   * Shows all accounts unsorted
   */
  private void showAllAccounts() {
    System.out.println("Alle Konten unsortiert anzeigen");
    showAccounts(accounts.toArray(Account[]::new));
  }

  /**
   * Input helper method to shut down the bank
   */
  private void shutDown() {
    System.out.println("Wollen Sie wirklich das Programm beenden? (j/n)");
    List<String> options = List.of("j", "n");
    String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
    if (input.equalsIgnoreCase("j")) {
      System.out.println("Bis zum nächsten Mal.");
      System.exit(0);
    }
  }

  /**
   * Input helper method to create an address
   * @return Address object
   */
  private Address createAddress() {
    System.out.println("Für eine neue Adresse brauchen wir folgende Angaben:");

    System.out.println("Straße: ");
    String street = ConsoleReader.readString("Bitte Straße angeben.");

    System.out.println("Hausnummer: ");
    String houseNr = ConsoleReader.readString("Bitte Hausnummer angeben.");

    System.out.println("Ort");
    String city = ConsoleReader.readString("Bitte Ort angeben.");

    while (true) {
      System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
      List<String> options = List.of("j", "n");
      String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
      if (input.equalsIgnoreCase("j")) {
        System.out.println("Welche Angaben wollen Sie korrigieren?");
        System.out.println("(01) Straße: " + street);
        System.out.println("(02) Hausnummer: " + houseNr);
        System.out.println("(03) Ort: " + city);
        List<Integer> optionsNum = List.of(1, 2, 3);
        int inputNum = ConsoleReader.readNumber("Bitte 1-3 als Option angeben.", optionsNum);
        switch (inputNum) {
          case 1:
            System.out.println("Straße: ");
            street = ConsoleReader.readString("Bitte Straße angeben.");
            break;
          case 2:
            System.out.println("Hausnummer: ");
            houseNr = ConsoleReader.readString("Bitte Hausnummer angeben.");
            break;
          case 3:
            System.out.println("Ort: ");
            city = ConsoleReader.readString("Bitte Ort angeben.");
            break;
          default:
            assert false;
        }
      } else {
        System.out.println("Die Angaben zur Adresse werden übernommen.");
        break;
      }
    }
    return new Address(street, houseNr, city);
  }

  /**
   * Input helper method to create a contact person
   * @return Customer object
   */
  private ContanctPerson createContactPerson() {
    System.out.println("Für einen neuen Ansprechpartner brauchen wir folgende Angaben:");

    System.out.println("Vorname: ");
    String vorname = ConsoleReader.readString("Bitte Vorname angeben.");

    System.out.println("Nachname: ");
    String nachname = ConsoleReader.readString("Bitte Nachnamen angeben.");

    System.out.println("Telefonnummer: ");
    String telefon = ConsoleReader.readString("Bitte Telefonnummer angeben.");

    while (true) {
      System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
      List<String> options = List.of("j", "n");
      String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
      if (input.equalsIgnoreCase("j")) {
        System.out.println("Welche Angaben wollen Sie korrigieren?");
        System.out.println("(01) Vorname: " + vorname);
        System.out.println("(02) Nachname: " + nachname);
        System.out.println("(03) Telefonnummer: " + telefon);
        List<Integer> optionsNum = List.of(1, 2, 3);
        int inputNum = ConsoleReader.readNumber("Bitte 1-3 als Option angeben.", optionsNum);
        switch (inputNum) {
          case 1:
            System.out.println("Vorname: ");
            vorname = ConsoleReader.readString("Bitte Vorname angeben.");
            break;
          case 2:
            System.out.println("Nachname: ");
            nachname = ConsoleReader.readString("Bitte Nachname angeben.");
            break;
          case 3:
            System.out.println("Telefonnummer: ");
            telefon = ConsoleReader.readString("Bitte Telefonnummer angeben.");
            break;
          default:
            assert false;
        }
      } else {
        System.out.println("Die Angaben zum Ansprechpartner werden übernommen.");
        break;
      }
    }
    return new ContanctPerson(vorname, nachname, telefon);

  }

  /**
   * Searches for a customer (private and company) based on customer number
   * @param customerNumber for the search in List with private and company customers
   * @return customer with the customer number or null if not existing
   */
  private Customer searchCustomerByCustomerNumber(String customerNumber) {
    for (Customer customer : privateCustomers) {
      if (customer.getCustomernumber().equalsIgnoreCase(customerNumber)) {
        return customer;
      }
    }

    for (Customer customer : companyCustomers) {
      if (customer.getCustomernumber().equalsIgnoreCase(customerNumber)) {
        return customer;
      }
    }
    return null;
  }

  /**
   * Searches for customers with matching name
   *
   * @param name of the customer (private: Vorname, Nachname) (company: Firmennamme)
   * @return found customer or null
   */
  private Customer searchCustomerByName(String name) {
    for (CompanyCustomer kunde : companyCustomers) {
      if (kunde.getCompanyName().equalsIgnoreCase(name)) {
        return kunde;
      }
    }

    for (PrivateCustomer kunde : privateCustomers) {
      if (kunde.getFirstName().equalsIgnoreCase(name) || kunde.getLastName().equalsIgnoreCase(name)) {
        return kunde;
      }
    }
    return null;
  }

  /**
   * Search for konto with matching IBAN.
   *
   * @param iban of the konto
   * @return konto with IBAN or null
   */
  private Account searchAccountsByIBAN(String iban) {
    for (Account account : accounts) {
      if (account.getIBAN().equalsIgnoreCase(iban)) {
        return account;
      }
    }
    return null;
  }

  /**
   * Prints out a variable number of private customers
   * @param customers is a single customer or an array of customers to be printed
   */
  private void showPrivateCustomers(PrivateCustomer... customers) {
    System.out.println("Kundennummer | Vorname | Nachname | Telefon | Email | Geburtsdatum | Ort | Straße | Nr.");
    for (PrivateCustomer kunde : customers) {
      Address address = kunde.getAddress();
      System.out.println(
          kunde.getCustomernumber() + " | " +
              kunde.getFirstName() + " | " +
              kunde.getLastName() + " | " +
              kunde.getPhone() + " | " +
              kunde.getEmail() + " | " +
              kunde.getBirthday() + " | " +
              address.getCity() + " | " +
              address.getStreet() + " | " +
              address.getHouseNr()
      );
    }
    System.out.println();
  }

  /**
   * Prints out a variable number of company customers
   * @param customers is a single customer or an array of customers to be printed
   */
  private void showCompanyCustomers(CompanyCustomer... customers) {
    System.out.println("Kundennummer | Firmenname | Ansprechpartner Name & Nummer | Telefon | Email | Geburtsdatum | Ort | Straße | Nr.");
    for (CompanyCustomer kunde : customers) {
      Address address = kunde.getAddress();
      ContanctPerson partner = kunde.getContanctPerson();
      System.out.println(
          kunde.getCustomernumber() + " | " +
              kunde.getCompanyName() + " | " +
              partner.getFirstName() + " " +
              partner.getLastName() + " & " +
              partner.getPhone() + " | " +
              kunde.getPhone() + " | " +
              kunde.getEmail() + " | " +
              address.getCity() + " | " +
              address.getStreet() + " | " +
              address.getHouseNr()
      );
    }
    System.out.println();
  }

  /**
   * Prints out a variable number of accounts
   * @param accounts is a single account or an array of accounts to be printed
   */
  private void showAccounts(Account... accounts) {
    System.out.println("IBAN | Kontostand");
    for (Account account : accounts) {
      System.out.println(
          account.getIBAN() + " | " +
              account.getBalance()
      );
    }
    System.out.println();
  }
}
