/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;

/**
 *
 * @author Ronaldo
 */
public class Utils {
    //Calcula a Idade baseado em String. Exemplo: calculaIdade("20/08/1977","dd/MM/yyyy");

    public static int calculaIdade(String dataNasc, String pattern) {
        DateFormat sdf = new SimpleDateFormat(pattern);
        Date dataNascInput = null;
        try {
            dataNascInput = sdf.parse(dataNasc);
        } catch (Exception e) {
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
