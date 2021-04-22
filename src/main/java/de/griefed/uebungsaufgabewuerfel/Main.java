package de.griefed.uebungsaufgabewuerfel;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wieOftWuerfeln, anzahlWuerfel, weiterWuerfeln;
        String  augensumme = null;
        int vorgekommen = 0;

        Random randInt = new Random();

        // 0 bis 5 = 6
        int augenWuerfelEins = 5;
        int augenWuerfelZwei = 5;
        int augenWuerfelDrei = 5;

        do {
            do {
                System.out.print("Wie oft soll gewuerfelt werden: ");
                wieOftWuerfeln = scanner.nextLine();

            } while (!isNumber(wieOftWuerfeln));

            do {
                System.out.print("Geben Sie die Anzahl der Wuerfel ein: ");
                anzahlWuerfel = scanner.nextLine();

            } while (!isNumber(anzahlWuerfel));

            if (Integer.parseInt(anzahlWuerfel) == 2) {
                do {
                    System.out.print("Geben Sie die Augensumme ein, welche auf Vorgkommnis geprueft werden soll: ");
                    augensumme = scanner.nextLine();

                } while (!isNumber(augensumme));
            }

            System.out.println();

            switch (Integer.parseInt(anzahlWuerfel)) {
                case 2:
                    vorgekommen = 0;

                    for (int wuerfeln = 0; wuerfeln < Integer.parseInt(wieOftWuerfeln); wuerfeln++) {

                        int wuerfelEins = randInt.nextInt(augenWuerfelEins)  + 1;
                        int wuerfelZwei = randInt.nextInt(augenWuerfelZwei)  + 1;

                        if (Integer.parseInt(augensumme) == wuerfelEins + wuerfelZwei) {
                            vorgekommen++;
                        }
                    }

                    System.out.println(String.format("Die angegebene Augensumme ist %s mal vorgekommen.", vorgekommen));
                    break;
                case 3:
                    vorgekommen = 0;

                    for (int wuerfeln = 0; wuerfeln < Integer.parseInt(wieOftWuerfeln); wuerfeln++) {

                        int wuerfelEins = randInt.nextInt(augenWuerfelEins) + 1;
                        int wuerfelZwei = randInt.nextInt(augenWuerfelZwei) + 1;
                        int wuerfelDrei = randInt.nextInt(augenWuerfelDrei) + 1;

                        if (wuerfelEins != wuerfelZwei && wuerfelEins != wuerfelDrei && wuerfelZwei != wuerfelDrei) {
                            vorgekommen++;
                        }
                    }

                    System.out.println(String.format("Die Wuerfel hatten %s mal verschiedene Augen.", vorgekommen));
                    break;
                default:
                    System.out.println("Es muessen zwei oder drei Wuerfel gewuerfelt werden.");
            }


            System.out.println();
            System.out.println("Wollen Sie weiterwuerfeln? Nein zum Beenden eingeben.");
            weiterWuerfeln = scanner.nextLine();
        } while(!weiterWuerfeln.contains("Nein"));
    }

    private static boolean isNumber(String input) {
        boolean result = false;
        if (input.matches("[0-9]*")) {
            result = true;
        } else {
            System.out.println("Sie muessen eine Zahl eingeben!");
        }
        return result;
    }
}
