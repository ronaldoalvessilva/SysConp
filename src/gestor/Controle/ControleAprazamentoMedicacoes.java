/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AprazamentoMedicamentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAprazamentoMedicacoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AprazamentoMedicamentos objApraza = new AprazamentoMedicamentos();
    int codInterno;

    public AprazamentoMedicamentos incluirAprazamentoMedico(AprazamentoMedicamentos objApraza) {
        buscarInterno(objApraza.getNomeInterno(), objApraza.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APRAZAMENTO_MEDICACAO (StatusLanc,DataLanc,IdInternoCrc,IdReq,TipoAprazamento,IdPres,IdItem,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objApraza.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objApraza.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objApraza.getIdReq());
            pst.setString(5, objApraza.getTipoAprazamento());
            pst.setInt(6, objApraza.getIdPres());
            pst.setInt(7, objApraza.getIdItem());
            pst.setString(8, objApraza.getObservacao());
            pst.setString(9, objApraza.getUsuarioInsert());
            pst.setString(10, objApraza.getDataInsert());
            pst.setString(11, objApraza.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApraza;
    }

    public AprazamentoMedicamentos alterarAprazamentoMedico(AprazamentoMedicamentos objApraza) {
        buscarInterno(objApraza.getNomeInterno(), objApraza.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APRAZAMENTO_MEDICACAO SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,IdReq=?,TipoAprazamento=?,IdPres=?,IdItem=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objApraza.getIdLanc() + "'");
            pst.setString(1, objApraza.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objApraza.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objApraza.getIdReq());
            pst.setString(5, objApraza.getTipoAprazamento());
            pst.setInt(6, objApraza.getIdPres());
            pst.setInt(7, objApraza.getIdItem());
            pst.setString(8, objApraza.getObservacao());
            pst.setString(9, objApraza.getUsuarioUp());
            pst.setString(10, objApraza.getDataUp());
            pst.setString(11, objApraza.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApraza;
    }

    public AprazamentoMedicamentos excluirAprazamentoMedico(AprazamentoMedicamentos objApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APRAZAMENTO_MEDICACAO WHERE IdLanc='" + objApraza.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objApraza;
    }

    public AprazamentoMedicamentos finalizarAprazamentoMedico(AprazamentoMedicamentos objApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APRAZAMENTO_MEDICACAO SET StatusLanc=? WHERE IdLanc='" + objApraza.getIdLanc() + "'");
            pst.setString(1, objApraza.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objApraza;
    }

    // ALTERA O STATUS DA REQUISCAO_PRODUTOS_INTERNOS_ENF COMO "Em Adamento" ou "Concluído" ou "Não Atendido"
    public AprazamentoMedicamentos atualizarRequisicaoMedicamentosInterno(AprazamentoMedicamentos objApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS_ENF SET StatusReqAtend=? WHERE IdReq='" + objApraza.getIdReq() + "'");
            pst.setString(1, objApraza.getStatusReqAndamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApraza;
    }
    
    // ALTERA O STATUS DA REQUISICAO_AVULSA_PRODUTOS_ENF COMO "Em Adamento" ou "Concluído" ou "Não Atendido"
    public AprazamentoMedicamentos atualizarRequisicaoMedicamentosAvulsa(AprazamentoMedicamentos objApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_ENF SET StatusReqAtend=? WHERE IdReq='" + objApraza.getIdReq() + "'");
            pst.setString(1, objApraza.getStatusReqAndamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApraza;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
