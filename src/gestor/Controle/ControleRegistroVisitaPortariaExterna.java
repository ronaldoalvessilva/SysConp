/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroChegadaVisitaPortariaExterna;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleRegistroVisitaPortariaExterna {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroChegadaVisitaPortariaExterna objRegChegaVisitas = new RegistroChegadaVisitaPortariaExterna();
    int codVisita;
    int codInterno;

    public RegistroChegadaVisitaPortariaExterna incluirRegistroChegadaVisitasInternos(RegistroChegadaVisitaPortariaExterna objRegChegaVisitas) {
        buscarVisita(objRegChegaVisitas.getIdVisita(), objRegChegaVisitas.getNomeVisita());
        buscarInterno(objRegChegaVisitas.getNomeInterno(), objRegChegaVisitas.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA (StatusReg,DataReg,IdVisita,IdInternoCrc,IdRol,DataChegada,HoraChegada,OrdemChegada,AssinaturaDigitalVisita,TipoOperacao,MotivoNaoAssinarDigital,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegChegaVisitas.getStatusReg());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegChegaVisitas.getDataReg().getTime()));
            pst.setInt(3, codVisita);
            pst.setInt(4, codInterno);
            pst.setInt(5, objRegChegaVisitas.getIdRol());
            pst.setTimestamp(6, new java.sql.Timestamp(objRegChegaVisitas.getDataChegada().getTime()));
            pst.setString(7, objRegChegaVisitas.getHoraChegada());
            pst.setInt(8, objRegChegaVisitas.getOrdemChegadaVisita());
            pst.setBytes(9, objRegChegaVisitas.getAssinaturaDigitalVisita());
            pst.setInt(10, objRegChegaVisitas.getTipoOperacao());
            pst.setString(11, objRegChegaVisitas.getMotivoNaoAssinarDigital());
            pst.setString(12, objRegChegaVisitas.getUsuarioInsert());
            pst.setString(13, objRegChegaVisitas.getDataInsert());
            pst.setString(14, objRegChegaVisitas.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados na tabela (REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA).\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegChegaVisitas;
    }

    public void buscarVisita(int idVisita, String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'AND IdVisita='" + idVisita + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
