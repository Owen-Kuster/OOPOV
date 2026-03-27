import java.util.Scanner;

public class OV {
    public static void main(String[] args) {
        Boolean opnieuwReizen = false;

        Scanner sc = new Scanner(System.in);
        Kaart kaart = new Kaart();
        Paal paal = new Paal();
        Automaat automaat = new Automaat();

        /** *Begin*/
        System.out.println("Welkom bij uw OV");
        System.out.println("Wat wilt u doen?");
        System.out.println("");

        while (!opnieuwReizen) {
            Boolean goedKeuze = false;

            /** *Keuze lijst*/
            System.out.println("1: Saldo Opladen");
            System.out.println("2: Kaartinformatie");
            System.out.println("3: Inchecken");
//            System.out.println("4: Reizen");
            System.out.println("4: Uitchecken");
            System.out.println("5: Stoppen");
            System.out.println("");
            String invoer;
            /** *Kiezen uit lijst*/
            while (!goedKeuze) {
                System.out.print("Voer uw antwoord in: ");
                invoer = sc.nextLine();
                System.out.println("");

                int keuze;
                try {
                    keuze = Integer.parseInt(invoer);
                    System.out.println("");
                    if (keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4 || keuze == 5) {
                        goedKeuze = true;
                    } else {
                        System.out.println("Vul in 1,2,3, 4 of 5");
                        System.out.println("");
                    }

                    switch (keuze) {
                        case 1:
                            /** *Saldo opwaarderen*/
                            automaat.saldoOpladen(kaart);
                            break;
                        case 2:
                            /** *Informatie*/
                            automaat.toonKaartInfo(kaart);
                            break;
                        case 3:
                            /** *Inchecken*/
                            paal.inchecken(kaart);
                            break;
                        case 4:
                            /** *Uitchecken*/
                            paal.uitchecken(kaart);
                            break;
                        case 5:
                            /** *Stoppen*/
                            System.out.println("Dank u voor het kiezen van het OOPOV");
                            System.out.println("Nog een fijne dag gewenst!");
                            opnieuwReizen = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Voer een geldig getal in.");
                }
            }
        }
        sc.close();
    }
}