/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensFichaAtivLaborativa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensFichaAtivLaborativa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensFichaAtivLaborativa objItensFichaLab = new ItensFichaAtivLaborativa();
    int codInterno;

    public ItensFichaAtivLaborativa incluirItensFichaAtivLabo(ItensFichaAtivLaborativa objItensFichaLab) {
        buscarInterno(objItensFichaLab.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSFICHALAB (IdLanc,IdInternoCrc,DataInicio,DataTermino,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objItensFichaLab.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensFichaLab.getDataInicio().getTime()));
            if (objItensFichaLab.getDataTermino() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensFichaLab.getDataTermino().getTime()));
            } else {
                pst.setString(4, null);
            }
            pst.setString(5, objItensFichaLab.getUsuarioInsert());
            pst.setString(6, objItensFichaLab.getDataInsert());
            pst.setString(7, objItensFichaLab.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFichaLab;
    }

    public ItensFichaAtivLaborativa alterarItensFichaAtivLabo(ItensFichaAtivLaborativa objItensFichaLab) {
        buscarInterno(objItensFichaLab.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSFICHALAB SET IdLanc=?,IdInternoCrc=?,DataInicio=?,DataTermino=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensFichaLab.getIdItem() + "'");
            pst.setInt(1, objItensFichaLab.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensFichaLab.getDataInicio().getTime()));
            if (objItensFichaLab.getDataTermino() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensFichaLab.getDataTermino().getTime()));
            } else {
                pst.setString(4, null);
            }
            pst.setString(5, objItensFichaLab.getUsuarioUp());
            pst.setString(6, objItensFichaLab.getDataUp());
            pst.setString(7, objItensFichaLab.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFichaLab;
    }

    public ItensFichaAtivLaborativa excluirItensFichaAtivLabo(ItensFichaAtivLaborativa objItensFichaLab) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSFICHALAB WHERE IdItem='" + objItensFichaLab.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensFichaLab;
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PRONTUARIO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
