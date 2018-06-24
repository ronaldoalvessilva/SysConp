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
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PRE_LOCACAO_INTERNOS (CodigoReg,IdInternoCrc,IdPav,IdEntrada,TipoPesq,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPreLocacao.getCodigoReg());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setInt(4, objItensPreLocacao.getIdEntrada());
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

    public ItensPreLocacao alterarItensPreLocacaoInternos(ItensPreLocacao objItensPreLocacao) {
        buscarPavilhao(objItensPreLocacao.getDescricaoPavilhao());
        buscarInternoCrc(objItensPreLocacao.getNomeInternoCrc(), objItensPreLocacao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRE_LOCACAO_INTERNOS SET CodigoReg=?,IdInternoCrc=?,IdPav=?,IdEntrada=?,TipoPesq=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensPreLocacao.getIdItem() + "'");
            pst.setInt(1, objItensPreLocacao.getCodigoReg());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setInt(4, objItensPreLocacao.getIdEntrada());
            pst.setInt(5, objItensPreLocacao.getTipoPesquisa());
            pst.setString(6, objItensPreLocacao.getUsuarioUp());
            pst.setString(7, objItensPreLocacao.getDataUp());
            pst.setString(8, objItensPreLocacao.getHorarioUp());
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
