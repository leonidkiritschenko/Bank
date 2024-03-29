package bank.address;

/**
 * Address is a value class with street, house number, and city.
 */
public class Address {
  private String street;
  private String houseNr;
  private String city;

  public Address(Address address) {
    this.street = address.street;
    this.houseNr = address.street;
    this.city = address.city;
  }

  public Address(String street, String houseNr, String city) {
    this.street = street;
    this.houseNr = houseNr;
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public String getHouseNr() {
    return houseNr;
  }

  public String getCity() {
    return city;
  }
}
