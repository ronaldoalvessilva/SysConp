/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AutoresRegimentoDisciplinar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAutorRegimeDisciplinar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AutoresRegimentoDisciplinar objAutor = new AutoresRegimentoDisciplinar();
    int codInterno, codCela, codPav;

    public AutoresRegimentoDisciplinar incluirAutorEventoDisciplinar(AutoresRegimentoDisciplinar objAutor) {
        pesquisarInternoRol(objAutor.getNomeInternoCrc());
        pesquisarPavilhao(objAutor.getDescricaoPavilhao());
        pesquisarCela(objAutor.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AUTORES_REGIMENTO_DISCIPLINAR (IdReg,IdInternoCrc,IdPav,IdCela,QtdeDias,UtilizaSaida,DataInicio,DataTermino,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");           
            pst.setInt(1, objAutor.getIdReg());
            pst.setInt(2, codInterno);
            pst.setInt(3, codPav);
            pst.setInt(4, codCela);
            pst.setFloat(5, objAutor.getQtdeDias());
            pst.setString(6, objAutor.getUtilizaSaida());
            pst.setTimestamp(7, new java.sql.Timestamp(objAutor.getDataInicio().getTime()));
            pst.setTimestamp(8, new java.sql.Timestamp(objAutor.getDataTermino().getTime()));
            pst.setString(9, objAutor.getUsuarioInsert());
            pst.setString(10, objAutor.getDataInsert());
            pst.setString(11, objAutor.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAutor;
    }

    public AutoresRegimentoDisciplinar alterarAutorEventoDisciplinar(AutoresRegimentoDisciplinar objAutor) {
        pesquisarInternoRol(objAutor.getNomeInternoCrc());
        pesquisarPavilhao(objAutor.getDescricaoPavilhao());
        pesquisarCela(objAutor.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUTORES_REGIMENTO_DISCIPLINAR SET IdReg=?,IdInternoCrc=?,IdPav=?,IdCela=?,QtdeDias=?,UtilizaSaida=?,DataInicio=?,DataTermino=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAutor='" + objAutor.getIdAutor() + "'");
            pst.setInt(1, objAutor.getIdReg());
            pst.setInt(2, codInterno);
            pst.setInt(3, codPav);
            pst.setInt(4, codCela);
            pst.setFloat(5, objAutor.getQtdeDias());
            pst.setString(6, objAutor.getUtilizaSaida());
            pst.setTimestamp(7, new java.sql.Timestamp(objAutor.getDataInicio().getTime()));
            pst.setTimestamp(8, new java.sql.Timestamp(objAutor.getDataTermino().getTime()));
            pst.setString(9, objAutor.getUsuarioUp());
            pst.setString(10, objAutor.getDataUp());
            pst.setString(11, objAutor.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAutor;
    }

    public AutoresRegimentoDisciplinar excluirAutorEventoDisciplinar(AutoresRegimentoDisciplinar objAutor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AUTORES_REGIMENTO_DISCIPLINAR WHERE IdAutor='" + objAutor.getIdAutor() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAutor;
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

    public void pesquisarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codPav = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarCela(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "'");
            conecta.rs.first();
            codCela = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
