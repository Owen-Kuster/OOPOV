import java.util.Scanner;

public class OV {
    public static void main(String[] args) {
        Boolean opnieuwReizen = false;

        Scanner sc = new Scanner(System.in);
        Kaart kaart1 = new Kaart();
        Paal paal1 = new Paal();
        Automaat automaat1 = new Automaat();

        /** *Initializeren*/
        kaart1.setSaldo(0);
        kaart1.setKaartNummer(3528);
        kaart1.setGeldig(true);
        kaart1.setIsIngecheckt(false);

        paal1.setInstapTarief(0);

        /** *Begin*/
        System.out.println("Welkom bij uw OV");
        System.out.println("Wat wilt u doen?");
        System.out.println("");

        while (!opnieuwReizen) {
            Boolean goedAntwoordInformatie = false, goedAntwoordSaldo = false, goedKeuze = false, goedAntwoordNogMeerInfo = false, reizenCheck = false, gekozenVervoer = false, gekozenLocatie = false;

            /** *Keuze lijst*/
            System.out.println("1: Saldo Opladen");
            System.out.println("2: Kaartinformatie");
            System.out.println("3: Reizen");
            System.out.println("4: Uitchecken");
            System.out.println("");

            /** *Kiezen uit lijst*/
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

                    /** *Saldo opwaarderen*/
                    if (keuze == 1) {
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
                                System.out.println(" ");
                            }
                        }

                        kaart1.getSaldo();
                    } else if (keuze == 2) {
                        /** *Informatie*/
                        while (!goedAntwoordInformatie) {
                            System.out.println("Welke Informatie wilt u zien?");
                            System.out.println("1: Saldo");
                            System.out.println("2: Kaartnummer");
                            System.out.println("3: Kaart geldig");
                            System.out.println("4: Bent u ingecheckt?");
                            System.out.println("5: Welke haltes zijn er?");

                            /** *Kiezen welke info*/
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

                                    /** *Vragen opnieuw info*/
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
                                            System.out.println(" ");
                                        }
                                    }
                                } else {
                                    System.out.println("Voer in 1,2,3,4 of 5 in.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Voer een geldig getal in.");
                            }
                        }
                        /** *Reizen*/
                    } else if (keuze == 3){
                        while(!reizenCheck){
                            /** *Kiezen vervoer*/
                            while(!gekozenVervoer){
                                System.out.println("Wilt u met de bus of trein reizen?");
                                System.out.print("Antwoord: ");
                                String vervoerKeuze = sc.nextLine();
                                if (vervoerKeuze.equalsIgnoreCase("bus")) {
                                    paal1.setInstapTarief(4);
                                    if (kaart1.getSaldo() < paal1.getInstapTarief()) {
                                        System.out.println("Geen saldo. Laad alstublieft uw kaart op.");
                                        reizenCheck = true;
                                        gekozenLocatie = true;
                                    } else {
                                        paal1.getInstapTarief();
                                    }
                                    gekozenVervoer = true;
                                } else if (vervoerKeuze.equalsIgnoreCase("trein")) {
                                    paal1.setInstapTarief(10);
                                    if (kaart1.getSaldo() < paal1.getInstapTarief()) {
                                        System.out.println("Geen saldo. Laad alstublieft uw kaart op.");
                                        reizenCheck = true;
                                        gekozenLocatie = true;
                                    } else {
                                        paal1.getInstapTarief();
                                    }
                                    gekozenVervoer = true;
                                } else if (vervoerKeuze.equalsIgnoreCase("trein")){
                                    paal1.setInstapTarief(10);
                                    paal1.getInstapTarief();
                                    gekozenVervoer = true;
                                } else {
                                    System.out.println("Voer in: Bus of Trein.");
                                }
                                System.out.println(" ");
                                System.out.println("U wilt reizen met de: " +vervoerKeuze);
                                System.out.println(" ");
                            }

                            /** *Locatie kiezen*/
                            while(!gekozenLocatie){
                                System.out.println("Waar wilt u heen?");
                                System.out.print("U kunt kiezen uit:");
                                paal1.showArrayListItems();
                                System.out.println(" ");
                                System.out.println("Type het exact over!");
                                System.out.print("U wilt naar: ");
                                String locatieVervoer = sc.nextLine();

                                /** *Locatie prijs*/
                                if (paal1.getLocations().contains(locatieVervoer)) {
                                    double reisbedrag = paal1.berekenReisbedrag(locatieVervoer);
                                    System.out.println("U wilt naar " + locatieVervoer + " reizen, dit kost u: €" + reisbedrag);
                                    gekozenLocatie = true;
                                } else {
                                    System.out.println("Voert alstublieft een geldige locatie in.");
                                }
                            }


                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Voer een geldig getal in van 1 tot en met 4.");
                    System.out.println("");
                }
            }
        }


        sc.close();
    }
}