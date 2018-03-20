/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoEducacionalLaboral;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleHistoricoLaborativo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoEducacionalLaboral objHistEducLabor = new HistoricoEducacionalLaboral();

    int codInterno;

    public HistoricoEducacionalLaboral incluirHistoricoLabor(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarInterno(objHistEducLabor.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TO_HISTORICO_PROFISSIONAL (IdLanc,IdInternoCrc,TemProfissao,QualProfissao,ExperienciaProfissional,QualExperienciaProfissional,DesejaTrabalharUnid,UsuarioInsert,DataInsert,HorarioInsert,InteresseLabor) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objHistEducLabor.getIdAtend());
            pst.setInt(2, codInterno);
            pst.setString(3, objHistEducLabor.getTemProfissao());
            pst.setString(4, objHistEducLabor.getQualProfissao());
            pst.setString(5, objHistEducLabor.getExperienciaProfissional());
            pst.setString(6, objHistEducLabor.getQualExperienciaProfissional());
            pst.setString(7, objHistEducLabor.getDesejaTrabalharUnid());
            pst.setString(8, objHistEducLabor.getUsuarioInsert());
            pst.setString(9, objHistEducLabor.getDataInsert());
            pst.setString(10, objHistEducLabor.getHorarioInsert());
            pst.setInt(11, objHistEducLabor.getTipoRemuneracao());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados. (TO_HISTORICO_PROFISSIONAL)\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public HistoricoEducacionalLaboral alterarHistoricoLabor(HistoricoEducacionalLaboral objHistEducLabor) {
        buscarInterno(objHistEducLabor.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TO_HISTORICO_PROFISSIONAL SET IdLanc=?,IdInternoCrc=?,TemProfissao=?,QualProfissao=?,ExperienciaProfissional=?,QualExperienciaProfissional=?,DesejaTrabalharUnid=?,UsuarioUp=?,DataUp=?,HorarioUp=?,InteresseLabor=? WHERE IdHistoricoLab='" + objHistEducLabor.getIdHistoricoLab() + "'");
            pst.setInt(1, objHistEducLabor.getIdAtend());
            pst.setInt(2, codInterno);
            pst.setString(3, objHistEducLabor.getTemProfissao());
            pst.setString(4, objHistEducLabor.getQualProfissao());
            pst.setString(5, objHistEducLabor.getExperienciaProfissional());
            pst.setString(6, objHistEducLabor.getQualExperienciaProfissional());
            pst.setString(7, objHistEducLabor.getDesejaTrabalharUnid());
            pst.setString(8, objHistEducLabor.getUsuarioUp());
            pst.setString(9, objHistEducLabor.getDataUp());
            pst.setString(10, objHistEducLabor.getHorarioUp());
            pst.setInt(11, objHistEducLabor.getTipoRemuneracao());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados. (TO_HISTORICO_PROFISSIONAL)\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
    }

    public HistoricoEducacionalLaboral excluirHistoricoLabor(HistoricoEducacionalLaboral objHistEducLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TO_HISTORICO_PROFISSIONAL WHERE IdHistoricoLab='" + objHistEducLabor.getIdHistoricoLab() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados. (TO_HISTORICO_PROFISSIONAL)\nERRO: " + e);
        }
        conecta.desconecta();
        return objHistEducLabor;
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
