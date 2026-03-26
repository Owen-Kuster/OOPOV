public class Kaart {
    private double saldo;
    private int kaartNummer;
    private boolean kaartGeldig, isIngecheckt;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("Saldo mag niet negatief zijn");
        }
        this.saldo = saldo;
    }

    public boolean getGeldig() {
        return kaartGeldig;
    }

    public void setGeldig(boolean kaartGeldig) {
        this.kaartGeldig = kaartGeldig;
    }

    public boolean getIsIngecheckt() {
        return isIngecheckt;
    }

    public void setIsIngecheckt(boolean isIngecheckt) {this.isIngecheckt = isIngecheckt;}

    public int getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(int kaartNummer){this.kaartNummer = kaartNummer;}
}
