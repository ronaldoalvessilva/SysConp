/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AlertaVisitasPortariaPavilhoes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAlertasPortariaPavilhoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AlertaVisitasPortariaPavilhoes objAlertaPortPav = new AlertaVisitasPortariaPavilhoes();
    //
    int codInterno;
    int idPavilhao;

    public AlertaVisitasPortariaPavilhoes incluirAcessoOficialPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        buscarInterno(objAlertaPortPav.getNomeInternoCrc(), objAlertaPortPav.getIdInternoCrc());
        buscarPavilhao(objAlertaPortPav.getDescricaoPavilhao(), objAlertaPortPav.getIdPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA (IdRegistroOF,DataChegada,HoraChegada,IdInternoCrc,IdPav,IdOficial,AssinaturaDigitalVisita,Confirmacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAlertaPortPav.getIdRegistroOF());
            pst.setTimestamp(2, new java.sql.Timestamp(objAlertaPortPav.getDataChegada().getTime()));
            pst.setString(3, objAlertaPortPav.getHoraChegada());
            pst.setInt(4, codInterno);
            pst.setInt(5, idPavilhao);
            pst.setInt(6, objAlertaPortPav.getIdOficial());
            pst.setBytes(7, objAlertaPortPav.getAssinaturaDigitalVisita());
            pst.setString(8, objAlertaPortPav.getConfirmacao());
            pst.setString(9, objAlertaPortPav.getUsuarioInsert());
            pst.setString(10, objAlertaPortPav.getDataInsert());
            pst.setString(11, objAlertaPortPav.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes alterarAcessoOficialPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        buscarInterno(objAlertaPortPav.getNomeInternoCrc(), objAlertaPortPav.getIdInternoCrc());
        buscarPavilhao(objAlertaPortPav.getDescricaoPavilhao(), objAlertaPortPav.getIdPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA SET IdRegistroOF=?,DataChegada=?,HoraChegada=?,IdInternoCrc=?,IdPav=?,IdOficial=?,AssinaturaDigitalVisita=?,Confirmacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroOF='" + objAlertaPortPav.getIdRegistroOF() + "'AND IdInternoCrc='" + objAlertaPortPav.getIdInternoCrc() + "'");
            pst.setInt(1, objAlertaPortPav.getIdRegistroOF());
            pst.setTimestamp(2, new java.sql.Timestamp(objAlertaPortPav.getDataChegada().getTime()));
            pst.setString(3, objAlertaPortPav.getHoraChegada());
            pst.setInt(4, codInterno);
            pst.setInt(5, idPavilhao);
            pst.setInt(6, objAlertaPortPav.getIdOficial());
            pst.setBytes(7, objAlertaPortPav.getAssinaturaDigitalVisita());
            pst.setString(8, objAlertaPortPav.getConfirmacao());
            pst.setString(9, objAlertaPortPav.getUsuarioUp());
            pst.setString(10, objAlertaPortPav.getDataUp());
            pst.setString(11, objAlertaPortPav.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes excluirAcessoOficialPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA WHERE IdRegistroOF='" + objAlertaPortPav.getIdRegistroOF() + "'AND IdInternoCrc='" + objAlertaPortPav.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }
///------------------------------------------- TELA DE ADVOGADOS ----------------------------------------------

    public AlertaVisitasPortariaPavilhoes incluirAcessoAdvogadoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        buscarInterno(objAlertaPortPav.getNomeInternoCrc(), objAlertaPortPav.getIdInternoCrc());
        buscarPavilhao(objAlertaPortPav.getDescricaoPavilhao(), objAlertaPortPav.getIdPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA (IdRegistroAD,DataChegada,HoraChegada,IdInternoCrc,IdPav,IdAdvogado,AssinaturaDigitalVisita,Confirmacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAlertaPortPav.getIdRegistroAD());
            pst.setTimestamp(2, new java.sql.Timestamp(objAlertaPortPav.getDataChegada().getTime()));
            pst.setString(3, objAlertaPortPav.getHoraChegada());
            pst.setInt(4, codInterno);
            pst.setInt(5, idPavilhao);
            pst.setInt(6, objAlertaPortPav.getIdAdvogado());
            pst.setBytes(7, objAlertaPortPav.getAssinaturaDigitalVisita());
            pst.setString(8, objAlertaPortPav.getConfirmacao());
            pst.setString(9, objAlertaPortPav.getUsuarioInsert());
            pst.setString(10, objAlertaPortPav.getDataInsert());
            pst.setString(11, objAlertaPortPav.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes alterarAcessoAdvogadoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        buscarInterno(objAlertaPortPav.getNomeInternoCrc(), objAlertaPortPav.getIdInternoCrc());
        buscarPavilhao(objAlertaPortPav.getDescricaoPavilhao(), objAlertaPortPav.getIdPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA SET IdRegistroAD=?,DataChegada=?,HoraChegada=?,IdInternoCrc=?,IdPav=?,IdAdvogado=?,AssinaturaDigitalVisita=?,Confirmacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroAD='" + objAlertaPortPav.getIdRegistroAD() + "'AND IdInternoCrc='" + objAlertaPortPav.getIdInternoCrc() + "'");
            pst.setInt(1, objAlertaPortPav.getIdRegistroAD());
            pst.setTimestamp(2, new java.sql.Timestamp(objAlertaPortPav.getDataChegada().getTime()));
            pst.setString(3, objAlertaPortPav.getHoraChegada());
            pst.setInt(4, codInterno);
            pst.setInt(5, idPavilhao);
            pst.setInt(6, objAlertaPortPav.getIdAdvogado());
            pst.setBytes(7, objAlertaPortPav.getAssinaturaDigitalVisita());
            pst.setString(8, objAlertaPortPav.getConfirmacao());
            pst.setString(9, objAlertaPortPav.getUsuarioUp());
            pst.setString(10, objAlertaPortPav.getDataUp());
            pst.setString(11, objAlertaPortPav.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes excluirAcessoAdvogadoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA WHERE IdRegistroAD='" + objAlertaPortPav.getIdRegistroAD() + "'AND IdInternoCrc='" + objAlertaPortPav.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

///------------------------------------------- INICIO METODO PARA VISITAS INTERNOS --------------------------------------------------
    public AlertaVisitasPortariaPavilhoes incluirAcessoVisitaInternoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        buscarInterno(objAlertaPortPav.getNomeInternoCrc(), objAlertaPortPav.getIdInternoCrc());
        buscarPavilhao(objAlertaPortPav.getDescricaoPavilhao(), objAlertaPortPav.getIdPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA (IdRegistroVI,DataChegada,HoraChegada,IdInternoCrc,IdPav,IdVisita,AssinaturaDigitalVisita,Confirmacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAlertaPortPav.getIdRegistroVI());
            pst.setTimestamp(2, new java.sql.Timestamp(objAlertaPortPav.getDataChegada().getTime()));
            pst.setString(3, objAlertaPortPav.getHoraChegada());
            pst.setInt(4, codInterno);
            pst.setInt(5, idPavilhao);
            pst.setInt(6, objAlertaPortPav.getIdVisita());
            pst.setBytes(7, objAlertaPortPav.getAssinaturaDigitalVisita());
            pst.setString(8, objAlertaPortPav.getConfirmacao());
            pst.setString(9, objAlertaPortPav.getUsuarioInsert());
            pst.setString(10, objAlertaPortPav.getDataInsert());
            pst.setString(11, objAlertaPortPav.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes alterarAcessoVisitaInternoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        buscarInterno(objAlertaPortPav.getNomeInternoCrc(), objAlertaPortPav.getIdInternoCrc());
        buscarPavilhao(objAlertaPortPav.getDescricaoPavilhao(), objAlertaPortPav.getIdPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA SET IdRegistroVI=?,DataChegada=?,HoraChegada=?,IdInternoCrc=?,IdPav=?,IdVisita=?,AssinaturaDigitalVisita=?,Confirmacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroVI='" + objAlertaPortPav.getIdRegistroVI() + "'AND IdInternoCrc='" + objAlertaPortPav.getIdInternoCrc() + "'");
            pst.setInt(1, objAlertaPortPav.getIdRegistroVI());
            pst.setTimestamp(2, new java.sql.Timestamp(objAlertaPortPav.getDataChegada().getTime()));
            pst.setString(3, objAlertaPortPav.getHoraChegada());
            pst.setInt(4, codInterno);
            pst.setInt(5, idPavilhao);
            pst.setInt(6, objAlertaPortPav.getIdVisita());
            pst.setBytes(7, objAlertaPortPav.getAssinaturaDigitalVisita());
            pst.setString(8, objAlertaPortPav.getConfirmacao());
            pst.setString(9, objAlertaPortPav.getUsuarioUp());
            pst.setString(10, objAlertaPortPav.getDataUp());
            pst.setString(11, objAlertaPortPav.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes alterarConfirmaVisitaInternoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA SET Confirmacao=? WHERE IdRegAlerta='" + objAlertaPortPav.getIdRegAlerta() + "'");
            pst.setString(1, objAlertaPortPav.getConfirmacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

    public AlertaVisitasPortariaPavilhoes excluirAcessoVisitaInternoPortariaPavilhoes(AlertaVisitasPortariaPavilhoes objAlertaPortPav) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA WHERE IdRegistroVI='" + objAlertaPortPav.getIdRegistroVI() + "'AND IdInternoCrc='" + objAlertaPortPav.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados do ALERTA.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAlertaPortPav;
    }

/// ---------------------------------------------- FIM DO METODO -------------------------------------------------------   
    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarPavilhao(String descricao, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + descricao + "'AND IdPav='" + id + "'");
            conecta.rs.first();
            idPavilhao = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados doPAVILHÃO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
