package bank.adresse;

public class Adresse {
    private String adresszeile1 = "";
    private String adresszeile2 = "";
    private String ort = "";

    /**
     * Copy constructor
     * @param adresse is to be coppied
     */
    public Adresse(Adresse adresse) {
        this.adresszeile1 = adresse.adresszeile1;
        this.adresszeile2 = adresse.adresszeile1;
        this.ort = adresse.ort;
    }

    public Adresse(String adresszeile1, String adresszeile2, String ort) {
        this.adresszeile1 = adresszeile1;
        this.adresszeile2 = adresszeile2;
        this.ort = ort;
    }

    public String getAdresszeile1() {
        return adresszeile1;
    }

    public String getAdresszeile2() {
        return adresszeile2;
    }

    public String getOrt() {
        return ort;
    }
}
