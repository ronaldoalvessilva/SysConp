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
import static gestor.Visao.TelaPesquisaKitComp.IdKit;
import static gestor.Visao.TelaPesquisaKitComp.jPesquisaNomeProduto;
import static gestor.Visao.TelaPesquisaKitComp.kitAnual;
import static gestor.Visao.TelaPesquisaKitComp.kitDecendial;
import static gestor.Visao.TelaPesquisaKitComp.kitInicial;
import static gestor.Visao.TelaPesquisaKitComp.kitMensal;
import static gestor.Visao.TelaPesquisaKitComp.kitQuinzenal;
import static gestor.Visao.TelaPesquisaKitComp.kitSemestral;
import static gestor.Visao.TelaPesquisaKitComp.pTOTAL_REGISTROS_kit;
import static gestor.Visao.TelaPesquisaMontagemKitHigiene.jCodigoRegistroPesquisa;
import static gestor.Visao.TelaPesquisaMontagemKitHigiene.pTOTAL_KITS_registrados;
import static gestor.Visao.TelaPesquisaMontagemKitHigiene.pDATA_inicial;
import static gestor.Visao.TelaPesquisaMontagemKitHigiene.pDATA_final;
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

    //------------------------------ LISTA DE PESQUISAS ------------------------------------------
    public List<PavilhaoInternosSelecionados> read() throws Exception {
        conecta.abrirConexao();
        List<PavilhaoInternosSelecionados> listaInternosPavilhaoSelecionados = new ArrayList<PavilhaoInternosSelecionados>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc,PRONTUARIOSCRC.Cnc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM INTERNOS_PAVILHAO_KIT_LOTE "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            while (conecta.rs.next()) {
                PavilhaoInternosSelecionados pDigiSelec = new PavilhaoInternosSelecionados();
                pDigiSelec.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigiSelec.setCncInternoCrc(conecta.rs.getString("Cnc"));
                pDigiSelec.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigiSelec.setIdPav(conecta.rs.getInt("IdPav"));
                pDigiSelec.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_CODIGO_read() throws Exception {
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

    public List<ComposicaoKit> PESQUISA_DATA_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_DATA_KI_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitInicial=1 "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_DATA_KD_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitDecendial=1 "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_DATA_KQ_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitQuinzenal=1 "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_DATA_KM_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitMensal=1 "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_DATA_KS_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitSemestral=1 "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_DATA_KA_read() throws Exception {
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
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitAnual=1 "
                    + "ORDER BY DataComp");
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

    public List<ComposicaoKit> PESQUISA_TIPO_KICD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitInicial=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KDCD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitDecendial=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KQCD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitQuinzenal=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KMCD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitMensal=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KSCD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitSemestral=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KACD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp BETWEEN'" + pDATA_inicial + "' "
                    + "AND '" + pDATA_final + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitAnual=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KISD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitInicial=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KDSD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitDecendial=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KQSD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitQuinzenal=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KMSD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitMensal=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KSSD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitSemestral=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TIPO_KASD_read() throws Exception {
        pTOTAL_KITS_registrados = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "INTERNOS_PAVILHAO_KIT_LOTE.IdPav, "
                    + "PAVILHAO.DescricaoPav "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem=PRODUTOS_KITS_HIGIENE_INTERNO.IdItem "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp "
                    + "INNER JOIN PAVILHAO "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdPav=PAVILHAO.IdPav "
                    + "WHERE KITS_HIGIENE_INTERNO.KitAnual=1 "
                    + "ORDER BY DataComp");
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
                pDigiSelec.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
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

    public List<ComposicaoKit> PESQUISA_TODOS_read() throws Exception {
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
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit");
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

    public ComposicaoKit MOSTRAR_REGISTRO_KITS_selecionado(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.DataComp, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdItem, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc, "
                    + "COLABORADOR.NomeFunc, "
                    + "DEPARTAMENTOS.NomeDepartamento, "
                    + "COLABORADOR.ImagemFunc, "
                    + "COLABORADOR.ImagemFrenteCO, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.Observacao "
                    + "FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "INNER JOIN COLABORADOR "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdFunc=COLABORADOR.IdFunc "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp='" + jCodigoRegistroPesquisa.getText() + "' ");
            conecta.rs.first();
            objComp.setIdRegistroComp(conecta.rs.getInt("IdRegistroComp"));
            objComp.setStatusComp(conecta.rs.getString("StatusComp"));
            objComp.setDataComp(conecta.rs.getDate("DataComp"));
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitInicial(conecta.rs.getInt("KitInicial"));
            objComp.setKitInicial(conecta.rs.getInt("KitDecendial"));
            objComp.setKitInicial(conecta.rs.getInt("KitQuinzenal"));
            objComp.setKitInicial(conecta.rs.getInt("KitMensal"));
            objComp.setKitInicial(conecta.rs.getInt("KitSemestral"));
            objComp.setKitInicial(conecta.rs.getInt("KitAnual"));
            objComp.setIdFunc(conecta.rs.getInt("IdFunc"));
            objComp.setNomeColaborador(conecta.rs.getString("NomeFunc"));
            objComp.setNomeDepartamento(conecta.rs.getString("NomeDepartamento"));
            objComp.setFotoColaborador(conecta.rs.getString("ImagemFunc"));
            objComp.setImagemColaborador(conecta.rs.getBytes("ImagemFrenteCO"));
            objComp.setObservacao(conecta.rs.getString("Observacao"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO na pesquisa..." + e);
        }
        return objComp;
    }

    //------------------------------------ PESQUISA DO TIPO DE KIT PARA COMPOSIÇÃO -------------------------
    public List<ComposicaoKit> PESQUISA_KIT_nome() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.KitInicial, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.KitMensal, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE DescricaoProd LIKE'%" + jPesquisaNomeProduto.getText() + "%'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> PESQUISA_KIT_inicial() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE KITS_HIGIENE_INTERNO.KitInicial='" + kitInicial + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> PESQUISA_KIT_decendial() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE KITS_HIGIENE_INTERNO.KitDecendial='" + kitDecendial + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> PESQUISA_KIT_quinzenal() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE KITS_HIGIENE_INTERNO.KitQuinzenal='" + kitQuinzenal + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> PESQUISA_KIT_mensal() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE KITS_HIGIENE_INTERNO.KitMensal='" + kitMensal + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> PESQUISA_KIT_semestral() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE KITS_HIGIENE_INTERNO.KitSemestral='" + kitSemestral + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ComposicaoKit> PESQUISA_KIT_anual() throws Exception {
        pTOTAL_REGISTROS_kit = 0;
        conecta.abrirConexao();
        List<ComposicaoKit> listaRegistrosKitCodigo = new ArrayList<ComposicaoKit>();
        try {
            conecta.executaSQL("SELECT "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                    + "KITS_HIGIENE_INTERNO.KitMensal, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral, "
                    + "KITS_HIGIENE_INTERNO.KitAnual, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "WHERE KITS_HIGIENE_INTERNO.KitAnual='" + kitAnual + "'");
            while (conecta.rs.next()) {
                ComposicaoKit pDigiSelec = new ComposicaoKit();
                pDigiSelec.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiSelec.setKitInicial(conecta.rs.getInt("KitInicial"));
                pDigiSelec.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                pDigiSelec.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                pDigiSelec.setKitMensal(conecta.rs.getInt("KitMensal"));
                pDigiSelec.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                pDigiSelec.setKitAnual(conecta.rs.getInt("KitAnual"));
                pDigiSelec.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiSelec.setDescricaoProd(conecta.rs.getString("DescricaoProd"));
                pDigiSelec.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiSelec.setQuantItem(conecta.rs.getFloat("QuantItem"));
                listaRegistrosKitCodigo.add(pDigiSelec);
                ++pTOTAL_REGISTROS_kit;
            }
            return listaRegistrosKitCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKitInicial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public ComposicaoKit CONFIRMAR_KIT_inicial(ComposicaoKit objComp) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdItem, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitInicial "
                    + "FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + IdKit + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitInicial='" + kitInicial + "'");
            conecta.rs.first();
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitInicial(conecta.rs.getInt("KitInicial"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit CONFIRMAR_KIT_decendial(ComposicaoKit objComp) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdItem, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitDecendial "
                    + "FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + IdKit + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitDecendial='" + kitDecendial + "'");
            conecta.rs.first();
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitDecendial(conecta.rs.getInt("KitDecendial"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit CONFIRMAR_KIT_quinzenal(ComposicaoKit objComp) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdItem, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitQuinzenal "
                    + "FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + IdKit + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitQuinzenal='" + kitQuinzenal + "'");
            conecta.rs.first();
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit CONFIRMAR_KIT_mensal(ComposicaoKit objComp) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdItem, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitMensal "
                    + "FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + IdKit + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitMensal='" + kitMensal + "'");
            conecta.rs.first();
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitMensal(conecta.rs.getInt("KitMensal"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit CONFIRMAR_KIT_semestral(ComposicaoKit objComp) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdItem, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitSemestral "
                    + "FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + IdKit + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitSemestral='" + kitSemestral + "'");
            conecta.rs.first();
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitSemestral(conecta.rs.getInt("KitSemestral"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit CONFIRMAR_KIT_anual(ComposicaoKit objComp) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdItem, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "KITS_HIGIENE_INTERNO.KitAnual "
                    + "FROM KITS_HIGIENE_INTERNO "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE KITS_HIGIENE_INTERNO.IdKit='" + IdKit + "' "
                    + "AND KITS_HIGIENE_INTERNO.KitAnual='" + kitAnual + "'");
            conecta.rs.first();
            objComp.setIdItem(conecta.rs.getInt("IdItem"));
            objComp.setIdKit(conecta.rs.getInt("IdKit"));
            objComp.setKitAnual(conecta.rs.getInt("KitAnual"));
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objComp;
    }
}
