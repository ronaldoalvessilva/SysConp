/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import gestor.Visao.TelaPRORES;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListaIndicadoresAcompanhamento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String entradaUniade = "ENTRADA NA UNIDADE";
    String retornoUnidade = "RETORNO A UNIDADE";

    public List<IndicadoresAcompanhamento> read() throws Exception {
        conecta.abrirConexao();
        List<IndicadoresAcompanhamento> listaInternosPavilhaoSelecionados = new ArrayList<IndicadoresAcompanhamento>();
        try {
            conecta.executaSQL("SELECT "
                    + "SUM(QtdDiabetes)AS QtdDiabetes, "
                    + "SUM(QtdHipertensao)AS QtdHipertensao, "
                    + "SUM(QtdEscabiose) AS QtdEscabiose, "
                    + "SUM(QtdHanseniase) AS QtdHanseniase, "
                    + "SUM(QtdSifilis) AS QtdSifilis, "
                    + "SUM(QtdTuberculose) AS QtdTuberculose, "
                    + "SUM(QtdHiv) AS QtdHiv, "
                    + "SUM(QtdHepatiteB) AS QtdHepatiteB, "
                    + "SUM(QtdHepatiteC) AS QtdHepatiteC, "
                    + "SUM(QtdDst) AS QtdDst "
                    + "FROM PRONTUARIOSCRC "
                    + "LEFT JOIN ACOMPANHAMENTO_INTERNO_ENFERMARIA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ACOMPANHAMENTO_INTERNO_ENFERMARIA.IdInternoCrc "
                    + "LEFT JOIN ADMISSAOENFERMEIRA "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ADMISSAOENFERMEIRA.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + entradaUniade + "'"
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + retornoUnidade + "'");
            while (conecta.rs.next()) {
                IndicadoresAcompanhamento pDigiProd = new IndicadoresAcompanhamento();
                pDigiProd.setQtdDiabetes(conecta.rs.getInt("QtdDiabetes"));
                pDigiProd.setQtdHipertensao(conecta.rs.getInt("QtdHipertensao"));
                pDigiProd.setQtdEscabiose(conecta.rs.getInt("QtdEscabiose"));
                pDigiProd.setQtdHanseniase(conecta.rs.getInt("QtdHanseniase"));
                pDigiProd.setQtdSifilis(conecta.rs.getInt("QtdSifilis"));
                pDigiProd.setQtdTuberculose(conecta.rs.getInt("QtdTuberculose"));
                pDigiProd.setQtdHib(conecta.rs.getInt("QtdHiv"));
                pDigiProd.setQtdHepatiteB(conecta.rs.getInt("QtdHepatiteB"));
                pDigiProd.setQtdHepatiteC(conecta.rs.getInt("QtdHepatiteC"));
                pDigiProd.setQdtDst(conecta.rs.getInt("QtdDst"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaIndicadoresAcompanhamento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
