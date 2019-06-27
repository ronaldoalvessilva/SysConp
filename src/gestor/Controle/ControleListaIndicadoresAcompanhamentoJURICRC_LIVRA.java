/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static gestor.Visao.TelaPRORES.pPROGRESSAO;
import static gestor.Visao.TelaPRORES.pLIVRAMENTO;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListaIndicadoresAcompanhamentoJURICRC_LIVRA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String entradaUniade = "ENTRADA NA UNIDADE";
    String retornoUnidade = "RETORNO A UNIDADE";
    String pSaida_PROGRESSAO = "PROGRESSAO DE REGIME";
    String pSaida_LIVRAMENTO = "LIVRAMENTO CONDICIONAL";
    String pDocumentacaoComp = "Sim";

    public List<IndicadoresAcompanhamento> read() throws Exception {
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "PRONTUARIOSCRC.IdInternoCrc,"
                    + "PRONTUARIOSCRC.NomeInternoCrc,"
                    + "ATIVIDADESJURIDICOS.DescricaoAtiv, "
                    + "ITENSSAIDA.DestinoSaida "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSATENDIMENTOJURI "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSATENDIMENTOJURI.IdInternoCrc "
                    + "INNER JOIN ATIVIDADESJURIDICOS "
                    + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                    + "INNER JOIN ITENSSAIDA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSSAIDA.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + entradaUniade + "' "
                    + "AND ITENSSAIDA.DestinoSaida='" + pSaida_LIVRAMENTO + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + retornoUnidade + "' "
                    + "AND ITENSSAIDA.DestinoSaida='" + pSaida_LIVRAMENTO + "'");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiProd.setNomeInternoPerfil(conecta.rs.getString("NomeInternoCrc"));
                pDigiProd.setLivramento(conecta.rs.getString("DestinoSaida"));
//                if (pDigiProd.getLivramento().equals("PROGRESSAO DE REGIME")) {
//                    pPROGRESSAO++;
//                    pDigiProd.setQtdLivramento(pPROGRESSAO);
//                }
                if (pDigiProd.getLivramento().equals("LIVRAMENTO CONDICIONAL")) {
                    pLIVRAMENTO++;
                    pDigiProd.setQtdLivramento(pLIVRAMENTO);
                }
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaIndicadoresAcompanhamentoJURICRC_LIVRA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
