/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PlanejamentoAtividades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePlanejamentoAtividades {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PlanejamentoAtividades objPlan = new PlanejamentoAtividades();

    public PlanejamentoAtividades incluirPlanejamento(PlanejamentoAtividades objPlan) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO (DescricaoPlaneja,Sigla,Setor) VALUES(?,?,?)");
            pst.setString(1, objPlan.getDescricaoPlanejamento());
            pst.setString(2, objPlan.getSigla());
            pst.setString(3, objPlan.getDepartamento());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPlan;
    }

    public PlanejamentoAtividades alterarPlanejamento(PlanejamentoAtividades objPlan) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PLANEJAMENTO_ATIVIDADES_GRUPO SET DescricaoPlaneja=?,Sigla=?,Setor=? WHERE IdPlan='" + objPlan.getCodigo() + "'");
            pst.setString(1, objPlan.getDescricaoPlanejamento());
            pst.setString(2, objPlan.getSigla());
            pst.setString(3, objPlan.getDepartamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPlan;
    }

    public PlanejamentoAtividades excluirPlanejamento(PlanejamentoAtividades objPlan) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PLANEJAMENTO_ATIVIDADES_GRUPO WHERE IdPlan='" + objPlan.getCodigo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPlan;
    }

    public List<PlanejamentoAtividades> read() throws Exception {
        conecta.abrirConexao();
        List<PlanejamentoAtividades> listaTodosPlan = new ArrayList<PlanejamentoAtividades>();
        try {
            conecta.executaSQL("SELECT * FROM PLANEJAMENTO_ATIVIDADES_GRUPO ");   
            while (conecta.rs.next()) {
                PlanejamentoAtividades pPlan = new PlanejamentoAtividades();
                pPlan.setCodigo(conecta.rs.getInt("IdPlan"));
                pPlan.setSigla(conecta.rs.getString("Sigla"));
                pPlan.setDescricaoPlanejamento(conecta.rs.getString("DescricaoPlaneja"));
                pPlan.setDepartamento(conecta.rs.getString("Setor"));
                listaTodosPlan.add(pPlan);
            }
            return listaTodosPlan;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePlanejamentoAtividades.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
