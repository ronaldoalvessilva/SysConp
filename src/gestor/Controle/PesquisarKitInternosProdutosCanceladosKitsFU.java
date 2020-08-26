/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import static gestor.Visao.TelaCancelamentoKit.jComboBoxPesquisarInterno;
import static gestor.Visao.TelaCancelamentoKit.jDataEntrega1;
import static gestor.Visao.TelaCancelamentoKit.jFotoInternoKitBio1;
import static gestor.Visao.TelaCancelamentoKit.jHorarioPagto1;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jComboBoxPavilhao;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Image;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class PesquisarKitInternosProdutosCanceladosKitsFU {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoPagamentoKitHigiene objCancelaKit = new CancelamentoPagamentoKitHigiene();

    String caminhoFotoInterno;
    String statusFinal = "FINALIZADO";

    public CancelamentoPagamentoKitHigiene PESQUISAR_INTERNO_KIT_FUselecionado(CancelamentoPagamentoKitHigiene objCancelaKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.FotoInternoCrc, "
                    + "PRONTUARIOSCRC.ImagemFrente,DADOSPENAISINTERNOS.Regime "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + jComboBoxPesquisarInterno.getSelectedItem() + "' "
                    + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp='" + statusFinal + "'");
            conecta.rs.first();
            objCancelaKit.setIdInternoKit(conecta.rs.getInt("IdInternoCrc"));
            objCancelaKit.setNomeInternoKit(conecta.rs.getString("NomeInternoCrc"));
            objCancelaKit.setRegimeInterno(conecta.rs.getString("Regime"));
            // Capturando foto
            caminhoFotoInterno = conecta.rs.getString("FotoInternoCrc");
            if (caminhoFotoInterno != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoInterno);
                jFotoInternoKitBio1.setIcon(i);
                jFotoInternoKitBio1.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKitBio1.getWidth(), jFotoInternoKitBio1.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitBio1.getWidth(), jFotoInternoKitBio1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoKitBio1.setIcon(icon);
            }
            jDataEntrega1.setCalendar(Calendar.getInstance());
            jHorarioPagto1.setText(jHoraSistema.getText());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO na pesquisa INTERNO.\nERROR: " + e);
        }
        conecta.desconecta();
        return objCancelaKit;
    }
    
}
