/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Audiencias;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAudiencias {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Audiencias objAudien = new Audiencias();
    int codInt;

    public Audiencias incluirAudiencias(Audiencias objAudien) {
        buscarInterno(objAudien.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AUDIENCIAS (StatusLanc,DataLanc,IdInternoCrc,TipoJust,Justificativa,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objAudien.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAudien.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAudien.getTipoJust());
            pst.setString(5, objAudien.getJustificativa());
            pst.setString(6, objAudien.getUsuarioInsert());
            pst.setString(7, objAudien.getDataInsert());
            pst.setString(8, objAudien.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAudien;
    }

    public Audiencias alterarAudiencias(Audiencias objAudien) {
        buscarInterno(objAudien.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUDIENCIAS SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,TipoJust=?,Justificativa=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objAudien.getIdLanc() + "'");
            pst.setString(1, objAudien.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAudien.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAudien.getTipoJust());
            pst.setString(5, objAudien.getJustificativa());
            pst.setString(6, objAudien.getUsuarioUp());
            pst.setString(7, objAudien.getDataUp());
            pst.setString(8, objAudien.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAudien;
    }

    public Audiencias excluirAudiencias(Audiencias objAudien) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AUDIENCIAS WHERE IdLanc='" + objAudien.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAudien;
    }

    public Audiencias finalizarAudiencias(Audiencias objAudien) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUDIENCIAS SET StatusLanc=? WHERE IdLanc='" + objAudien.getIdLanc() + "'");
            pst.setString(1, objAudien.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAudien;
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da interno a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
