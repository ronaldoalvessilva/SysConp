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
import static gestor.Visao.TelaPRORES.pSTATUS_ANDAMENTO_CONCLUIDO;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListaIndicadoresAcompanhamentoPSICOLOGIA_II {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String entradaUniade = "ENTRADA NA UNIDADE";
    String retornoUnidade = "RETORNO A UNIDADE";
    String pTRATAMENTO = "Em Andamento";
    String pCONCLUIDO = "Concluído";
    String pDocumentacaoComp = "Sim";

    public List<IndicadoresAcompanhamento> read() throws Exception {
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT "
                    + "PRONTUARIOSCRC.IdInternoCrc,"
                    + "PRONTUARIOSCRC.NomeInternoCrc,"
                    + "STATUS_INTERNO_PSICOLOGIA.StatusAtendimento "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN STATUS_INTERNO_PSICOLOGIA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=STATUS_INTERNO_PSICOLOGIA.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + entradaUniade + "' "
                    + "AND STATUS_INTERNO_PSICOLOGIA.StatusAtendimento='" + pCONCLUIDO + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + retornoUnidade + "' "
                    + "AND STATUS_INTERNO_PSICOLOGIA.StatusAtendimento='" + pCONCLUIDO + "'");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiProd.setNomeInternoPerfil(conecta.rs.getString("NomeInternoCrc"));
                pDigiProd.setTratamento(conecta.rs.getString("StatusAtendimento"));
                if (pDigiProd.getTratamento().equals("Concluído")) {
                    pSTATUS_ANDAMENTO_CONCLUIDO++;
                    pDigiProd.setQtdTratamento(pSTATUS_ANDAMENTO_CONCLUIDO);
                }                
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaIndicadoresAcompanhamentoPSICOLOGIA_II.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
