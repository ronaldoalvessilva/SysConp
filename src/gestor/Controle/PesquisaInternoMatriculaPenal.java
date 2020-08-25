/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaPesquisaInternoSaidaSimbolica.jMatriculaPesquisa;
import static gestor.Visao.TelaSaidaSimbolica.pTOTAL_registros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaInternoMatriculaPenal {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();

    String caminho = "";
    String pSAIDA_audiencia = "SAIDA PARA AUDIENCIA";
    String pSAIDA_medico = "SAIDA PARA MEDICO";
    String pSAIDA_temporaria = "SAIDA TEMPORARIA";
    String pSAIDA_PRISAO_domiciliar = "PRISAO DOMICILIAR";

    public List<SaidaSimbolica> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<SaidaSimbolica> listaInternosMatricula = new ArrayList<SaidaSimbolica>();
        try {
            conecta.executaSQL("SELECT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.MatriculaCrc,DADOSPENAISINTERNOS.Regime,"
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.MaeInternoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + pSAIDA_audiencia + "' "
                    + "AND PRONTUARIOSCRC.MatriculaCrc='" + jMatriculaPesquisa.getText() + "' "
                    + "OR SituacaoCrc='" + pSAIDA_medico + "' "
                    + "AND PRONTUARIOSCRC.MatriculaCrc='" + jMatriculaPesquisa.getText() + "' "
                    + "OR SituacaoCrc='" + pSAIDA_temporaria + "' "
                    + "AND PRONTUARIOSCRC.MatriculaCrc='" + jMatriculaPesquisa.getText() + "' "
                    + "OR SituacaoCrc LIKE'%" + pSAIDA_PRISAO_domiciliar + "%' "
                    + "AND PRONTUARIOSCRC.MatriculaCrc='" + jMatriculaPesquisa.getText() + "'");
            while (conecta.rs.next()) {
                SaidaSimbolica pPesquisarInternos = new SaidaSimbolica();
                pPesquisarInternos.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pPesquisarInternos.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pPesquisarInternos.setRegimePenal(conecta.rs.getString("Regime"));
                pPesquisarInternos.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pPesquisarInternos.setMaeInterno(conecta.rs.getString("MaeInternoCrc"));
                listaInternosMatricula.add(pPesquisarInternos);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaInternosMatricula;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaInternoMatriculaPenal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
