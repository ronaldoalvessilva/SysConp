/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.ParseException;

/**
 *
 * @author Ronaldo
 */
public class CalcularDataNascimento {

    public static void main(String args[]) throws ParseException {
        Util util = new Util();

        System.out.println(util.calculaIdade("27-07-1927", "dd-MM-yyyy"));
    }
}
