/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Ronaldo
 */
public class DiferencaEntreDatas {
     public static void main(String args[]) throws ParseException{
         String maiorData = "30/01/2021";
         String menorData = "16/11/2020";
        try {  
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
            GregorianCalendar maior = new GregorianCalendar();
            maior.setTime(dateFormat.parse(maiorData));
            GregorianCalendar menor = new GregorianCalendar();
            menor.setTime(dateFormat.parse(menorData));
            GregorianCalendar dif = new GregorianCalendar();
            dif.setTimeInMillis(maior.getTimeInMillis() - menor.getTimeInMillis());
            System.out.println(maior.get(GregorianCalendar.YEAR));
            System.out.println(menor.get(GregorianCalendar.YEAR));
            System.out.println("Diferença: " + (maior.get(GregorianCalendar.YEAR)-menor.get(GregorianCalendar.YEAR)) + " ano(s), "  
                    + (dif.get(GregorianCalendar.MONTH) + 1) + " mes(es), "  
                    + dif.get(GregorianCalendar.DAY_OF_MONTH) + " dia(s)");  
        } catch (ParseException ex) { //Lança exceção caso a data informada não esteja no formato "dd/MM/yyyy"  
            ex.printStackTrace(System.err);  
        }  
    }
}
