/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoMedica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEvolucaoMedica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoMedica objEvolMedica = new EvolucaoMedica();
    int codInterno;

    public EvolucaoMedica incluirEvolucaoMedica(EvolucaoMedica objEvolMedica) {
        buscarInterno(objEvolMedica.getNomeInternoEvoluMedica());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOMEDICA (DataEvolu,IdLanc,IdInternoCrc,TextoEvolucao,UsuarioInsert,DataInsert,HorarioInsert,HipoteseDiagnostica,ExamesSolicitados,Patologia) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolMedica.getDataEvolu().getTime()));
            pst.setInt(2, objEvolMedica.getIdLanc());
            pst.setInt(3, codInterno);
            pst.setString(4, objEvolMedica.getTextoEvolucao());
            pst.setString(5, objEvolMedica.getUsuarioInsert());
            pst.setString(6, objEvolMedica.getDataInsert());
            pst.setString(7, objEvolMedica.getHoraInsert());
            pst.setString(8, objEvolMedica.getHipoteseDiagnostica());
            pst.setString(9, objEvolMedica.getExamesSolicitados());
            pst.setString(10, objEvolMedica.getPatologiaAdquiridaMedica());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
    }

    public EvolucaoMedica alterarEvolucaoMedica(EvolucaoMedica objEvolMedica) {
        buscarInterno(objEvolMedica.getNomeInternoEvoluMedica());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOMEDICA SET DataEvolu=?,IdLanc=?,IdInternoCrc=?,TextoEvolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,HipoteseDiagnostica=?,ExamesSolicitados=?,Patologia=? WHERE IdLanc='" + objEvolMedica.getIdLanc() + "'AND IdItem='" + objEvolMedica.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvolMedica.getDataEvolu().getTime()));
            pst.setInt(2, objEvolMedica.getIdLanc());
            pst.setInt(3, codInterno);
            pst.setString(4, objEvolMedica.getTextoEvolucao());
            pst.setString(5, objEvolMedica.getUsuarioUp());
            pst.setString(6, objEvolMedica.getDataUp());
            pst.setString(7, objEvolMedica.getHoraUp());
            pst.setString(8, objEvolMedica.getHipoteseDiagnostica());
            pst.setString(9, objEvolMedica.getExamesSolicitados());
            pst.setString(10, objEvolMedica.getPatologiaAdquiridaMedica());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
    }

    public EvolucaoMedica excluirEvolucaoMedica(EvolucaoMedica objEvolMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAOMEDICA WHERE IdLanc='" + objEvolMedica.getIdLanc() + "'AND IdItem='" + objEvolMedica.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
    }

    public EvolucaoMedica FinalizarEvolucaoMedica(EvolucaoMedica objEvolMedica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOMEDICA SET StatusLanc=? WHERE IdLanc='" + objEvolMedica.getIdLanc() + "'");
            pst.setString(1, objEvolMedica.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvolMedica;
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
