import java.util.ArrayList;
import java.util.Scanner;

public class Paal {
    private double instapTarief;
    private Scanner sc = new Scanner(System.in);

    private String typeVervoer;
    private double afstandTafief;
    private ArrayList<String> locations = new ArrayList<String>();

    public Paal(){
        instapTarief = 10;
        locations.add("Gent");
        locations.add("Arnhem");
        locations.add("Nijmegen");
        locations.add("Oosterhout");
    }

    public double berekenReisbedrag(String locatie) {
        switch (locatie) {
            case "Gent":
                return instapTarief + 15.00;
            case "Arnhem":
                return instapTarief + 5.00;
            case "Nijmegen":
                return instapTarief + 3.00;
            case "Oosterhout":
                return instapTarief + 8.00;
            default:
                return instapTarief;
        }
    }

    public void showArrayListItems(){
        for (String location : locations) {
            System.out.print(" -" +location);
        }
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public String typeVervoerOV(String typeVervoer){
        return this.typeVervoer;
    }

    public void inchecken(Kaart kaart) {
        if (!kaart.getGeldig()) {
            System.out.println("Kaart is niet geldig!");
            System.out.println(" ");
            return;
        }

        if (kaart.getIsIngecheckt()) {
            System.out.println("Kaart is al ingecheckt!");
            System.out.println(" ");
            return;
        }

        if (kaart.getSaldo() < instapTarief) {
            System.out.println("Onvoldoende saldo!");
            System.out.println("Waardeer uw saldo op!");
            System.out.println(" ");
            return;
        }


        kaart.setIsIngecheckt(true);
        System.out.println("Welkom bij de NS");
        System.out.println("U bent nu ingecheckt.");
        System.out.println("Geniet van uw reis!");
        System.out.println(" ");
    }

    public double getInstapTarief() {
        System.out.println("Uw instaptarief is: " + instapTarief);
        return instapTarief;
    }

    public void setInstapTarief(double instapTarief) {
        this.instapTarief = instapTarief;
    }

    public void uitchecken(Kaart kaart) {
        if (kaart == null || !kaart.getIsIngecheckt()) {
            System.out.println("Geen kaart ingecheckt!");
            System.out.println(" ");

        } else {
            kaart.setIsIngecheckt(false);
            System.out.println("Kaart uitgecheckt");
            System.out.println(" ");
        }
    }
}