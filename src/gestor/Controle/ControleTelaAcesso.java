/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TelaAcessos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleTelaAcesso {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TelaAcessos objTelaAcesso = new TelaAcessos();
    int idCod;

    public TelaAcessos incluirTelaAcesso(TelaAcessos objTelaAcesso) {
        buscarUsuarios(objTelaAcesso.getNomeUsuario(), objTelaAcesso.getIdUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TELAS_ACESSO (IdUsuario,NomeTela,Abrir,Incluir,Alterar,Excluir,Gravar,Consultar,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, idCod);
            pst.setString(2, objTelaAcesso.getNomeTela());
            pst.setInt(3, objTelaAcesso.getAbrir());
            pst.setInt(4, objTelaAcesso.getIncluir());
            pst.setInt(5, objTelaAcesso.getAlterar());
            pst.setInt(6, objTelaAcesso.getExcluir());
            pst.setInt(7, objTelaAcesso.getGravar());
            pst.setInt(8, objTelaAcesso.getConsultar());
            pst.setString(9, objTelaAcesso.getUsuarioInsert());
            pst.setString(10, objTelaAcesso.getDataInsert());
            pst.setString(11, objTelaAcesso.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTelaAcesso;
    }

    public TelaAcessos alterarTelaAcesso(TelaAcessos objTelaAcesso) {
        buscarUsuarios(objTelaAcesso.getNomeUsuario(), objTelaAcesso.getIdUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TELAS_ACESSO SET IdUsuario=?,NomeTela=?,Abrir=?,Incluir=?,Alterar=?,Excluir=?,Gravar=?,Consultar=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTela='" + objTelaAcesso.getIdTela() + "'");
            pst.setInt(1, idCod);
            pst.setString(2, objTelaAcesso.getNomeTela());
            pst.setInt(3, objTelaAcesso.getAbrir());
            pst.setInt(4, objTelaAcesso.getIncluir());
            pst.setInt(5, objTelaAcesso.getAlterar());
            pst.setInt(6, objTelaAcesso.getExcluir());
            pst.setInt(7, objTelaAcesso.getGravar());
            pst.setInt(8, objTelaAcesso.getConsultar());
            pst.setString(9, objTelaAcesso.getUsuarioUp());
            pst.setString(10, objTelaAcesso.getDataUp());
            pst.setString(11, objTelaAcesso.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTelaAcesso;
    }

    public TelaAcessos excluirTelaAcesso(TelaAcessos objTelaAcesso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TELAS_ACESSO WHERE IdTela='" + objTelaAcesso.getIdTela() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTelaAcesso;
    }

    public void buscarUsuarios(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nome + "' "
                    + "AND IdUsuario='" + codigo + "'");
            conecta.rs.first();
            idCod = conecta.rs.getInt("IdUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (USUÁRIOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
