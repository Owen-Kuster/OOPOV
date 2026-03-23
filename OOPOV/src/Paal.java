import java.util.ArrayList;

public class Paal{
    private double instapTarief;
    private String typeVervoer;
    private double afstandTafief;
    private ArrayList<String> locations = new ArrayList<String>();

    public Paal(){
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

    public void inchecken(Kaart kaart){

    }

    public double getInstapTarief(){
        System.out.println("Uw instaptarief is: " +instapTarief);
        return instapTarief;
    }
    public void setInstapTarief(double instapTarief){this.instapTarief = instapTarief;}
}