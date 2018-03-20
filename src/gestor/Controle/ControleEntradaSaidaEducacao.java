/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaEducacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEntradaSaidaEducacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaEducacao objEntSaiEdu = new EntradaSaidaEducacao();
    int codInstituicao;
    String StatusEmp = "Ativo";

    public EntradaSaidaEducacao incluirEntSaiEducar(EntradaSaidaEducacao objEntSaiEdu) {
        buscarInstituicao(objEntSaiEdu.getNomeInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADA_SAIDA_EDUCACAO (StatusLanc,DataLanc,IdCod,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objEntSaiEdu.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiEdu.getDataLanc().getTime()));
            pst.setInt(3, codInstituicao);
            pst.setString(4, objEntSaiEdu.getObservacao());
            pst.setString(5, objEntSaiEdu.getUsuarioInsert());
            pst.setString(6, objEntSaiEdu.getDataInsert());
            pst.setString(7, objEntSaiEdu.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiEdu;
    }

    public EntradaSaidaEducacao alterarEntSaiEducar(EntradaSaidaEducacao objEntSaiEdu) {
        buscarInstituicao(objEntSaiEdu.getNomeInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_EDUCACAO SET StatusLanc=?,DataLanc=?,IdCod=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiEdu.getIdLanc() + "'");
            pst.setString(1, objEntSaiEdu.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiEdu.getDataLanc().getTime()));
            pst.setInt(3, codInstituicao);
            pst.setString(4, objEntSaiEdu.getObservacao());
            pst.setString(5, objEntSaiEdu.getUsuarioUp());
            pst.setString(6, objEntSaiEdu.getDataUp());
            pst.setString(7, objEntSaiEdu.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiEdu;
    }

    public EntradaSaidaEducacao excluirEntSaiEducar(EntradaSaidaEducacao objEntSaiEdu) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADA_SAIDA_EDUCACAO WHERE IdLanc='" + objEntSaiEdu.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiEdu;
    }

    public EntradaSaidaEducacao finalizarEntSaiEducar(EntradaSaidaEducacao objEntSaiEdu) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_EDUCACAO SET StatusLanc=? WHERE IdLanc='" + objEntSaiEdu.getIdLanc() + "'");
            pst.setString(1, objEntSaiEdu.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiEdu;
    }

    public void buscarInstituicao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + desc + "'");
            conecta.rs.first();
            codInstituicao = conecta.rs.getInt("IdCod");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar a instituição, talvez ela esteja inativa." + e);
        }
        conecta.desconecta();
    }
}
