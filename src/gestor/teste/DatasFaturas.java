/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

/**
 *
 * @author ronal
 */
public class DatasFaturas {

    public static void main(String args[]) {
        String data = "16/11/2020";

        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        int mesParada = mes + 5;
        String proximaData = null;

        while (mes <= mesParada) {
            ++mes;
            proximaData = dia + "/" + mes + "/" + ano;
            System.out.println("Data de Pagamento: " + proximaData);
        }
    }
}
