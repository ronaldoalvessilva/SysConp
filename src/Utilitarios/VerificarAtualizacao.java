/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronaldo
 */
public class VerificarAtualizacao {

    
    // Compara as datas dos arquivos
    public void comprarData(String file1, String file2) {
        File arq1 = new File(file1);
        long data1 = arq1.lastModified();

        File arq2 = new File(file2);
        long data2 = arq2.lastModified();

        if (data1 == data2) {
            System.out.println("As datas de alteracoes sao iguais");
        } else if (data1 < data2) {
            System.out.println("O segundo arquivo e mais recente");
        } else {
            System.out.println("O primeiro arquivo e mais recente");
        }
    }

    // Copiar os arquivos
    public void copiarArquivos() throws IOException {
        //  public static void main(String[] args) throws IOException {  
        File arquivoOrigem = new File("\\10.32.132.196\\AtualizacaoSistema\\SysConp.jar");
        FileReader fis;
        try {
            fis = new FileReader(arquivoOrigem);
            BufferedReader bufferedReader = new BufferedReader(fis);
            StringBuilder buffer = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            fis.close();
            bufferedReader.close();
            File arquivoDestino = new File("C:\\SysConp\\SysConp.jar");
            FileWriter writer = new FileWriter(arquivoDestino);
            writer.write(buffer.toString());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VerificarAtualizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
