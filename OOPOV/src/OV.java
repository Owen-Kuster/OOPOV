import java.util.Scanner;

public class OV {
    public static void main(String[] args) {
        Boolean goedAntwoordInformatie = false, goedAntwoordGeldig = false, goedAntwoordSaldo = false, goedAntwoordVervoer = false, goedKeuze = false, opnieuwReizen = false, goedAntwoordNogMeerInfo = false;

        Scanner sc = new Scanner(System.in);
        Kaart kaart1 = new Kaart();
        Paal paal1 = new Paal();
        Automaat automaat1 = new Automaat();

        /** *Initializeren*/
        kaart1.setSaldo(30);
        kaart1.setKaartNummer(3528);
        kaart1.setGeldig(true);
        kaart1.setIsIngecheckt(false);

        System.out.println("Welkom bij uw OV");
        System.out.println("Wat wilt u doen?");
        System.out.println("");

        while (!opnieuwReizen) {

            /** *uitleg*/
            System.out.println("1: Saldo Opladen");
            System.out.println("2: Kaartinformatie");
            System.out.println("3: Uitchecken");
            System.out.println("4: Reizen");
            System.out.println("");

            while (!goedKeuze) {
                System.out.print("Voer uw antwoord in: ");
                String invoer = sc.nextLine();
                System.out.println("");

                try {
                    int keuze = Integer.parseInt(invoer);
                    System.out.println("");
                    if (keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4) {
                        goedKeuze = true;
                    } else {
                        System.out.println("Vul in 1,2,3 of 4");
                        System.out.println("");
                    }


                    if (keuze == 1) {
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
                    } else if (keuze == 2) {
                        while (!goedAntwoordInformatie) {
                            System.out.println("Welke Informatie wilt u zien?");
                            System.out.println("1: Saldo");
                            System.out.println("2: Kaartnummer");
                            System.out.println("3: Kaart geldig");
                            System.out.println("4: Bent u ingecheckt?");
                            System.out.println("5: Welke haltes zijn er?");

                            String invoerInformatie = sc.nextLine();
                            try {
                                int informatieKeuze = Integer.parseInt(invoerInformatie);
                                if (informatieKeuze == 1 || informatieKeuze == 2 || informatieKeuze == 3 || informatieKeuze == 4 || informatieKeuze == 5) {
                                    switch (informatieKeuze) {
                                        case 1:
                                            kaart1.getSaldo();
                                            System.out.println("");
                                            goedAntwoordNogMeerInfo = false;
                                            break;
                                        case 2:
                                            kaart1.getKaartNummer();
                                            System.out.println("");
                                            goedAntwoordNogMeerInfo = false;
                                            break;
                                        case 3:
                                            kaart1.getGeldig();
                                            System.out.println("");
                                            goedAntwoordNogMeerInfo = false;
                                            break;
                                        case 4:
                                            kaart1.getIsIngecheckt();
                                            System.out.println("");
                                            goedAntwoordNogMeerInfo = false;
                                            break;
                                        case 5:
                                            paal1.showArrayListItems();
                                            System.out.println("");
                                            goedAntwoordNogMeerInfo = false;
                                    }
                                    while (!goedAntwoordNogMeerInfo) {
                                        System.out.println("Wilt u nog een keer uw informatie bekijken?");
                                        System.out.println("Ja/nee");
                                        String nogMeerInformatie = sc.nextLine();
                                        if (nogMeerInformatie.equalsIgnoreCase("ja")) {
                                            goedAntwoordNogMeerInfo = true;
                                        } else if (nogMeerInformatie.equalsIgnoreCase("nee")) {
                                            goedAntwoordInformatie = true;
                                            goedAntwoordNogMeerInfo = true;
                                        } else {
                                            System.out.println("Voer een ja of nee in.");
                                        }
                                    }


                                } else {
                                    System.out.println("Voer in 1,2,3,4 of 5 in.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Voer een geldig getal in.");
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Voer een geldig getal in van 1 tot en met 4.");
                    System.out.println("");
                }
            }


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
                System.out.println("U wilt met de " + antwoordVervoer + " reizen.");
            }


            paal1.inchecken(kaart1);

        }


        sc.close();
    }
}