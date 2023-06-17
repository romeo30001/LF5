package Raumschiffe;

import java.util.ArrayList;


public class Raumschiff extends Ladung{
    private int photonentorpedoAnzahl;
    private int energieversorgungInProzent;
    private int schildeInProzent;
    private int huelleInProzent;
    private int lebenserhaltungssystemeInProzent;
    private int androidenAnzahl;
    private String schiffsname;
    private ArrayList<String> broadcastKommunikator = new ArrayList<>();
    private ArrayList<Ladung> ladungsverzeichnis = new ArrayList<>();

    public Raumschiff(){

    }

    public Raumschiff (int photonentorpedoAnzahl, int energieversorgungInProzent, int schildeInProzent, int huelleInProzent, int lebenserhaltungssystemeInProzent, int androidenAnzahl, String schiffsname ){
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schildeInProzent = schildeInProzent;
        this.huelleInProzent = huelleInProzent;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
        this.androidenAnzahl = androidenAnzahl;
        this.schiffsname = schiffsname;
    }

    public int getPhotonentorpedoAnzahl (){
        return this.photonentorpedoAnzahl;
    }

    public void setPhotonentorpedoAnzahl (int photonentorpedoAnzahlNeu){
        this.photonentorpedoAnzahl = photonentorpedoAnzahlNeu;
    }

    public int getEnergieversorgungInProzent() {
        return energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent;
    }

    public int getSchildeInProzent() {
        return schildeInProzent;
    }

    public void setSchildeInProzent(int schildeInProzent) {
        this.schildeInProzent = schildeInProzent;
    }

    public int getHuelleInProzent() {
        return huelleInProzent;
    }

    public void setHuelleInProzent(int huelleInProzent) {
        this.huelleInProzent = huelleInProzent;
    }

