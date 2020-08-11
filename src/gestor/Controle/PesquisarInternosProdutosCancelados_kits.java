/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jCodigoReq;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarInternosProdutosCancelados_kits {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();

    String caminho = "";

    public List<CancelamentoPagamentoKitHigiene> read() throws Exception {
        conecta.abrirConexao();
        List<CancelamentoPagamentoKitHigiene> listaCancelCodigo = new ArrayList<CancelamentoPagamentoKitHigiene>();
        try {
            conecta.executaSQL("SELECT IdRegistro, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdItemINT "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS.IdRegistro='" + jCodigoReq.getText() + "' "
                    + "ORDER BY IdItemINT");
            while (conecta.rs.next()) {
                CancelamentoPagamentoKitHigiene pCancelamentos = new CancelamentoPagamentoKitHigiene();
                pCancelamentos.setIdItemINT(conecta.rs.getInt("IdItemINT"));
                pCancelamentos.setIdInternoKit(conecta.rs.getInt("IdInternoCrc"));
                pCancelamentos.setNomeInternoKit(conecta.rs.getString("NomeInternoCrc"));
                listaCancelCodigo.add(pCancelamentos);
            }
            return listaCancelCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosProdutosCancelados_kits.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
