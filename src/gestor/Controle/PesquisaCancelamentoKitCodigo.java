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
public class PesquisaCancelamentoKitCodigo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();

    public List<CancelamentoPagamentoKitHigiene> read() throws Exception {
        conecta.abrirConexao();
        List<CancelamentoPagamentoKitHigiene> listaCancelCodigo = new ArrayList<CancelamentoPagamentoKitHigiene>();
        try {
            conecta.executaSQL("SELECT CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistro, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.StatusRegistro, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.DataRegistro, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav, "
                    + "PAVILHAO.DescricaoPav, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.TipoKit,"
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistroComp, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdKit, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.DataRegistroKit, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.MotivoCancelamento, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.UsuarioInsert, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.DataInsert, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.HorarioInsert, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.UsuarioUp, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.DataUp, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.HorarioUp "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                    + "INNER JOIN PAVILHAO "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav=CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdKit=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit "
                    + "INNER JOIN COLABORADOR "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistro='" + jCodigoReq.getText() + "'");
            while (conecta.rs.next()) {
                CancelamentoPagamentoKitHigiene pCancelamentos = new CancelamentoPagamentoKitHigiene();
                pCancelamentos.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pCancelamentos.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pCancelamentos.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pCancelamentos.setIdFunc(conecta.rs.getInt("IdFunc"));
                pCancelamentos.setNomeFunc(conecta.rs.getString("NomeFunc"));
                pCancelamentos.setIdPav(conecta.rs.getInt("IdPav"));
                pCancelamentos.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                pCancelamentos.setTipoKit(conecta.rs.getString("TipoKit"));
                pCancelamentos.setIdRegistroKit(conecta.rs.getInt("IdRegistroComp"));
                pCancelamentos.setIdKit(conecta.rs.getInt("IdKit"));
                pCancelamentos.setDataRegistroKit(conecta.rs.getDate("DataRegistroKit"));
                pCancelamentos.setMotivoCancelamento(conecta.rs.getString("MotivoCancelamento"));
                pCancelamentos.setUsuarioInsert(conecta.rs.getString("UsuarioInsert"));
                pCancelamentos.setUsuarioUp(conecta.rs.getString("UsuarioUp"));
                pCancelamentos.setDataInsert(conecta.rs.getString("DataInsert"));
                pCancelamentos.setDataUp(conecta.rs.getString("DataUp"));
                pCancelamentos.setHorarioInsert(conecta.rs.getString("HorarioInsert"));
                pCancelamentos.setHorarioUp(conecta.rs.getString("HorarioUp"));
                listaCancelCodigo.add(pCancelamentos);
            }
            return listaCancelCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaCancelamentoKitCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
