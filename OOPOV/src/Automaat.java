import java.util.Scanner;

public class Automaat {
    private Scanner scanner;

    public Automaat(){
        this.scanner = new Scanner(System.in);
    }


    public void saldoOpladen(Kaart kaart) {
        System.out.println("--- Saldo Opladen ---");
        System.out.print("Hoeveel euro wilt u toevoegen? €");

        try {
            double bedrag = Double.parseDouble(this.scanner.nextLine());
            kaart.setSaldo(bedrag);
            System.out.println("Uw saldo is nu: €" + kaart.getSaldo());
            System.out.println(" ");
        } catch (Exception ex) {
            System.out.println("Voer een geldig bedrag in!");
        }
    }

    public void toonKaartInfo(Kaart kaart) {
        boolean opnieuwInfo = false;
        while(!opnieuwInfo){
            System.out.println("--- Kaartinformatie ---");
            System.out.println("Uw kaartnummer is: " + kaart.getKaartNummer());
            System.out.println("Uw saldo is: €" + kaart.getSaldo());

            if (kaart.getGeldig()){
                System.out.println("Uw kaart is geldig!");
            } else {
                System.out.println("Uw kaart is niet geldig!");
            }
            if (kaart.getIsIngecheckt()){
                System.out.println("Uw kaart is ingecheckt!");
            } else {
                System.out.println("Uw kaart is niet ingecheckt!");
                System.out.println(" ");
            }

            System.out.println("Wilt u het opnieuw zien?");
            System.out.println("Ja/Nee");
            String keuze = this.scanner.nextLine().toLowerCase();

            switch (keuze) {
                case "ja":
                    opnieuwInfo = false;
                    break;
                case "nee":
                    opnieuwInfo = true;
                    break;
                default:
                    System.out.println("Voer Ja of Nee in.");
            }

            System.out.println(" ");
        }
    }



}
