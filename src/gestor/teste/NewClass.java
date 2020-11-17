/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class NewClass {

    public static void main(String args[]) {
        DateUtils dateUtils = new DateUtils();
        int inteiro = 1;
        String dataInicial = "16/11/2020";
        String dataFinal = "31/12/2021";

        int dia = Integer.parseInt(dataInicial.substring(0, 2));
        int mes = Integer.parseInt(dataInicial.substring(3, 5));
        int ano = Integer.parseInt(dataInicial.substring(6, 10));
        //
        int diaF = Integer.parseInt(dataFinal.substring(0, 2));
        int mesF = Integer.parseInt(dataFinal.substring(3, 5));
        int anoF = Integer.parseInt(dataFinal.substring(6, 10));

        int diaParada = diaF;
        int mesParada = mesF;
        int anoParada = anoF + ano;
        //
        Date d1;
        for (int i = 0; i < anoF; i++) {
            try {
                d1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
                Date d2 = dateUtils.addDate(Calendar.DAY_OF_MONTH, inteiro, d1);
                System.out.print("Data da Escala: " + d2 + "\n");
                ++inteiro;
            } catch (ParseException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
