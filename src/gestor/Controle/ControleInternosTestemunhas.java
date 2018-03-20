/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InternosTestemunha;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleInternosTestemunhas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InternosTestemunha objIntTeste = new InternosTestemunha();

    int codInterno;

    public InternosTestemunha incluirInternoTestemunha(InternosTestemunha objIntTeste) {
        pesquisarInternoTestemunha(objIntTeste.getNomeInternoTestemunha());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOTESTEMUNHA (IdLanc,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objIntTeste.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntTeste.getUsuarioInsert());
            pst.setString(4, objIntTeste.getDataInsert());
            pst.setString(5, objIntTeste.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntTeste;
    }

    public InternosTestemunha alterarInternoTestemunha(InternosTestemunha objIntTeste) {
        pesquisarInternoTestemunha(objIntTeste.getNomeInternoTestemunha());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOTESTEMUNHA SET IdLanc=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=?  WHERE IdIntTeste='" + objIntTeste.getIdIntTeste() + "'");
            pst.setInt(1, objIntTeste.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntTeste.getUsuarioUp());
            pst.setString(4, objIntTeste.getDataUp());
            pst.setString(5, objIntTeste.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntTeste;
    }

    public InternosTestemunha excluirInternoTestemunha(InternosTestemunha objIntTeste) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOTESTEMUNHA WHERE IdIntTeste='" + objIntTeste.getIdIntTeste() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntTeste;
    }

    public void pesquisarInternoTestemunha(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
