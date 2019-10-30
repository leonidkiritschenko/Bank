package test;

import bank.Bank;
import bank.adresse.Adresse;

public class BankTester {

    public static void main(String[] args) {
        Adresse bankAdresse = new Adresse("Mainzer Landstraße", "151"
                , "60327 Frankfurt am Main");
        String bankName = "Commerzbank";
        String bankBIC = "COBADEFF";
        Bank bank = Bank.getInstance(bankName, bankBIC, bankAdresse);
        bank.run();
    }
}
