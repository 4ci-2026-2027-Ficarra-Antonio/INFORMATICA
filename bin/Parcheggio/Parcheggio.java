package Parcheggio;

import java.util.ArrayList;

public class Parcheggio {
    //variabili d'istanza
    private int postiDisponibili;
    private double costoOrario;

    private int capienzaMax;
    private ArrayList<Car> autoPresenti;

    //costruttore vuoto
    public Parcheggio() {
        this.postiDisponibili = 0;
        this.costoOrario = 0.0;
        this.capienzaMax = 0;
        this.autoPresenti = new ArrayList<>();
    }

    //costruttore con parametri
    public Parcheggio(int posti, double costo) {
        if (posti > 0) {
            this.postiDisponibili = posti;
        } else {
            this.postiDisponibili = 0;
        }
        if (costo > 0) {
            this.costoOrario = costo;
        } else {
            this.costoOrario = 0.0;
        }
        this.autoPresenti = new ArrayList<>();
    }

    //costruttore di copia
    public Parcheggio(Parcheggio p) {
        if (p != null) {
            this.postiDisponibili = p.postiDisponibili;
            this.costoOrario = p.costoOrario;
            this.capienzaMax = p.capienzaMax;
            this.autoPresenti = new ArrayList<>(p.autoPresenti);
        }
    }

    //set e get costo
    public void setCostoOrario (double costo) {
        if (costo >= 0) {
            this.costoOrario = costo;
        }
    }

    public double getCostoOrario() {
        return this.costoOrario;
    }

    //get postiDisponibili
    public int getPostiDisponibili() {
        return this.postiDisponibili;
    }

    public boolean entra(Car auto) {
        if (auto != null && this.postiDisponibili > 0) {
            for (int i = 0; i < autoPresenti.size(); i++) {
                Car c = autoPresenti.get(i);
                if (c.uguale(auto)) {
                    return false;
                }

                this.autoPresenti.add(new Car(auto));
                this.postiDisponibili--;
                return true;
            }
        }
        return false;
    }

    public double esce(Car auto, double ore) {
        if (auto != null) {
            Car autoTrovata = null;
            for (int i = 0; i < autoPresenti.size(); i++) {
                Car c = autoPresenti.get(i);

                if (c.uguale(auto) && autoTrovata == null) {
                    autoTrovata = auto;
                }
            }

            if (autoTrovata != null) {
                this.autoPresenti.remove(autoTrovata);
                this.postiDisponibili++;
                double totale = ore * this.costoOrario;
                return totale;
            }
        }
        return -1;
    }

    //metodo toString
    public String toString() {
        String output = "";
        output += "Posti disponibili nel parcheggio: " + this.postiDisponibili;
        output += "\nCosto orario del parcheggio: " + this.costoOrario + "€";
        output += "\nAuto presenti nel parcheggio: " + autoPresenti.size();
        
        return output;
    }
}
