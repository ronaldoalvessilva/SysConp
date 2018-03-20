/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class DiferencaMeses {
    /**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio = format.parse("01/01/2010");
		Date dataFim = format.parse("01/03/2010");
		/*
		 * valor de um mes em milisegundos, sendo que os valores sao:
		 * 30 dias no mes, 24 horas no dia, 60 minutos por hora, 60 segundos por minuto e 1000 milisegundos  
		 */
		final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;
		//final double MES_EM_MILISEGUNDOS = 2592000000.0;
		double numeroDeMeses = (double)((dataFim.getTime() - dataInicio.getTime())/MES_EM_MILISEGUNDOS);
		System.out.println("numero de meses: "+numeroDeMeses);
	}
}
