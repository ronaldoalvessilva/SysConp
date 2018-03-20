/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Ronaldo
 */
public class DiferencaMesesMelhor {
    public static void main(String[] args) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar c1 = Calendar.getInstance();  
		Calendar c2 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, 10);
		c1.add(Calendar.MONTH, +3);  
		c1.add(Calendar.YEAR, +10);
		System.out.println("data inicio: "+formatador.format(c2.getTime()));  
		System.out.println("mes final "+formatador.format(c1.getTime()));  
		System.out.println("diferenca de meses: "+(+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH)));  
	}
}
