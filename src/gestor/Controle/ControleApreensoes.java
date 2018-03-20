/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Apreensoes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleApreensoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Apreensoes objApre = new Apreensoes();

    int codInterno, codObjeto;

    public Apreensoes incluirApreensoes(Apreensoes objApre) {
        pesquisarInternoTestemunha(objApre.getNomeInternoApreensoes());
        pesquisarObjetosApreendido(objApre.getDescricaoObjeto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APRENSSOES (IdLanc,IdInternoCrc,IdObjeto,Qtd,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objApre.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setInt(3, codObjeto);
            pst.setFloat(4, objApre.getQtdEncontrada());
            pst.setString(5, objApre.getUsuarioInsert());
            pst.setString(6, objApre.getDataInsert());
            pst.setString(7, objApre.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApre;
    }

    public Apreensoes alterarApreensoes(Apreensoes objApre) {
        pesquisarInternoTestemunha(objApre.getNomeInternoApreensoes());
        pesquisarObjetosApreendido(objApre.getDescricaoObjeto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APRENSSOES SET IdLanc=?,IdInternoCrc=?,IdObjeto=?,Qtd=?,UsuarioUp=?,DataUp=?,HorarioUp=?  WHERE IdAprende='" + objApre.getIdAprende() + "'");
            pst.setInt(1, objApre.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setInt(3, codObjeto);
            pst.setFloat(4, objApre.getQtdEncontrada());
            pst.setString(5, objApre.getUsuarioUp());
            pst.setString(6, objApre.getDataUp());
            pst.setString(7, objApre.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApre;
    }

    public Apreensoes excluirApreensoes(Apreensoes objApre) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APRENSSOES WHERE IdAprende='" + objApre.getIdAprende() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApre;
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

    public void pesquisarObjetosApreendido(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OBJETOSPROCEDIMENTOS WHERE DescricaoObjeto='" + nome + "'");
            conecta.rs.first();
            codObjeto = conecta.rs.getInt("IdObjeto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
