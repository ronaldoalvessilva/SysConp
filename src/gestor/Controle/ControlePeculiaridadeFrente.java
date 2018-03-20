/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PeculiaridadeFrente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePeculiaridadeFrente {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PeculiaridadeFrente objPecuFrente = new PeculiaridadeFrente();

    public PeculiaridadeFrente incluirPeculiaridadeFrente(PeculiaridadeFrente objPecuFrente) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PECULIARIDADE_FRENTE (DataPec,IdInternoCrc,RegiaoFrente,TextoPeculiaridade,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPecuFrente.getDataPec().getTime()));
            pst.setInt(2, objPecuFrente.getIdInternoCrc());
            pst.setString(3, objPecuFrente.getRegiaoFrente());
            pst.setString(4, objPecuFrente.getTextoPeculiaridade());
            pst.setString(5, objPecuFrente.getUsuarioInsert());
            pst.setString(6, objPecuFrente.getDataInsert());
            pst.setString(7, objPecuFrente.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPecuFrente;
    }

    public PeculiaridadeFrente alterarPeculiaridadeFrente(PeculiaridadeFrente objPecuFrente) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PECULIARIDADE_FRENTE SET DataPec=?,IdInternoCrc=?,RegiaoFrente=?,TextoPeculiaridade=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objPecuFrente.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPecuFrente.getDataPec().getTime()));
            pst.setInt(2, objPecuFrente.getIdInternoCrc());
            pst.setString(3, objPecuFrente.getRegiaoFrente());
            pst.setString(4, objPecuFrente.getTextoPeculiaridade());
            pst.setString(5, objPecuFrente.getUsuarioUp());
            pst.setString(6, objPecuFrente.getDataUp());
            pst.setString(7, objPecuFrente.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPecuFrente;
    }

    public PeculiaridadeFrente excluirPeculiaridadeFrente(PeculiaridadeFrente objPecuFrente) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PECULIARIDADE_FRENTE WHERE IdItem='" + objPecuFrente.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPecuFrente;
    }
}
