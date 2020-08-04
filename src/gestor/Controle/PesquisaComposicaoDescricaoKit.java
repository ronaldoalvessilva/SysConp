/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ComposicaoKitPesquisa;
import static gestor.Visao.TelaPesquisarComposicaoKit_CA.jPesqDescricaoPav;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class PesquisaComposicaoDescricaoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKitPesquisa objCancelaKit = new ComposicaoKitPesquisa();

    public List<ComposicaoKitPesquisa> read() throws Exception {

        List<ComposicaoKitPesquisa> pLISTAR_composicao = new ArrayList<ComposicaoKitPesquisa>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "StatusComp,DataComp,IdKit,DescricaoPav,EndCelaPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE DescricaoPav='" + jPesqDescricaoPav.getText() + "'");
            while (conecta.rs.next()) {
                ComposicaoKitPesquisa pPESQUISAR_todos = new ComposicaoKitPesquisa();
                pPESQUISAR_todos.setIdRegistroComp(conecta.rs.getInt("IdRegistroComp"));
                pPESQUISAR_todos.setStatusComp(conecta.rs.getString("StatusComp"));
                pPESQUISAR_todos.setDataComp(conecta.rs.getDate("DataComp"));
                pPESQUISAR_todos.setDescricaoPav(conecta.rs.getString("DescricaoPav"));               
                pLISTAR_composicao.add(pPESQUISAR_todos);
            }
            return pLISTAR_composicao;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoPagoKit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
