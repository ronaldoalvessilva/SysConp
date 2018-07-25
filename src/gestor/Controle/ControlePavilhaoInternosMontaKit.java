/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PavilhaoInternoMontaKit;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jComboBoxPavilhoes;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControlePavilhaoInternosMontaKit {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    String situacaoEntrada = "ENTRADA NA UNIDADE";
    String situacaoRetorno = "RETORNO A UNIDADE";
    
    public List<PavilhaoInternoMontaKit> read() throws Exception {
        conecta.abrirConexao();
        List<PavilhaoInternoMontaKit> listaInternosPavilhao = new ArrayList<PavilhaoInternoMontaKit>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhoes.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoEntrada + "' "
                    + "OR PAVILHAO.DescricaoPav='" + jComboBoxPavilhoes.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoRetorno + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                PavilhaoInternoMontaKit pDigi = new PavilhaoInternoMontaKit();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setCncInternoCrc(conecta.rs.getString("Cnc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));                
                listaInternosPavilhao.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosPavilhao;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
