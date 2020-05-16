/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoEvolucaoEducacaoFisica;
import static gestor.Visao.TelaAdmissaoEvolucoEF.jID_REGISTRO_Pesquisa;
import static gestor.Visao.TelaAdmissaoEvolucoEF.pTOTAL_REGISTROS_ATIVIDADES;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class listarTodosRegistrosEvolucao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoEvolucaoEducacaoFisica objAdmissao = new AdmissaoEvolucaoEducacaoFisica();

    public List<AdmissaoEvolucaoEducacaoFisica> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<AdmissaoEvolucaoEducacaoFisica> listaEvolucaoCodigo = new ArrayList<AdmissaoEvolucaoEducacaoFisica>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAO_EDUCACAO_FISICA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON EVOLUCAO_EDUCACAO_FISICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE EVOLUCAO_EDUCACAO_FISICA.IdRegistroEF='" + jID_REGISTRO_Pesquisa.getText() + "'");
            while (conecta.rs.next()) {
                AdmissaoEvolucaoEducacaoFisica pEvolucao = new AdmissaoEvolucaoEducacaoFisica();
                pEvolucao.setIdRegistroEF(conecta.rs.getInt("IdRegistroEF"));
                pEvolucao.setIdItem(conecta.rs.getInt("IdItem"));
                pEvolucao.setDataRegistroEF(conecta.rs.getDate("DataEvolucaoEF"));
                pEvolucao.setIdInternoEF(conecta.rs.getInt("IdInternoCrc"));
                pEvolucao.setNomeInternoEF(conecta.rs.getString("NomeInternoCrc"));                
                pEvolucao.setTextoEvolucaoAdmissao(conecta.rs.getString("TextoEvolucaoEF"));                
                listaEvolucaoCodigo.add(pEvolucao);
                pTOTAL_REGISTROS_ATIVIDADES = pTOTAL_REGISTROS_ATIVIDADES + 1;
            }
            return listaEvolucaoCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(listarTodosRegistrosEvolucao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
