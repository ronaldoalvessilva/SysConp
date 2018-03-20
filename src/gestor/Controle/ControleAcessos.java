/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Acessos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAcessos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Acessos objAccess = new Acessos();
    int codModulo;
    int codGrupo;

    public Acessos incluirAcessos(Acessos objAccess) {
        buscarModulo(objAccess.getNomeModulo());
        buscarGrupo(objAccess.getNomeGrupo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ACESSOS (DataLanc,IdModulo,IdGrupo,Permissao) VALUES(?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAccess.getDataLanc().getTime()));
            pst.setInt(2, codModulo);
            pst.setInt(3, codGrupo);
            pst.setString(4, objAccess.getPermissao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objAccess;
    }

    public Acessos alterarAcessos(Acessos objAccess) {
        buscarModulo(objAccess.getNomeModulo());
        buscarGrupo(objAccess.getNomeGrupo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ACESSOS SET DataLanc=?,IdModulo=?,IdGrupo=?,Permissao=? WHERE IdAcesso='" + objAccess.getIdAcesso() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAccess.getDataLanc().getTime()));
            pst.setInt(2, codModulo);
            pst.setInt(3, codGrupo);
            pst.setString(4, objAccess.getPermissao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAccess;
    }

    public Acessos excluirAcessos(Acessos objAccess) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ACESSOS WHERE IdAcesso='" + objAccess.getIdAcesso() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAccess;
    }

    public void buscarModulo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS WHERE NomeModulo='" + nome + "'");
            conecta.rs.first();
            codModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarGrupo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPOUSUARIOS WHERE NomeGrupo='" + nome + "'");
            conecta.rs.first();
            codGrupo = conecta.rs.getInt("IdGrupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
