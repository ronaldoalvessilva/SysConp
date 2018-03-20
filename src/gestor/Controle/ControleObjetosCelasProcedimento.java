/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ObjetosProcedimento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleObjetosCelasProcedimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ObjetosProcedimento objObjetos = new ObjetosProcedimento();

    int codCela;
    int codObjeto;

    public ObjetosProcedimento incluirObjetoProcedimento(ObjetosProcedimento objObjetos) {
        pesquisarCela(objObjetos.getDescricaoCela());
        pesquisarObjeto(objObjetos.getDescricaoObjeto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSOBJETOSPROCEDIMENTO (IdProc,IdCela,IdObjeto,Unid,Qtde,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objObjetos.getIdProc());
            pst.setInt(2, codCela);
            pst.setInt(3, codObjeto);
            pst.setString(4, objObjetos.getUnidadeObjeto());
            pst.setFloat(5, objObjetos.getQtde());
            pst.setString(6, objObjetos.getUsuarioInsert());
            pst.setString(7, objObjetos.getDataInsert());
            pst.setString(8, objObjetos.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objObjetos;
    }

    public ObjetosProcedimento alterarObjetoProcedimento(ObjetosProcedimento objObjetos) {
        pesquisarCela(objObjetos.getDescricaoCela());
        pesquisarObjeto(objObjetos.getDescricaoObjeto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSOBJETOSPROCEDIMENTO SET IdProc=?,IdCela=?,IdObjeto=?,Unid=?,Qtde=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdObjPro='" + objObjetos.getIdObjPro() + "'");
            pst.setInt(1, objObjetos.getIdProc());
            pst.setInt(2, codCela);
            pst.setInt(3, codObjeto);
            pst.setString(4, objObjetos.getUnidadeObjeto());
            pst.setFloat(5, objObjetos.getQtde());
            pst.setString(6, objObjetos.getUsuarioUp());
            pst.setString(7, objObjetos.getDataUp());
            pst.setString(8, objObjetos.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objObjetos;
    }

    public ObjetosProcedimento excluirObjetoProcedimento(ObjetosProcedimento objObjetos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSOBJETOSPROCEDIMENTO WHERE IdObjPro='" + objObjetos.getIdObjPro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objObjetos;
    }

    public void pesquisarObjeto(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OBJETOSPROCEDIMENTOS WHERE DescricaoObjeto='" + nome + "'");
            conecta.rs.first();
            codObjeto = conecta.rs.getInt("IdObjeto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos (OBJETO) !!!.\nERRO: " + ex);
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
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos (CELAS) !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
