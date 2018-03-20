/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TurnosAula;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleTurnosAula {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TurnosAula objTurma = new TurnosAula();

    public TurnosAula incluirTurnosAula(TurnosAula objTurma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TURNOSAULA (StatusTurno,DataCad,DescricaoTurno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objTurma.getStatusTurno());
            pst.setTimestamp(2, new java.sql.Timestamp(objTurma.getDataCad().getTime()));
            pst.setString(3, objTurma.getDescricaoTurno());
            pst.setString(4, objTurma.getUsuarioInsert());
            pst.setString(5, objTurma.getDataInsert());
            pst.setString(6, objTurma.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTurma;
    }

    public TurnosAula alterarTurnoAula(TurnosAula objTurma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TURNOSAULA SET StatusTurno=?,DataCad=?,DescricaoTurno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTurno='" + objTurma.getIdTurno()+ "'");
            pst.setString(1, objTurma.getStatusTurno());
            pst.setTimestamp(2, new java.sql.Timestamp(objTurma.getDataCad().getTime()));
            pst.setString(3, objTurma.getDescricaoTurno());
            pst.setString(4, objTurma.getUsuarioUp());
            pst.setString(5, objTurma.getDataUp());
            pst.setString(6, objTurma.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTurma;
    }

    public TurnosAula excluirTurnosAula(TurnosAula objTurma) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TURNOSAULA WHERE IdTurno='" + objTurma.getIdTurno()+ "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTurma;
    }
}
