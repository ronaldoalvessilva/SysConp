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
public class ControleRequisicaoMedicamentosInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RequiscaoProdutosInternos objReqMatInter = new RequiscaoProdutosInternos();
    int codInt, codFunc;

    public RequiscaoProdutosInternos incluirRequisicaoMaterialInternos(RequiscaoProdutosInternos objReqMatInter) {
        buscarInterno(objReqMatInter.getNomeInternoReq());
        buscarColaborador(objReqMatInter.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_PRODUTOS_INTERNOS_ENF (StatusReq,StatusReqAtend,DataReq,IdLocal,IdItem,IdPres,IdInternoCrc,DescricaoPavilhao,DescricaoCela,IdFunc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objReqMatInter.getStatusReq());
            pst.setString(2, objReqMatInter.getStatusReqAtend());
            pst.setTimestamp(3, new java.sql.Timestamp(objReqMatInter.getDataReq().getTime()));
            pst.setInt(4, objReqMatInter.getIdLocal());
            pst.setInt(5, objReqMatInter.getIdItem());
            pst.setInt(6, objReqMatInter.getIdPres());
            pst.setInt(7, codInt);
            pst.setString(8, objReqMatInter.getDescricaoPavilhao());
            pst.setString(9, objReqMatInter.getDescricaoCela());
            pst.setInt(10, codFunc);
            pst.setString(11, objReqMatInter.getObservacao());
            pst.setString(12, objReqMatInter.getUsuarioInsert());
            pst.setString(13, objReqMatInter.getDataInsert());
            pst.setString(14, objReqMatInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
    }

    public RequiscaoProdutosInternos alterarRequisicaoMaterialInternos(RequiscaoProdutosInternos objReqMatInter) {
        buscarInterno(objReqMatInter.getNomeInternoReq());
        buscarColaborador(objReqMatInter.getNomeColaboradorReq());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS_ENF SET StatusReq=?,StatusReqAtend=?,DataReq=?,IdLocal=?,IdItem=?,IdPres=?,IdInternoCrc=?,DescricaoPavilhao=?,DescricaoCela=?,IdFunc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            pst.setString(1, objReqMatInter.getStatusReq());
            pst.setString(2, objReqMatInter.getStatusReqAtend());
            pst.setTimestamp(3, new java.sql.Timestamp(objReqMatInter.getDataReq().getTime()));
            pst.setInt(4, objReqMatInter.getIdLocal());
            pst.setInt(5, objReqMatInter.getIdItem());
            pst.setInt(6, objReqMatInter.getIdPres());
            pst.setInt(7, codInt);
            pst.setString(8, objReqMatInter.getDescricaoPavilhao());
            pst.setString(9, objReqMatInter.getDescricaoCela());
            pst.setInt(10, codFunc);
            pst.setString(11, objReqMatInter.getObservacao());
            pst.setString(12, objReqMatInter.getUsuarioUp());
            pst.setString(13, objReqMatInter.getDataUp());
            pst.setString(14, objReqMatInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
    }

    public RequiscaoProdutosInternos excluirRequisicaoMaterialInternos(RequiscaoProdutosInternos objReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_PRODUTOS_INTERNOS_ENF WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
    }

    public RequiscaoProdutosInternos finalizarRequisicaoMaterialInternos(RequiscaoProdutosInternos objReqMatInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS_ENF SET StatusReq=? WHERE IdReq='" + objReqMatInter.getIdReq() + "'");
            pst.setString(1, objReqMatInter.getStatusReq());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR Requisição de materiais.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objReqMatInter;
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