    public int getLebenserhaltungssystemeInProzent() {
        return lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public int getAndroidenAnzahl() {
        return androidenAnzahl;
    }

    public void setAndroidenAnzahl(int androidenAnzahl) {
        this.androidenAnzahl = androidenAnzahl;
    }

    public String getSchiffsname() {
        return schiffsname;
    }

    public void setSchiffsname(String schiffsname) {
        this.schiffsname = schiffsname;
    }

    public void addLadung (Ladung neueLadung){
        this.ladungsverzeichnis.add(neueLadung);
    }

    public void photonentorpedoSchiessen (Raumschiff r){
        if (r.photonentorpedoAnzahl == 0 || r.photonentorpedoAnzahl < 0){
            nachrichtAnAlle("-=*Click*=- ");
        }else {
            r.photonentorpedoAnzahl = r.photonentorpedoAnzahl-1;
            nachrichtAnAlle("Photonentorpedo abgeschossen");
        }
    }

    public void phaserkanoneSchiessen (Raumschiff r){
        if (r.energieversorgungInProzent < 50){
            nachrichtAnAlle("-=*Click*=- ");
        }else {
            r.energieversorgungInProzent = r.energieversorgungInProzent-50;
            nachrichtAnAlle("Phaserkanone abgeschossen");
        }

    }

    protected void treffer(Raumschiff r) {
        nachrichtAnAlle(r.schiffsname + " wurde getroffen!");
        r.schildeInProzent = r.schildeInProzent - 50;
        if (r.schildeInProzent <= 0) {
            r.huelleInProzent = r.huelleInProzent - 50;
            r.energieversorgungInProzent = r.energieversorgungInProzent - 50;
        }
        if (r.huelleInProzent <=0){
            nachrichtAnAlle("Die Lebenserhaltungssysteme sind vernichtet worden");
        }
    }

    public void nachrichtAnAlle (String message){
        System.out.println(message);
        broadcastKommunikator.add(message);
    }

    public ArrayList<String> eintraegeLogbuchZurueckgeben (){
        return this.broadcastKommunikator;
    }

    public void photonentorpedosLaden(int anzahlTorpedos) {
        if (getPhotonentorpedoAnzahl() <= 0) {
            nachrichtAnAlle("Keine Photonentorpedos gefunden!");
            nachrichtAnAlle("-=*Click*=-");
        }
        if (anzahlTorpedos > getPhotonentorpedoAnzahl()) {
            System.out.println(anzahlTorpedos + " Photonentorpedo(s) eingesetzt");
            for (Ladung ladung : ladungsverzeichnis) {
                if (ladung.getBezeichnung() == "Photonentorpedo"){
                    ladung.setMenge(ladung.getMenge() - anzahlTorpedos);
                }
            }
            this.photonentorpedoAnzahl = getPhotonentorpedoAnzahl() + anzahlTorpedos;
        }
    }

    public void reparaturDurchfuehren (boolean schutzschilde, boolean energieversorgung, boolean schiffshuelle, int anzahlDroiden){
        int zufallszahl = (int) (Math.random() * 100);
        int anzahlDerEingesetztenAndroiden;
        int anzahlDerAufTrueGesetztenSchiffsstrukturen;
        int berechnungDerRepariertenSchiffsstrukturenInProzent;

        if (anzahlDroiden > getAndroidenAnzahl()){
            anzahlDerEingesetztenAndroiden = getAndroidenAnzahl() + anzahlDroiden;
        } else {
            anzahlDerEingesetztenAndroiden = getAndroidenAnzahl();
        }

        if (schutzschilde && energieversorgung && schiffshuelle){
            anzahlDerAufTrueGesetztenSchiffsstrukturen = 3;
        } else if (schutzschilde && energieversorgung || schutzschilde && schiffshuelle || energieversorgung && schiffshuelle){
            anzahlDerAufTrueGesetztenSchiffsstrukturen = 2;
        } else if (!schutzschilde && !energieversorgung && !schiffshuelle){
            anzahlDerAufTrueGesetztenSchiffsstrukturen = 0;
        }
        else {
            anzahlDerAufTrueGesetztenSchiffsstrukturen = 1;
        }

        berechnungDerRepariertenSchiffsstrukturenInProzent = zufallszahl * Math.abs(anzahlDerEingesetztenAndroiden) / Math.abs(anzahlDerAufTrueGesetztenSchiffsstrukturen);

        if (schutzschilde){
            setSchildeInProzent(berechnungDerRepariertenSchiffsstrukturenInProzent);
        }
        if (energieversorgung){
            setEnergieversorgungInProzent(berechnungDerRepariertenSchiffsstrukturenInProzent);
        }
        if (schiffshuelle){
            setHuelleInProzent(berechnungDerRepariertenSchiffsstrukturenInProzent);
        }
    }

    public void zustandRaumschiff (){
        System.out.println("Anzahl der Photonentorpedos: " + getPhotonentorpedoAnzahl());
        System.out.println("Energieversorgung: " + getEnergieversorgungInProzent());
        System.out.println("Schilde: " + getSchildeInProzent());
        System.out.println("Huelle: " + getHuelleInProzent());
        System.out.println("Lebenserhaltungssysteme: " + getLebenserhaltungssystemeInProzent());
        System.out.println("Anzahl der Androiden: " + getAndroidenAnzahl());
        System.out.println("Name des Raumschiffs: " + getSchiffsname());
    }

    public void ladungsverzeichnisAusgeben (){
        for (Ladung ladung : ladungsverzeichnis) {
            System.out.print("Bezeichnung: " + ladung.getBezeichnung() + ";");
            System.out.println(" Menge: " + ladung.getMenge());
        }
    }

    public void ladungsverzeichnisAufraeumen (){
        for (int i = 0; i < ladungsverzeichnis.size(); i++) {
           if (ladungsverzeichnis.get(i).getMenge() <= 0){
               ladungsverzeichnis.remove(ladungsverzeichnis.get(i));
           }
        }
    }

    public void broadcastLogAusgeben (){
        for (int i = 0; i < broadcastKommunikator.size(); i++) {
            System.out.println(broadcastKommunikator.get(i));
        }
    }
}
