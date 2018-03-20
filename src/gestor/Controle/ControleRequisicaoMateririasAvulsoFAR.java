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
public class ControleRequisicaoMateririasAvulsoFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequisicaoProdutosAvulso objReqMatAvulso = new RequisicaoProdutosAvulso();
    int codFunc;
    int codMotivo;

    public RequisicaoProdutosAvulso incluirRequisicaoMaterialAvulsoFAR(RequisicaoProdutosAvulso objReqMatAvulso) {
        buscarColaborador(objReqMatAvulso.getNomeColaboradorReq());
        buscarMotivoRequisicao(objReqMatAvulso.getTituloMotivo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_AVULSA_PRODUTOS_FAR (StatusReq,DataReq,IdLocal,IdFunc,IdFuncAut,MatriculaFuncAut,NomeFuncAut,NomeDepartamentoAut,IdMot,Observacao,UsuarioInsert,DataInsert,HorarioInsert,ProdutosAV) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatAvulso.getDataReq().getTime()));
            pst.setInt(3, objReqMatAvulso.getIdLocal());
            pst.setInt(4, codFunc);
            pst.setInt(5, objReqMatAvulso.getIdFuncAutorizador());
            pst.setString(6, objReqMatAvulso.getMatriculaFuncAutorizador());
            pst.setString(7, objReqMatAvulso.getNomeFuncAutorizador());
            pst.setString(8, objReqMatAvulso.getDescricaoDeptoAutorizador());
            pst.setInt(9, codMotivo);
            pst.setString(10, objReqMatAvulso.getObservacao());
            pst.setString(11, objReqMatAvulso.getUsuarioInsert());
            pst.setString(12, objReqMatAvulso.getDataInsert());
            pst.setString(13, objReqMatAvulso.getHorarioInsert());
            pst.setString(14, objReqMatAvulso.getProdutosAvaria());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso alterarRequisicaoMaterialAvulsoFAR(RequisicaoProdutosAvulso objReqMatAvulso) {
        buscarColaborador(objReqMatAvulso.getNomeColaboradorReq());
        buscarMotivoRequisicao(objReqMatAvulso.getTituloMotivo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_FAR SET StatusReq=?,DataReq=?,IdLocal=?,IdFunc=?,IdFuncAut=?,MatriculaFuncAut=?,NomeFuncAut=?,NomeDepartamentoAut=?,IdMot=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,ProdutosAV=? WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.setString(1, objReqMatAvulso.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatAvulso.getDataReq().getTime()));
            pst.setInt(3, objReqMatAvulso.getIdLocal());
            pst.setInt(4, codFunc);
            pst.setInt(5, objReqMatAvulso.getIdFuncAutorizador());
            pst.setString(6, objReqMatAvulso.getMatriculaFuncAutorizador());
            pst.setString(7, objReqMatAvulso.getNomeFuncAutorizador());
            pst.setString(8, objReqMatAvulso.getDescricaoDeptoAutorizador());
            pst.setInt(9, codMotivo);
            pst.setString(10, objReqMatAvulso.getObservacao());
            pst.setString(11, objReqMatAvulso.getUsuarioUp());
            pst.setString(12, objReqMatAvulso.getDataUp());
            pst.setString(13, objReqMatAvulso.getHorarioUp());
            pst.setString(14, objReqMatAvulso.getProdutosAvaria());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso excluirRequisicaoMaterialAvulsoFAR(RequisicaoProdutosAvulso objReqMatAvulso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_AVULSA_PRODUTOS_FAR WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatAvulso;
    }

    public RequisicaoProdutosAvulso finalizarRequisicaoMaterialAvulsoFAR(RequisicaoProdutosAvulso objReqMatAvulso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS_FAR SET StatusReq=? WHERE IdReq='" + objReqMatAvulso.getIdReq() + "'");
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

    public void buscarMotivoRequisicao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MOTIVO_SAIDA_PRODUTOS_FAR WHERE TituloMotivo='" + nome + "'");
            conecta.rs.first();
            codMotivo = conecta.rs.getInt("IdMot");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dao MOTIVO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
