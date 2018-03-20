/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RequiscaoProdutosInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRequisicaoMateriasCardapioNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequiscaoProdutosInternos objReqMatInter = new RequiscaoProdutosInternos();
    int codFunc;

    public RequiscaoProdutosInternos incluirRequisicaoMaterialCardapioNUTRI(RequiscaoProdutosInternos objReqMatInter) {

        buscarColaborador(objReqMatInter.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_PRODUTOS_CARDAPIO_NUTRI (StatusReq,DataReq,IdLocal,IdCardapio,IdFunc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objReqMatInter.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatInter.getDataReq().getTime()));
            pst.setInt(3, objReqMatInter.getIdLocal());
            pst.setInt(4, objReqMatInter.getIdReq());           
            pst.setInt(5, codFunc);
            pst.setString(6, objReqMatInter.getObservacao());
            pst.setString(7, objReqMatInter.getUsuarioInsert());
            pst.setString(8, objReqMatInter.getDataInsert());
            pst.setString(9, objReqMatInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
    }

    public RequiscaoProdutosInternos alterarRequisicaoMaterialCardapioNUTRI(RequiscaoProdutosInternos objReqMatInter) {

        buscarColaborador(objReqMatInter.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_CARDAPIO_NUTRI SET StatusReq=?,DataReq=?,IdLocal=?,IdCardapio=?,IdFunc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            pst.setString(1, objReqMatInter.getStatusReq());
            pst.setTimestamp(2, new java.sql.Timestamp(objReqMatInter.getDataReq().getTime()));
            pst.setInt(3, objReqMatInter.getIdLocal());
            pst.setInt(4, objReqMatInter.getIdReq());           
            pst.setInt(5, codFunc);
            pst.setString(6, objReqMatInter.getObservacao());
            pst.setString(7, objReqMatInter.getUsuarioUp());
            pst.setString(8, objReqMatInter.getDataUp());
            pst.setString(9, objReqMatInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
    }

    public RequiscaoProdutosInternos excluirRequisicaoMaterialCardapioNUTRI(RequiscaoProdutosInternos objReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_PRODUTOS_CARDAPIO_NUTRI WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
    }

    public RequiscaoProdutosInternos finalizarRequisicaoMaterialCardapioNUTRI(RequiscaoProdutosInternos objReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_CARDAPIO_NUTRI SET StatusReq=? WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            pst.setString(1, objReqMatInter.getStatusReq());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR Requisição de materiais.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
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
