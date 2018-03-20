/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ColaboradorTestemunha;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleFuncTestemunha {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ColaboradorTestemunha objFuncTeste = new ColaboradorTestemunha();

    int codFunc;

    public ColaboradorTestemunha incluirColaboradorVitima(ColaboradorTestemunha objFuncTeste) {
        pesquisarColaborador(objFuncTeste.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COLABORADORTESTEMUNHA (IdLanc,IdFunc,RgFuncTeste,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objFuncTeste.getIdLanc());
            pst.setInt(2, codFunc);
            pst.setString(3, objFuncTeste.getRgFuncTestemunha());
            pst.setString(4, objFuncTeste.getUsuarioInsert());
            pst.setString(5, objFuncTeste.getDataInsert());
            pst.setString(6, objFuncTeste.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFuncTeste;
    }

    public ColaboradorTestemunha alterarColaboradorVitima(ColaboradorTestemunha objFuncTeste) {
        pesquisarColaborador(objFuncTeste.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COLABORADORTESTEMUNHA SET IdLanc=?,IdFunc=?,RgFuncTeste=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdColaVit='" + objFuncTeste.getIdColaVit() + "'");
            pst.setInt(1, objFuncTeste.getIdLanc());
            pst.setInt(2, codFunc);
            pst.setString(3, objFuncTeste.getRgFuncTestemunha());
            pst.setString(4, objFuncTeste.getUsuarioUp());
            pst.setString(5, objFuncTeste.getDataUp());
            pst.setString(6, objFuncTeste.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFuncTeste;
    }

    public ColaboradorTestemunha excluirColaboradorVitima(ColaboradorTestemunha objFuncTeste) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM COLABORADORTESTEMUNHA WHERE IdColaVit='" + objFuncTeste.getIdColaVit() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFuncTeste;
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
