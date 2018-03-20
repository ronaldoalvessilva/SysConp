/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TransferenciaProdutosLocal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleTransferenciaProdutos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaProdutosLocal objTransfProd = new TransferenciaProdutosLocal();

    int idLocalOrigem, idFunc;

    public TransferenciaProdutosLocal incluirTransferenciaProduto(TransferenciaProdutosLocal objTransfProd) {
        buscarLocalOrigem(objTransfProd.getNomeLocal());
        buscarColaborador(objTransfProd.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRANSFERENCIA_PRODUTO_FAR (StatusLanc,DataLanc,IdLocal,IdFunc,IdReqEnf,IdLocalDst,DescricaoLocalDestino,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objTransfProd.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTransfProd.getDataLanc().getTime()));
            pst.setInt(3, idLocalOrigem);
            pst.setInt(4, idFunc);
            pst.setInt(5, objTransfProd.getIdRequisicaoEnfermaria());
            pst.setInt(6, objTransfProd.getIdLocalDst());
            pst.setString(7, objTransfProd.getDescricaoLocalDestino());
            pst.setString(8, objTransfProd.getObservacao());
            pst.setString(9, objTransfProd.getUsuarioInsert());
            pst.setString(10, objTransfProd.getDataInsert());
            pst.setString(11, objTransfProd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransfProd;
    }

    public TransferenciaProdutosLocal alterarTransferenciaProduto(TransferenciaProdutosLocal objTransfProd) {
        buscarLocalOrigem(objTransfProd.getNomeLocal());
        buscarColaborador(objTransfProd.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIA_PRODUTO_FAR SET StatusLanc=?,DataLanc=?,IdLocal=?,IdFunc=?,IdReqEnf=?,IdLocalDst=?,DescricaoLocalDestino=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objTransfProd.getIdLanc() + "'");
            pst.setString(1, objTransfProd.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objTransfProd.getDataLanc().getTime()));
            pst.setInt(3, idLocalOrigem);
            pst.setInt(4, idFunc);
            pst.setInt(5, objTransfProd.getIdRequisicaoEnfermaria());
            pst.setInt(6, objTransfProd.getIdLocalDst());
            pst.setString(7, objTransfProd.getDescricaoLocalDestino());
            pst.setString(8, objTransfProd.getObservacao());
            pst.setString(9, objTransfProd.getUsuarioUp());
            pst.setString(10, objTransfProd.getDataUp());
            pst.setString(11, objTransfProd.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransfProd;
    }

    public TransferenciaProdutosLocal excluirTransferenciaProduto(TransferenciaProdutosLocal objTransfProd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TRANSFERENCIA_PRODUTO_FAR WHERE IdLanc='" + objTransfProd.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransfProd;
    }

    public TransferenciaProdutosLocal finalizarTransferenciaProduto(TransferenciaProdutosLocal objTransfProd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIA_PRODUTO_FAR SET StatusLanc=? WHERE IdLanc='" + objTransfProd.getIdLanc() + "'");
            pst.setString(1, objTransfProd.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTransfProd;
    }

    public void buscarLocalOrigem(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + desc + "'");
            conecta.rs.first();
            idLocalOrigem = conecta.rs.getInt("IdLocal");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (LOCAL) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarColaborador(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + desc + "'");
            conecta.rs.first();
            idFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (COLABORADOR) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
