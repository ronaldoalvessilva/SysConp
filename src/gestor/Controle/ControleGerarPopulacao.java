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
import static gestor.Visao.TelaApagarPopulacaoCRC.pRESPOSTA;
import static gestor.Visao.TelaApagarPopulacaoCRC.pREPSOSTA_existencia;

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

    //EXCLUIR POPULAÇÃO CRC
    public GerarPopNominal excluirPopulacaoNominal(GerarPopNominal objPopNom) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPULACAOINTERNOS_CRC WHERE DataPop='" + objPopNom.getDataExclusaoPop() + "'");
            pst.executeUpdate();
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopNom;
    }
    
    // VERIFICAR POPULAÇÃO NO LINUX
    public GerarPopNominal verificarPopulacaoLINUX_WINDOWS(GerarPopNominal objPopNom) {
        conecta.abrirConexao();
        try {            
            conecta.executaSQL("SELECT DataPop FROM POPULACAOINTERNOS_CRC WHERE DataPop='" + objPopNom.getDataExclusaoPop() + "'");
            conecta.rs.first();            
            pREPSOSTA_existencia = conecta.rs.getString("DataPop");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objPopNom;
    }
}
