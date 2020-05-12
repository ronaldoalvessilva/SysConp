/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PavilhaoInternoMontaKit;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import static gestor.Visao.TelaAtendimentoGrupoEducacaoFisica.jComboBoxNivelPavilhao;
import static gestor.Visao.TelaSelecaoLoteInternosAG_EF.qtdInternos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleListaInternosPavilhaoAG_II_EF {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();

    //
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
                    + "WHERE PAVILHAO.NivelPav='" + jComboBoxNivelPavilhao.getSelectedItem() + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                PavilhaoInternoMontaKit pDigi = new PavilhaoInternoMontaKit();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setCncInternoCrc(conecta.rs.getString("Cnc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setIdPav(conecta.rs.getInt("IdPav"));
                pDigi.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                listaInternosPavilhao.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosPavilhao;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaInternosCelasAG.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
