import java.util.Scanner;

class Fahrkartenautomat {
    //Münzrückgabe
    public static void muenzRueckgabe(double rueckgabebetrag){

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

    // Rückgeldberechnung und -ausgabe
    public static void rueckgeldAusgeben(double eingezahlterGesamtbetrag, double zuZahlenderBetrag) {
        double rueckgabebetrag;
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.print("Der Rückgabebetrag in Höhe von ");
            System.out.printf("%.2f", rueckgabebetrag);
            System.out.print(" Euro");
            System.out.println(" wird in folgenden Münzen ausgezahlt:");
            System.out.println();

            muenzRueckgabe(rueckgabebetrag);
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");
    }

    // Fahrscheinausgabe
    public static void fahrKartenAusgeben(double zuZahlenderBetrag) {
        if (zuZahlenderBetrag > 0) {
            System.out.println("\nFahrschein wird ausgegeben");
            for (int i = 0; i < 8; i++) {
                System.out.print("=");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n\n");
        } else {
            System.out.println("\nFahrschein wird nicht ausgegeben, weil Sie kein Geld bezahlt haben");
            for (int i = 0; i < 8; i++) {
                System.out.print("=");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n\n");
        }
    }

    //Geldeinwurf
    public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
        double nochZuZahlen;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        eingezahlterGesamtbetrag = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.print("Noch zu zahlen: ");
            System.out.printf("%.2f", nochZuZahlen);
            System.out.println(" Euro");
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 || eingeworfeneMuenze == 0.2 || eingeworfeneMuenze == 0.5 || eingeworfeneMuenze == 1 || eingeworfeneMuenze == 2 || eingeworfeneMuenze == 5 || eingeworfeneMuenze == 10 || eingeworfeneMuenze == 20) {
                eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
            } else {
                System.out.println(">> Kein gültiges Zahlungsmittel");
            }
        }
        return eingezahlterGesamtbetrag;
    }

    //Kartenauswahl und Ticketanzahl
    public static double fahrkartenbestellungErfassen(Scanner tastatur) {
        double zuZahlenderBetrag = 0;
        double zwischensumme = 0;
        int fahrkartenAnzahl;
        int fahrkartenTyp;
        System.out.println("Fahrkartenbestellvorgang: ");
        System.out.println("=========================");
        System.out.println();

        // Auswahl der Fahrkarten
        System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus: ");
        System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
        System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
        System.out.println("Tageskarte AB [8,80 EUR] (3)");
        System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
        System.out.println("Bezahlen (9)");
        System.out.println();
        System.out.print("Ihre Wahl: ");
        fahrkartenTyp = tastatur.nextInt();

        while (fahrkartenTyp == 9) {
            System.out.println();
            System.out.println("Fahrkartenbestellvorgang: ");
            System.out.println("=========================");
            System.out.println();
            System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus: ");
            System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
            System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
            System.out.println("Tageskarte AB [8,80 EUR] (3)");
            System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
            System.out.println("Bezahlen (9)");
            System.out.println();
            System.out.print("Ihre Wahl: ");
            fahrkartenTyp = tastatur.nextInt();

        }

        while (fahrkartenTyp != 9) {
            while (fahrkartenTyp < 1 || fahrkartenTyp > 9 || fahrkartenTyp == 8 || fahrkartenTyp == 7 || fahrkartenTyp == 6 || fahrkartenTyp == 5) {
                System.out.println(">>falsche Eingabe<<");
                System.out.print("Ihre Wahl: ");
                fahrkartenTyp = tastatur.nextInt();
            }
            // Berechnung des Geldbetrags
            if (fahrkartenTyp == 1) {
                zuZahlenderBetrag = 0;
                zuZahlenderBetrag = zuZahlenderBetrag + 2;
            } else if (fahrkartenTyp == 2) {
                zuZahlenderBetrag = 0;
                zuZahlenderBetrag = zuZahlenderBetrag + 3;
            } else if (fahrkartenTyp == 3) {
                zuZahlenderBetrag = 0;
                zuZahlenderBetrag = zuZahlenderBetrag + 8.80;
            } else if (fahrkartenTyp == 4) {
                zuZahlenderBetrag = 0;
                zuZahlenderBetrag = zuZahlenderBetrag + 9.40;
            } else {
                zuZahlenderBetrag = 0;
                zuZahlenderBetrag = zuZahlenderBetrag + 0;
            }

            //Anzahl der Fahrkarten eingeben
            System.out.print("Anzahl der Tickets: ");
            fahrkartenAnzahl = tastatur.nextInt();
            zwischensumme = zwischensumme + (zuZahlenderBetrag * fahrkartenAnzahl);
            zuZahlenderBetrag = zwischensumme;
            while (fahrkartenAnzahl < 1 || fahrkartenAnzahl > 10) {
                System.out.println("Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus.");
                System.out.print("Anzahl der Tickets: ");
                fahrkartenAnzahl = tastatur.nextInt();
            }
            System.out.println();
            System.out.println("Zwischensumme: " + zwischensumme + " €");
            System.out.println();
            System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus: ");
            System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
            System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
            System.out.println("Tageskarte AB [8,80 EUR] (3)");
            System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
            System.out.println("Bezahlen (9)");
            System.out.println();
            System.out.print("Ihre Wahl: ");
            fahrkartenTyp = tastatur.nextInt();
        }
        return zuZahlenderBetrag;
    }

    public static void begruessung() {
        System.out.println("Herzlich Willkommen!");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;

        begruessung();
        zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
        eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
        fahrKartenAusgeben(zuZahlenderBetrag);
        rueckgeldAusgeben(eingezahlterGesamtbetrag, zuZahlenderBetrag);

        tastatur.close();
    }
}
