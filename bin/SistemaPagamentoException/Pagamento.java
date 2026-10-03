package SistemaPagamentoException;
public class Pagamento {
    private String beneficiario;
    public double importo;

    //Costruttore default
    public Pagamento() {
        this.beneficiario = "";
        this.importo = 0.0;
    }

    //Costruttore con parametri
    public Pagamento (String b, double i) {
        if (b != null) {
            this.beneficiario = b;
        } else {
            this.beneficiario = "";
        }

        if (i > 0) {
            this.importo = i;
        } else {
            this.importo = 0.0;
        }
    }

    //get e set beneficiario
    public String getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario (String b) {
        if (b != null) {
            this.beneficiario = b;
        }
    }

    //get e set importo
    public double getImporto() {
        return this.importo;
    }

    public void setImporto(double i) {
        if (i > 0) {
            this.importo = i;
        }
    }

    //toString
    public String toString() {
        String output = "";
        output += "Pagamento a favore di: " + this.beneficiario;
        output += "\nImporto: " + this.importo + "€";
        return output;
    }
}
