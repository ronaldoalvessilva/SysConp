/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutosPagtoKitInterno;
import static gestor.Visao.TelaCancelamentoKit.jComboBoxPesquisarInterno;
import static gestor.Visao.TelaCancelamentoKit.pKitPago;
import static gestor.Visao.TelaCancelamentoKit.statusFinal;
import static gestor.Visao.TelaCancelamentoKit.utilizado;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxPavilhao;
import java.sql.SQLException;

/**
 *
 * @author ronaldo.silva7
 */
public class Controle_PESQUISAR_kits_internosFU {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutosPagtoKitInterno objItensPagtoProd = new ProdutosPagtoKitInterno();

    //KIT INICIAL
    public ProdutosPagtoKitInterno pPAGAMENTO_KIT_FUinicial(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                    + "KITS_INICIAL_INTERNOS.KitPago,KITS_INICIAL_INTERNOS.Utilizado "
                    + "FROM  PRONTUARIOSCRC "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_INICIAL_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=KITS_INICIAL_INTERNOS.IdInternoCrc "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp='" + statusFinal + "' "
                    + "AND KITS_INICIAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_INICIAL_INTERNOS.Utilizado='" + utilizado + "'"
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //KIT DECENDIAL
    public ProdutosPagtoKitInterno pPAGAMENTO_KIT_FUdecendial(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "KITS_DECENDIAL_INTERNOS.KitPago, "
                    + "KITS_DECENDIAL_INTERNOS.Utilizado "
                    + "FROM KITS_DECENDIAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_DECENDIAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE KITS_DECENDIAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //KIT QUINZENAL
    public ProdutosPagtoKitInterno pPAGAMENTO_KIT_FUquinzenal(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "KITS_QUINZENAL_INTERNOS.KitPago, "
                    + "KITS_QUINZENAL_INTERNOS.Utilizado "
                    + "FROM KITS_QUINZENAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_QUINZENAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE KITS_QUINZENAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_QUINZENAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //KIT MENSAL
    public ProdutosPagtoKitInterno pPAGAMENTO_KIT_FUmensal(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "KITS_MENSAL_INTERNOS.KitPago,KITS_MENSAL_INTERNOS.Utilizado "
                    + "FROM KITS_MENSAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_MENSAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "      
                    + "WHERE KITS_MENSAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_MENSAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    // KIT SEMESTRAL
    public ProdutosPagtoKitInterno pPAGAMENTO_KIT_FUsemetral(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "KITS_SEMESTRAL_INTERNOS.KitPago,KITS_SEMESTRAL_INTERNOS.Utilizado "
                    + "FROM KITS_SEMESTRAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_SEMESTRAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "                                   
                    + "WHERE KITS_SEMESTRAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_SEMESTRAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //KIT ANUAL
    public ProdutosPagtoKitInterno pPAGAMENTO_KIT_FUanual(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "KITS_ANUAL_INTERNOS.KitPago,KITS_ANUAL_INTERNOS.Utilizado "
                    + "FROM KITS_ANUAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_ANUAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "                   
                    + "WHERE KITS_ANUAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_ANUAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }
}
