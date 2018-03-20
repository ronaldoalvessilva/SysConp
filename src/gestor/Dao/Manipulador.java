/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Ronaldo Alves da Silva
 */
public class Manipulador {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./SysConp/Conecta.properties");
        props.load(file);
        return props;

    }

    public static void main(String args[]) throws IOException {

        String host; //Variavel que guardará o host do servidor.				
        Properties prop = getProp();
        host = prop.getProperty("prop.server.host");
    }

}
