package bank.kunden;

import bank.konto.Konto;
import bank.adresse.Adresse;

import java.util.ArrayList;

public abstract class Kunde implements Comparable {
  private String telefon;
  private String email;
  private Adresse adresse;

  // max 10 Konten
  private ArrayList<Konto> konten = new ArrayList<>();

  Kunde(String telefon, String email, Adresse adresse) {
    this.telefon = telefon;
    this.email = email;
    this.adresse = adresse;
  }

  public abstract String getKundennummer();

  public String getTelefon() {
    return telefon;
  }

  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Adresse getAdresse() {
    return new Adresse(adresse);
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = new Adresse(adresse);
  }

  public ArrayList<Konto> getKonten() {
    return new ArrayList<>(this.konten);
  }

  public boolean addKonto(Konto konto) {
    if (this.konten.size() < 10) {
      this.konten.add(new Konto(konto));
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int compareTo(Object o) {
    Kunde kunde = (Kunde) o;
    return Integer.valueOf(this.getKundennummer().substring(1)) - Integer.valueOf(kunde.getKundennummer().substring(1));
  }
}
