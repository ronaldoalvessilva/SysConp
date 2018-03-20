/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.MotivoSaidaFAR;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleMotivoSaidaFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MotivoSaidaFAR objMotivo = new MotivoSaidaFAR();
    int codFunc;

    public MotivoSaidaFAR incluirMotivoFAR(MotivoSaidaFAR objMotivo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOTIVO_SAIDA_PRODUTOS_FAR (StatusMot,DataMot,TituloMotivo,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objMotivo.getStatusMot());
            pst.setTimestamp(2, new java.sql.Timestamp(objMotivo.getDataMot().getTime()));
            pst.setString(3, objMotivo.getTituloMotivo());
            pst.setString(4, objMotivo.getMotivo());
            pst.setString(5, objMotivo.getUsuarioInsert());
            pst.setString(6, objMotivo.getDataInsert());
            pst.setString(7, objMotivo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMotivo;
    }

    public MotivoSaidaFAR alterarMotivoFAR(MotivoSaidaFAR objMotivo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOTIVO_SAIDA_PRODUTOS_FAR SET StatusMot=?,DataMot=?,TituloMotivo=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdMot='" + objMotivo.getIdMot() + "'");
            pst.setString(1, objMotivo.getStatusMot());
            pst.setTimestamp(2, new java.sql.Timestamp(objMotivo.getDataMot().getTime()));
            pst.setString(3, objMotivo.getTituloMotivo());
            pst.setString(4, objMotivo.getMotivo());
            pst.setString(5, objMotivo.getUsuarioUp());
            pst.setString(6, objMotivo.getDataUp());
            pst.setString(7, objMotivo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMotivo;
    }

    public MotivoSaidaFAR excluirMotivoFAR(MotivoSaidaFAR objMotivo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOTIVO_SAIDA_PRODUTOS_FAR WHERE IdMot='" + objMotivo.getIdMot() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objMotivo;
    }
}
