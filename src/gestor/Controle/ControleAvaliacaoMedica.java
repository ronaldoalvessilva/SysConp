/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AvaliacaoMedica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAvaliacaoMedica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AvaliacaoMedica objAvalia = new AvaliacaoMedica();

    int codInterno;

    public AvaliacaoMedica incluirAvaliacaoMedica(AvaliacaoMedica objAvalia) {
        buscarInterno(objAvalia.getNomeInterno(),objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALIACAO_MEDICA_PSIQUIATRICA (StatusAval,DataAval,IdInternoCrc,TextoAvaliacao,UsuarioInsert,DataInsert,HorarioInsert,Fonte,Tamanho,BtEsq,BtCen,BtDir,BtJus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAvalia.getStatusAval());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvalia.getDataAval().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAvalia.getTextoAvaliacao());
            pst.setString(5, objAvalia.getUsuarioInsert());
            pst.setString(6, objAvalia.getDataInsert());
            pst.setString(7, objAvalia.getHorarioInsert());
            pst.setString(8, objAvalia.getFonte());
            pst.setString(9, objAvalia.getTamanho());
            pst.setInt(10, objAvalia.getBtesq());
            pst.setInt(11, objAvalia.getBtCen());
            pst.setInt(12, objAvalia.getBtDir());
            pst.setInt(13, objAvalia.getBtJus());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AvaliacaoMedica alterarAvaliacaoMedica(AvaliacaoMedica objAvalia) {
        buscarInterno(objAvalia.getNomeInterno(),objAvalia.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAO_MEDICA_PSIQUIATRICA SET StatusAval=?,DataAval=?,IdInternoCrc=?,TextoAvaliacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Fonte=?,Tamanho=?,BtEsq=?,BtCen=?,BtDir=?,BtJus=? WHERE IdAvalia='" + objAvalia.getIdAvalia() + "'");
            pst.setString(1, objAvalia.getStatusAval());
            pst.setTimestamp(2, new java.sql.Timestamp(objAvalia.getDataAval().getTime()));
            pst.setInt(3, codInterno);
            pst.setString(4, objAvalia.getTextoAvaliacao());
            pst.setString(5, objAvalia.getUsuarioUp());
            pst.setString(6, objAvalia.getDataUp());
            pst.setString(7, objAvalia.getHorarioUp());
            pst.setString(8, objAvalia.getFonte());
            pst.setString(9, objAvalia.getTamanho());
            pst.setInt(10, objAvalia.getBtesq());
            pst.setInt(11, objAvalia.getBtCen());
            pst.setInt(12, objAvalia.getBtDir());
            pst.setInt(13, objAvalia.getBtJus());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AvaliacaoMedica excluiAvaliacaoMedica(AvaliacaoMedica objAvalia) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALIACAO_MEDICA_PSIQUIATRICA WHERE IdAvalia='" + objAvalia.getIdAvalia() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUI os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public AvaliacaoMedica finalizarAvaliacaoMedica(AvaliacaoMedica objAvalia) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAO_MEDICA_PSIQUIATRICA SET StatusAval=? WHERE IdAvalia='" + objAvalia.getIdAvalia() + "'");
            pst.setString(1, objAvalia.getStatusAval());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAvalia;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
