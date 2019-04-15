/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import static gestor.Visao.TelaProgramacaoKitsHigiene.idPROG;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jComboBoxPavilhao;
import static gestor.Visao.TelaProgramacaoKitsHigiene.qtdInternos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
//LISTAR TODOS OS INTERNOS A SEREM EXCLUIDOS NO KIT DECENDIAL
public class ControlePagamentoKitQuinzenalRealizado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();

    public List<GravarInternosKitCompleto> read() throws Exception {
        conecta.abrirConexao();
        List<GravarInternosKitCompleto> listaInternosKitComp = new ArrayList<GravarInternosKitCompleto>();
        try {
            conecta.executaSQL("SELECT * FROM KITS_QUINZENAL_INTERNOS "
                    + "INNER JOIN PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                    + "ON KITS_QUINZENAL_INTERNOS.IDREG_PROG=PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_QUINZENAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_QUINZENAL_INTERNOS.IDREG_PROG='" + idPROG + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                GravarInternosKitCompleto pDigi = new GravarInternosKitCompleto();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePagamentoKitQuinzenalRealizado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
