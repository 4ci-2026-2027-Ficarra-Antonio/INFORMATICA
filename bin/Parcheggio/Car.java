package Parcheggio;

public class Car {
    //variabili d'istanza
    private String targa;
    private String marca;
    private String modello;

    //Costruttore vuoto
    public Car() {
        this.targa = "";
        this.marca = "";
        this.modello = "";
    }

    //costruttore con parametri
    public Car(String t, String ma, String mo) {
        if (t != null) {
            this.targa = t;
        } else {
            this.targa = "";
        }
        if (ma != null) {
            this.marca = ma;
        } else {
            this.marca = "";
        }
        if (mo != null) {
            this.modello = mo;
        } else {
            this.modello = "";
        }
    }

    //costruttore di copia
    public Car(Car auto) {
        if (auto != null) {
            this.targa = auto.targa;
            this.marca = auto.marca;
            this.modello = auto.modello;
        }
    }

    //get e set targa
    public String getTarga() {
        return this.targa;
    }

    public void setTarga(String t) {
        if (t != null) {
            this.targa = t;
        }
    }

    //get e set marca
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String ma) {
        if (ma != null) {
            this.marca = ma;
        }
    }

    //get e set modello
    public String getModello() {
        return this.modello;
    }

    public void setModello(String mo) {
        if (mo != null) {
            this.modello = mo;
        }
    }

    //metodo per confrontare 2 auto in base alla targa
    public boolean uguale(Car auto) {
        if (auto == null) {
            return false;
        }
        return this.targa.equalsIgnoreCase(auto.targa);
    }

    //metodo toString
    public String toString() {
        String output = "";
        output += "La targa della macchina è: " + this.targa.toUpperCase();
        output += "\nLa marca della macchina è: " + this.marca;
        output += "\nIl modello della macchina è: " + this.modello;

        return output;
    }
}
