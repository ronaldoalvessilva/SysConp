/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPreLocacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePreLocacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPreLocacao objItensPreLocacao = new ItensPreLocacao();
    int codUnid;
    int codInt;

    public ItensPreLocacao incluirItensPreLocacaoInternos(ItensPreLocacao objItensPreLocacao) {
        buscarPavilhao(objItensPreLocacao.getDescricaoPavilhao());
        buscarInternoCrc(objItensPreLocacao.getNomeInternoCrc(), objItensPreLocacao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PRE_LOCACAO_INTERNOS (CodigoReg,IdInternoCrc,IdPav,IdEntrada,TipoPesq,Confirmacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPreLocacao.getCodigoReg());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setInt(4, objItensPreLocacao.getIdEntrada());
            pst.setInt(5, objItensPreLocacao.getTipoPesquisa());
            pst.setString(6, objItensPreLocacao.getConfirmacao());
            pst.setString(7, objItensPreLocacao.getUsuarioInsert());
            pst.setString(8, objItensPreLocacao.getDataInsert());
            pst.setString(9, objItensPreLocacao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    public ItensPreLocacao alterarItensPreLocacaoInternos(ItensPreLocacao objItensPreLocacao) {
        buscarPavilhao(objItensPreLocacao.getDescricaoPavilhao());
        buscarInternoCrc(objItensPreLocacao.getNomeInternoCrc(), objItensPreLocacao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRE_LOCACAO_INTERNOS SET CodigoReg=?,IdInternoCrc=?,IdPav=?,IdEntrada=?,TipoPesq=?,Confirmacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensPreLocacao.getIdItem() + "'");
            pst.setInt(1, objItensPreLocacao.getCodigoReg());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setInt(4, objItensPreLocacao.getIdEntrada());
            pst.setInt(5, objItensPreLocacao.getTipoPesquisa());
            pst.setString(6, objItensPreLocacao.getConfirmacao());
            pst.setString(7, objItensPreLocacao.getUsuarioUp());
            pst.setString(8, objItensPreLocacao.getDataUp());
            pst.setString(9, objItensPreLocacao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    public ItensPreLocacao excluirItensPreLocacaoInternos(ItensPreLocacao objItensPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PRE_LOCACAO_INTERNOS WHERE IdItem='" + objItensPreLocacao.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    public ItensPreLocacao incluirItensExportacaoLocacaoInternos(ItensPreLocacao objItensPreLocacao) {
        buscarPavilhao(objItensPreLocacao.getDescricaoPavilhao());
        buscarInternoCrc(objItensPreLocacao.getNomeInternoCrc(), objItensPreLocacao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_EXPORTADO_LOCACAO_INTERNOS (CodigoReg,IdInternoCrc,IdPav,ConfirmacaoBase,TipoPesq,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPreLocacao.getCodigoReg());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setString(4, objItensPreLocacao.getConfirmacao());
            pst.setInt(5, objItensPreLocacao.getTipoPesquisa());
            pst.setString(6, objItensPreLocacao.getUsuarioInsert());
            pst.setString(7, objItensPreLocacao.getDataInsert());
            pst.setString(8, objItensPreLocacao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    // CONFIRMAR QUE O INTERNO FOI LOCADO ATRAVES DA BASE I E BASE II
    public ItensPreLocacao confirmarLocacaoInternosPavilhao(ItensPreLocacao objItensPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_EXPORTADO_LOCACAO_INTERNOS SET ConfirmaBase=? WHERE IdInternoCrc='" + objItensPreLocacao.getIdInternoCrc() + "'");
            pst.setString(1, objItensPreLocacao.getConfirmacao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    public ItensPreLocacao confirmcaoPreLocacaoInternos(ItensPreLocacao objItensPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRE_LOCACAO_INTERNOS SET Confirmacao=? WHERE CodigoReg='" + objItensPreLocacao.getIdEntrada() + "'AND IdInternoCrc='" + objItensPreLocacao.getIdInternoCrc() + "'");
            pst.setString(1, objItensPreLocacao.getConfirmacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    public ItensPreLocacao confirmcaoPreLocacaoInternosEntrada(ItensPreLocacao objItensPreLocacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADA SET ConfirmaUtil=? WHERE IdEntrada='" + objItensPreLocacao.getIdEntrada() + "'AND IdInternoCrc='" + objItensPreLocacao.getIdInternoCrc() + "'");
            pst.setString(1, objItensPreLocacao.getConfirmaUtil());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPreLocacao;
    }

    public void buscarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PAVILHÃO) a serem exibidos!!!");
        }
        conecta.desconecta();
    }

    public void buscarInternoCrc(String nomeInterno, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nomeInterno + "' "
                    + "AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido!!!\nERROR: " + e);
        }
        conecta.desconecta();
    }
}
