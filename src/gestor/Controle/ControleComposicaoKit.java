/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ComposicaoKit;
import gestor.Modelo.PavilhaoInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosSelec;
import static gestor.Visao.TelaPesquisaMontagemKitHigiene.jCodigoRegistroPesquisa;
import static gestor.Visao.TelaPesquisaMontagemKitHigiene.pTOTAL_KITS_registrados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleComposicaoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKit objComp = new ComposicaoKit();

    int codFunc;

    public ComposicaoKit incluirComposicaoKitlInternos(ComposicaoKit objComp) {
        buscarColaborador(objComp.getNomeColaborador(), objComp.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE (StatusComp,DataComp,IdKit,IdItem,IdFunc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objComp.getStatusComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataComp().getTime()));
            pst.setInt(3, objComp.getIdKit());
            pst.setInt(4, objComp.getIdItem());
            pst.setInt(5, codFunc);
            pst.setString(6, objComp.getObservacao());
            pst.setString(7, objComp.getUsuarioInsert());
            pst.setString(8, objComp.getDataInsert());
            pst.setString(9, objComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit alterarComposicaoKitlInternos(ComposicaoKit objComp) {
        buscarColaborador(objComp.getNomeColaborador(), objComp.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET StatusComp=?,DataComp=?,IdKit=?,IdItem=?,IdFunc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getStatusComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataComp().getTime()));
            pst.setInt(3, objComp.getIdKit());
            pst.setInt(4, objComp.getIdItem());
            pst.setInt(5, codFunc);
            pst.setString(6, objComp.getObservacao());
            pst.setString(7, objComp.getUsuarioUp());
            pst.setString(8, objComp.getDataUp());
            pst.setString(9, objComp.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit excluirComposicaoKitlInternos(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit finalizarComposicaoKitlInternos(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET StatusComp=?,KitPago=? WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getStatusComp());
            pst.setString(2, objComp.getKitPago());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit confirmarProgramacaoKit(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET ProgGerada=?,DataProgramacao=? "
                    + "WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getProgGerada());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataProgramacao().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit confirmarPagamentoKit(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET KitPago=?,DataPagamento=? "
                    + "WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getKitPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataPagamentoKit().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public void buscarColaborador(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'AND IdFunc='" + codigo + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public List<PavilhaoInternosSelecionados> read() throws Exception {
        conecta.abrirConexao();
        List<PavilhaoInternosSelecionados> listaInternosPavilhaoSelecionados = new ArrayList<PavilhaoInternosSelecionados>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc,PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc "
                    + "FROM INTERNOS_PAVILHAO_KIT_LOTE "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "WHERE INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            while (conecta.rs.next()) {
                PavilhaoInternosSelecionados pDigiSelec = new PavilhaoInternosSelecionados();
                pDigiSelec.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiSelec.setCncInternoCrc(conecta.rs.getString("Cnc"));
                pDigiSelec.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosPavilhaoSelecionados.add(pDigiSelec);
                qtdInternosSelec = qtdInternosSelec + 1;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> pCODIGO_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + jCodigoRegistroPesquisa.getText() + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdRegistroComp(conecta.rs.getInt("IdRegistroComp"));
                pDigiSelec.setDataComp(conecta.rs.getDate("DataComp"));
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdFunc(conecta.rs.getInt("IdFunc"));
                pDigiSelec.setNomeColaborador(conecta.rs.getString("NomeFunc"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_KITS_registrados;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
