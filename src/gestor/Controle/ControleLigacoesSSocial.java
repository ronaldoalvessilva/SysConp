/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ControleLigacoes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleLigacoesSSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleLigacoes objConLiga = new ControleLigacoes();
    int codInt;

    public ControleLigacoes incluirLigacoes(ControleLigacoes objConLiga) {
        buscarInterno(objConLiga.getNomeInterno());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONTROLIGA (DataControl,IdInternoCrc,StatusControl,TelefoneControl,TempoControl,LocalLigacao,ObsControl,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objConLiga.getDataControl().getTime()));
            pst.setInt(2, codInt);
            pst.setString(3, objConLiga.getStatusLigacao());
            pst.setString(4, objConLiga.getTelefoneControl());
            pst.setString(5, objConLiga.getTempoControl());
            pst.setString(6, objConLiga.getLocalLigacao());
            pst.setString(7, objConLiga.getObsControl());
            pst.setString(8, objConLiga.getUsuarioInsert());
            pst.setString(9, objConLiga.getDataInsert());
            pst.setString(10, objConLiga.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objConLiga;
    }

    public ControleLigacoes alterarLigacoes(ControleLigacoes objConLiga) {
        buscarInterno(objConLiga.getNomeInterno());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTROLIGA SET DataControl=?,IdInternoCrc=?,StatusControl=?,TelefoneControl=?,TempoControl=?,LocalLigacao=?,ObsControl=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdControl='" + objConLiga.getIdControl() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objConLiga.getDataControl().getTime()));
            pst.setInt(2, codInt);
            pst.setString(3, objConLiga.getStatusLigacao());
            pst.setString(4, objConLiga.getTelefoneControl());
            pst.setString(5, objConLiga.getTempoControl());
            pst.setString(6, objConLiga.getLocalLigacao());
            pst.setString(7, objConLiga.getObsControl());
            pst.setString(8, objConLiga.getUsuarioUp());
            pst.setString(9, objConLiga.getDataUp());
            pst.setString(10, objConLiga.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objConLiga;
    }

    public ControleLigacoes excluirLigacoes(ControleLigacoes objConLiga) {        

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CONTROLIGA WHERE IdControl='" + objConLiga.getIdControl() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objConLiga;
    }
 public ControleLigacoes finalizarLigacoes(ControleLigacoes objConLiga) {        

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTROLIGA SET StatusControl=? WHERE IdControl='" + objConLiga.getIdControl() + "'");
            pst.setString(1, objConLiga.getStatusLigacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR controle da ligação\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objConLiga;
    }
    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
