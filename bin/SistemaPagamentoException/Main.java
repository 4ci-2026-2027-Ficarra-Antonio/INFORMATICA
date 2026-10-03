package SistemaPagamentoException;
public class Main {
    public static void main(String[] args) {
        Conto conto1 = new Conto("Mario Rossi", 500.00);

        //Creazione 2 oggetti Pagamento
        Pagamento p1 = new Pagamento("Amazon", 120.50);
        Pagamento p2 = new Pagamento("Concessionaria", 600.00);

        System.out.println("\n" + conto1.toString());

        //pagamento1
        System.out.println("\nElaborazione primo pagamento...");
        System.out.println(p1.toString());

        try {
            conto1.effettuaPagamento(p1);
        } catch (SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        System.out.println("\nStato conto:" + conto1.toString() + "\n");

        //pagamento2
        System.out.println("\nElaborazione primo pagamento...");
        System.out.println(p2.toString());

        try {
            conto1.effettuaPagamento(p2);
        } catch (SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        System.out.println("\nStato conto:" + conto1.toString() + "\n");
    }
}
