/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

/**
 *
 * @author Ronaldo
 */
public class ConverterHorasMinutos {

    public static void main(String[] args) {
        float hora = 2;
        float minuto = 50;
        float segundo = 30;
        float minutosTrabalhado = (hora * 60) + minuto + (segundo / 60);
        System.out.println(minutosTrabalhado);
    }
}
