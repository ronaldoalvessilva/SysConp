/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradasInternosPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEntradaInternosPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradasInternosPortaria objEntIntPort = new EntradasInternosPortaria();

    public EntradasInternosPortaria incluirEntradaInternosUnid(EntradasInternosPortaria objEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAINTERNOSPORTARIA (StatusLanc,DataLanc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objEntIntPort.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntIntPort.getDataLanc().getTime()));
            pst.setString(3, objEntIntPort.getObservacao());
            pst.setString(4, objEntIntPort.getUsuarioInsert());
            pst.setString(5, objEntIntPort.getDataInsert());
            pst.setString(6, objEntIntPort.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntIntPort;
    }

    public EntradasInternosPortaria alterarEntradaInternosUnid(EntradasInternosPortaria objEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAINTERNOSPORTARIA SET StatusLanc=?,DataLanc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntIntPort.getIdLanc() + "'");
            pst.setString(1, objEntIntPort.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntIntPort.getDataLanc().getTime()));
            pst.setString(3, objEntIntPort.getObservacao());
            pst.setString(4, objEntIntPort.getUsuarioInsert());
            pst.setString(5, objEntIntPort.getDataInsert());
            pst.setString(6, objEntIntPort.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntIntPort;
    }

    public EntradasInternosPortaria excluirEntradaInternosUnid(EntradasInternosPortaria objEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAINTERNOSPORTARIA WHERE IdLanc='" + objEntIntPort.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntIntPort;
    }

    public EntradasInternosPortaria finalizarEntradaInternosUnid(EntradasInternosPortaria objEntIntPort) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAINTERNOSPORTARIA SET StatusLanc=? WHERE IdLanc='" + objEntIntPort.getIdLanc() + "'");
            pst.setString(1, objEntIntPort.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntIntPort;
    }
}
