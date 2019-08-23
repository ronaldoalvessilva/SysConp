/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import static gestor.Visao.TelaPRORES.pSTATUS_SITUACAO_APROVADO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaIndicadoresAcompanhamentoTO_APROVADO {
    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String entradaUniade = "ENTRADA NA UNIDADE";
    String retornoUnidade = "RETORNO A UNIDADE";
    String pESTUDANDO = "Andamento";
    String pCONCLUIDO = "Concluído";
    String pREPROVADO = "Reprovado";
    String pDocumentacaoComp = "Sim";
    String pAPROVADOS = "Aprovado";

    public List<IndicadoresAcompanhamento> read() throws Exception {
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT "
                    + "PRONTUARIOSCRC.IdInternoCrc,"
                    + "PRONTUARIOSCRC.NomeInternoCrc,"
                    + "ITENS_CAPACITACAO_INTERNO_TO.SituacaoCurso "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENS_CAPACITACAO_INTERNO_TO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_CAPACITACAO_INTERNO_TO.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + entradaUniade + "' "
                    + "AND ITENS_CAPACITACAO_INTERNO_TO.SituacaoCurso='" + pAPROVADOS + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + retornoUnidade + "' "
                    + "AND ITENS_CAPACITACAO_INTERNO_TO.SituacaoCurso='" + pAPROVADOS + "'");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiProd.setNomeInternoPerfil(conecta.rs.getString("NomeInternoCrc"));
                pDigiProd.setSituacaoAluno(conecta.rs.getString("SituacaoCurso"));
                if (pDigiProd.getSituacaoAluno().equals("Aprovado")) {
                    pSTATUS_SITUACAO_APROVADO++;
                    pDigiProd.setqTdAprova(pSTATUS_SITUACAO_APROVADO);
                }                
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaIndicadoresAcompanhamentoTO_APROVADO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
