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
import static gestor.Visao.TelaCancelamentoEvasao.jIdInternoEvadido;
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
import static gestor.Visao.TelaPesquisaCancelaEvadidos_PD.idItem_CEPDomiciliar;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_PD.jPesqNomeInternoEvadidoPrisaoDomi;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_PD.nomeInterno_PD;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_PD.pCODIGO_INTERNO_prisao;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_PD.pCODIGO_SAIDA_prisao;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_PD.pTOTAL_REGISTROS_prisao;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.idItem_CE;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.jPesqNomeInternoEvadido;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.nomeInterno;
import static gestor.Visao.TelaPesquisaCancelaEvadidos_TMP.pCODIGO_saida;
import static gestor.Visao.TelaCancelamentoEvasao.pINTERNO_rol;
import static gestor.Visao.TelaCancelamentoEvasao.saldoTotalCredito;
import static gestor.Visao.TelaCancelamentoEvasao.saldoTotalDebito;
import static gestor.Visao.TelaCancelamentoEvasao.tipoMovCred;
import static gestor.Visao.TelaCancelamentoEvasao.tipoMovDeb;
import static gestor.Visao.TelaCancelamentoEvasao.valorCredito;
import static gestor.Visao.TelaCancelamentoEvasao.valorDebito;
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
    //SAIDA TEMPORAIA E MÉDICO
    String pTIPO_SAIDA = "SAIDA TEMPORARIA";
    String pTIPO_SAIDA_medico = "SAIDA PARA MEDICO";
    String pTIPO_SAIDA_PRISAO_domiciliar = "PRISAO DOMICILIAR - COVID-19";
    String pCONFIRMAR_EVASAO_sim = "Sim";
    String dataEvasao = ""; // Variavel que controla a saida temporaria junto com a evasão
    String NrDocRetorno = "";
    //SAIDA LABORATIVA
    String horarioEntrada = "00:00";
    String evadido = "EVADIDO";
    Integer pCODIGO_INTERNO_evadido = null;
    String statusRol = "FINALIZADO";

    public CancelamentoEvasao incluirCancelamentoEvasaoInternos(CancelamentoEvasao objCancelaEvasao) {
        PESQUISAR_CODIGO_interno(objCancelaEvasao.getNomeInternoCrc(), objCancelaEvasao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CANCELAMENTO_EVASAO_INTERNOS (StatusRegistro,DataRegistro,TipoOperacaoCancelar,NomeResponsavel,CargoResponsavel,NumeroDocumentoCancela,DataCancelamento,IdLanc,IdInternoCrc,MotivoCancelamento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setInt(9, pCODIGO_INTERNO_evadido);
            pst.setString(10, objCancelaEvasao.getMotivoCancelamento());
            pst.setString(11, objCancelaEvasao.getUsuarioInsert());
            pst.setString(12, objCancelaEvasao.getDataInsert());
            pst.setString(13, objCancelaEvasao.getHorarioInsert());
            pst.execute();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao alterarCancelamentoEvasaoInternos(CancelamentoEvasao objCancelaEvasao) {
        PESQUISAR_CODIGO_interno(objCancelaEvasao.getNomeInternoCrc(), objCancelaEvasao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAMENTO_EVASAO_INTERNOS SET StatusRegistro=?, "
                    + "DataRegistro=?,TipoOperacaoCancelar=?,NomeResponsavel=?,CargoResponsavel=?,NumeroDocumentoCancela=?, "
                    + "DataCancelamento=?,IdLanc=?,IdInternoCrc=?,MotivoCancelamento=?,UsuarioUp=?,DataUp=?, "
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
            pst.setInt(9, pCODIGO_INTERNO_evadido);
            pst.setString(10, objCancelaEvasao.getMotivoCancelamento());
            pst.setString(11, objCancelaEvasao.getUsuarioUp());
            pst.setString(12, objCancelaEvasao.getDataUp());
            pst.setString(13, objCancelaEvasao.getHorarioUp());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao excluirCancelamentoEvasaoInternos(CancelamentoEvasao objCancelaEvasao) {

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

    public void PESQUISAR_CODIGO_interno(String nome, Integer codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "NomeInternoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "WHERE IdInternoCrc='" + codigo + "' "
                    + "AND NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_evadido = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter os dados do interno, tente novamente.\nERROR: " + e);
        }
        conecta.desconecta();
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
                    + "c.TipoOperacaoCancelar, "
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
                pLISTA_registros.setTipoEvasao(conecta.rs.getInt("TipoOperacaoCancelar"));
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
                    + "c.IdCancelaEvasao, "
                    + "c.StatusRegistro, "
                    + "c.DataRegistro, "
                    + "c.TipoOperacaoCancelar, "
                    + "c.IdInternoCrc, "
                    + "p.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS c "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON c.IdInternoCrc=P.IdinternoCrc "
                    + "WHERE c.DataRegistro BETWEEN'" + dataInicial + "' "
                    + "AND '" + dataFinal + "'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setTipoEvasao(conecta.rs.getInt("TipoOperacaoCancelar"));
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
                    + "c.IdCancelaEvasao, "
                    + "c.StatusRegistro, "
                    + "c.DataRegistro, "
                    + "c.TipoOperacaoCancelar, "
                    + "c.IdInternoCrc, "
                    + "p.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS c "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON c.IdInternoCrc=p.IdinternoCrc "
                    + "WHERE p.NomeInternoCrc LIKE'%" + jNomeInterno.getText() + "%'");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
                pLISTA_registros.setTipoEvasao(conecta.rs.getInt("TipoOperacaoCancelar"));
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
                    + "c.IdCancelaEvasao, "
                    + "c.StatusRegistro, "
                    + "c.DataRegistro, "
                    + "c.TipoOperacaoCancelar, "
                    + "c.IdInternoCrc, "
                    + "p.NomeInternoCrc "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS c "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON c.IdInternoCrc=p.IdinternoCrc ");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdCancelaEvasao(conecta.rs.getInt("IdCancelaEvasao"));
                pLISTA_registros.setStatusCancelarEvasao(conecta.rs.getString("StatusRegistro"));
                pLISTA_registros.setDataCancelaEvasao(conecta.rs.getDate("DataRegistro"));
                pLISTA_registros.setTipoOperacaoCancelar(conecta.rs.getInt("TipoOperacaoCancelar"));
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
                    + "c.IdCancelaEvasao, "
                    + "c.StatusRegistro, "
                    + "c.DataRegistro, "
                    + "c.TipoOperacaoCancelar, "
                    + "c.NomeResponsavel, "
                    + "c.CargoResponsavel, "
                    + "c.NumeroDocumentoCancela, "
                    + "c.DataCancelamento, "
                    + "c.MotivoCancelamento, "
                    + "c.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.IdItem, "
                    + "i.IdSaida, "
                    + "i.DataSaida, "
                    + "i.DocumentoSaida, "
                    + "e.IdLanc, "
                    + "e.StatusLanc, "
                    + "e.DataLanc, "
                    + "e.TipoOp "
                    + "FROM CANCELAMENTO_EVASAO_INTERNOS AS c "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON c.IdInternoCrc=p.IdinternoCrc "
                    + "INNER JOIN EVADIDOSIND AS e "
                    + "ON c.IdLanc=e.IdLanc "
                    + "INNER JOIN SAIDACRC AS s "
                    + "ON e.IdSaida=s.IdSaida "
                    + "INNER JOIN ITENSSAIDA AS i "
                    + "ON s.IdSaida=i.IdSaida "
                    + "WHERE c.IdCancelaEvasao='" + jCodigo.getText() + "'");
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
            objCancelaEvasao.setDataEvasao(conecta.rs.getDate("DataLanc"));
            objCancelaEvasao.setTipoOperacao(conecta.rs.getString("TipoOp"));
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
                    + "WHERE i.DestinoSaida='" + pTIPO_SAIDA_medico + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "' "
                    + "AND DataEvasao!='" + dataEvasao + "' "
                    + "ORDER BY p.NomeInternoCrc");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPesquisaEvasao(conecta.rs.getString("DataEvasao"));
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
                    + "ON m.IdInternoCrc=p.IdInternoCrc "
                    + "INNER JOIN ITENSREGSAIDA AS i "
                    + "ON p.IdInternoCrc=i.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido_MED.getText() + "%' "
                    + "AND i.DestinoSaida='" + pTIPO_SAIDA_medico + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "' "
                    + "AND DataEvasao!='" + dataEvasao + "' "
                    + "ORDER BY p.NomeInternoCrc");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPesquisaEvasao(conecta.rs.getString("DataEvasao"));
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

    public CancelamentoEvasao PESQUISAR_INTERNO_nome(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
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
                    + "ON p.IdInternoCrc=i.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadido_MED.getText() + "%' "
                    + "AND i.DestinoSaida='" + pTIPO_SAIDA_medico + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "' "
                    + "AND DataEvasao!='" + dataEvasao + "' ");
            conecta.rs.first();
            objCancelaEvasao.setIdItem(conecta.rs.getInt("IdItem"));
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setDataPesquisaEvasao(conecta.rs.getString("DataEvasao"));
            objCancelaEvasao.setNomeDestino(conecta.rs.getString("DestinoSaida"));
            pTOTAL_REGISTROS_medico++;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
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
                    + "IdSaida, "
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

    //------------------------------------------------ PESQUISA PRISÃO DOMICILIAR -------------------------------------
    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_PD_todos() throws Exception {
        pTOTAL_REGISTROS_prisao = 0;
        conecta.abrirConexao();
        List<CancelamentoEvasao> LISTA_REGISTROS_todos = new ArrayList<CancelamentoEvasao>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "m.IdItem, "
                    + "m.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "m.IdSaida, "
                    + "m.NrDocRetorno, "
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
                    + "WHERE i.DestinoSaida='" + pTIPO_SAIDA_PRISAO_domiciliar + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "' "
                    + "AND DataEvasao!='" + dataEvasao + "' "
                    + "ORDER BY p.NomeInternoCrc");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPesquisaEvasao(conecta.rs.getString("DataEvasao"));
                pLISTA_registros.setNomeDestino(conecta.rs.getString("DestinoSaida"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTROS_prisao++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<CancelamentoEvasao> LISTA_REGISTROS_EVADIDOS_PD_nome() throws Exception {
        pTOTAL_REGISTROS_prisao = 0;
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
                    + "ON p.IdInternoCrc=i.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadidoPrisaoDomi.getText() + "%' "
                    + "AND i.DestinoSaida='" + pTIPO_SAIDA_PRISAO_domiciliar + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "' "
                    + "AND m.DataEvasao!='" + dataEvasao + "' ");
            while (conecta.rs.next()) {
                CancelamentoEvasao pLISTA_registros = new CancelamentoEvasao();
                pLISTA_registros.setIdItem(conecta.rs.getInt("IdItem"));
                pLISTA_registros.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLISTA_registros.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pLISTA_registros.setIdSaida(conecta.rs.getInt("IdSaida"));
                pLISTA_registros.setDataSaida(conecta.rs.getDate("DataSaida"));
                pLISTA_registros.setDataPesquisaEvasao(conecta.rs.getString("DataEvasao"));
                pLISTA_registros.setNomeDestino(conecta.rs.getString("DestinoSaida"));
                LISTA_REGISTROS_todos.add(pLISTA_registros);
                pTOTAL_REGISTROS_prisao++;
            }
            return LISTA_REGISTROS_todos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public CancelamentoEvasao PESQUISAR_INTERNO_PD_nome(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
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
                    + "ON p.IdInternoCrc=i.IdInternoCrc "
                    + "WHERE p.NomeInternoCrc LIKE'%" + jPesqNomeInternoEvadidoPrisaoDomi.getText() + "%' "
                    + "AND i.DestinoSaida='" + pTIPO_SAIDA_PRISAO_domiciliar + "' "
                    + "AND m.ConfirmaEvasao='" + pCONFIRMAR_EVASAO_sim + "' "
                    + "AND DataEvasao!='" + dataEvasao + "' ");
            conecta.rs.first();
            objCancelaEvasao.setIdItem(conecta.rs.getInt("IdItem"));
            objCancelaEvasao.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objCancelaEvasao.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            objCancelaEvasao.setIdSaida(conecta.rs.getInt("IdSaida"));
            objCancelaEvasao.setDataSaida(conecta.rs.getDate("DataSaida"));
            objCancelaEvasao.setDataPesquisaEvasao(conecta.rs.getString("DataEvasao"));
            objCancelaEvasao.setNomeDestino(conecta.rs.getString("DestinoSaida"));
            pTOTAL_REGISTROS_prisao++;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoEvasao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //ABA DADOS DO INTERNO
    public CancelamentoEvasao PESQUISAR_DADOS_INTERNO_PD_evasao(CancelamentoEvasao objCancelaEvasao) {
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
                    + "WHERE p.NomeInternoCrc='" + nomeInterno_PD + "' "
                    + "AND m.IdItem='" + idItem_CEPDomiciliar + "'");
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
    public CancelamentoEvasao ENVIAR_DADOS_REGISTRO_PD_evasao(CancelamentoEvasao objCancelaEvasao) {
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
                    + "WHERE IdInternoCrc='" + pCODIGO_INTERNO_prisao + "' "
                    + "AND IdSaida='" + pCODIGO_SAIDA_prisao + "'");
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

    //-------------------------------------------- FINALIZAR O CANCELAMENTO -------------------------------------------
    //---------------------------------------------------------------- SAIDA LABORATIVA EVASÃO ------------------------
    // SAIDA LABORATIVA EVASÃO   
    public CancelamentoEvasao UPDATE_ITENS_laborativa(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLABORINTERNO SET Evadido=?"
                    + "WHERE IdInternoCrc='" + objCancelaEvasao.getIdInternoCrc() + "' "
                    + "AND IdLanc='" + objCancelaEvasao.getIdRegistroLabor() + "'");
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
    public CancelamentoEvasao UPDATE_Status(CancelamentoEvasao objItenLabor) {
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
                    + "WHERE IdInternoCrc'" + objItemSaida.getIdInternoSaida() + "' "
                    + "AND IdSaida='" + objItemSaida.getIdSaida() + "'");
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

    //--------------------------------------------------------------------------------------------
    public CancelamentoEvasao UPDATE_SITUACAO_interno(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET SituacaoCrc=? WHERE IdInternoCrc='" + objCancelaEvasao.getIdInternoCrc() + "'");
            pst.setString(1, objCancelaEvasao.getSituacaoCrc());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //--------------------------------- ROL DE VISITAS ------------------------------------------
    public CancelamentoEvasao UPDATE_ROL_SAIDA_interno(CancelamentoEvasao objCancelaEvasao) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "StatusRol "
                    + "FROM ROLVISITAS "
                    + "WHERE IdInternoCrc='" + jIdInternoEvadido.getText() + "' "
                    + "AND StatusRol='" + statusRol + "'");
            conecta.rs.first();
            pINTERNO_rol = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao FINALIZA_ROL_VISITAS_portaria(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=?,ObsPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objCancelaEvasao.getIdInternoCrc() + "'");
            pst.setString(1, objCancelaEvasao.getStatusRol());
            pst.setString(2, objCancelaEvasao.getObservacao());
            pst.setString(3, objCancelaEvasao.getUsuarioUp());
            pst.setString(4, objCancelaEvasao.getDataUp());
            pst.setString(5, objCancelaEvasao.getHoraUp());
            pst.executeUpdate();
            pRESPOSTA_cancel = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_cancel = "Não";
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao FINALIZAR_CANCELAMENTO_evasao(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVADIDOSIND SET StatusLanc=? "
                    + "WHERE IdInternoCrc='" + objCancelaEvasao.getIdInternoCrc() + "' "
                    + "AND IdLanc='" + objCancelaEvasao.getIdCancelaEvasao() + "'");
            pst.setString(1, objCancelaEvasao.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    //----------------------------------- CALCULAR VALORES DO FINANCEIRO ------------------------------------------
    public CancelamentoEvasao CALCULAR_debito(CancelamentoEvasao objCancelaEvasao) {
        valorDebito = 0;
        saldoTotalDebito = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALDOVALORES "
                    + "WHERE IdInternoCrc='" + jIdInternoEvadido.getText() + "' "
                    + "AND StatusMov='" + tipoMovDeb + "'");
            conecta.rs.first();
            do {
                valorDebito = conecta.rs.getDouble("ValorMov");
                saldoTotalDebito = saldoTotalDebito + valorDebito;
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }

    public CancelamentoEvasao CALCULAR_credito(CancelamentoEvasao objCancelaEvasao) {
        valorCredito = 0;
        saldoTotalCredito = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALDOVALORES "
                    + "WHERE IdInternoCrc='" + jIdInternoEvadido.getText() + "' "
                    + "AND StatusMov='" + tipoMovCred + "'");
            conecta.rs.first();
            do {
                valorCredito = conecta.rs.getDouble("ValorMov");
                saldoTotalCredito = saldoTotalCredito + valorCredito;
            } while (conecta.rs.next());
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
    public CancelamentoEvasao INCLUIR_saldo(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALDOVALORES (IdInternoCrc,IdLanc,Historico,FavorecidoDepositante,ValorMov,StatusMov,DataMov) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objCancelaEvasao.getIdInternoCrc());
            pst.setInt(2, objCancelaEvasao.getIdCancelaEvasao());
            pst.setString(3, objCancelaEvasao.getHistorico());
            pst.setString(4, objCancelaEvasao.getFavorecidoDepositante());
            pst.setFloat(5, objCancelaEvasao.getSaldo());
            pst.setString(6, objCancelaEvasao.getStatusMov());
            pst.setTimestamp(7, new java.sql.Timestamp(objCancelaEvasao.getDataMov().getTime()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
    public CancelamentoEvasao INCLUIR_SALDO_inativos(CancelamentoEvasao objCancelaEvasao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SALDO_VALORES_INATIVOS (DataMov,IdInternoCrc,IdDoc,Historico,FavorecidoDepositante,TipoMov,ValorMov,SaldoAtual) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objCancelaEvasao.getDataMov().getTime()));
            pst.setInt(2, objCancelaEvasao.getIdInternoCrc());
            pst.setInt(3, objCancelaEvasao.getIdCancelaEvasao());
            pst.setString(4, objCancelaEvasao.getHistorico());
            pst.setString(5, objCancelaEvasao.getFavorecidoDepositante());
            pst.setString(6, objCancelaEvasao.getStatusMov());
            pst.setFloat(7, objCancelaEvasao.getSaldo());
            pst.setDouble(8, objCancelaEvasao.getSaldoAtual());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
    public CancelamentoEvasao INCLUIR_saque(CancelamentoEvasao objCancelaEvasao) {
        PESQUISAR_CODIGO_interno(objCancelaEvasao.getNomeInternoCrc(), objCancelaEvasao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SAQUE (StatusLanc,DataLanc,IdInternoCrc,ValorSaque,Favorecido,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancelaEvasao.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancelaEvasao.getDataLanc().getTime()));
            pst.setInt(3, pCODIGO_INTERNO_evadido);
            pst.setFloat(4, objCancelaEvasao.getValorSaque());
            pst.setString(5, objCancelaEvasao.getFavorecido());
            pst.setString(6, objCancelaEvasao.getObservacao());
            pst.setString(7, objCancelaEvasao.getUsuarioInsert());
            pst.setString(8, objCancelaEvasao.getDataInsert());
            pst.setString(9, objCancelaEvasao.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
    
    public CancelamentoEvasao INCLUID_depositos(CancelamentoEvasao objCancelaEvasao) {
        PESQUISAR_CODIGO_interno(objCancelaEvasao.getNomeInternoCrc(), objCancelaEvasao.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEPOSITO_INATIVOS (StatusLanc,DataLanc,IdInternoCrc,ValorDeposito,Depositante,Observacao,UsuarioInsert,DataInsert,HorarioInsert,Tipo) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancelaEvasao.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancelaEvasao.getDataLanc().getTime()));
            pst.setInt(3, pCODIGO_INTERNO_evadido);
            pst.setFloat(4, objCancelaEvasao.getValorDeposito());
            pst.setString(5, objCancelaEvasao.getDepositante());
            pst.setString(6, objCancelaEvasao.getObservacao());
            pst.setString(7, objCancelaEvasao.getUsuarioInsert());
            pst.setString(8, objCancelaEvasao.getDataInsert());
            pst.setString(9, objCancelaEvasao.getHoraInsert());
            pst.setString(10, objCancelaEvasao.getTipoTrans());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaEvasao;
    }
}
