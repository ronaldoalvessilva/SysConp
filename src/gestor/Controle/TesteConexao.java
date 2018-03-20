/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class TesteConexao {
    private final String driver;
    private final String password;
    private final String url;
    private final String user;
    private ResourceBundle config;
    public Connection con;
    public Statement stmt;
    public ResultSet rs;

    public TesteConexao() throws FileNotFoundException, IOException {

        Properties defaultProps = new Properties();
        FileInputStream in = new FileInputStream("C:\\Compserv\\COMPRAS\\banco.properties");
        defaultProps.load(in);
        in.close();

// Cria objeto de configuracao, com os valores padrao  
        Properties applicationProps = new Properties(defaultProps);

// Utilizamos as propriedades quando precisarmos  
        driver = applicationProps.getProperty("DRIVER");
        password = applicationProps.getProperty("SENHA");
        url = applicationProps.getProperty("URL");
        user = applicationProps.getProperty("USER");


    }

    public void conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Driver de DB : " + ex);
            System.out.println("Erro ao carregar Driver de DB : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro SQL na Class Connection : " + ex);
            System.out.println("Erro SQL na Class Conexao, metodo conectar() :" + ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar do DB, Metodo => desconectar(): " + ex.getMessage());

        }
    }

    public void executeQuery(String sql) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace(); 
        }
    }
    
        public void executeQuery2(String sql) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {            
            ex.printStackTrace(); 
        }
    }

    public void executesSQL(String sql) {
        try {
            String SQL = sql;
            Statement stmt = con.createStatement();
            boolean results = stmt.execute(SQL);
            int rsCount = 0;

            //Loop through the available result sets.  
            do {
                if (results) {
                    ResultSet rs = stmt.getResultSet();
                    rsCount++;

                    //Show data from the result set.  
                    System.out.println("RESULT SET #" + rsCount);
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                    rs.close();
                }
                System.out.println();
                results = stmt.getMoreResults();
            } while (results);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
