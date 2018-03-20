/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RequisicaoProdutosAvulso;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRequisicaoMateririasAvulsoNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequisicaoProdutosAvulso objReqMatAvulso = new RequisicaoProdutosAvulso();
    int codFunc;

    public RequisicaoProdutosAvulso incluirRequisicaoMaterialAvulsoNUTRI(RequisicaoProdutosAvulso objReqMatAvulso) {
        buscarColaborador(objReqMatAvulso.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_AVULSA_PRODUTOS_NUTRI (StatusReq,DataReq,IdLocal,IdFunc,IdFuncAut,MatriculaFuncAut,NomeFuncAut,NomeDepartamentoAut,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatAvulso.getDataReq().getTime()));
            pst.setInt(3, objReqMatAvulso.getIdLocal());
            pst.setInt(4, codFunc);
            pst.setInt(5, objReqMatAvulso.getIdFuncAutorizador());
            pst.setString(6, objReqMatAvulso.getMatriculaFuncAutorizador());
            pst.setString(7, objReqMatAvulso.getNomeFuncAutorizador());
            pst.setString(8, objReqMatAvulso.getDescricaoDeptoAutorizador());
            pst.setString(9, objReqMatAvulso.getObservacao());
            pst.setString(10, objReqMatAvulso.getUsuarioInsert());
            pst.setString(11, objReqMatAvulso.getDataInsert());
            pst.setString(12, objReqMatAvulso.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso alterarRequisicaoMaterialAvulsoNUTRI(RequisicaoProdutosAvulso objReqMatAvulso) {
        buscarColaborador(objReqMatAvulso.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_NUTRI SET StatusReq=?,DataReq=?,IdLocal=?,IdFunc=?,IdFuncAut=?,MatriculaFuncAut=?,NomeFuncAut=?,NomeDepartamentoAut=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatAvulso.getDataReq().getTime()));
            pst.setInt(3, objReqMatAvulso.getIdLocal());
            pst.setInt(4, codFunc);
            pst.setInt(5, objReqMatAvulso.getIdFuncAutorizador());
            pst.setString(6, objReqMatAvulso.getMatriculaFuncAutorizador());
            pst.setString(7, objReqMatAvulso.getNomeFuncAutorizador());
            pst.setString(8, objReqMatAvulso.getDescricaoDeptoAutorizador());
            pst.setString(9, objReqMatAvulso.getObservacao());
            pst.setString(10, objReqMatAvulso.getUsuarioUp());
            pst.setString(11, objReqMatAvulso.getDataUp());
            pst.setString(12, objReqMatAvulso.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso excluirRequisicaoMaterialAvulsoNUTRI(RequisicaoProdutosAvulso objReqMatAvulso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_AVULSA_PRODUTOS_NUTRI WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso finalizarRequisicaoMaterialAvulsoNUTRI(RequisicaoProdutosAvulso objReqMatAvulso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_NUTRI SET StatusReq=? WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR Requisição de materiais.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public void buscarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dao COLABORADOR a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
