/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ColabordorVitima;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleFuncVitima {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ColabordorVitima objFuncVitima = new ColabordorVitima();

    int codFunc;

    public ColabordorVitima incluirColaboradorVitima(ColabordorVitima objFuncVitima) {
        pesquisarColaborador(objFuncVitima.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COLABORADORVITIMA (IdLanc,IdFunc,RgFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objFuncVitima.getIdLanc());
            pst.setInt(2, codFunc);
            pst.setString(3, objFuncVitima.getRgColaborador());
            pst.setString(4, objFuncVitima.getUsuarioInsert());
            pst.setString(5, objFuncVitima.getDataInsert());
            pst.setString(6, objFuncVitima.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFuncVitima;
    }

    public ColabordorVitima alterarColaboradorVitima(ColabordorVitima objFuncVitima) {
        pesquisarColaborador(objFuncVitima.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COLABORADORVITIMA SET IdLanc=?,IdFunc=?,RgFunc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdColaVit='" + objFuncVitima.getIdColaVit() + "'");
            pst.setInt(1, objFuncVitima.getIdLanc());
            pst.setInt(2, codFunc);
            pst.setString(3, objFuncVitima.getRgColaborador());
            pst.setString(4, objFuncVitima.getUsuarioUp());
            pst.setString(5, objFuncVitima.getDataUp());
            pst.setString(6, objFuncVitima.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFuncVitima;
    }

    public ColabordorVitima excluirColaboradorVitima(ColabordorVitima objFuncVitima) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM COLABORADORVITIMA WHERE IdColaVit='" + objFuncVitima.getIdColaVit() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFuncVitima;
    }

    public void pesquisarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
