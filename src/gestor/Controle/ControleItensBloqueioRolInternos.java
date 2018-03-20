/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensBloqueioRolInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensBloqueioRolInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensBloqueioRolInternos objItensBloq = new ItensBloqueioRolInternos();

    int codInt;

    public ItensBloqueioRolInternos incluirItensListaInternos(ItensBloqueioRolInternos objItensBloq) {
        buscarInternoCrc(objItensBloq.getNomeInternoCrc(), objItensBloq.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL (IdCan,IdInternoCrc,StatusVisita,DataBloqueio,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensBloq.getIdCan());
            pst.setInt(2, codInt);
            pst.setString(3, objItensBloq.getStatusVisita());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensBloq.getDataBloqueio().getTime()));
            pst.setString(5, objItensBloq.getMotivoBloqueio());
            pst.setString(6, objItensBloq.getUsuarioInsert());
            pst.setString(7, objItensBloq.getDataInsert());
            pst.setString(8, objItensBloq.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensBloq;
    }

    public ItensBloqueioRolInternos alterarItensListaInternos(ItensBloqueioRolInternos objItensBloq) {
        buscarInternoCrc(objItensBloq.getNomeInternoCrc(), objItensBloq.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL SET IdCan=?,IdInternoCrc=?,StatusVisita=?,DataBloqueio=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemCanInt='" + objItensBloq.getIdItemCanInt() + "'");
            pst.setInt(1, objItensBloq.getIdCan());
            pst.setInt(2, codInt);
            pst.setString(3, objItensBloq.getStatusVisita());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensBloq.getDataBloqueio().getTime()));
            pst.setString(5, objItensBloq.getMotivoBloqueio());
            pst.setString(5, objItensBloq.getUsuarioUp());
            pst.setString(6, objItensBloq.getDataUp());
            pst.setString(7, objItensBloq.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensBloq;
    }

    public ItensBloqueioRolInternos excluirItensListaInternos(ItensBloqueioRolInternos objItensBloq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL WHERE IdItemCanInt='" + objItensBloq.getIdItemCanInt() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensBloq;
    }

    public ItensBloqueioRolInternos alterarItensRolInterno(ItensBloqueioRolInternos objItensBloq) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_LISTA_ROL SET StatusInterna=? WHERE IdInternoCrc='" + objItensBloq.getIdInternoCrc() + "'");
            pst.setString(1, objItensBloq.getStatusVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItensBloq;
    }

    public void buscarInternoCrc(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
