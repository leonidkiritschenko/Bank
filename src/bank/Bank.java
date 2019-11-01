package bank;

import bank.konto.Konto;
import bank.kunden.Ansprechpartner;
import bank.kunden.Firmenkunde;
import bank.kunden.Kunde;
import bank.adresse.Adresse;
import bank.kunden.Privatkunde;
import bank.util.ConsoleReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern for Creation:
 * https://dzone.com/articles/design-patterns-the-builder-pattern
 */

public class Bank {

    private static final Bank INSTANCE = new Bank();
    private String name = "";
    private String BIC = "";
    private Adresse adresse;

    private ArrayList<Kunde> kunden = new ArrayList<>();
    private ArrayList<Konto> konten = new ArrayList<>();

    private Bank() { }

    /**
     * Singleton getInstance
     * @return bank instance
     */
    public static Bank getInstance() {
        return INSTANCE;
    }

    /**
     * Singleton getInstance with parameters
     * @param name of the bank
     * @param BIC of the bank
     * @param adresse of the bank
     * @return bank instance
     */
    public static Bank getInstance(String name, String BIC, Adresse adresse) {
        INSTANCE.name = name;
        INSTANCE.BIC = BIC;
        INSTANCE.adresse = adresse;
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

    public Adresse getAdresse() {
        return new Adresse(adresse);
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = new Adresse(adresse);
    }

    public void run() {
        int input;
        while(true) {
            showMenu();
            List<Integer> options = List.of(1,2,3,4,5,6,7,8,9,10);
            input = ConsoleReader.readNumber("Bitte eine Zahl zwischen 1 und 10", options);
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

        System.out.println("Für einen neuen Privatkunden brauchen wir folgende Angaben:");

        System.out.println("Vorname: ");
        String vorname = ConsoleReader.readString("Bitte Vorname angeben.");

        System.out.println("Nachname: ");
        String nachname = ConsoleReader.readString("Bitte Nachnamen angeben.");

        System.out.println("Telefonnummer: ");
        String telefon = ConsoleReader.readString("Bitte Telefonnummer angeben.");

        System.out.println("Email: ");
        String email = ConsoleReader.readString("Bitte Email angeben.");

        System.out.println("Geburtsdatum (yyyy-mm-dd): ");
        LocalDate bday = ConsoleReader.readDate("Bitte Geburtsdatum angeben.");

        while (true) {
            System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
            List<String> options = List.of("j", "n");
            String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
            if (input.equalsIgnoreCase("j")) {
                System.out.println("Welche Angaben wollen Sie korrigieren?");
                System.out.println("(01) Vorname: " + vorname);
                System.out.println("(02) Nachname: " + nachname);
                System.out.println("(03) Telefonnummer: " + telefon);
                System.out.println("(04) Email: " + email);
                System.out.println("(05) Geburtsdatum: " + bday);
                List<Integer> optionsNum = List.of(1,2,3,4,5);
                int inputNum = ConsoleReader.readNumber("Bitte 1-5 als Option angeben.", optionsNum);
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
                    case 4:
                        System.out.println("Email: ");
                        email = ConsoleReader.readString("Bitte Email angeben.");
                        break;
                    case 5:
                        System.out.println("Geburtsdatum: ");
                        bday = ConsoleReader.readDate("Bitte Geburtsdatum angeben.");
                        break;
                    default:
                        assert false;
                }
            } else {
                System.out.println("Die Angaben zum Privatkunden werden übernommen.");
                break;
            }
        }

        Adresse adresse = createAdress();
        Privatkunde privatkunde = new Privatkunde(vorname, nachname, telefon, email, bday, adresse);
        kunden.add(privatkunde);
        System.out.println("Neuen Privatkunden mit Kundennumer " + privatkunde.getKundennummer() +
                " erfolgreich angelet.");
    }

    private void createFirmenkunde() {
        System.out.println("Für einen neuen Firmenkunde brauchen wir folgende Angaben:");

        // Firmennamen
        System.out.println("Firmennamen: ");
        String name = ConsoleReader.readString("Bitte Firmennamen angeben.");

        // Telefonnummer
        System.out.println("Telefonnummer: ");
        String telefon = ConsoleReader.readString("Bitte Telefonnummer angeben.");

        // Email
        System.out.println("Email: ");
        String email = ConsoleReader.readString("Bitte Email angeben.");

        while (true) {
            System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
            List<String> options = List.of("j", "n");
            String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
            if (input.equalsIgnoreCase("j")) {
                System.out.println("Welche Angaben wollen Sie korrigieren?");
                System.out.println("(01) Firmenname: " + name);
                System.out.println("(02) Telefonnummer: " + telefon);
                System.out.println("(03) Email: " + email);
                List<Integer> optionsNum = List.of(1,2,3);
                int inputNum = ConsoleReader.readNumber("Bitte 1-3 als Option angeben.", optionsNum);
                switch (inputNum) {
                    case 1:
                        System.out.println("Firmenname: ");
                        name = ConsoleReader.readString("Bitte Firmenname angeben.");
                        break;
                    case 2:
                        System.out.println("Telefonnummer: ");
                        telefon = ConsoleReader.readString("Bitte Telefonnummer angeben.");
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

        Ansprechpartner ansprechpartner = createAnsprechpartner();

        Adresse adresse = createAdress();

        Firmenkunde firmenkunde = new Firmenkunde(name, ansprechpartner, telefon, email, adresse);
        kunden.add(firmenkunde);
        System.out.println("Neuer Firmenkunde mit Kundennumer " + firmenkunde.getKundennummer() +
                " erfolgreich angelet.");
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

    private Adresse createAdress() {
        System.out.println("Für eine neue Adresse brauchen wir folgende Angaben:");

        System.out.println("Straße: ");
        String street = ConsoleReader.readString("Bitte Straße angeben.");

        System.out.println("Hausnummer: ");
        String houseNr = ConsoleReader.readString("Bitte Hausnummer angeben.");

        System.out.println("Ort");
        String city = ConsoleReader.readString("Bitte Ort angeben.");

        // TODO: Export correction into separate method.
        while (true) {
            System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
            List<String> options = List.of("j", "n");
            String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
            if (input.equalsIgnoreCase("j")) {
                System.out.println("Welche Angaben wollen Sie korrigieren?");
                System.out.println("(01) Straße: " + street);
                System.out.println("(02) Hausnummer: " + houseNr);
                System.out.println("(03) Ort: " + city);
                List<Integer> optionsNum = List.of(1,2,3);
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
        return new Adresse(street, houseNr, city);
    }

    private Ansprechpartner createAnsprechpartner() {
        System.out.println("Für einen neuen Ansprechpartner brauchen wir folgende Angaben:");

        // Vorname
        System.out.println("Vorname: ");
        String vorname = ConsoleReader.readString("Bitte Vorname angeben.");

        // Nachname
        System.out.println("Nachname: ");
        String nachname = ConsoleReader.readString("Bitte Nachnamen angeben.");

        // Telefonnummer
        System.out.println("Telefonnummer: ");
        String telefon = ConsoleReader.readString("Bitte Telefonnummer angeben.");

        // TODO: Export correction into separate method.
        while (true) {
            System.out.println("Wollen Sie die Angaben korrigieren? (j/n)");
            List<String> options = List.of("j", "n");
            String input = ConsoleReader.readString("Bitte 'j' oder 'n'.", options);
            if (input.equalsIgnoreCase("j")) {
                System.out.println("Welche Angaben wollen Sie korrigieren?");
                System.out.println("(01) Vorname: " + vorname);
                System.out.println("(02) Nachname: " + nachname);
                System.out.println("(03) Telefonnummer: " + telefon);
                List<Integer> optionsNum = List.of(1,2,3);
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
        return new Ansprechpartner(vorname, nachname, telefon);

    }

    private Kunde searchKundeByKundennummer(String knummer) {
        for (Kunde kunde : kunden) {
            if (kunde.getKundennummer().equalsIgnoreCase(knummer)) {
                return kunde;
            }
        }
        return null;
    }

    /**
     * Searches for customers with matching name
     * @param name of the customer (private: Vorname, Nachname) (company: Firmennamme)
     * @return found customer or null
     */
    private Kunde searchKundeByName(String name) {
        for (Kunde kunde : kunden) {
            if (kunde instanceof Privatkunde) {
                if (((Privatkunde)kunde).getVorname().equalsIgnoreCase(name) || ((Privatkunde)kunde).getNachname().equalsIgnoreCase(name)) {
                    return kunde;
                }
            }
            if (kunde instanceof Firmenkunde) {
                if (((Firmenkunde)kunde).getFirmenname().equalsIgnoreCase(name)) {
                    return kunde;
                }
            }
        }
        return null;
    }
}
