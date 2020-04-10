/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronaldo
 */
public class ManipulaProperties {
    

    /**
     * MÃ©todo que faz a leitura do arquivo properties 
     * dentro do projeto
     * 
     * @throws FileNotFoundException 
     */
    public void readPropertiesInterno() throws FileNotFoundException {

        try {

            /**Instanciando objeto da classe Properties**/
            Properties config = new Properties();

            /**Lendo o arquivo dentro do projeto**/
            InputStream configuracao = getClass().getResourceAsStream("/manipulaproperties/files/login.properties");

            /**carregando o arquivo**/
            config.load(configuracao);

            /**Imprimindo o conteÃºdo do arquivo**/
            System.out.println("Usuário :" + config.getProperty("user"));
            System.out.println("Senha :" + config.getProperty("senha"));


        } catch (IOException ex) {
            Logger.getLogger(ManipulaProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * MÃ©todo que faz a leitura do arquivo properties
     * externo ao projeto
     * 
     * @throws FileNotFoundException 
     */
    public void readPropertiesExterno() throws FileNotFoundException {

        try {
            /**Instanciando objeto da classe Properties**/
            Properties config = new Properties();
            
            /**Lendo o arquivo externamente**/
            InputStream configuracao = new FileInputStream("C://login.properties");

            /**carregando o arquivo**/
            config.load(configuracao);

            System.out.println("Usuário :" + config.getProperty("user"));
            System.out.println("Senha :" + config.getProperty("senha"));


        } catch (IOException ex) {
            Logger.getLogger(ManipulaProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * MÃ©todo que edita o arquivo properties 
     * dentro do projeto (NÃ£o funcionarÃ¡ apÃ³s gerado o jar)
     * 
     * @param usuario
     * @param senha 
     */
    public void writePropertiesInterno(String usuario, String senha) {
        
        try {

             /**Lendo o arquivo dentro do projeto**/
            URI arquivo = getClass().getResource("/manipulaproperties/files/login.properties").toURI();


            /**Instanciando objeto do tipo File**/
            File file = new File(arquivo);


            /**Instanciando objeto da classe Properties**/
            Properties config = new Properties();

            /**Instanciando objeto do tipo FileInpusStream **/
            FileInputStream fis = new FileInputStream(file);

            /**carregando o arquivo**/
            config.load(fis);

            /**setando as propriedades no arquivo properties**/
            config.setProperty("user", usuario);
            config.setProperty("senha", senha);

            /**Instanciando objeto do tipo FileOutputStream **/
            FileOutputStream fos = new FileOutputStream(file);

            /**Salvando os valores alterados no arquivo properties**/
            config.store(fos, "ConfiguraÃ§Ã£o UsuÃ¡rio e Senha:");

            fos.close();



        } catch (IOException ex) {
            ex.getMessage();
        } catch (URISyntaxException ex) {
            ex.getMessage();
        }


    }

    /**
     * MÃ©todo que edita o arquivo properties 
     * externo ao projeto
     * 
     * @param usuario
     * @param senha 
     */
    public void writePropertiesExterno(String usuario, String senha) {

        try {

            /**Lendo o arquivo externamente**/
            String arquivo = "C://login.properties";

            /**Instanciando objeto do tipo File**/
            File file = new File(arquivo);


            /**Instanciando objeto da classe Properties**/
            Properties config = new Properties();

            /**Instanciando objeto do tipo FileInpusStream **/
            FileInputStream fis = new FileInputStream(file);

            /**carregando o arquivo**/
            config.load(fis);

            /**setando as propriedades no arquivo properties**/
            config.setProperty("user", usuario);
            config.setProperty("senha", senha);

            /**Instanciando objeto do tipo FileOutputStream **/
            FileOutputStream fos = new FileOutputStream(file);

            /**Salvando os valores alterados no arquivo properties**/
            config.store(fos, "ConfiguraÃ§Ã£o UsuÃ¡rio e Senha:");

            fos.close();



        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
