package Raumschiffe;

public class Main {
    public static void main(String[] args) {

        //Erstellung von Raumschiffobjekten
        Raumschiff klingonen = new Raumschiff(1,100,100,100,100,2,"IKS Heghta");
        Raumschiff romulaner = new Raumschiff(2,100,100,100,100,2,"IRW Khazara");
        Raumschiff vulkaner = new Raumschiff(0,80,80,50,100,5,"NiVar");

        //Erstellung von Ladungsobjekten
        Ladung klingonenFirstLadung = new Ladung("Ferengi Schneckensaft", 200);
        Ladung klingonenSecondLadung = new Ladung("Gatleth Klingonen Schwert", 200);
        Ladung romulanerFirstLadung = new Ladung("Borg-Schrott", 5);
        Ladung romulanerSecondLadung = new Ladung("Rote Materie", 2);
        Ladung romulanerThirdLadung = new Ladung("Plasma-Waffe", 50);
        Ladung vulkanierFirstLadung = new Ladung("Forschungssonde", 35);
        Ladung vulkanierSecondLadung = new Ladung("Photonentorpedo", 3);

        //Hinzufügen aller Ladungen zu Raumschiffen
        klingonen.addLadung(klingonenFirstLadung);
        klingonen.addLadung(klingonenSecondLadung);
        romulaner.addLadung(romulanerFirstLadung);
        romulaner.addLadung(romulanerSecondLadung);
        romulaner.addLadung(romulanerThirdLadung);
        vulkaner.addLadung(vulkanierFirstLadung);
        vulkaner.addLadung(vulkanierSecondLadung);

        //Die Klingonen schießen mit dem Photonentorpedo einmal auf die Romulaner
        klingonen.photonentorpedoSchiessen(klingonen);
        klingonen.treffer(romulaner);
        System.out.println("-------------------------------");

        //Die Romulaner schießen mit der Phaserkanone zurück
        romulaner.phaserkanoneSchiessen(romulaner);
        romulaner.treffer(klingonen);
        System.out.println("-------------------------------");

        //Die Vulkanier senden eine Nachricht an Alle “Gewalt ist nicht logisch”
        vulkaner.nachrichtAnAlle("Gewalt ist nicht logisch");
        System.out.println("-------------------------------");

        //Die Klingonen rufen den Zustand Ihres Raumschiffes ab und geben Ihr Ladungsverzeichnis aus
        klingonen.zustandRaumschiff();
        klingonen.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------------");

        //Die Vulkanier sind sehr sicherheitsbewusst und setzen alle Androiden zur Aufwertung ihres Schiffes ein (für Experten)
        vulkaner.reparaturDurchfuehren(true, true,true, 5);

        //Die Vulkanier verladen Ihre Ladung “Photonentorpedos” in die Torpedoröhren Ihres Raumschiffes und räumen das Ladungsverzeichnis auf (für Experten)
        vulkaner.photonentorpedosLaden(3);
        vulkaner.ladungsverzeichnisAufraeumen();
        System.out.println("-------------------------------");

        //Die Klingonen schießen mit zwei weiteren Photonentorpedo auf die Romulaner
        klingonen.photonentorpedoSchiessen(klingonen);
        klingonen.photonentorpedoSchiessen(klingonen);
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println();

        //Die Klingonen, die Romulaner und die Vulkanier rufen jeweils den Zustand Ihres Raumschiffes ab und geben Ihr Ladungsverzeichnis aus
        System.out.println("Die Klingonen rufen den Zustand Ihres Raumschiffes ab:");
        klingonen.zustandRaumschiff();
        System.out.println("-------------------------------");
        System.out.println("Die Klingonen geben Ihr Ladungsverzeichnis aus:");
        klingonen.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------------");
        System.out.println("Die Romulaner rufen den Zustand Ihres Raumschiffes ab:");
        romulaner.zustandRaumschiff();
        System.out.println("-------------------------------");
        System.out.println("Die Romulaner geben Ihr Ladungsverzeichnis aus:");
        romulaner.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------------");
        System.out.println("Die Vulkanier rufen den Zustand Ihres Raumschiffes ab:");
        vulkaner.zustandRaumschiff();
        System.out.println("-------------------------------");
        System.out.println("Die Vulkanier geben Ihr Ladungsverzeichnis aus:");
        vulkaner.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println();

        //Ausgabe von Broadcast-Kommunikatoren
        System.out.println("Ausgabe von Broadcast-Kommunikatoren:");
        klingonen.broadcastLogAusgeben();
        System.out.println("-------------------------------");
        romulaner.broadcastLogAusgeben();
        System.out.println("-------------------------------");
        vulkaner.broadcastLogAusgeben();





    }
}
