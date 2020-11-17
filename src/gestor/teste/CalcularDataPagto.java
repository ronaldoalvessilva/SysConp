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
public class CalcularDataPagto {

    public static void main(String args[]) {
        DateUtils dateUtils = new DateUtils();

        String data = "16/11/2020";
        Date d1;
        try {
            d1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Date d2 = dateUtils.addDate(Calendar.MONTH, 1, d1);
            System.out.println("Data orig: " + d1);
            System.out.println("Data +1 mes: " + d2);

            System.out.println("");

            d2 = dateUtils.addDate(Calendar.DAY_OF_MONTH, 30, d1);
            System.out.println("Data orig: " + d1);
            System.out.println("Data +30 dias: " + d2);

            System.out.println("");

            d2 = dateUtils.addDate(Calendar.WEEK_OF_MONTH, 2, d1);
            System.out.println("Data orig: " + d1);
            System.out.println("Data +2 semana: " + d2);
        } catch (ParseException ex) {
            Logger.getLogger(CalcularDataPagto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
