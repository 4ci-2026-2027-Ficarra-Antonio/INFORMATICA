import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //variabili
        final double PREZZO_INIZIALE = 2.40;
        final double LITRI_RIFORNIMENTO_DISTRIBUTORE = 10000.0;
        double importo;
        double kmPercorsi;
        double carbPrima;
        double carbDopo;
        double litriEffettivi;
        double spesaEffettiva;

        //inizializzazione e creazione oggetti
        DistributoreBenzina distributore1 = new DistributoreBenzina(PREZZO_INIZIALE);
        Car auto1 = new Car(15.0, 0.0, 60.0);
        Car auto2 = new Car(12.0, 0.0, 60.0);

        //rifornimento distributore
        distributore1.rifornisci(LITRI_RIFORNIMENTO_DISTRIBUTORE);

        //rifornimento auto1
        System.out.print("Inserisci l'importo per il rifornimento: ");
        importo = sc.nextDouble();

        carbPrima = auto1.getQuantita();
        System.out.println("Rifornimento in corso...\n");
        distributore1.vendi(importo, auto1);
        carbDopo = auto1.getQuantita();

        litriEffettivi = carbDopo - carbPrima;
        spesaEffettiva = litriEffettivi * distributore1.getEuroPerLitro();

        //output
        System.out.println("Litri erogati: " + litriEffettivi + "L");
        System.out.println("Spesa effettiva " + spesaEffettiva + " euro");
        System.out.println("Resto: " + (importo - spesaEffettiva) + " euro");

        //rifornimento auto2
        System.out.print("\nInserisci l'importo per il rifornimento: ");
        importo = sc.nextDouble();

        carbPrima = auto2.getQuantita();
        System.out.println("Rifornimento in corso...\n");
        distributore1.vendi(importo, auto2);
        carbDopo = auto2.getQuantita();

        litriEffettivi = carbDopo - carbPrima;
        spesaEffettiva = litriEffettivi * distributore1.getEuroPerLitro();

        //output
        System.out.println("Litri erogati: " + litriEffettivi + "L");
        System.out.println("Spesa effettiva " + spesaEffettiva + " euro");
        System.out.println("Resto: " + (importo - spesaEffettiva) + " euro");

        //viaggi
        System.out.println("\nInserire Km da percorrere: ");
        kmPercorsi = sc.nextDouble();
        auto1.drive(kmPercorsi);

        System.out.println("\nInserire Km da percorrere: ");
        kmPercorsi = sc.nextDouble();
        auto2.drive(kmPercorsi);

        //stato finale auto1 e auto2
        System.out.println("\nStato auto1");
        System.out.println(auto1.toString());

        System.out.println("\nStato auto2");
        System.out.println(auto2.toString());
    }
}