package SistemaPagamentoException;
public class Conto {
    private String intestatario;
    private double saldo;

    //Costruttore default
    public Conto() {
        this.intestatario = "";
        this.saldo = 0.0;
    }

    //Costruttore con parametri
    public Conto(String intest, double s) {
        if (intest != null) {
            this.intestatario = intest;
        } else {
            this.intestatario = "";
        }

        if (s >= 0) {
            this.saldo = s;
        } else {
            this.saldo = 0.0;
        }
    }

    //get e set intestatario
    public String getIntestatario() {
        return this.intestatario;
    }

    public void setIntestatario(String intest) {
        if (intest != null) {
            this.intestatario = intest;
        }
    }

    //get e set saldo
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double s) {
        if (s >= 0) {
            this.saldo = s;
        }
    }

    public void effettuaPagamento(Pagamento pagamento) throws SaldoInsufficienteException {
        if (pagamento == null) {
            throw new IllegalArgumentException("Il pagamento non può essere vuoto");
        }

        double importoDaPagare = pagamento.getImporto();

        if (importoDaPagare <= 0) {
            throw new IllegalArgumentException("L'importo del pagamento deve essere maggiore di 0");
        }

        if (this.saldo < importoDaPagare) {
            throw new SaldoInsufficienteException("Saldo insufficiente per pagare " + pagamento.getBeneficiario() + ". \nSaldo attuale: " + this.saldo + "€. \nImporto da pagare: " + importoDaPagare + "€.");
        }

        this.saldo -= importoDaPagare;
        System.out.println("Pagamento effettuato. \nBeneficiario: " + pagamento.getBeneficiario() + "\nImporto pagato: " + importoDaPagare + "€");
    }

    //toString
    public String toString() {
        String output = "";
        output += "Conto di:" + this.intestatario;
        output += "\nSaldo attuale: " + this.saldo + "€";
        return output;
    }
}

