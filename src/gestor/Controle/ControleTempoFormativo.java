/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RolVisitas;
import gestor.Modelo.TempoFormativo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleTempoFormativo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TempoFormativo objTempo = new TempoFormativo();

    int codTurno;

    public TempoFormativo incluirTempoFormativo(TempoFormativo objTempo) {
        buscarTurno(objTempo.getDescricaoTurno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TEMPOFORMATIVO (StatusTempo,DataCad,IdTurno,DescricaoTempo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objTempo.getStatusTempo());
            pst.setTimestamp(2, new java.sql.Timestamp(objTempo.getDataCad().getTime()));
            pst.setInt(3, codTurno);
            pst.setString(4, objTempo.getDescricaoTempo());
            pst.setString(5, objTempo.getUsuarioInsert());
            pst.setString(6, objTempo.getDataInsert());
            pst.setString(7, objTempo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTempo;
    }

    public TempoFormativo alterarTempoFormativo(TempoFormativo objTempo) {
        buscarTurno(objTempo.getDescricaoTurno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TEMPOFORMATIVO SET StatusTempo=?,DataCad=?,IdTurno=?,DescricaoTempo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTempo='" + objTempo.getIdTempo() + "'");
            pst.setString(1, objTempo.getStatusTempo());
            pst.setTimestamp(2, new java.sql.Timestamp(objTempo.getDataCad().getTime()));
            pst.setInt(3, codTurno);
            pst.setString(4, objTempo.getDescricaoTempo());
            pst.setString(5, objTempo.getUsuarioUp());
            pst.setString(6, objTempo.getDataUp());
            pst.setString(7, objTempo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTempo;
    }

    public TempoFormativo excluirTempoFormativo(TempoFormativo objTempo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TEMPOFORMATIVO SET WHERE IdTempo='" + objTempo.getIdTempo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTempo;
    }

    public void buscarTurno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TURNOSAULA WHERE DescricaoTurno='" + nome + "'");
            conecta.rs.first();
            codTurno = conecta.rs.getInt("IdTurno");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do TURNOS a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
