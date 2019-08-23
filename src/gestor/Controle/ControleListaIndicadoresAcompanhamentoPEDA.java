/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import static gestor.Visao.TelaPRORES.pAcessoUni;
import static gestor.Visao.TelaPRORES.pAprovado;
import static gestor.Visao.TelaPRORES.pConcluido;
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
public class ControleListaIndicadoresAcompanhamentoPEDA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String entradaUniade = "ENTRADA NA UNIDADE";
    String retornoUnidade = "RETORNO A UNIDADE";

    public List<IndicadoresAcompanhamento> read() throws Exception {
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT "
                    + "PRONTUARIOSCRC.IdInternoCrc,"
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "TEMPOFORMATIVO.DescricaoTempo, "
                    + "ITENSMATRICULA.StatusAluno, "
                    + "ITENSMATRICULA.SituacaoAluno, "
                    + "RESENHA_REMICAO_INTERNO.ResenhaEntregue, "
                    + "EVOLUCAO_ADMISSAO_PEDAGOGIA.AcessoUni "
                    + "FROM PRONTUARIOSCRC "
                    + "LEFT JOIN ITENSMATRICULA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSMATRICULA.IdInternoCrc "
                    + "LEFT JOIN MATRICULAESCOLAR "
                    + "ON ITENSMATRICULA.IdMat=MATRICULAESCOLAR.IdMat "
                    + "LEFT JOIN TEMPOFORMATIVO "
                    + "ON MATRICULAESCOLAR.IdTempo=TEMPOFORMATIVO.IdTempo "
                    + "LEFT JOIN EVOLUCAO_ADMISSAO_PEDAGOGIA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=EVOLUCAO_ADMISSAO_PEDAGOGIA.IdInternoCrc "
                    + "LEFT JOIN RESENHA_REMICAO_INTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=RESENHA_REMICAO_INTERNO.IdInternoCrc "
                    + "LEFT JOIN ITENS_CAPACITACAO_INTERNO_TO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_CAPACITACAO_INTERNO_TO.IdInternoCrc "
                    + "LEFT JOIN ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + entradaUniade + "'"
                    + "AND RESENHA_REMICAO_INTERNO.ResenhaEntregue IS NOT NULL "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + retornoUnidade + "' "
                    + "AND RESENHA_REMICAO_INTERNO.ResenhaEntregue IS NOT NULL");
//                    + "WHERE TEMPOFORMATIVO.DescricaoTempo IS NOT NULL "
//                    + "AND ITENSMATRICULA.StatusAluno IS NOT NULL "
//                    + "AND ITENSMATRICULA.SituacaoAluno IS NOT NULL");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiProd.setNomeInternoPerfil(conecta.rs.getString("NomeInternoCrc"));
                pDigiProd.setTempoFormativo(conecta.rs.getString("DescricaoTempo"));
                pDigiProd.setStatusAluno(conecta.rs.getString("StatusAluno"));
                pDigiProd.setSituacaoAluno(conecta.rs.getString("SituacaoAluno"));
                pDigiProd.setResenhaEntregue(conecta.rs.getString("ResenhaEntregue"));
                pDigiProd.setAcessoUni(conecta.rs.getString("AcessoUni"));
//                if (pDigiProd.getStatusAluno().equals("Concluído") && pDigiProd.getSituacaoAluno().equals("Aprovado")) {
//                    pAprovado++;
//                    pConcluido++;
//                    pDigiProd.setqTdAprova(pAprovado);
//                    pDigiProd.setqTdConcluido(pConcluido);
//                }
                if (pDigiProd.getResenhaEntregue().equals("Sim")) {
                    pResenhaEntregue++;
                    pDigiProd.setqTdResenhaEntregue(pResenhaEntregue);
                }
//                if (pDigiProd.getTempoFormativo().equals("Sim")) {
//                    pAcessoUni++;
//                    pDigiProd.setqTdAcessoUni(pAcessoUni);
//                }
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaIndicadoresAcompanhamentoPEDA.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
