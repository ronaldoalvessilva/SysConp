/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxCela;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxPavilhao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleCancelamentoPagoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();

    public CancelamentoPagamentoKitHigiene incluirRegistroCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CANCELAR_PAGAMENTO_KIT_HIGIENE (StatusRegistro,DataRegistro,IdPav,IdCela,TipoKit,IdRegistroKit,DataRegistroKit,MotivoCancelamento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancelaKit.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancelaKit.getDataRegistro().getTime()));
            pst.setInt(3, objCancelaKit.getIdPav());
            pst.setInt(4, objCancelaKit.getIdCela());
            pst.setString(5, objCancelaKit.getTipoKit());
            pst.setInt(6, objCancelaKit.getIdRegistroKit());
            if (objCancelaKit.getDataRegistroKit() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objCancelaKit.getDataRegistroKit().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objCancelaKit.getMotivoCancelamento());
            pst.setString(9, objCancelaKit.getUsuarioInsert());
            pst.setString(10, objCancelaKit.getDataInsert());
            pst.setString(11, objCancelaKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene altgerarRegistroCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAR_PAGAMENTO_KIT_HIGIENE SET StatusRegistro=?,DataRegistro=?,IdPav=?,IdCela=?,TipoKit=?,IdRegistroKit=?,DataRegistroKit=?,MotivoCancelamento=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistro='" + objCancelaKit.getIdRegistro() + "'");
            pst.setString(1, objCancelaKit.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancelaKit.getDataRegistro().getTime()));
            pst.setInt(3, objCancelaKit.getIdPav());
            pst.setInt(4, objCancelaKit.getIdCela());
            pst.setString(5, objCancelaKit.getTipoKit());
            pst.setInt(6, objCancelaKit.getIdRegistroKit());
            if (objCancelaKit.getDataRegistroKit() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objCancelaKit.getDataRegistroKit().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objCancelaKit.getMotivoCancelamento());
            pst.setString(9, objCancelaKit.getUsuarioUp());
            pst.setString(10, objCancelaKit.getDataUp());
            pst.setString(11, objCancelaKit.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene excluirRegistroCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CANCELAR_PAGAMENTO_KIT_HIGIENE WHERE IdRegistro='" + objCancelaKit.getIdRegistro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public List<CancelamentoPagamentoKitHigiene> read() throws Exception {

        List<CancelamentoPagamentoKitHigiene> listaTodosCancelamentos = new ArrayList<CancelamentoPagamentoKitHigiene>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro,StatusRegistro,"
                    + "DataRegistro,DescricaoPav, "
                    + "EndCelaPav,TipoKit,IdRegistroKit, "
                    + "DataRegistroKit,MotivoCancelamento "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                    + "INNER JOIN PAVILHAO "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdpAV=CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav "
                    + "INNER JOIN CELAS "
                    + "ON PAVILHAO.IdPav=CELAS.IdPav");
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
                listaTodosCancelamentos.add(pCancelamentos);
            }
            return listaTodosCancelamentos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleCancelamentoPagoKit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public CancelamentoPagamentoKitHigiene pesquisarCodigo(CancelamentoPagamentoKitHigiene objCancelaKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE");
            conecta.rs.last();
            objCancelaKit.setIdRegistro(conecta.rs.getInt("IdRegistro"));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleCancelamentoPagoKit.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene pesquisarPavilhao(CancelamentoPagamentoKitHigiene objCancelaKit) {
        jComboBoxPavilhao.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhao.addItem(conecta.rs.getString("DescricaoPav"));
            } while (conecta.rs.next());
            jComboBoxPavilhao.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene pesquisarCela(CancelamentoPagamentoKitHigiene objCancelaKit) {
        jComboBoxCela.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DescricaoPav, "
                    + "EndCelaPav "
                    + "FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "'");
            conecta.rs.first();
            do {
                jComboBoxCela.addItem(conecta.rs.getString("EndCelaPav"));
            } while (conecta.rs.next());
            jComboBoxCela.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
        return objCancelaKit;
    }
}
