/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoEvasao;
import static gestor.Visao.TelaCancelamentoEvasao.dataFinal;
import static gestor.Visao.TelaCancelamentoEvasao.dataInicial;
import static gestor.Visao.TelaCancelamentoEvasao.jCodigo;
import static gestor.Visao.TelaCancelamentoEvasao.jIdLanc;
import static gestor.Visao.TelaCancelamentoEvasao.jNomeInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaCancelamentoEvasao.pRESPOSTA_cancel;
import static gestor.Visao.TelaCancelamentoEvasao.pTOTAL_registros;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_EDU.jPesqNomeInternoEvadido_EDU;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_EDU.pTOTAL_REGISTRO_educa;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_LAB.jPesqNomeInternoEvadido_LAB;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_LAB.pCODIGO_LAB_saida;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_LAB.pCODIGO_LB_interno;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_LAB.pTOTAL_REGISTROS_laborativa;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_MED.idItem_CESMedico;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_MED.jPesqNomeInternoEvadido_MED;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_MED.nomeInterno_SM;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_MED.pCODIGO_INTERNO_medico;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_MED.pCODIGO_SAIDA_medico;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_MED.pTOTAL_REGISTROS_medico;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.idItem_CE;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.jPesqNomeInternoEvadido;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.nomeInterno;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.pCODIGO_saida;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.pCODIGO_interno;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.pTOTAL_evadidos;

/**
 *
 * @author ronal
 */
