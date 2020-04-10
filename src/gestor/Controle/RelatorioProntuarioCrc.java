/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JInternalFrame;
//import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ronaldo
 */
public class RelatorioProntuarioCrc {

   

    public RelatorioProntuarioCrc() {

    }
// Método de conexão com o banco
    private static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=db_socializa;";
        String driver = "net.sourceforge.jtds.jdbc.Driver";
        String user = "sa";
        String password = "w2e3r4";
        System.setProperty("jdbc.Driveres", driver);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
// Metódo para gerar o relatório
    public static void geraRelatorio(String nomeRel, Map parametros) {

        Connection con = null;
        try {
            con = getConnection();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String path = "reports/ProntuarioCrc";
        try {
            JasperFillManager.fillReportToFile(path + nomeRel + ".jasper", parametros, con);
            JasperViewer jv = new JasperViewer(path + nomeRel + ".jasper", false, false);
            JInternalFrame iframe = (JInternalFrame) jv.add(jv);

//            jv.setTitle(titulo);
            //Colocar ícone na janela. Obs.: não é necessário
            // jv.setIconImage(new ImageIcon("Imagens/Icone.gif").getImage());
            jv.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
