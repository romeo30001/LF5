import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int fahrkartenAnzahl = 1;

        // Geldbetrag eingeben
        System.out.print("Zu zahlender Betrag (Euro): ");
        zuZahlenderBetrag = tastatur.nextDouble();
        if (zuZahlenderBetrag < 1) {
            zuZahlenderBetrag = 1;
            System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf " + zuZahlenderBetrag + " gesetzt");
        }

        //Anzahl der Fahrkarten eingeben
        System.out.print("Anzahl der Tickets: ");
        fahrkartenAnzahl = tastatur.nextInt();
        if (fahrkartenAnzahl < 1 || fahrkartenAnzahl > 10) {
            fahrkartenAnzahl = 1;
            System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf " + fahrkartenAnzahl + " gesetzt");
        }

        // Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag * fahrkartenAnzahl - eingezahlterGesamtbetrag;
            System.out.println("Noch zu zahlen: " + nochZuZahlen + " Euro");
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 || eingeworfeneMuenze == 0.2 || eingeworfeneMuenze == 0.5 || eingeworfeneMuenze == 1 || eingeworfeneMuenze == 2 || eingeworfeneMuenze == 5 || eingeworfeneMuenze == 10 || eingeworfeneMuenze == 20) {
                eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
            }
            else {
                System.out.println(">> Kein gültiges Zahlungsmittel");
            }
        }

        // Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(0);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // Rückgeldberechnung und -ausgabe
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0 ) {
            System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 20.0) { // 20-Euro-Münzen
                System.out.println("20 Euro");
                rueckgabebetrag = rueckgabebetrag - 20.0;
            }
            while (rueckgabebetrag >= 10.0) { // 10-Euro-Münzen
                System.out.println("10 Euro");
                rueckgabebetrag = rueckgabebetrag - 10.0;
            }
            while (rueckgabebetrag >= 5.0) { // 5-Euro-Münzen
                System.out.println("5 Euro");
                rueckgabebetrag = rueckgabebetrag - 5.0;
            }
            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 2.0;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 1.0;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.5;
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.2;
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.1;
            }
            while (rueckgabebetrag > 0.049) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.05;
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }
}
