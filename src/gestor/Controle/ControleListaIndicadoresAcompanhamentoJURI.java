/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import static gestor.Visao.TelaPRORES.pDocumento;
import static gestor.Visao.TelaPRORES.pResenhaEntregue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListaIndicadoresAcompanhamentoJURI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String entradaUniade = "ENTRADA NA UNIDADE";
    String retornoUnidade = "RETORNO A UNIDADE";
    String pSaida_PROGRESSAO = "PROGRESSAO REGIME";
    String pSaida_LIVRAMENTO = "LIVRAMENTO CONDICIONAL";
    String pDocumentacaoComp = "Sim";

    public List<IndicadoresAcompanhamento> read() throws Exception {
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT "
                    + "PRONTUARIOSCRC.IdInternoCrc,"
                    + "PRONTUARIOSCRC.NomeInternoCrc,"
                    + "PRONTUARIOSCRC.DocumentacaoCompleta "
                    + "FROM PRONTUARIOSCRC "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + entradaUniade + "'"
                    + "AND PRONTUARIOSCRC.DocumentacaoCompleta='" + pDocumentacaoComp + "'"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + retornoUnidade + "' "
                    + "AND PRONTUARIOSCRC.DocumentacaoCompleta='" + pDocumentacaoComp + "'");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiProd.setNomeInternoPerfil(conecta.rs.getString("NomeInternoCrc"));
                pDigiProd.setDocumentacao(conecta.rs.getString("DocumentacaoCompleta"));
                if (pDigiProd.getDocumentacao().equals("Sim")) {
                    pDocumento++;
                    pDigiProd.setQtdDocumentacao(pDocumento);
                }
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaIndicadoresAcompanhamentoJURI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
