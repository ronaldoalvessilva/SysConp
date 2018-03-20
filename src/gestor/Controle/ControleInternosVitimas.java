/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AutorEventos;
import gestor.Modelo.InternosVitimas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleInternosVitimas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InternosVitimas objIntVitima = new InternosVitimas();
    int codInterno;

    public InternosVitimas incluirInternoVitima(InternosVitimas objIntVitima) {
        pesquisarInternoRol(objIntVitima.getNomeInternoVitima());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOSVITIMAS (IdLanc,IdInternoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objIntVitima.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntVitima.getUsuarioInsert());
            pst.setString(4, objIntVitima.getDataInsert());
            pst.setString(5, objIntVitima.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntVitima;
    }

    public InternosVitimas alterarInternoVitima(InternosVitimas objIntVitima) {
        pesquisarInternoRol(objIntVitima.getNomeInternoVitima());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOSVITIMAS SET IdLanc=?,IdInternoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=?  WHERE IdIntVitima='" + objIntVitima.getIdIntVitima() + "'");
            pst.setInt(1, objIntVitima.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntVitima.getUsuarioUp());
            pst.setString(4, objIntVitima.getDataUp());
            pst.setString(5, objIntVitima.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntVitima;
    }

    public InternosVitimas excluirInternoVitima(InternosVitimas objIntVitima) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOSVITIMAS WHERE IdIntVitima='" + objIntVitima.getIdIntVitima() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objIntVitima;
    }

    public void pesquisarInternoRol(String nome) {
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
