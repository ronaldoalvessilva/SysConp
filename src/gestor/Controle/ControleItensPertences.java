/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensPertences {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPertences objItensPert = new ItensPertences();
    int codPertence;
    int codInterno;
    int codVisita;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";

    public ItensPertences incluirItensPertences(ItensPertences objItensPert) {
//        buscarVisitas(objItensPert.getNomeVisita());
//        buscarInterno(objItensPert.getNomeInterno());
        buscarPertences(objItensPert.getDescrcaoPertence());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSPERTENCES (Idlanc,IdInternoCrc,IdPertence,IdVisita,UndPertence,QtdPertence,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPert.getIdLanc());
            pst.setInt(2, objItensPert.getIdInternoCrc());
            pst.setInt(3, codPertence);
            pst.setInt(4, objItensPert.getIdVisita());
            pst.setString(5, objItensPert.getUndPertence());
            pst.setInt(6, objItensPert.getQtdPertence());
            pst.setString(7, objItensPert.getUsuarioInsert());
            pst.setString(8, objItensPert.getDataInsert());
            pst.setString(9, objItensPert.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPert;
    }

    public ItensPertences alterarItensPertences(ItensPertences objItensPert) {
     //   buscarVisitas(objItensPert.getNomeVisita());
//        buscarInterno(objItensPert.getNomeInterno());
        buscarPertences(objItensPert.getDescrcaoPertence());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSPERTENCES SET Idlanc=?,IdInternoCrc=?,IdPertence=?,IdVisita=?,UndPertence=?,QtdPertence=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensPert.getIdItem() + "'");
            pst.setInt(1, objItensPert.getIdLanc());
            pst.setInt(2, objItensPert.getIdInternoCrc());
            pst.setInt(3, codPertence);
            pst.setInt(4, objItensPert.getIdVisita());
            pst.setString(5, objItensPert.getUndPertence());
            pst.setInt(6, objItensPert.getQtdPertence());
            pst.setString(7, objItensPert.getUsuarioUp());
            pst.setString(8, objItensPert.getDataUp());
            pst.setString(9, objItensPert.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPert;
    }

    public ItensPertences excluirItensPertences(ItensPertences objItensPert) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSPERTENCES WHERE IdItem='" + objItensPert.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPert;
    }

    public void buscarPertences(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PERTENCES WHERE DescricaoPertence='" + nome + "'");
            conecta.rs.first();
            codPertence = conecta.rs.getInt("IdPertence");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PERTENCE) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND SituacaoCrc='" + situacaoEnt + "' OR NomeInternoCrc='" + desc + "' AND SituacaoCrc='" + situacaoRet + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarVisitas(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + nome + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (VISITA) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
