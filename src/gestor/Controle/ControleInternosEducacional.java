/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CursosDiversos;
import gestor.Modelo.InternosSaidaEducacional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleInternosEducacional {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InternosSaidaEducacional objIntEduca = new InternosSaidaEducacional();

    int codInterno;

    public InternosSaidaEducacional incluirAssistenciaEducativa(InternosSaidaEducacional objIntEduca) {
        buscarInternoCrc(objIntEduca.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOS_SAIDA_EDUCACIONAL (IdEduca,IdInternoCrc,Motivo,TipoAcesso,Evadido,UsuarioInsert,DataInsert,HorarioInsert,DiaSeg,DiaTer,DiaQua,DiaQui,DiaSex,DiaSab,DiaDom,HoraSeg,HoraTer,HoraQua,HoraQui,HoraSex,HoraSab,HoraDom,HoraSegEnt,HoraTerEnt,HoraQuaEnt,HoraQuiEnt,HoraSexEnt,HoraSabEnt,HoraDomEnt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objIntEduca.getIdEduca());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntEduca.getMotivo());
            pst.setInt(4, objIntEduca.getTipoAcesso());
            pst.setString(5, objIntEduca.getEvadidoEducacao());
            pst.setString(6, objIntEduca.getUsuarioInsert());
            pst.setString(7, objIntEduca.getDataInsert());
            pst.setString(8, objIntEduca.getHorarioInsert());
            pst.setInt(9, objIntEduca.getDiaSeg());
            pst.setInt(10, objIntEduca.getDiaTer());
            pst.setInt(11, objIntEduca.getDiaQua());
            pst.setInt(12, objIntEduca.getDiaQui());
            pst.setInt(13, objIntEduca.getDiaSex());
            pst.setInt(14, objIntEduca.getDiaSab());
            pst.setInt(15, objIntEduca.getDiaDom());
            pst.setString(16, objIntEduca.getHoraSeg());
            pst.setString(17, objIntEduca.getHoraTer());
            pst.setString(18, objIntEduca.getHoraQua());
            pst.setString(19, objIntEduca.getHoraQui());
            pst.setString(20, objIntEduca.getHoraSex());
            pst.setString(21, objIntEduca.getHoraSab());
            pst.setString(22, objIntEduca.getHoraDom());
            pst.setString(23, objIntEduca.getHoraSegEnt());
            pst.setString(24, objIntEduca.getHoraTerEnt());
            pst.setString(25, objIntEduca.getHoraQuaEnt());
            pst.setString(26, objIntEduca.getHoraQuiEnt());
            pst.setString(27, objIntEduca.getHoraSexEnt());
            pst.setString(28, objIntEduca.getHoraSabEnt());
            pst.setString(29, objIntEduca.getHoraDomEnt());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objIntEduca;
    }

    public InternosSaidaEducacional alterarAssistenciaEducativa(InternosSaidaEducacional objIntEduca) {
        buscarInternoCrc(objIntEduca.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_SAIDA_EDUCACIONAL SET IdEduca=?,IdInternoCrc=?,Motivo=?,TipoAcesso=?,Evadido=?,UsuarioUp=?,DataUp=?,HorarioUp=?,DiaSeg=?,DiaTer=?,DiaQua=?,DiaQui=?,DiaSex=?,DiaSab=?,DiaDom=?,HoraSeg=?,HoraTer=?,HoraQua=?,HoraQui=?,HoraSex=?,HoraSab=?,HoraDom=?,HoraSegEnt=?,HoraTerEnt=?,HoraQuaEnt=?,HoraQuiEnt=?,HoraSexEnt=?,HoraSabEnt=?,HoraDomEnt=? WHERE IdItem='" + objIntEduca.getIdItem() + "'");
            pst.setInt(1, objIntEduca.getIdEduca());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntEduca.getMotivo());
            pst.setInt(4, objIntEduca.getTipoAcesso());
            pst.setString(5, objIntEduca.getEvadidoEducacao());
            pst.setString(6, objIntEduca.getUsuarioUp());
            pst.setString(7, objIntEduca.getDataUp());
            pst.setString(8, objIntEduca.getHorarioUp());
            pst.setInt(9, objIntEduca.getDiaSeg());
            pst.setInt(10, objIntEduca.getDiaTer());
            pst.setInt(11, objIntEduca.getDiaQua());
            pst.setInt(12, objIntEduca.getDiaQui());
            pst.setInt(13, objIntEduca.getDiaSex());
            pst.setInt(14, objIntEduca.getDiaSab());
            pst.setInt(15, objIntEduca.getDiaDom());
            pst.setString(16, objIntEduca.getHoraSeg());
            pst.setString(17, objIntEduca.getHoraTer());
            pst.setString(18, objIntEduca.getHoraQua());
            pst.setString(19, objIntEduca.getHoraQui());
            pst.setString(20, objIntEduca.getHoraSex());
            pst.setString(21, objIntEduca.getHoraSab());
            pst.setString(22, objIntEduca.getHoraDom());
            pst.setString(23, objIntEduca.getHoraSegEnt());
            pst.setString(24, objIntEduca.getHoraTerEnt());
            pst.setString(25, objIntEduca.getHoraQuaEnt());
            pst.setString(26, objIntEduca.getHoraQuiEnt());
            pst.setString(27, objIntEduca.getHoraSexEnt());
            pst.setString(28, objIntEduca.getHoraSabEnt());
            pst.setString(29, objIntEduca.getHoraDomEnt());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objIntEduca;
    }

    public InternosSaidaEducacional excluirAssistenciaEducativa(InternosSaidaEducacional objIntEduca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOS_SAIDA_EDUCACIONAL WHERE IdItem='" + objIntEduca.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objIntEduca;
    }

    public void buscarInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNO) a serem exibidos !!!\nERRO: " + ex);
        }
        conecta.desconecta();
    }       
}
