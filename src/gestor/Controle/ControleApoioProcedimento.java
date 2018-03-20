/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ApoioProcedimento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleApoioProcedimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ApoioProcedimento objApoio = new ApoioProcedimento();

    int codColaborador;

    public ApoioProcedimento incluirAgentesApoio(ApoioProcedimento objApoio) {
        buscarColaborador(objApoio.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO APOIOPROCEDIMENTO (IdProc,IdFunc,TipoAuxilio,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objApoio.getIdProc());
            pst.setInt(2, codColaborador);
            pst.setString(3, objApoio.getTipoAuxilio());
            pst.setString(4, objApoio.getUsuarioInsert());
            pst.setString(5, objApoio.getDataInsert());
            pst.setString(6, objApoio.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApoio;
    }

    public ApoioProcedimento alterarAgentesApoio(ApoioProcedimento objApoio) {
        buscarColaborador(objApoio.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APOIOPROCEDIMENTO SET IdProc=?,IdFunc=?,TipoAuxilio=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdApoio='" + objApoio.getIdApoio() + "'");
            pst.setInt(1, objApoio.getIdProc());
            pst.setInt(2, codColaborador);
            pst.setString(3, objApoio.getTipoAuxilio());
            pst.setString(4, objApoio.getUsuarioUp());
            pst.setString(5, objApoio.getDataUp());
            pst.setString(6, objApoio.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApoio;
    }

    public ApoioProcedimento excluirAgentesApoio(ApoioProcedimento objApoio) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM APOIOPROCEDIMENTO WHERE IdApoio='" + objApoio.getIdApoio() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objApoio;
    }

    public void buscarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codColaborador = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do interno a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
