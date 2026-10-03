package SistemaPagamentoException_file;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Conto conto1 = new Conto("Mario Rossi", 500.00);
        System.out.println("\n" + conto1.toString() + "\n");

        String beneficiario;
        double importo;
        Scanner sc;
        FileWriter fw;
        PrintWriter pw;

        try {
            File fileInput = new File("bin/SistemaPagamentoException_file/pagamenti_input.txt");
            sc = new Scanner(fileInput);

            fw = new FileWriter("bin/SistemaPagamentoException_file/log_transazioni.txt", false);
            pw = new PrintWriter(fw);

            pw.println("Conto intestato a: " + conto1.getIntestatario() + " Saldo: " + conto1.getSaldo() + "€\n");

            int numeroRiga = 0;

            while(sc.hasNextLine()){
                numeroRiga++;
                String riga = sc.nextLine();

                if (!riga.isEmpty()) {
                    String[] parti = riga.split(",");
                    
                    if (parti.length != 2) {
                        pw.println("Errore riga " + numeroRiga + ": " + riga + "\n");
                    } else {
                        beneficiario = parti[0];
                        importo = Double.parseDouble(parti[1]);

                        Pagamento p = new Pagamento(beneficiario, importo);

                        try {
                            conto1.effettuaPagamento(p);
                            pw.println("Pagamento: " + importo + "€. Beneficiario: " + beneficiario);
                        } catch (SaldoInsufficienteException e) {
                            System.out.println("Errore: " + e.getMessage() + "\n");
                            pw.println("\nFALLITO: " + e.getMessage() + "\n");
                        }
                    }


                }

            }

            sc.close();
            pw.close();
            fw.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        System.out.println("Stato conto:" + conto1.toString() + "\n");
    }
}
