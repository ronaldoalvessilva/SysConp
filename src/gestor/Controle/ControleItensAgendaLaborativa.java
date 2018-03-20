/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAgendaLaborativa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensAgendaLaborativa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAgendaLaborativa objItensAgenda = new ItensAgendaLaborativa();
    int codInterno;

    public ItensAgendaLaborativa incluirItensAgendaLab(ItensAgendaLaborativa objItensAgenda) {
         buscarInterno(objItensAgenda.getNomeInterno(), objItensAgenda.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSAGENDALABORATIVA (IdAgenda,IdInternoCrc,IdEmp,StatusInterno,ObservacaoInterno,UsuarioInsert,DataInsert,HorarioInsert,TipoEmpresa,DiaSeg,DiaTer,DiaQua,DiaQui,DiaSex,DiaSab,DiaDom,HoraSeg,HoraTer,HoraQua,HoraQui,HoraSex,HoraSab,HoraDom,HoraSegEnt,HoraTerEnt,HoraQuaEnt,HoraQuiEnt,HoraSexEnt,HoraSabEnt,HoraDomEnt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensAgenda.getIdAgenda());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensAgenda.getIdEmp());
            pst.setString(4, objItensAgenda.getStatusInterno());
            pst.setString(5, objItensAgenda.getObservacaoInterno());
            pst.setString(6, objItensAgenda.getUsuarioInsert());
            pst.setString(7, objItensAgenda.getDataInsert());
            pst.setString(8, objItensAgenda.getHoraInsert());
            pst.setString(9, objItensAgenda.getTipoEmpresa());            
            pst.setInt(10, objItensAgenda.getDiaSeg());
            pst.setInt(11, objItensAgenda.getDiaTer());
            pst.setInt(12, objItensAgenda.getDiaQua());
            pst.setInt(13, objItensAgenda.getDiaQui());
            pst.setInt(14, objItensAgenda.getDiaSex());
            pst.setInt(15, objItensAgenda.getDiaSab());
            pst.setInt(16, objItensAgenda.getDiaDom());            
            pst.setString(17, objItensAgenda.getHoraSeg());
            pst.setString(18, objItensAgenda.getHoraTer());
            pst.setString(19, objItensAgenda.getHoraQua());
            pst.setString(20, objItensAgenda.getHoraQui());
            pst.setString(21, objItensAgenda.getHoraSex());
            pst.setString(22, objItensAgenda.getHoraSab());
            pst.setString(23, objItensAgenda.getHoraDom());
            pst.setString(24, objItensAgenda.getHoraSegEnt());
            pst.setString(25, objItensAgenda.getHoraTerEnt());
            pst.setString(26, objItensAgenda.getHoraQuaEnt());
            pst.setString(27, objItensAgenda.getHoraQuiEnt());
            pst.setString(28, objItensAgenda.getHoraSexEnt());
            pst.setString(29, objItensAgenda.getHoraSabEnt());
            pst.setString(30, objItensAgenda.getHoraDomEnt());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public ItensAgendaLaborativa alterarItensAgendaLab(ItensAgendaLaborativa objItensAgenda) {
        buscarInterno(objItensAgenda.getNomeInterno(), objItensAgenda.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSAGENDALABORATIVA SET IdAgenda=?,IdInternoCrc=?,IdEmp=?,StatusInterno=?,ObservacaoInterno=?,UsuarioUp=?,DataUp=?,HorarioUp=?,TipoEmpresa=?,DiaSeg=?,DiaTer=?,DiaQua=?,DiaQui=?,DiaSex=?,DiaSab=?,DiaDom=?,HoraSeg=?,HoraTer=?,HoraQua=?,HoraQui=?,HoraSex=?,HoraSab=?,HoraDom=?,HoraSegEnt=?,HoraTerEnt=?,HoraQuaEnt=?,HoraQuiEnt=?,HoraSexEnt=?,HoraSabEnt=?,HoraDomEnt=? WHERE IdItem='" + objItensAgenda.getIdItem() + "'");
            pst.setInt(1, objItensAgenda.getIdAgenda());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensAgenda.getIdEmp());
            pst.setString(4, objItensAgenda.getStatusInterno());
            pst.setString(5, objItensAgenda.getObservacaoInterno());
            pst.setString(6, objItensAgenda.getUsuarioUp());
            pst.setString(7, objItensAgenda.getDataUp());
            pst.setString(8, objItensAgenda.getHoraUp());
            pst.setString(9, objItensAgenda.getTipoEmpresa());
            pst.setInt(10, objItensAgenda.getDiaSeg());
            pst.setInt(11, objItensAgenda.getDiaTer());
            pst.setInt(12, objItensAgenda.getDiaQua());
            pst.setInt(13, objItensAgenda.getDiaQui());
            pst.setInt(14, objItensAgenda.getDiaSex());
            pst.setInt(15, objItensAgenda.getDiaSab());
            pst.setInt(16, objItensAgenda.getDiaDom());            
            pst.setString(17, objItensAgenda.getHoraSeg());
            pst.setString(18, objItensAgenda.getHoraTer());
            pst.setString(19, objItensAgenda.getHoraQua());
            pst.setString(20, objItensAgenda.getHoraQui());
            pst.setString(21, objItensAgenda.getHoraSex());
            pst.setString(22, objItensAgenda.getHoraSab());
            pst.setString(23, objItensAgenda.getHoraDom());
            pst.setString(24, objItensAgenda.getHoraSegEnt());
            pst.setString(25, objItensAgenda.getHoraTerEnt());
            pst.setString(26, objItensAgenda.getHoraQuaEnt());
            pst.setString(27, objItensAgenda.getHoraQuiEnt());
            pst.setString(28, objItensAgenda.getHoraSexEnt());
            pst.setString(29, objItensAgenda.getHoraSabEnt());
            pst.setString(30, objItensAgenda.getHoraDomEnt());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public ItensAgendaLaborativa excluirItensAgendaLab(ItensAgendaLaborativa objItensAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSAGENDALABORATIVA WHERE IdItem='" + objItensAgenda.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno  + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o interno!!!\nERRO: " + ex);
        }
    }
}
