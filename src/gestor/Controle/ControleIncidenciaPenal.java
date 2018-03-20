/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IncidenciaPenal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleIncidenciaPenal {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IncidenciaPenal objIncid = new IncidenciaPenal();

    int codAmparo;

    public IncidenciaPenal incluirIncidenciaPenal(IncidenciaPenal objIncid) {
        buscarAmparo(objIncid.getIdAmparo(), objIncid.getDescricaoAmparo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INCIDENCIA_PENAL (IdFicha,IdLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");           
            pst.setInt(1, objIncid.getIdFicha());
            pst.setInt(2, codAmparo);
            pst.setString(3, objIncid.getUsuarioInsert());
            pst.setString(4, objIncid.getDataInsert());
            pst.setString(5, objIncid.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIncid;
    }

    public IncidenciaPenal alterarIncidenciaPenal(IncidenciaPenal objIncid) {
        buscarAmparo(objIncid.getIdAmparo(), objIncid.getDescricaoAmparo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INCIDENCIA_PENAL SET IdFicha=?,IdLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInc='" + objIncid.getIdInc() + "'");           
            pst.setInt(1, objIncid.getIdFicha());
            pst.setInt(2, codAmparo);
            pst.setString(3, objIncid.getUsuarioUp());
            pst.setString(4, objIncid.getDataUp());
            pst.setString(5, objIncid.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIncid;
    }

    public IncidenciaPenal excluirIncidenciaPenal(IncidenciaPenal objIncid) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INCIDENCIA_PENAL WHERE IdInc='" + objIncid.getIdInc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIncid;
    }

    public void buscarAmparo(int codigo, String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AMPARO_LEGAL WHERE IdLanc='" + codigo + "'AND DescricaoAmparoLegal='" + desc + "'");
            conecta.rs.first();
            codAmparo = conecta.rs.getInt("IdLanc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
