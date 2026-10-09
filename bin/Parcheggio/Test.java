package Parcheggio;

import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scelta = 0;
        double ore = 0.0;
        double costo = 0.0;
        double totalePagamento = 0.0;
        String targa = "";
        String marca = "";
        String modello = "";
        Car auto = null;
        boolean successo = false;

        //Creazione di un parcheggio
        Parcheggio parcheggio1 = new Parcheggio(500, 1.50);
        
        do {
            System.out.println("1. Fai entrare un'automobile");
            System.out.println("2. Fai uscire un'automobile");
            System.out.println("3. Modifica costo orario");
            System.out.println("4. Visualizza lo stato del parcheggio");
            System.out.println("0. Esci dal programma");

            scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci la targa dell'auto: ");
                    targa = sc.nextLine();
                    System.out.println("Inserisci la marca dell'auto: ");
                    marca = sc.nextLine();
                    System.out.println("Inserisci il modello dell'auto: ");
                    modello = sc.nextLine();

                    auto = new Car (targa, marca, modello);
                    successo = parcheggio1.entra(auto);
                     
                    if (successo) {
                        System.out.println("L'automobile targata " + auto.getTarga() + "è entrata nel parcheggio");
                        System.out.println("Posti rimasti: " + parcheggio1.getPostiDisponibili());
                    } else {
                        System.out.println("Errore: parcheggio pieno.");
                    }
                    break;
                case 2:
                    System.out.println("Inserisci la targa dell'auto in uscita: ");
                    targa = sc.nextLine();
                    System.out.println("Inserisci le ore di sosta nel parcheggio: ");
                    ore = sc.nextDouble();
                    sc.nextLine();

                    auto = new Car(targa, "", "");
                    totalePagamento = parcheggio1.esce(auto, ore);

                    if (totalePagamento >= 0) {
                        System.out.println("L'automobile targata " + auto.getTarga() + "è uscita dal parcheggio");
                        System.out.println("Totale da pagare per " + ore + "ore: " + totalePagamento + "€");
                        System.out.println( "Posti disponibili: " + parcheggio1.getPostiDisponibili());
                    } else {
                        System.out.println("Errore: nessuna automobile targata " + auto.getTarga() + "risulta presente nel parcheggio.");
                    }
                    break;

                case 3:
                    System.out.println("Inserisci il nuovo costo orario: ");
                    costo = sc.nextDouble();
                    sc.nextLine();

                    parcheggio1.setCostoOrario(costo);
                    System.out.println("Costo orario aggiornato a " + costo);
                    break;

                case 4:
                    System.out.println(parcheggio1.toString());
                    break;
                
                case 0:
                    System.out.println("Stai uscendo dal programma");
                    break;
                default:
                    System.out.println("Scelta non valida, inserisci un numero tra 0 e 4.");
            }

        } while (scelta != 0);

        sc.close();
    }
}
