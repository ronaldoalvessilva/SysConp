/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DigitalInterno;
import static gestor.Visao.TelaSolicitacaoAuxilioReclusao.jCodigoVisitaAux;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControlePesquisaInternoAuxiloRec {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    String pBio = null;
    String situacao = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    public static int qtdInternos = 0;
    String statusRol = "ABERTO";

    public List<DigitalInterno> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInterno> listaColaboradores = new ArrayList<DigitalInterno>();
        try {
            conecta.executaSQL("SELECT * FROM ROLVISITAS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ROLVISITAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENSROL "
                    + "ON ROLVISITAS.IdRol=ITENSROL.IdRol "
                    + "WHERE BIOMETRIA_INTERNOS.BiometriaDedo1!='" + pBio + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacao + "' "
                    + "AND ITENSROL.IdVisita='" + jCodigoVisitaAux.getText() + "' "
                    + "AND ROLVISITAS.StatusRol='" + statusRol + "' "
                    + "OR BIOMETRIA_INTERNOS.BiometriaDedo1!='" + pBio + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "' "
                    + "AND ITENSROL.IdVisita='" + jCodigoVisitaAux.getText() + "' "
                    + "AND ROLVISITAS.StatusRol='" + statusRol + "'");
            while (conecta.rs.next()) {
                DigitalInterno pDigi = new DigitalInterno();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setNomeMaeInterno(conecta.rs.getString("MaeInternoCrc"));
                pDigi.setRegimePenal(conecta.rs.getString("Regime"));
                pDigi.setFotoInternoDB(conecta.rs.getBytes("ImagemFrente"));
                pDigi.setCnc(conecta.rs.getString("Cnc"));
                pDigi.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigi.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigi.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigi.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                listaColaboradores.add(pDigi);
                qtdInternos++;
            }
            return listaColaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaInternoAuxiloRec.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
