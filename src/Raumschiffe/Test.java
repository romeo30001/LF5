package Raumschiffe;
public class Test extends Raumschiff {
    public static void main(String[] args) {
        Raumschiff raumschiff1 = new Raumschiff(10,50,30,45,20,10,"vw");
        Raumschiff raumschiff2 = new Raumschiff(1,5,3,4,2,1,"bmw");

        Ladung ladung1 = new Ladung("Photonentorpedo",10);
        Ladung ladung2 = new Ladung("Testtorpedos",10);

        raumschiff1.zustandRaumschiff();
        System.out.println("-------------------------");
        raumschiff1.addLadung(ladung1);
        raumschiff1.addLadung(ladung2);

        raumschiff1.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------");
        raumschiff1.photonentorpedoSchiessen(raumschiff1);
        System.out.println("-------------------------");
        raumschiff1.zustandRaumschiff();
        System.out.println("-------------------------");
        raumschiff1.phaserkanoneSchiessen(raumschiff1);
        System.out.println("-------------------------");
        raumschiff1.zustandRaumschiff();
        System.out.println("-------------------------");
        raumschiff1.photonentorpedosLaden(10);
        System.out.println("-------------------------");
        raumschiff1.zustandRaumschiff();
        System.out.println("-------------------------");
        raumschiff1.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------");
        raumschiff1.ladungsverzeichnisAufraeumen();
        raumschiff1.ladungsverzeichnisAusgeben();
        System.out.println("-------------------------");
        raumschiff1.treffer(raumschiff2);
        System.out.println("-------------------------");
        raumschiff2.zustandRaumschiff();
        System.out.println("-------------------------");
        raumschiff2.reparaturDurchfuehren(true,true,true,5);
        raumschiff2.zustandRaumschiff();
        System.out.println("-------------------------");
        raumschiff1.nachrichtAnAlle("Test");
        raumschiff1.nachrichtAnAlle("Test 1");
        System.out.println("-------------------------");
        raumschiff1.broadcastLogAusgeben();
    }
}
