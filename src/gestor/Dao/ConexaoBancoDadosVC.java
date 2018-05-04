/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

//import config.Computer;
//import config.Ler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo Alves da Silva
 */
public class ConexaoBancoDadosVC {

    public Statement stmt; // Responsavael para preparar e realizar pesquisas no banco de dados
    public ResultSet rs; // Responsavel por armazenar o resultado de uma pesquisa passado para o Statement         
    Properties prop = getProp();// Metodo que esta no final dessa classe
    String urlBanco = prop.getProperty("URL");// URL é o nome da proprienade no arquivo
    private final String url = urlBanco;
    private final String driver = "net.sourceforge.jtds.jdbc.Driver";
    private final String user = "sa"; // usuario do banco de dados     
    private final String password = "W@e3R4#14"; // Senha do banco de dados
    public Connection con; // Responsavel por conectar no banco de dados

    public void abrirConexao() { // Metodo resposavel por realizar conexão com o banco de dados

        try { // Bloco lógico de tratamento de erros
            System.setProperty("jdbc.Driveres", driver); // Seta propriedade do drive de conexão
            con = DriverManager.getConnection(url, user, password); //Realiza a conexão com o banco de dados                        
        } catch (SQLException ex) { // Excessão de erro na variável (ex)
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com o banco de dados...\n  " + ex.getMessage());
        }
    }

    public void executaSQL(String SQL) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do executaSQL\n\n\n" + ex.getMessage());
            Logger.getLogger(ConexaoBancoDadosVC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconecta() { // Metódo para desconectar com o banco de dados

        try {
            con.close();
            //     JOptionPane.showMessageDialog(null, "Desconectado com Sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Desconectar conexão com o Banco de Dados" + e.getMessage());
        }
    }

    public static Properties getProp() {
        //EXEMPLO DE USO
        //Properties prop = getProp();
        //String login = prop.getProperty("prop.server.login");

        FileInputStream file = null;
        Properties props = null;
        try {
            String Computer = System.getProperty("os.name");
            System.out.println(Computer);
            props = new Properties();
            if (Computer.equals("Linux")) {
                file = new FileInputStream("/home/configuracoes.properties");//ALTERE AQUI DE ACORDO COM SUA NECESSIDADE
            } else {
                //Se Windows
                file = new FileInputStream("C:\\SysConp\\ConectaVC.properties");////ALTERE AQUI DE ACORDO COM SUA NECESSIDADE
            }
            props.load(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexaoBancoDadosVC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoBancoDadosVC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexaoBancoDadosVC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return props;
    }

    // Conexão com o banco de dados MySQL
//     private String url = "jdbc:mysql://localhost:3306/db_socializa"; // Responsavel pelo caminho do banco de dados
//     private String driver = "com.mysql.jdbc.Driver"; // Responsavel por identificar o banco de dados
//     private final String user = "root"; // usuario do banco de dados
//     private final String password = "w2e3r4"; // Senha do banco de dados
//     public Connection con; // Responsavel por conectar no banco de dados
}
