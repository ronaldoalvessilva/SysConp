/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.UsuarioConectado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleUsuarioConectado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    UsuarioConectado userConectado = new UsuarioConectado();

    public UsuarioConectado incluirHostName(UsuarioConectado userConectado) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USERCONECTADOS (DataPlugado,HorarioPlugado,NomeUsuario,ConectadoDesconectado,HostName,IpHost,StatusFlag) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, userConectado.getDataPlugado());           
            pst.setString(2, userConectado.getHorarioPlugado());           
            pst.setString(3, userConectado.getNomeUsuario());
            pst.setString(4, userConectado.getConectadoDesconectado());
            pst.setString(5, userConectado.getHostName());
            pst.setString(6, userConectado.getIpHost());
            pst.setString(7, userConectado.getStatusFlag());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return userConectado;
    }
    
    public UsuarioConectado desconectarHostName(UsuarioConectado userConectado) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USERCONECTADOS SET DataDesconectado=?,HorarioDesconectado=?,ConectadoDesconectado=?,StatusFlag=? WHERE IdUser='" + userConectado.getIdUser() + "'");
            pst.setString(1, userConectado.getDataDesconectado());
            pst.setString(2, userConectado.getHorarioDesconectado());           
            pst.setString(3, userConectado.getConectadoDesconectado());           
            pst.setString(4, userConectado.getStatusFlag());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO." + ex);
        }
        conecta.desconecta();
        return userConectado;
    }

//    public UsuarioConectado desconectarHostName(UsuarioConectado userConectado) {
//        conecta.abrirConexao();
//        try {
//            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USERCONECTADOS (DataPlugado,HorarioPlugado,NomeUsuario,ConectadoDesconectado,HostName,IpHost,StatusFlag) VALUES(?,?,?,?,?,?,?)");
//            pst.setString(1, userConectado.getDataPlugado());
//            pst.setString(2, userConectado.getHorarioPlugado());
//            pst.setString(3, userConectado.getNomeUsuario());
//            pst.setString(4, userConectado.getConectadoDesconectado());
//            pst.setString(5, userConectado.getHostName());
//            pst.setString(6, userConectado.getIpHost());
//            pst.setString(7, userConectado.getStatusFlag());
//            pst.execute();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
//        }
//        conecta.desconecta();
//        return userConectado;
//    }

    public UsuarioConectado excluirHostName(UsuarioConectado userConectado) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USERCONECTADOS WHERE NomeUsuario='" + userConectado.getNomeUsuario() + "'AND IpHost='" + userConectado.getIpHost() + "'AND HostName='" + userConectado.getHostName() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return userConectado;
    }
}
