/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EstornoRequisicaoMateriais;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEstornoRequisicaoAC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EstornoRequisicaoMateriais objEstoReq = new EstornoRequisicaoMateriais();

    public EstornoRequisicaoMateriais incluirEstornoMaterial(EstornoRequisicaoMateriais objEstoReq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESTORNO_PRODUTOS_AC (StatusEst,DataEst,TipoEstorno,DataReq,LocalEstoque,IdReq,NomeRequisitante,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEstoReq.getStatusEstorno());
            pst.setTimestamp(2, new java.sql.Timestamp(objEstoReq.getDataEstorno().getTime()));
            pst.setInt(3, objEstoReq.getTipoEstorno());
            pst.setTimestamp(4, new java.sql.Timestamp(objEstoReq.getDataReq().getTime()));
            pst.setInt(5, objEstoReq.getLocalEstoque());
            pst.setInt(6, objEstoReq.getIdRequisicao());
            pst.setString(7, objEstoReq.getNomeRequisitante());
            pst.setString(8, objEstoReq.getObservacao());
            pst.setString(9, objEstoReq.getUsuarioInsert());
            pst.setString(10, objEstoReq.getDataInsert());
            pst.setString(11, objEstoReq.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR estorno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEstoReq;
    }

    public EstornoRequisicaoMateriais alterarEstornoMaterial(EstornoRequisicaoMateriais objEstoReq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTORNO_PRODUTOS_AC SET StatusEst=?,DataEst=?,TipoEstorno=?,DataReq=?,LocalEstoque=?,IdReq=?,NomeRequisitante=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReq='" + objEstoReq.getIdEstorno() + "'");
            pst.setString(1, objEstoReq.getStatusEstorno());
            pst.setTimestamp(2, new java.sql.Timestamp(objEstoReq.getDataEstorno().getTime()));
            pst.setInt(3, objEstoReq.getTipoEstorno());
            pst.setTimestamp(4, new java.sql.Timestamp(objEstoReq.getDataReq().getTime()));
            pst.setInt(5, objEstoReq.getLocalEstoque());
            pst.setInt(6, objEstoReq.getIdRequisicao());
            pst.setString(7, objEstoReq.getNomeRequisitante());
            pst.setString(8, objEstoReq.getObservacao());
            pst.setString(9, objEstoReq.getUsuarioUp());
            pst.setString(10, objEstoReq.getDataUp());
            pst.setString(11, objEstoReq.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR estorno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEstoReq;
    }

    public EstornoRequisicaoMateriais excluirEstornoMaterial(EstornoRequisicaoMateriais objEstoReq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ESTORNO_PRODUTOS_AC WHERE IdReq='" + objEstoReq.getIdEstorno() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR estorno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEstoReq;
    }

    public EstornoRequisicaoMateriais finalizarEstornoMaterial(EstornoRequisicaoMateriais objEstoReq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTORNO_PRODUTOS_AC SET StatusEst=? WHERE IdEst='" + objEstoReq.getIdEstorno() + "'");
            pst.setString(1, objEstoReq.getStatusEstorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR estorno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEstoReq;
    }
}
