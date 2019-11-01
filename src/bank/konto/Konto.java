package bank.konto;

public class Konto {
    private String IBAN;
    private double kontostand = 0.0;

    public Konto(String IBAN) {
        this.IBAN = IBAN;
        this.kontostand = kontostand;
    }

    public Konto(Konto konto) {
        this.IBAN = konto.IBAN;
        this.kontostand = konto.kontostand;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }
}
