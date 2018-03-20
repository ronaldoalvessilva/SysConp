/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensBaixaInternos;
import gestor.Modelo.ItensInternosMatriculado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensBaixaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensBaixaInternos objItensBaixa = new ItensBaixaInternos();
    ItensInternosMatriculado objItensMat = new ItensInternosMatriculado();
    int codInterno;

    public ItensBaixaInternos incluirItensBaixaInternos(ItensBaixaInternos objItensBaixa) {
        buscarInterno(objItensBaixa.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSBAIXAINTERNOS (IdLanc,IdInternoCrc,Motivo,Bloqueado,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objItensBaixa.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objItensBaixa.getMotivo());
            pst.setString(4, objItensBaixa.getBloqueio());
            pst.setString(5, objItensBaixa.getUsuarioInsert());
            pst.setString(6, objItensBaixa.getDataInsert());
            pst.setString(7, objItensBaixa.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensBaixa;
    }

    public ItensBaixaInternos alterarItensBaixaInternos(ItensBaixaInternos objItensBaixa) {
        buscarInterno(objItensBaixa.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSBAIXAINTERNOS SET IdLanc=?,IdInternoCrc=?,Motivo=?,Bloqueado=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensBaixa.getIdItem() + "'");
            pst.setInt(1, objItensBaixa.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objItensBaixa.getMotivo());
            pst.setString(4, objItensBaixa.getBloqueio());
            pst.setString(5, objItensBaixa.getUsuarioUp());
            pst.setString(6, objItensBaixa.getDataUp());
            pst.setString(7, objItensBaixa.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensBaixa;
    }

    public ItensBaixaInternos excluirItensBaixaInternos(ItensBaixaInternos objItensBaixa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSBAIXAINTERNOS WHERE IdItem='" + objItensBaixa.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensBaixa;
    }

    // Confirmar bloquio de internos na frequência

    public ItensInternosMatriculado confirmarBloqueioBaixaInternos(ItensInternosMatriculado objItensMat) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSMATRICULA SET Bloqueio=? WHERE IdInternoCrc='" + objItensMat.getIdInternoCrc() + "'AND IdMat='" + objItensMat.getIdMat() + "'");
            pst.setString(1, objItensMat.getBloqueio());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel BLOQUEAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensMat;
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do interno a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
