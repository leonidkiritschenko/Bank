package bank;

import bank.kunden.Kunde;
import bank.adresse.Adresse;
import bank.util.ConsoleReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern for Creation:
 * https://dzone.com/articles/design-patterns-the-builder-pattern
 */

public class Bank {
    private String name = "";
    private String BIC = "";
    private Adresse adresse;

    private ArrayList<Kunde> kunden;

    public void run() {
        int input = 0;
        while(true) {
            showMenu();
            input = ConsoleReader.readNumber("Bitte eine Zahl zwischen 1 und 10");
            pickMenu(input);
        }
    }

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

    private void pickMenu(int input) {
        switch (input) {
            case 1:
                createPrivatkunde();
                break;
            case 2:
                createFirmenkunde();
                break;
            case 3:
                createKonto();
                break;
            case 4:
                showKundenKontoOfKundennumer();
                break;
            case 5:
                showKundenKontoOfName();
                break;
            case 6:
                showKontoOfIBAN();
                break;
            case 7:
                showAllKunden();
                break;
            case 8:
                showAllKundenSorted();
                break;
            case 9:
                showAllKonten();
                break;
            case 10:
                beenden();
                break;
        }
    }

    private void createPrivatkunde() {

    }

    private void createFirmenkunde() {

    }

    private void createKonto() {

    }

    private void showKundenKontoOfKundennumer() {

    }

    private void showKundenKontoOfName() {
        // Bei Auswahl durch Name soll der Suchtext beim Privatkunden im Vor- oder Nachnamen und bei Firmenkunden im
        // Firmennamen enthalten sein.

    }

    private void showKontoOfIBAN() {

    }

    private void showAllKunden() {

    }

    private void showAllKundenSorted() {

    }

    private void showAllKonten() {

    }

    private void beenden() {
        System.out.println("Wollen Sie wirklich das Programm beenden? (j/n)");
        List<String> options = List.of("j", "n");
        String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
        if(input.equalsIgnoreCase("j")) {
            System.out.println("Bis zum nächsten Mal.");
            System.exit(0);
        }
    }
}
