import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //variabili
        final double PREZZO_INIZIALE = 2.40;
        final double LITRI_RIFORNIMENTO_DISTRIBUTORE = 10000.0;
        double importo;
        double km;
        double carbPrima;
        double carbDopo;
        double litriEffettivi;
        double spesaEffettiva;
        int sceltaAuto = -1;
        int azione = -1;
        String nomeAuto = "";

        //inizializzazione e creazione oggetti
        DistributoreBenzina distributore1 = new DistributoreBenzina(PREZZO_INIZIALE);
        Car auto1 = new Car(15.0, 0.0, 60.0);
        Car auto2 = new Car(12.0, 0.0, 60.0);

        Car autoSelezionata = null;

        //rifornimento distributore
        distributore1.rifornisci(LITRI_RIFORNIMENTO_DISTRIBUTORE);

        while (sceltaAuto != 0) {
            System.out.println("1. Sali su auto1;");
            System.out.println("2. Sali su auto2;");
            System.out.println("3. Visualizza lo stato del distributore;");
            System.out.println("0. Esci.");
            System.out.println("\nScegli un opzione:");
            sceltaAuto = sc.nextInt();

            switch (sceltaAuto) {
                case 0:
                    System.out.println("\nSei uscito dal programma");
                    break;
                case 1:
                    autoSelezionata = auto1;
                    nomeAuto = "Auto 1";
                    break;
                case 2:           
                    autoSelezionata = auto2;
                    nomeAuto = "Auto 2";
                    break;
                case 3:
                    System.out.println("\nStato distributore");
                    System.out.println(distributore1.toString());
                    break;
                default:
                    System.out.println("\nOpzione non valida.");
                    break;
            }

            if (autoSelezionata != null) {
                azione = -1;
                while (azione != 0) {
                    System.out.println("\nSei salito su " + nomeAuto);
                    System.out.println("1. Fai rifornimento");
                    System.out.println("2. Guida");
                    System.out.println("3. Visualizza lo stato dell'auto");
                    System.out.println("4. Visualizza lo stato del distributore");
                    System.out.println("0. Scendi dall'auto (Torna al menu principale)");
                    System.out.print("\nScegli un'azione: ");
                    azione = sc.nextInt();

                    switch (azione) {
                        case 0:
                            System.out.println("\nScendi da " + nomeAuto);
                            break;
                        case 1:
                            System.out.println("Inserisci l'importo per il rifornimento: ");
                            importo = sc.nextDouble();
                            carbPrima = autoSelezionata.getQuantita();

                            System.out.println("Rifornimento in corso...");
                            if (distributore1.vendi(importo, autoSelezionata)){
                                carbDopo = autoSelezionata.getQuantita();

                                litriEffettivi = carbDopo - carbPrima;
                                spesaEffettiva = litriEffettivi * distributore1.getEuroPerLitro();

                                System.out.println("Litri erogati: " + litriEffettivi + " L");
                                System.out.println("Spesa effettiva: " + spesaEffettiva + " euro");
                                System.out.println("Resto: " + (importo - spesaEffettiva) + " euro");
                            } else {
                                System.out.println("Impossibile effettuare il rifornimento.");
                            }
                            break;
                        case 2:
                            System.out.print("\nInserisci i Km da percorrere: ");
                            km = sc.nextDouble();
                            if(autoSelezionata.drive(km)){
                                System.out.println("Viaggio effettuato.");
                            } else {
                                System.out.println("Carburante insufficiente.");
                            }
                            break;
                        case 3:
                            System.out.println("\nStato " + nomeAuto);
                            System.out.println(autoSelezionata.toString());
                            break;
                        case 4:
                            System.out.println("\nStato distributore");
                            System.out.println(distributore1.toString());
                            break;
                        default:
                            System.out.println("Scelta non valida.");
                            break;
                    }
                }
            }
        }
    }
}