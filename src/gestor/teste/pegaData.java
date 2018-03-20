/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class pegaData {

    public static void main(String args[]) throws ParseException{
        String s = "31/01/2016";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dt = df.parse(s);
        DateFormat df2 = new SimpleDateFormat("MMMMM", new Locale("pt", "BR"));
        System.out.println(df2.format(dt)); // "Janeiro"
        JOptionPane.showMessageDialog(null, "O mês é: " + df2.format(dt));
    }
}
