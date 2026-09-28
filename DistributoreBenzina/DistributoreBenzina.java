public class DistributoreBenzina{
    
    //variabili di istanza
    private double deposito;
    private double euroPerLitro;
    
    //costruttori
    public DistributoreBenzina() {
        this.deposito = 0.0;
        this.euroPerLitro = 0.0;
    }

    public DistributoreBenzina(double euroLitro) {
        if (euroLitro > 0) {
            this.euroPerLitro = euroLitro ;
        }
    }

    //set e get deposito
    public void setDeposito(double dep) {
        if (dep > 0) {
            this.deposito = dep;
        }
    }

    public double getDeposito() {
        return this.deposito;
    }

    //set e get euroPerLitro
    public void setEuroPerLitro(double euro) {
        if (euro > 0) {
            this.euroPerLitro = euro;
        }
    }

    public double getEuroPerLitro() {
        return this.euroPerLitro;
    }

    //metodo rifornisci (rifornisce il deposito del distributore)
    public void rifornisci(double aggCarburante) {
        if (aggCarburante > 0) {
            this.deposito += aggCarburante;
        }
    }

    //metodo vendi (rifornimento ad un veicolo)
    public boolean vendi(double euro, Car auto) {
        if (euro <= 0 || this.euroPerLitro <= 0 || this.deposito <= 0){
            return false;
        }

        //variabili metodo
        double litriTeorici = euro / euroPerLitro; 
        double spazioSerbatoio = auto.getSpazioDisponibile();
        double litriEffettivi = litriTeorici;

        //controllo spazio serbatoio
        if (litriEffettivi > spazioSerbatoio) {
            litriEffettivi = spazioSerbatoio;
        }

        //controllo disponibilità serbatoio
        if (litriEffettivi > this.deposito) {
            litriEffettivi = this.deposito;
        }

        if (litriEffettivi > 0) {
            auto.addGas(litriEffettivi);
            this.deposito -= litriEffettivi;
            return true;
        }
        
        return false;
    }

    public String toString() {
        String output = "";
        output += "Litri nel deposito: " + this.deposito;
        output += "\nPrezzo benzina:" + this.euroPerLitro + "€";
        return output;
    }
}