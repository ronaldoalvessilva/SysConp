/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class CalculoHorasEmDias {
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH");
		Date data = null;
		String retorno = null;
		try {
			data = formatter.parse("48:00:00");
		} catch (ParseException e) {
		}
		BigDecimal valor = new BigDecimal((double)data.getTime() / (24L * 60 * 60 * 1000) - 0.125);
		if(!valor.toString().contains(".")){
			retorno = valor + " Dia(s)";
		}else{
			BigDecimal valorQuebrado = valor.setScale(2, RoundingMode.UP);
			retorno = valorQuebrado.toString().replace(".", ",") + " Dia(s)";
		}
		System.out.println(retorno);
	}
}
