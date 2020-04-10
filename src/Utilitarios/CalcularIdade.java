/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Ronaldo
 */
public class CalcularIdade {

//    Calculando a idade usando como parâmetro um java.util.Date
//
//A Código abaixo apresenta o mesmo método com apenas uma diferença, pode ser utilizado um objeto do tipo java.util.Date para calcular a idade.
//
//Listagem 3:
//Calcula a Idade baseado em java.util.Date
    public static int calculaIdade(java.util.Date dataNasc) {

        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNasc);
// Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();
// Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);
//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }
//Leia mais em: Calcule a idade corretamente em Java http://www.devmedia.com.br/calcule-a-idade-corretamente-em-java/4729#ixzz39L0gFqAx    

//Calcula a Idade baseado em String. Exemplo: calculaIdade("20/08/1977","dd/MM/yyyy");
    public static int calcularIdade(String dataNasc, String pattern) {

        DateFormat sdf = new SimpleDateFormat(pattern);

        Date dataNascInput = null;

        try {

            dataNascInput = sdf.parse(dataNasc);

        } catch (ParseException e) {
        }

        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNascInput);

// Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

// Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

        if (today.before(dateOfBirth)) {

            age--;
        }
        return age;
    }
}
