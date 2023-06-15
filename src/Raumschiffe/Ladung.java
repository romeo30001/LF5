package Raumschiffe;

public class Ladung {
    protected String bezeichnung;
    private int menge;

    public Ladung(){

    }
    public Ladung (String bezeichnung, int menge){
        this.bezeichnung = bezeichnung;
        this.menge = menge;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}
