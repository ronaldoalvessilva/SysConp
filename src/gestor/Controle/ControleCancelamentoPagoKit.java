/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jCodigoReq;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxPavilhao;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxTiposKits;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jDataComposicaoKit;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdKit;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistro;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistroComp;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jResponsavel;
import static gestor.Visao.TelaCancelamentoPagamentoKits.pDESCRICAO_pavilhao;
import static gestor.Visao.TelaCancelamentoPagamentoKits.pTOTAL_registros;
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

    int pCODIGO_pav = 0;
    int pCODIGO_cela = 0;

    public CancelamentoPagamentoKitHigiene incluirRegistroCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {
        PESQUISAR_pavilhao(objCancelaKit.getDescricaoPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CANCELAR_PAGAMENTO_KIT_HIGIENE (StatusRegistro,DataRegistro,IdFunc,IdPav,TipoKit,SituacaoInterno,IdRegistroComp,IdKit,DataRegistroKit,MotivoCancelamento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancelaKit.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancelaKit.getDataRegistro().getTime()));
            pst.setInt(3, objCancelaKit.getIdFunc());
            pst.setInt(4, pCODIGO_pav);
            pst.setString(5, objCancelaKit.getTipoKit());
            pst.setString(6, objCancelaKit.getSituacaoInterno());
            pst.setInt(7, objCancelaKit.getIdRegistroKit());
            pst.setInt(8, objCancelaKit.getIdKit());
            if (objCancelaKit.getDataRegistroKit() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objCancelaKit.getDataRegistroKit().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objCancelaKit.getMotivoCancelamento());
            pst.setString(11, objCancelaKit.getUsuarioInsert());
            pst.setString(12, objCancelaKit.getDataInsert());
            pst.setString(13, objCancelaKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene altgerarRegistroCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {
        PESQUISAR_pavilhao(objCancelaKit.getDescricaoPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAR_PAGAMENTO_KIT_HIGIENE SET StatusRegistro=?,DataRegistro=?,IdFunc=?,IdPav=?,TipoKit=?,SituacaoInterno=?,IdRegistroComp=?,IdKit=?,DataRegistroKit=?,MotivoCancelamento=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistro='" + objCancelaKit.getIdRegistro() + "'");
            pst.setString(1, objCancelaKit.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancelaKit.getDataRegistro().getTime()));
            pst.setInt(3, objCancelaKit.getIdFunc());
            pst.setInt(4, pCODIGO_pav);
            pst.setString(5, objCancelaKit.getTipoKit());
            pst.setString(6, objCancelaKit.getSituacaoInterno());
            pst.setInt(7, objCancelaKit.getIdRegistroKit());
            pst.setInt(8, objCancelaKit.getIdKit());
            if (objCancelaKit.getDataRegistroKit() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objCancelaKit.getDataRegistroKit().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objCancelaKit.getMotivoCancelamento());
            pst.setString(11, objCancelaKit.getUsuarioUp());
            pst.setString(12, objCancelaKit.getDataUp());
            pst.setString(13, objCancelaKit.getHorarioUp());
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

    public CancelamentoPagamentoKitHigiene finalizarRegistroCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAR_PAGAMENTO_KIT_HIGIENE SET StatusRegistro=? WHERE IdRegistro='" + objCancelaKit.getIdRegistro() + "'");
            pst.setString(1, objCancelaKit.getStatusRegistro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene PESQUISAR_status(CancelamentoPagamentoKitHigiene objCancelaKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro,StatusRegistro "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                    + "WHERE IdRegistro='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            objCancelaKit.setStatusRegistro(conecta.rs.getString("StatusRegistro"));                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível verificar se lançamento foi finalizado.\nERROR: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    //------------------------------------------- INTERNOS E PRODUTOS DO CANCELAMENTO ---------------------------------------------
    public CancelamentoPagamentoKitHigiene incluirInternoProdutoCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE (IdRegistro,IdInternoCrc,IdProd,Quantidade,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objCancelaKit.getIdRegistro());
            pst.setInt(2, objCancelaKit.getIdInternoKit());
            pst.setInt(3, objCancelaKit.getCodigoProduto());
            pst.setInt(4, objCancelaKit.getQuantidadeProduto());
            pst.setString(5, objCancelaKit.getUsuarioInsert());
            pst.setString(6, objCancelaKit.getDataInsert());
            pst.setString(7, objCancelaKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene alterarInternoProdutoCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE SET IdRegistro=?,IdInternoCrc=?,IdProd=?,Quantidade=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemSA='" + objCancelaKit.getIdItemSA() + "'");
            pst.setInt(1, objCancelaKit.getIdRegistro());
            pst.setInt(2, objCancelaKit.getIdInternoKit());
            pst.setInt(3, objCancelaKit.getCodigoProduto());
            pst.setInt(4, objCancelaKit.getQuantidadeProduto());
            pst.setString(5, objCancelaKit.getUsuarioUp());
            pst.setString(6, objCancelaKit.getDataUp());
            pst.setString(7, objCancelaKit.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public CancelamentoPagamentoKitHigiene excluirInternoProdutoCancelamento(CancelamentoPagamentoKitHigiene objCancelaKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE WHERE IdItemSA='" + objCancelaKit.getIdItemSA() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }

    public List<CancelamentoPagamentoKitHigiene> read() throws Exception {
        pTOTAL_registros = 0;
        List<CancelamentoPagamentoKitHigiene> listaTodosCancelamentos = new ArrayList<CancelamentoPagamentoKitHigiene>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro, "
                    + "StatusRegistro,DataRegistro, "
                    + "TipoKit, DescricaoPav "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                    + "INNER JOIN PAVILHAO "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav=PAVILHAO.IdPav");
            while (conecta.rs.next()) {
                CancelamentoPagamentoKitHigiene pCancelamentos = new CancelamentoPagamentoKitHigiene();
                pCancelamentos.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pCancelamentos.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pCancelamentos.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pCancelamentos.setTipoKit(conecta.rs.getString("TipoKit"));
                pCancelamentos.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                listaTodosCancelamentos.add(pCancelamentos);
                pTOTAL_registros = pTOTAL_registros + 1;
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
            jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegistro")));
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
            conecta.executaSQL("SELECT IdPav,"
                    + "DescricaoPav "
                    + "FROM PAVILHAO "
                    + "ORDER BY DescricaoPav");
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

    public void PESQUISAR_pavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdPav,DescricaoPav "
                    + "FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            pCODIGO_pav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void PESQUISAR_cela(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdCela,EndCelaPav "
                    + "FROM CELAS "
                    + "WHERE EndCelaPav='" + nome + "'");
            conecta.rs.first();
            pCODIGO_cela = conecta.rs.getInt("IdCela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public CancelamentoPagamentoKitHigiene MOSTRAR_interno(CancelamentoPagamentoKitHigiene objCancelaKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistro, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.StatusRegistro, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.DataRegistro, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav, "
                    + "PAVILHAO.DescricaoPav, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.TipoKit, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.SituacaoInterno, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistroComp, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.IdKit, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.DataRegistroKit, "
                    + "CANCELAR_PAGAMENTO_KIT_HIGIENE.MotivoCancelamento "
                    + "FROM CANCELAR_PAGAMENTO_KIT_HIGIENE "
                    + "INNER JOIN PAVILHAO "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav=CANCELAR_PAGAMENTO_KIT_HIGIENE.IdPav "
                    + "INNER JOIN COLABORADOR "
                    + "ON CANCELAR_PAGAMENTO_KIT_HIGIENE.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE CANCELAR_PAGAMENTO_KIT_HIGIENE.IdRegistro='" + jCodigoReq.getText() + "' "
                    + "AND PAVILHAO.DescricaoPav='" + pDESCRICAO_pavilhao + "'");
            conecta.rs.first();
            objCancelaKit.setIdRegistro(conecta.rs.getInt("IdRegistro"));
            objCancelaKit.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
            objCancelaKit.setDataRegistro(conecta.rs.getDate("DataRegistro"));
            objCancelaKit.setIdFunc(conecta.rs.getInt("IdFunc"));
            objCancelaKit.setNomeFunc(conecta.rs.getString("NomeFunc"));
            objCancelaKit.setIdPav(conecta.rs.getInt("IdPav"));
            objCancelaKit.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
            objCancelaKit.setTipoKit(conecta.rs.getString("TipoKit"));
            objCancelaKit.setSituacaoInterno(conecta.rs.getString("SituacaoInterno"));
            objCancelaKit.setIdRegistroKit(conecta.rs.getInt("IdRegistroComp"));
            objCancelaKit.setIdKit(conecta.rs.getInt("IdKit"));
            objCancelaKit.setDataRegistroKit(conecta.rs.getDate("DataRegistroKit"));
            objCancelaKit.setMotivoCancelamento(conecta.rs.getString("MotivoCancelamento"));
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaCancelamentoKitCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objCancelaKit;
    }
}
