import java.util.ArrayList;

public class Paal{
    private double instapTarief;
    private String typeVervoer;
    private ArrayList<String> locations = new ArrayList<String>();

    public void arrayListItems(){
        locations.add("Gent");
        locations.add("Arnhem");
        locations.add("Nijmegen");
        locations.add("Oosterhout");
    }

    public void showArrayListItems(){
        for (String location : locations) {
            System.out.println(location);
        }
    }

    public String typeVervoerOV(String typeVervoer){
        return this.typeVervoer;
    }

    public void inchecken(Kaart kaart){
        for (int i = 0; i < locations.size(); i++) {
            System.out.println(locations.get(i));
        }

    }
}