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
            conecta.executaSQL("SELECT IdRegistro,StatusRegistro,"
                    + "DataRegistro,DescricaoPav, "
                    + "EndCelaPav,TipoKit,IdRegistroKit, "
                    + "DataRegistroKit,MotivoCancelamento "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                    + "INNER JOIN PAVILHAO "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdpAV=CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON PAVILHAO.IdPav=CELAS.IdPav "
                    + "WHERE IdRegistro='" + jCodigoReq.getText() + "'");
            while (conecta.rs.next()) {
                CancelamentoPagamentoKitHigiene pCancelamentos = new CancelamentoPagamentoKitHigiene();
                pCancelamentos.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pCancelamentos.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pCancelamentos.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pCancelamentos.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                pCancelamentos.setDescricaoCela(conecta.rs.getString("EndCelaPav"));
                pCancelamentos.setTipoKit(conecta.rs.getString("TipoKit"));
                pCancelamentos.setIdRegistroKit(conecta.rs.getInt("IdRegistroKit"));
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
