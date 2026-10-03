package SistemaPagamento;
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
        if (intestatario != null) {
            this.intestatario = intest;
        } else {
            this.intestatario = "";
        }

        if (saldo >= 0) {
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
        if (saldo >= 0) {
            this.saldo = s;
        }
    }

    public boolean effettuaPagamento(Pagamento pagamento) {
        if (pagamento == null) {
            return false;
        }

        double importoDaPagare = pagamento.getImporto();

        if (importoDaPagare > 0 && this.saldo >= importoDaPagare) {
            this.saldo -= importoDaPagare;
            return true;
        }

        return false;
    }

    //toString
    public String toString() {
        String output = "";
        output += "Conto di:" + this.intestatario;
        output += "\nSaldo attuale: " + this.saldo + "€";
        return output;
    }
}

