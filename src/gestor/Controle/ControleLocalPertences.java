/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LocalArmazenamentoPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLocalPertences {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LocalArmazenamentoPertences objLocal = new LocalArmazenamentoPertences();

    public LocalArmazenamentoPertences incluirLocalPertences(LocalArmazenamentoPertences objLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCALPERTENCES (StatusLocal,DescricaoLocal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setString(1, objLocal.getStatusLocal());
            pst.setString(2, objLocal.getDescricaoLocal());
            pst.setString(3, objLocal.getUsuarioInsert());
            pst.setString(4, objLocal.getDataInsert());
            pst.setString(5, objLocal.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocal;
    }

    public LocalArmazenamentoPertences alterarLocalPertences(LocalArmazenamentoPertences objLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCALPERTENCES SET StatusLocal=?,DescricaoLocal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLocal='" + objLocal.getIdLocal() + "'");
            pst.setString(1, objLocal.getStatusLocal());
            pst.setString(2, objLocal.getDescricaoLocal());
            pst.setString(3, objLocal.getUsuarioUp());
            pst.setString(4, objLocal.getDataUp());
            pst.setString(5, objLocal.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocal;
    }

    public LocalArmazenamentoPertences excluirLocalPertences(LocalArmazenamentoPertences objLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCALPERTENCES WHERE IdLocal='" + objLocal.getIdLocal() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETE os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocal;
    }
}