public class ControleCancelamentoEvasao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoEvasao objCancelaEvasao = new CancelamentoEvasao();
    //SAIDA TEMPORAIA
    String pTIPO_SAIDA = "SAIDA TEMPORARIA";
    String pTIPO_SAIDA_medico = "SAIDA PARA MEDICO";
    String pCONFIRMAR_EVASAO_sim = "Sim";
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    String NrDocRetorno = "";
    //SAIDA LABORATIVA
    String horarioEntrada = "00:00";
    String evadido = "EVADIDO";

    public CancelamentoEvasao incluirCancelamentoEvasaoInTernos(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CANCELAMENTO_EVASAO_INTERNOS (StatusRegistro,DataRegistro,TipoOperacaoCancelar,NomeResponsavel,CargoResponsavel,NumeroDocumentoCancela,DataCancelamento,IdLanc,IdInternoCrc,IdItem,IdSaida,MotivoCancelamento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancelaEvasao.getStatusLanc());
            if (objCancelaEvasao.getDataRegistroCancelamento() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objCancelaEvasao.getDataRegistroCancelamento().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, objCancelaEvasao.getTipoOperacaoCancelar());
            pst.setString(4, objCancelaEvasao.getNomeResponsavel());
            pst.setString(5, objCancelaEvasao.getCargoResponsavel());
            pst.setString(6, objCancelaEvasao.getNumeroDocumentoCancela());
            if ((objCancelaEvasao.getDataCancelamento() != null)) {
                pst.setTimestamp(7, new java.sql.Timestamp(objCancelaEvasao.getDataCancelamento().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setInt(8, objCancelaEvasao.getIdRegistroEvasao());
            pst.setInt(9, objCancelaEvasao.getIdInternoCrc());
            pst.setInt(10, objCancelaEvasao.getIdItem());
            pst.setInt(11, objCancelaEvasao.getIdSaida());
            pst.setString(12, objCancelaEvasao.getMotivoCancelamento());
            pst.setString(13, objCancelaEvasao.getUsuarioInsert());
            pst.setString(14, objCancelaEvasao.getDataInsert());
            pst.setString(15, objCancelaEvasao.getHorarioInsert());
            pst.execute();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao alterarCancelamentoEvasaoInTernos(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAMENTO_EVASAO_INTERNOS SET StatusRegistro=?,"
                    + "DataRegistro=?,TipoOperacaoCancelar=?,NomeResponsavel=?,CargoResponsavel=?,NumeroDocumentoCancela=?,"
                    + "DataCancelamento=?,IdLanc=?,IdInternoCrc=?,IdItem=?,IdSaida=?,MotivoCancelamento=?,UsuarioUp=?,DataUp=?,"
                    + "HorarioUp=? WHERE IdCancelaEvasao='" + objCancelaEvasao.getIdCancelaEvasao() + "'");
            pst.setString(1, objCancelaEvasao.getStatusLanc());
            if (objCancelaEvasao.getDataRegistroCancelamento() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objCancelaEvasao.getDataRegistroCancelamento().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, objCancelaEvasao.getTipoOperacaoCancelar());
            pst.setString(4, objCancelaEvasao.getNomeResponsavel());
            pst.setString(5, objCancelaEvasao.getCargoResponsavel());
            pst.setString(6, objCancelaEvasao.getNumeroDocumentoCancela());
            if ((objCancelaEvasao.getDataCancelamento() != null)) {
                pst.setTimestamp(7, new java.sql.Timestamp(objCancelaEvasao.getDataCancelamento().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setInt(8, objCancelaEvasao.getIdRegistroEvasao());
            pst.setInt(9, objCancelaEvasao.getIdInternoCrc());
            pst.setInt(10, objCancelaEvasao.getIdItem());
            pst.setInt(11, objCancelaEvasao.getIdSaida());
            pst.setString(12, objCancelaEvasao.getMotivoCancelamento());
            pst.setString(13, objCancelaEvasao.getUsuarioInsert());
            pst.setString(14, objCancelaEvasao.getDataInsert());
            pst.setString(15, objCancelaEvasao.getHorarioInsert());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao excluirCancelamentoEvasaoInTernos(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CANCELAMENTO_EVASAO_INTERNOS "
                    + "WHERE IdCancelaEvasao='" + objCancelaEvasao.getIdCancelaEvasao() + "'");
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao BUSCAR_CODIGO_cancelamento(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdCancelaEvasao "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS");
            conecta.rs.last();
            jIdLanc.setText(String.valueOf(conecta.rs.getInt("IdCancelaEvasao")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro.\nERROR: " + e);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //--------------------------------------------- PESQUISAS DADOS DO CANCELAMENTO --------------------------------------
    public List<CancelamentoEvasao> LISTA_REGISTROS_CODIGO_read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_codigo = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "C.IdCancelaEvasao, "
                    + "C.StatusRegistro, "
                    + "C.DataRegistro, "
                    + "P.IdInternoCrc, "
                    + "P.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS C "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON C.IdInternoCrc=P.IdinternoCrc "
                    + "WHERE C.IdCancelaEvasao='" + jCodigo.getText() + "' "
                    + "ORDER BY C.IdCancelaEvasao");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                LISTA_REGISTROS_codigo.add(pLISTA_registros);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return LISTA_REGISTROS_codigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_DATA_read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_data = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "C.IdCancelaEvasao, "
                    + "C.StatusRegistro, "
                    + "C.DataRegistro, "
                    + "P.IdInternoCrc, "
                    + "P.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS C "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON C.IdInternoCrc=P.IdinternoCrc "
                    + "WHERE C.DataCancelaEvasao BETWEEN='" + dataInicial + "' "
                    + "AND '" + dataFinal + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                LISTA_REGISTROS_data.add(pLISTA_registros);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return LISTA_REGISTROS_data;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_NOME_read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_nome = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "C.IdCancelaEvasao, "
                    + "C.StatusRegistro, "
                    + "C.DataRegistro, "
                    + "P.IdInternoCrc, "
                    + "P.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS C "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON C.IdInternoCrc=P.IdinternoCrc "
                    + "WHERE P.NomeInternoCrc LIKE='%" + jNomeInterno.getText() + "%'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                LISTA_REGISTROS_nome.add(pLISTA_registros);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return LISTA_REGISTROS_nome;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_TODOS_read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_nome = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "C.IdCancelaEvasao, "
                    + "C.StatusRegistro, "
                    + "C.DataRegistro, "
                    + "P.IdInternoCrc, "
                    + "P.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS C "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON C.IdInternoCrc=P.IdinternoCrc ");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                LISTA_REGISTROS_nome.add(pLISTA_registros);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return LISTA_REGISTROS_nome;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public CancelamentoEvasao MOSTRAR_pesquisa(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "C.IdCancelaEvasao, "
                    + "C.StatusRegistro, "
                    + "C.DataRegistro, "
                    + "C.MotivoCancelamento, "
                    + "C.IdLanc, "
                    + "I.IdInternoCrc, "
                    + "P.NomeInternoCrc, "
                    + "I.IdItem, "
                    + "I.IdSaida, "
                    + "I.DataSaida, "
                    + "I.DocumentoSaida, "
                    + "E.TipoEvasao "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS C "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON C.IdInternoCrc=P.IdinternoCrc "
                    + "INNER JOIN EVADIDOSIND AS E"
                    + "ON C.IdLanc=E.IdLanc "
                    + "INNER JOIN SAIDASCRC AS S "
                    + "ON C.IdSaida=S.IdSaida "
                    + "INNER JOIN ITENSSAIDAS AS I "
                    + "ON S.IdSaida=I.IdSaida "
                    + "WHERE C.IdCancelaEvasao='" + jCodigo.getText() + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
            objCancelaEvasao.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
            objCancelaEvasao.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
            //ABA DADOS DO LIBERADOR
            objCancelaEvasao.setNomeResponsavel(conecta.rs.getString("NomeResponsavel"));
            objCancelaEvasao.setCargoResponsavel(conecta.rs.getString("CargoResponsavel"));
            objCancelaEvasao.setNumeroDocumentoCancela(conecta.rs.getString("NumeroDocumentoCancela"));
            objCancelaEvasao.setDataCancelamento(conecta.rs.getDate("DataCancelamento"));
            //ABA DADOS DA EVASÃO
            objCancelaEvasao.setIdRegistroEvasao(conecta.rs.getInt("IdLanc"));
            objCancelaEvasao.setStatusLanc(conecta.rs.getString("StatusLanc"));
            objCancelaEvasao.setDataEvasao(conecta.rs.getDate("DataEvasao"));
            objCancelaEvasao.setTipoEvasao(conecta.rs.getInt("TipoEvasao"));
            //ABA DADOS DO INTERNO
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setIdItem(conecta.rs.getInt("IdItem"));
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setNrDocSaida(conecta.rs.getString("DocumentoSaida"));
            objCancelaEvasao.setMotivoCancelamento(conecta.rs.getString("MotivoCancelamento"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //---------------------------------------- PESQUISAS DO TIPO DE EVASÃO --------------------------------------------
    //SAIDA TEMPORÁRIA
    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_ST_todos() throws Exception {
        pTOTAL_evadidos = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "M.IdItem, "
                    + "M.IdInternoCrc, "
                    + "P.NomeInternoCrc, "
                    + "M.IdSaida, "
                    + "M.NrDocRetorno, "
                    + "M.DataPrevRetorno, "
                    + "M.DataEvasao, "
                    + "M.DataSaida, "
                    + "M.DataPrevRetorno, "
                    + "M.NrDocRetorno, "
                    + "M.ConfirmaEvasao, "
                    + "I.DestinoSaida "
                    + "FROM MOVISR AS M "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON M.IdInternoCrc=P.IdInternoCrc "
                    + "INNER JOIN ITENSREGSAIDA AS I "
                    + "ON M.IdInternoCrc=I.IdInternoCrc "
                    + "WHERE M.NrDocRetorno!='" + NrDocRetorno + "' "
                    + "AND M.DataEvasao!='" + dataEvasao + "' "
                    + "AND I.DestinoSaida='" + pTIPO_SAIDA + "' "
                    + "AND M.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPrevRetorno(conecta.rs.getDate("DataPrevRetorno"));
                pLISTA_registros.setNomeDestino(conecta.rs.getString("DestinoSaida"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_evadidos++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_ST_nome() throws Exception {
        pTOTAL_evadidos = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_nome = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "M.IdItem, "
                    + "M.IdInternoCrc, "
                    + "P.NomeInternoCrc, "
                    + "M.IdSaida,"
                    + "M.NrDocRetorno, "
                    + "M.DataPrevRetorno, "
                    + "M.DataEvasao, "
                    + "I.DestinoSaida, "
                    + "M.DataSaida, "
                    + "M.DataPrevRetorno, "
                    + "M.NrDocRetorno, "
                    + "M.ConfirmaEvasao "
                    + "FROM MOVISR AS M "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON M.IdInternoCrc=P.IdInternoCrc "
                    + "INNER JOIN ITENSREGSAIDA AS I "
                    + "ON M.IdInternoCrc=I.IdInternoCrc "
                    + "WHERE M.NrDocRetorno!='" + NrDocRetorno + "' "
                    + "AND M.DataEvasao!='" + dataEvasao + "' "
                    + "AND P.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido.getText() + "%' "
                    + "AND I.DestinoSaida='" + pTIPO_SAIDA + "' "
                    + "AND M.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPrevRetorno(conecta.rs.getDate("DataPrevRetorno"));
                pLISTA_registros.setNomeDestino(conecta.rs.getString("DestinoSaida"));
                LISTA_REGISTROS_nome.add(pLISTA_registros);
                pTOTAL_evadidos++;
            }
            return LISTA_REGISTROS_nome;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    //ABA DADOS DO INTERNO
    public CancelamentoEvasao PESQUISAR_DADOS_INTERNO_ST_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "M.IdItem, "
                    + "M.IdInternoCrc, "
                    + "P.NomeInternoCrc, "
                    + "M.IdSaida, "
                    + "M.DataSaida, "
                    + "M.NrDocSaida "
                    + "FROM MOVISR AS M "
                    + "INNER JOIN PRONTUARIOSCRC AS P "
                    + "ON M.IdInternoCrc=P.IdInternoCrc "
                    + "WHERE P.NomeInternoCrc='" + nomeInterno + "' "
                    + "AND M.IdItem='" + idItem_CE + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setNrDocSaida(conecta.rs.getString("NrDocSaida"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //ABA DADOS DO EVASÃO
    public CancelamentoEvasao ENVIAR_DADOS_REGISTRO_ST_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "StatusLanc, "
                    + "DataLanc, "
                    + "IdInternoCrc, "
                    + "TipoOp "
                    + "FROM EVADIDOSIND "
                    + "WHERE IdInternoCrc='" + pCODIGO_interno + "' "
                    + "AND IdSaida='" + pCODIGO_saida + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdRegistroEvasao(conecta.rs.getInt("IdLanc"));
            objCancelaEvasao.setStatusLanc(conecta.rs.getString("StatusLanc"));
            objCancelaEvasao.setDataEvasao(conecta.rs.getDate("DataLanc"));
            objCancelaEvasao.setTipoOperacao(conecta.rs.getString("TipoOp"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //-------------------------------------------- PESQUISA DE INTERNO NA SAÍDA LABORATIVA ----------------------------
    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_LB_nome() throws Exception {
        pTOTAL_REGISTROS_laborativa = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_nome = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DataSaida, "
                    + "i.HorarioSaida, "
                    + "i.Evadido, "
                    + "i.DataEntrada, "
                    + "i.HorarioEntrada "
                    + "FROM ITENSLABORINTERNO AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc='" + jPesqNomeInternoEvadido_LAB.getText() + "' "
                    + "AND i.Evadido='" + evadido + "' "
                    + "AND HorarioEntrada='" + horarioEntrada + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdRegistroLabor(conecta.rs.getInt("IdLanc"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setHorarioSaida(conecta.rs.getString("HorarioSaida"));
                pLISTA_registros.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                pLISTA_registros.setHorarioEntrada(conecta.rs.getString("HorarioEntrada"));
                LISTA_REGISTROS_nome.add(pLISTA_registros);
                pTOTAL_REGISTROS_laborativa++;
            }
            return LISTA_REGISTROS_nome;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    //ABA DADOS DO EVASÃO
    public CancelamentoEvasao ENVIAR_DADOS_REGISTRO_LB_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdSaida, "
                    + "IdLanc, "
                    + "StatusLanc, "
                    + "DataLanc, "
                    + "IdInternoCrc, "
                    + "TipoOp "
                    + "FROM EVADIDOSIND "
                    + "WHERE IdInternoCrc='" + pCODIGO_LB_interno + "' "
                    + "AND IdSaida='" + pCODIGO_LAB_saida + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdRegistroEvasao(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setStatusLanc(conecta.rs.getString("StatusLanc"));
            objCancelaEvasao.setDataEvasao(conecta.rs.getDate("DataLanc"));
            objCancelaEvasao.setTipoOperacao(conecta.rs.getString("TipoOp"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_LB_todos() throws Exception {
        pTOTAL_REGISTROS_laborativa = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DataSaida, "
                    + "i.HorarioSaida, "
                    + "i.Evadido, "
                    + "i.DataEntrada, "
                    + "i.HorarioEntrada "
                    + "FROM ITENSLABORINTERNO AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE i.Evadido='" + evadido + "' "
                    + "AND HorarioEntrada='" + horarioEntrada + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdRegistroLabor(conecta.rs.getInt("IdLanc"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setHorarioSaida(conecta.rs.getString("HorarioSaida"));
                pLISTA_registros.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                pLISTA_registros.setHorarioEntrada(conecta.rs.getString("HorarioEntrada"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTROS_laborativa++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    //ABA DADOS DO INTERNO
    public CancelamentoEvasao PESQUISAR_DADOS_INTERNO_LAB_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DataSaida, "
                    + "i.HorarioSaida, "
                    + "i.Evadido "
                    + "FROM ITENSLABORINTERNO AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc='" + jPesqNomeInternoEvadido_LAB.getText() + "' "
                    + "AND i.Evadido='" + evadido + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdItem(conecta.rs.getInt("IdItem"));
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdLanc"));
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setHorarioSaida(conecta.rs.getString("HorarioSaida"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //ABA DADOS DO EVASÃO
    public CancelamentoEvasao ENVIAR_DADOS_REGISTRO_ED_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdSaida, "
                    + "IdLanc, "
                    + "StatusLanc, "
                    + "DataLanc, "
                    + "IdInternoCrc, "
                    + "TipoOp "
                    + "FROM EVADIDOSIND "
                    + "WHERE IdInternoCrc='" + pCODIGO_LB_interno + "' "
                    + "AND IdSaida='" + pCODIGO_LAB_saida + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdRegistroEvasao(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setStatusLanc(conecta.rs.getString("StatusLanc"));
            objCancelaEvasao.setDataEvasao(conecta.rs.getDate("DataLanc"));
            objCancelaEvasao.setTipoOperacao(conecta.rs.getString("TipoOp"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
    // ----------------------------------------------- PESQUISAS EVASÃO DE EDUCAÇÃO -----------------------------------
    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_ED_todos() throws Exception {
        pTOTAL_REGISTRO_educa = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DataSaida, "
                    + "i.HorarioSaida, "
                    + "i.DataEntrada, "
                    + "i.HorarioEntrada "
                    + "FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE i.Evadido='" + evadido + "' "
                    + "AND i.HorarioEntrada='" + horarioEntrada + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdRegistroLabor(conecta.rs.getInt("IdLanc"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setHorarioSaida(conecta.rs.getString("HorarioSaida"));
                pLISTA_registros.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                pLISTA_registros.setHorarioEntrada(conecta.rs.getString("HorarioEntrada"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTRO_educa++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_ED_nome() throws Exception {
        pTOTAL_REGISTRO_educa = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DataSaida, "
                    + "i.HorarioSaida, "
                    + "i.DataEntrada, "
                    + "i.HorarioEntrada "
                    + "FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE i.Evadido='" + evadido + "' "
                    + "AND p.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido_EDU.getText() + "%' "
                    + "AND i.HorarioEntrada='" + horarioEntrada + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdRegistroLabor(conecta.rs.getInt("IdLanc"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setHorarioSaida(conecta.rs.getString("HorarioSaida"));
                pLISTA_registros.setDataEntrada(conecta.rs.getDate("DataEntrada"));
                pLISTA_registros.setHorarioEntrada(conecta.rs.getString("HorarioEntrada"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTRO_educa++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public CancelamentoEvasao PESQUISAR_DADOS_INTERNO_EDU_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "i.IdItem, "
                    + "i.IdLanc, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DataSaida, "
                    + "i.HorarioSaida, "
                    + "i.Evadido "
                    + "FROM INTERNOS_ENTRADA_SAIDA_EDUCACAO AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc='" + jPesqNomeInternoEvadido_EDU.getText() + "' "
                    + "AND i.Evadido='" + evadido + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdItem(conecta.rs.getInt("IdItem"));
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdLanc"));
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setHorarioSaida(conecta.rs.getString("HorarioSaida"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
     //------------------------------------------------ PESQUISA SAÍDA PARA MÉDICO -------------------------------------
    
    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_SM_todos() throws Exception {
        pTOTAL_REGISTROS_medico = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "m.IdItem, "
                    + "m.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "m.IdSaida, "
                    + "m.NrDocRetorno, "
                    + "m.DataPrevRetorno, "
                    + "m.DataEvasao, "
                    + "m.DataSaida, "
                    + "m.DataPrevRetorno, "
                    + "m.NrDocRetorno, "
                    + "m.ConfirmaEvasao, "
                    + "i.DestinoSaida "
                    + "FROM MOVISR AS m "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON m.IdInternoCrc=p.IdInternoCrc "
                    + "INNER JOIN ITENSREGSAIDA AS i "
                    + "ON m.IdInternoCrc=i.IdInternoCrc "
                    + "WHERE m.NrDocRetorno!='" + NrDocRetorno + "' "
                    + "AND i.DestinoSaida='" + pTIPO_SAIDA_medico + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPrevRetorno(conecta.rs.getDate("DataPrevRetorno"));
                pLISTA_registros.setNomeDestino(conecta.rs.getString("DestinoSaida"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTROS_medico++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
    
    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_SM_nome() throws Exception {
        pTOTAL_REGISTROS_medico = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "m.IdItem, "
                    + "m.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "m.IdSaida, "
                    + "m.NrDocRetorno, "
                    + "m.DataPrevRetorno, "
                    + "m.DataEvasao, "
                    + "m.DataSaida, "
                    + "m.DataPrevRetorno, "
                    + "m.NrDocRetorno, "
                    + "m.ConfirmaEvasao, "
                    + "i.DestinoSaida "
                    + "FROM MOVISR AS m "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON m.IdInternoCrc=m.IdInternoCrc "
                    + "INNER JOIN ITENSREGSAIDA AS i "
                    + "ON m.IdInternoCrc=i.IdInternoCrc "
                    + "WHERE m.NrDocRetorno!='" + NrDocRetorno + "' "
                    + "AND p.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido_MED.getText() + "%' "
                    + "AND i.DestinoSaida='" + pTIPO_SAIDA_medico + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPrevRetorno(conecta.rs.getDate("DataPrevRetorno"));
                pLISTA_registros.setNomeDestino(conecta.rs.getString("DestinoSaida"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTROS_medico++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
    
    //ABA DADOS DO INTERNO
    public CancelamentoEvasao PESQUISAR_DADOS_INTERNO_SM_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "m.IdItem, "
                    + "m.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "m.IdSaida, "
                    + "m.DataSaida, "
                    + "m.NrDocSaida "
                    + "FROM MOVISR AS m "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON m.IdInternoCrc=P.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc='" + nomeInterno_SM + "' "
                    + "AND m.IdItem='" + idItem_CESMedico + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setNrDocSaida(conecta.rs.getString("NrDocSaida"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //ABA DADOS DO EVASÃO
    public CancelamentoEvasao ENVIAR_DADOS_REGISTRO_SM_evasao(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdLanc, "
                    + "StatusLanc, "
                    + "DataLanc, "
                    + "IdInternoCrc, "
                    + "TipoOp "
                    + "FROM EVADIDOSIND "
                    + "WHERE IdInternoCrc='" + pCODIGO_INTERNO_medico + "' "
                    + "AND IdSaida='" + pCODIGO_SAIDA_medico + "'");
            conecta.rs.first();
            objCancelaEvasao.setIdRegistroEvasao(conecta.rs.getInt("IdLanc"));
            objCancelaEvasao.setStatusLanc(conecta.rs.getString("StatusLanc"));
            objCancelaEvasao.setDataEvasao(conecta.rs.getDate("DataLanc"));
            objCancelaEvasao.setTipoOperacao(conecta.rs.getString("TipoOp"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
    
    //---------------------------------------------------------------- SAIDA LABORATIVA EVASÃO ------------------------
    // SAIDA LABORATIVA EVASÃO   
    public CancelamentoEvasao UPDATE_ITENS_laborativa(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLABORINTERNO SET Evadido=?"
                    + "WHERE IdInternoCrc='" + objCancelaEvasao.getIdInternoCrc() + "'AND IdLanc='" + objCancelaEvasao.getIdRegistroLabor() + "'");
            pst.setString(1, objCancelaEvasao.getInternoEvadido());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    // ATUALIZAR STATUS DA TABELA ENTRADALABORINTERNO
    public CancelamentoEvasao atualizarStatus(CancelamentoEvasao objItenLabor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALABORINTERNO SET StatusLanc=? WHERE IdLanc='" + objItenLabor.getIdRegistroLabor() + "'");
            pst.setString(1, objItenLabor.getStatusLanc());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Entrada/Saída laborativa do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    // SAIDA LABORATIVA EVASÃO MANUAL (MOVISR) INCLUIR O REGISTRO PARA CAPTURA DO INTERNO
    public CancelamentoEvasao INSERT_movisr(CancelamentoEvasao objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVISR (IdInternoCrc,IdSaida,DataSaida,NrDocSaida,DataEvasao,ConfirmaEvasao) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objItemSaida.getIdInternoSaida());
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(4, objItemSaida.getDocumento());
            pst.setTimestamp(5, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            pst.setString(6, objItemSaida.getConfirmaEvasao());
            pst.execute();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    // SAIDA LABORATIVA EVASÃO MANUAL (MOVISR) ALTERAR O REGISTRO PARA CAPTURA DO INTERNO
    public CancelamentoEvasao UPDATE_MOVISR_laborativa(CancelamentoEvasao objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdInternoCrc=?,IdSaida=?,"
                    + "DataSaida=?,NrDocSaida=?,DataEvasao=?,ConfirmaEvasao=? "
                    + "WHERE IdInternoCrc'" + objItemSaida.getIdInternoSaida() + "'AND IdSaida='" + objItemSaida.getIdSaida() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(2, objItemSaida.getDocumento());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            pst.setString(4, objItemSaida.getConfirmaEvasao());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //----------------------------------------- SAIDA TEMPORARIA EVASÃO  -------------------------------------------
    public CancelamentoEvasao UPDATE_ITENS_saida(CancelamentoEvasao objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET Evadido=?,ConfirmaEvasao=? "
                    + "WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND DocumentoSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getInternoEvadido());
            pst.setString(2, objItemSaida.getConfirmaEvasao());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    public CancelamentoEvasao UPDATE_CONFIRMAR_SAIDA_movisr(CancelamentoEvasao objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET ConfirmaEvasao=?,DataEvasao=? "
                    + "WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "' "
                    + "AND NrDocSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getConfirmaEvasao());
            if (objItemSaida.getDataEvasaoTmp() == null) {
                pst.setTimestamp(2, null);
            } else {
                pst.setTimestamp(2, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            }
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //------------------------------ SAIDA EDUCACIONAL - PORTARIA E PEDAGOGIA --------------------------------------------
    public CancelamentoEvasao UPDATE_SAIDA_EDUCACIONAL_DATA_HORA_portaria(CancelamentoEvasao objItenLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_ENTRADA_SAIDA_EDUCACAO SET Observacao=?,Evadido=? "
                    + "WHERE IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'AND HorarioEntrada='" + objItenLabor.getHorarioEntrada() + "'");
            pst.setString(1, objItenLabor.getInternoEvadido());
            pst.setString(2, objItenLabor.getObservacao());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    // ------------------------------ PEDAGOGIA -----------------------------------------
    public CancelamentoEvasao UPDATE_CONFIRMA_SAIDA_EDUCACIONAL_portaria(CancelamentoEvasao objItenLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_SAIDA_EDUCACIONAL SET Evadido=? "
                    + "WHERE IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'");
            pst.setString(1, objItenLabor.getInternoEvadido());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    public CancelamentoEvasao UPDATE_MOVISR_CONFIRMA_CANCELAMENTO_pedagogia(CancelamentoEvasao objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET ConfirmaEvasao=?,DataEvasao=? "
                    + "WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND NrDocSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getConfirmaEvasao());
            if (objItemSaida.getDataEvasaoTmp() == null) {
                pst.setTimestamp(2, null);
            } else {
                pst.setTimestamp(2, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            }
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
}
