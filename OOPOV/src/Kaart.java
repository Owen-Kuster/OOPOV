public class Kaart {
    private double saldo;
    private int kaartNummer;
    private boolean kaartGeldig, isIngecheckt;

    public double getSaldo() {
        System.out.println("Uw saldo is: €" + saldo);
        return saldo;
    }

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public boolean getGeldig() {
        if (!kaartGeldig) {
            System.out.println("Uw kaart is niet geldig");
        } else {
            System.out.println("Uw kaart is geldig");
        }

        return kaartGeldig;
    }

    public void setGeldig(boolean kaartGeldig) {
        this.kaartGeldig = kaartGeldig;
    }

    public boolean getIsIngecheckt() {
        if (!isIngecheckt) {
            System.out.println("U bent niet ingecheckt");
        } else {
            System.out.println("U bent al ingecheckt");
        }
        return isIngecheckt;
    }

    public void setIsIngecheckt(boolean isIngecheckt) {this.isIngecheckt = isIngecheckt;}

    public int getKaartNummer() {
        System.out.println("Uw kaartnummer is: " + kaartNummer);
        return kaartNummer;
    }

    public void setKaartNummer(int kaartNummer){this.kaartNummer = kaartNummer;}
}
