/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import java.io.*;

/**
 *
 * @author Ronaldo
 */
public class CompararDatas {

    public static void main(String[] args) {
        File arq1 = new File("c:\\java\\Atualizar.java");
        long data1 = arq1.lastModified();

        File arq2 = new File("c:\\java\\CarregarDriver.java");
        long data2 = arq2.lastModified();

        if (data1 == data2) {
            System.out.println("As datas de alteracoes sao iguais");
        } else if (data1 < data2) {
            System.out.println("O segundo arquivo e mais recente");
        } else {
            System.out.println("O primeiro arquivo e mais recente");
        }
    }
}
