import java.util.Scanner;

public class OV {
    public static void main(String[] args) {
        Boolean goedAntwoordIncheck = false, goedAntwoordGeldig = false, goedAntwoordSaldo = false, goedAntwoordVervoer = false;

        Scanner sc = new Scanner(System.in);
        Kaart kaart1 = new Kaart();
        Paal paal1 = new Paal();
        Automaat automaat1 = new Automaat();

        System.out.println("Welkom bij uw OV");
        System.out.println("Wat wilt u doen?");

        System.out.println("1: Saldo Opladen");
        System.out.println("2: Inchecken");
        System.out.println("3: Uitchecken");
        System.out.println("4: Reizen");

        int keuze = sc.nextInt();

        while (if ()){

        }

        /** Set saldo of card */
        while (!goedAntwoordSaldo) {
            System.out.println("Wat is uw saldo?");
            System.out.print("Voer uw saldo in: ");
            String inputSaldo = sc.nextLine();
            try {
                double antwoordSaldo = Double.parseDouble(inputSaldo);
                kaart1.setSaldo(antwoordSaldo);
                goedAntwoordSaldo = true;
            } catch (NumberFormatException e) {
                System.out.println("Voer een geldig bedrag in.");
            }
        }
        kaart1.getSaldo();

        /** Set if checked in */
        while (!goedAntwoordIncheck) {
            System.out.println("Bent u al ingecheckt?");
            System.out.print("Ja/Nee: ");
            String antwoordIngecheckt = sc.nextLine();

            if (antwoordIngecheckt.equalsIgnoreCase("ja") || antwoordIngecheckt.equalsIgnoreCase("nee")) {
                goedAntwoordIncheck = true;
                kaart1.setIsIngecheckt(antwoordIngecheckt.equalsIgnoreCase("ja"));
            } else {
                System.out.println("Voer in ja of nee");
            }
        }
        kaart1.getIsIngecheckt();

        /** Set if card is valid */
        while (!goedAntwoordGeldig) {
            System.out.println("Is uw kaart geldig?");
            System.out.print("Ja/Nee: ");
            String antwoordGeldig = sc.nextLine();

            if (antwoordGeldig.equalsIgnoreCase("ja") || antwoordGeldig.equalsIgnoreCase("nee")) {
                goedAntwoordGeldig = true;
                kaart1.setGeldig(antwoordGeldig.equalsIgnoreCase("ja"));
            } else {
                System.out.println("Voer een ja of nee in.");
            }
        }
        kaart1.getGeldig();

        kaart1.getKaartNummer();

        /** *arraylist items oproepen*/
        paal1.arrayListItems();

        /** *Kiezen welke type vervoer*/
        while (!goedAntwoordVervoer) {
            System.out.println("Reist u met de bus of met de trein?");
            System.out.print("Voer in: ");
            String antwoordVervoer = sc.nextLine();

            if (antwoordVervoer.equalsIgnoreCase("bus")) {
                goedAntwoordVervoer = true;
                paal1.typeVervoerOV(("bus"));
            } else if (antwoordVervoer.equalsIgnoreCase("trein")) {
                goedAntwoordVervoer = true;
                paal1.typeVervoerOV(("trein"));
            } else {
                System.out.println("Voer in: Trein of Bus");
            }
            System.out.println("U wilt met de " +antwoordVervoer +" reizen.");
        }


        paal1.inchecken(kaart1);


        sc.close();
    }
}