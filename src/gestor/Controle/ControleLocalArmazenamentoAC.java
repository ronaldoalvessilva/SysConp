/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LocalArmazenamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLocalArmazenamentoAC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LocalArmazenamento objLocalMaster = new LocalArmazenamento();

    public LocalArmazenamento incluirLocalMaster(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCAL_ARMAZENAMENTO_AC (StatusLocal,DescricaoLocal,NivelLocal,Modulo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objLocalMaster.getStatusLocal());
            pst.setString(2, objLocalMaster.getDescricaLocal());
            pst.setInt(3, objLocalMaster.getNivelLocal());
            pst.setString(4, objLocalMaster.getModulo());
            pst.setString(5, objLocalMaster.getUsuarioInsert());
            pst.setString(6, objLocalMaster.getDataInsert());
            pst.setString(7, objLocalMaster.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }

    public LocalArmazenamento alterarLocalMaster(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCAL_ARMAZENAMENTO_AC SET StatusLocal=?,DescricaoLocal=?,NivelLocal=?,Modulo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLocal='" + objLocalMaster.getIdLocal() + "'");
            pst.setString(1, objLocalMaster.getStatusLocal());
            pst.setString(2, objLocalMaster.getDescricaLocal());
            pst.setInt(3, objLocalMaster.getNivelLocal());
            pst.setString(4, objLocalMaster.getModulo());
            pst.setString(5, objLocalMaster.getUsuarioUp());
            pst.setString(6, objLocalMaster.getDataUp());
            pst.setString(7, objLocalMaster.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }

    public LocalArmazenamento excluirLocalMaster(LocalArmazenamento objLocalMaster) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCAL_ARMAZENAMENTO_AC WHERE IdLocal='" + objLocalMaster.getIdLocal() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLocalMaster;
    }
}
