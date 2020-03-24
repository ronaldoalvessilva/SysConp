/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.HistoricoEducacionalLaboral;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleIncluirExperienciaProfissionaDAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoEducacionalLaboral objHistEducLabor = new HistoricoEducacionalLaboral();

    int codProf;

    public HistoricoEducacionalLaboral incluirExperiencia(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarExperiencias(objHistEducLabor.getExperienciaProfissional());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO (IdATN,IdCodigoProf,IdHistoricoLabN,InteresseLabor) VALUES(?,?,?,?)");
            pst.setInt(1, objHistEducLabor.getIdATN());
            pst.setInt(2, codProf);
            pst.setInt(3, objHistEducLabor.getIdHistoricoLabPN());
            pst.setInt(4, objHistEducLabor.getTipoRemuneracao());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }
    
     public HistoricoEducacionalLaboral excluirExperiencia(HistoricoEducacionalLaboral objHistEducLabor) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO WHERE IdHistoricoLabN='" + objHistEducLabor.getIdHistoricoLab()+ "'");        
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public void buscarExperiencias(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROFISSAO WHERE DescricaoProf='" + desc + "'");
            conecta.rs.first();
            codProf = conecta.rs.getInt("IdCodigoProf");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PROFISSÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
