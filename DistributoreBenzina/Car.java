public class Car {

    //variabili di istanza
    private double resa; //in km/L
    private double quantita;
    private double capienzaMax;

    //Costruttori
    public Car() {
        this.resa = 0.0;
        this.quantita = 0.0;
        this.capienzaMax = 60.0;
    }

    public Car(double r, double carb, double capienzaM) {
        if (r > 0) {
            this.resa = r;
        }

        if (capienzaM > 0) {
            this.capienzaMax = capienzaM;
        }

        if (carb > 0) {
            if (carb > this.capienzaMax){
                this.quantita = capienzaMax;
            } else {
                this.quantita = carb;
            }
        }
    }

    //get e set resa
    public void setResa(double r) {
        if (r > 0) {
            this.resa = r;
        }
    }

    public double getResa() {
        return this.resa;
    }

    //get e set quantita
    public void setQuantita(double carb) {
        if (carb > 0){
            if(carb > this.capienzaMax) {
                this.quantita = this.capienzaMax;
            } else {
                this.quantita = carb;
            }
        }
    }

    public double getQuantita() {
        return this.quantita;
    }

    //get e set capienzaMax
    public void setCapienzaMax(double capienzaM) {
        if (capienzaM > 0) {
            this.capienzaMax = capienzaM;
        }
    }

    public double getCapienzaMax() {
        return this.capienzaMax;
    }

    //metodo getSpazioDisponibile()
    public double getSpazioDisponibile() {
        return this.capienzaMax - this.quantita;
    }

    //metodo drive()
    public void drive(double distanza) {
        double consumo;

        if (distanza > 0 && this.resa > 0) {
            consumo = distanza / this.resa;
            if (this.quantita >= consumo) {
                this.quantita -= consumo;
            }
        }

    }

    //metodo addGas
    public void addGas(double carb) {
        if(carb > 0) {
            if (this.quantita + carb > this.capienzaMax) {
                this.quantita = this.capienzaMax;
            } else {
                this.quantita += carb;
            }
        }
    }

    //metodo toString
    public String toString() {
        String output = "";
        output += "La quantità di carburante nel serbatoio è di: " + this.quantita + " L.";
        output += "\nLa capienza massima è di: " + this.capienzaMax + " L.";
        output += "\nLa resa è di: " + this.resa + " km/L.";
        return output;
    } 
}