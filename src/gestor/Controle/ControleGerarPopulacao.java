/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GerarPopNominal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleGerarPopulacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GerarPopNominal objPopNom = new GerarPopNominal();
   

    //Método para SALVAR POPULAÇÃO NOMINAL
    public GerarPopNominal incluirPopulacaoNominal(GerarPopNominal objPopNom) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPULACAOINTERNOS_CRC (DataPop,IdInternoCrc)VALUES(?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopNom.getDataLanc().getTime()));
            pst.setInt(2, objPopNom.getIdInternoCrc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopNom;
    }  
}
