/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensLocacaoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensLocacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensLocacaoInternos objItensLoca = new ItensLocacaoInternos();
    int codInterno;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    int qtd = 1;

    public ItensLocacaoInternos incluirInternoLocacao(ItensLocacaoInternos objItensLoca) {
        buscarInternoCrc(objItensLoca.getNomeInterno(), objItensLoca.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSLOCACAOINTERNO (IdLoca,IdInternoCrc,IdCela,QtdLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objItensLoca.getIdLoca());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensLoca.getIdCela());
            pst.setInt(4, qtd);
            pst.setString(5, objItensLoca.getUsuarioInsert());
            pst.setString(6, objItensLoca.getDataInsert());
            pst.setString(7, objItensLoca.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public ItensLocacaoInternos alterarInternoLocacao(ItensLocacaoInternos objItensLoca) {
        buscarInternoCrc(objItensLoca.getNomeInterno(), objItensLoca.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLOCACAOINTERNO SET IdLoca=?,IdInternoCrc=?,IdCela=?,QtdLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensLoca.getIdItem() + "'");
            pst.setInt(1, objItensLoca.getIdLoca());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensLoca.getIdCela());
            pst.setInt(4, qtd);
            pst.setString(5, objItensLoca.getUsuarioUp());
            pst.setString(6, objItensLoca.getDataUp());
            pst.setString(7, objItensLoca.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public ItensLocacaoInternos excluirInternoLocacao(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSLOCACAOINTERNO WHERE IdItem='" + objItensLoca.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    // Excluir o interno da cela quando sair da portaria

    public ItensLocacaoInternos deletarInternoLocacaoSaida(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSLOCACAOINTERNO WHERE IdInternoCrc='" + objItensLoca.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR o Interno da Cela.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
//            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'AND SituacaoCrc='" + situacaoEnt + "' OR NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'AND SituacaoCrc='" + situacaoRet + "'");
             conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "' AND SituacaoCrc='" + situacaoEnt  + "'OR NomeInternoCrc='" +  desc  +"'AND IdInternoCrc='" + codigo  + "'AND SituacaoCrc='" + situacaoRet + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
