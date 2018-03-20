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
public class ControleRequisicaoMateririasAvulsoENF {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequisicaoProdutosAvulso objReqMatAvulso = new RequisicaoProdutosAvulso();
    int codFunc;

    public RequisicaoProdutosAvulso incluirRequisicaoMaterialAvulsoENF(RequisicaoProdutosAvulso objReqMatAvulso) {
        buscarColaborador(objReqMatAvulso.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_AVULSA_PRODUTOS_ENF (StatusReq,StatusReqAtend,DataReq,IdLocal,IdFunc,IdFuncAut,MatriculaFuncAut,NomeFuncAut,NomeDepartamentoAut,TipoReq,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.setString(2, objReqMatAvulso.getStatusReqAtend());
            pst.setTimestamp(3, new java.sql.Timestamp(objReqMatAvulso.getDataReq().getTime()));
            pst.setInt(4, objReqMatAvulso.getIdLocal());
            pst.setInt(5, codFunc);
            pst.setInt(6, objReqMatAvulso.getIdFuncAutorizador());
            pst.setString(7, objReqMatAvulso.getMatriculaFuncAutorizador());
            pst.setString(8, objReqMatAvulso.getNomeFuncAutorizador());
            pst.setString(9, objReqMatAvulso.getDescricaoDeptoAutorizador());
            pst.setInt(10, objReqMatAvulso.getTipoRequisicao());
            pst.setString(11, objReqMatAvulso.getObservacao());            
            pst.setString(12, objReqMatAvulso.getUsuarioInsert());
            pst.setString(13, objReqMatAvulso.getDataInsert());
            pst.setString(14, objReqMatAvulso.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso alterarRequisicaoMaterialAvulsoENF(RequisicaoProdutosAvulso objReqMatAvulso) {
        buscarColaborador(objReqMatAvulso.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_ENF SET StatusReq=?,StatusReqAtend=?,DataReq=?,IdLocal=?,IdFunc=?,IdFuncAut=?,MatriculaFuncAut=?,NomeFuncAut=?,NomeDepartamentoAut=?,TipoReq=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.setString(2, objReqMatAvulso.getStatusReqAtend());
            pst.setTimestamp(3, new java.sql.Timestamp(objReqMatAvulso.getDataReq().getTime()));
            pst.setInt(4, objReqMatAvulso.getIdLocal());
            pst.setInt(5, codFunc);
            pst.setInt(6, objReqMatAvulso.getIdFuncAutorizador());
            pst.setString(7, objReqMatAvulso.getMatriculaFuncAutorizador());
            pst.setString(8, objReqMatAvulso.getNomeFuncAutorizador());
            pst.setString(9, objReqMatAvulso.getDescricaoDeptoAutorizador());
            pst.setInt(10, objReqMatAvulso.getTipoRequisicao());
            pst.setString(11, objReqMatAvulso.getObservacao());            
            pst.setString(12, objReqMatAvulso.getUsuarioUp());
            pst.setString(13, objReqMatAvulso.getDataUp());
            pst.setString(14, objReqMatAvulso.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso excluirRequisicaoMaterialAvulsoENF(RequisicaoProdutosAvulso objReqMatAvulso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_AVULSA_PRODUTOS_ENF WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso finalizarRequisicaoMaterialAvulsoENF(RequisicaoProdutosAvulso objReqMatAvulso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_ENF SET StatusReq=? WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
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
