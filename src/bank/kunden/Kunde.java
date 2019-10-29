package bank.kunden;

import bank.konto.Konto;
import bank.adresse.Adresse;

import java.util.ArrayList;

public abstract class Kunde {
    private String kundennummer = "";
    private String telefon = "";
    private String email = "";
    private Adresse adresse;

    // max 10 Konten
    private ArrayList<Konto> konten;

}
