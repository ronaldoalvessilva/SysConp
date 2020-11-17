/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.teste;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ronal
 */
public class TesteDatas {
    public static void main(String args[]) {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date dataBase = null;
      Date vencimento = null;
      try {
         dataBase = sdf.parse("16/11/2020");
         vencimento = sdf.parse("17/12/2022");
      } catch (java.text.ParseException e) { return; }

      long diferencaMS = vencimento.getTime() - dataBase.getTime();
      long diferencaSegundos = diferencaMS / 1000;
      long diferencaMinutos = diferencaSegundos / 60;
      long diferencaHoras = diferencaMinutos / 60;
      long diferencaDias = diferencaHoras / 24;

      System.out.println(diferencaMS);
      System.out.println(diferencaSegundos);
      System.out.println(diferencaMinutos);
      System.out.println(diferencaHoras);
      System.out.println(diferencaDias);
  }
}
