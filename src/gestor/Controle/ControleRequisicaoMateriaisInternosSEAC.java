/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RequisicaoProdutosInternosSEAC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRequisicaoMateriaisInternosSEAC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequisicaoProdutosInternosSEAC objReqMatInterSEAC = new RequisicaoProdutosInternosSEAC();
    int codInt, codFunc;

    public RequisicaoProdutosInternosSEAC incluirRequisicaoMaterialInternosSEAC(RequisicaoProdutosInternosSEAC objReqMatInterSEAC) {
        buscarInterno(objReqMatInterSEAC.getNomeInternoReq());
        buscarColaborador(objReqMatInterSEAC.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_PRODUTOS_INTERNOS_SEAC (StatusReq,DataReq,IdLocal,IdInternoCrc,DescricaoPavilhao,DescricaoCela,IdFunc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objReqMatInterSEAC.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatInterSEAC.getDataReq().getTime()));
            pst.setInt(3, objReqMatInterSEAC.getIdLocal());
            pst.setInt(4, codInt);
            pst.setString(5, objReqMatInterSEAC.getDescricaoPavilhao());
            pst.setString(6, objReqMatInterSEAC.getDescricaoCela());
            pst.setInt(7, codFunc);
            pst.setString(8, objReqMatInterSEAC.getObservacao());
            pst.setString(9, objReqMatInterSEAC.getUsuarioInsert());
            pst.setString(10, objReqMatInterSEAC.getDataInsert());
            pst.setString(11, objReqMatInterSEAC.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInterSEAC;
    }

    public RequisicaoProdutosInternosSEAC alterarRequisicaoMaterialInternosSEAC(RequisicaoProdutosInternosSEAC objReqMatInterSEAC) {
        buscarInterno(objReqMatInterSEAC.getNomeInternoReq());
        buscarColaborador(objReqMatInterSEAC.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS_SEAC SET StatusReq=?,DataReq=?,IdLocal=?,IdReqUser=?,IdInternoCrc=?,DescricaoPavilhao=?,DescricaoCela=?,IdFunc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReq='" + objReqMatInterSEAC.getIdReq() + "'");
            pst.setString(1, objReqMatInterSEAC.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatInterSEAC.getDataReq().getTime()));
            pst.setInt(3, objReqMatInterSEAC.getIdLocal());
            pst.setInt(4, codInt);
            pst.setString(5, objReqMatInterSEAC.getDescricaoPavilhao());
            pst.setString(6, objReqMatInterSEAC.getDescricaoCela());
            pst.setInt(7, codFunc);
            pst.setString(8, objReqMatInterSEAC.getObservacao());
            pst.setString(9, objReqMatInterSEAC.getUsuarioUp());
            pst.setString(10, objReqMatInterSEAC.getDataUp());
            pst.setString(11, objReqMatInterSEAC.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInterSEAC;
    }

    public RequisicaoProdutosInternosSEAC excluirRequisicaoMaterialInternosSEAC(RequisicaoProdutosInternosSEAC objReqMatInterSEAC) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_PRODUTOS_INTERNOS_SEAC WHERE IdReq='" + objReqMatInterSEAC.getIdReq() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInterSEAC;
    }

    public RequisicaoProdutosInternosSEAC finalizarRequisicaoMaterialInternosSEAC(RequisicaoProdutosInternosSEAC objReqMatInterSEAC) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS_SEAC SET StatusReq=? WHERE IdReq='" + objReqMatInterSEAC.getIdReq() + "'");
            pst.setString(1, objReqMatInterSEAC.getStatusReq());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR Requisição de materiais.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInterSEAC;
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNOS a serem exibidos !!!");
        }
        conecta.desconecta();
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
