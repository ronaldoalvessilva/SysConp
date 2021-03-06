package gestor.Controle;

import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AlertaKitHigiente;
import gestor.Modelo.ParametrosCrc;
import static gestor.Visao.TelaAlertaPagamentoKitHigiene.pTOTAL_produtos;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaModuloAlmoxarifado.pALERTA;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ronaldo.silva7
 */
public class ControleListaKitsAgendado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AlertaKitHigiente objComp = new AlertaKitHigiente();
    ParametrosCrc objParCrc = new ParametrosCrc();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //
    String pKIT_pago = "Não";

    public List<AlertaKitHigiente> read() throws Exception {
        pTOTAL_produtos = 0;
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            conecta.abrirConexao();
            List<AlertaKitHigiente> listaInternosKitComp = new ArrayList<AlertaKitHigiente>();
            try {
                conecta.executaSQL("SELECT DISTINCT "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.DataPrevisao, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.KitPago, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "PRODUTOS_AC.IdProd, "
                        + "PRODUTOS_AC.DescricaoProd, "
                        + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_AC  "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE KitPago='" + pKIT_pago + "' "
                        + "AND DataPrevisao='" + dataSisConvert + "'");
                while (conecta.rs.next()) {
                    AlertaKitHigiente pDigi = new AlertaKitHigiente();
                    pDigi.setIdRegProdutoKC(conecta.rs.getInt("IdPROG"));
                    pDigi.setDataPrevisao(conecta.rs.getDate("DataPrevisao"));
                    pDigi.setKitPago(conecta.rs.getString("KitPago"));
                    pDigi.setKitInicial(conecta.rs.getInt("KitInicial"));
                    pDigi.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                    pDigi.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                    pDigi.setKitMensal(conecta.rs.getInt("KitMensal"));
                    pDigi.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                    pDigi.setKitAnual(conecta.rs.getInt("KitAnual"));
                    pDigi.setCodigoProduto(conecta.rs.getInt("IdProd"));
                    pDigi.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                    pDigi.setQuantProd(conecta.rs.getInt("QuantItem"));
                    listaInternosKitComp.add(pDigi);
                    ++pTOTAL_produtos;
                }
                return listaInternosKitComp;
            } catch (SQLException ex) {
                Logger.getLogger(ControleListaKitsAgendado.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            conecta.abrirConexao();
            List<AlertaKitHigiente> listaInternosKitComp = new ArrayList<AlertaKitHigiente>();
            try {
                conecta.executaSQL("SELECT DISTINCT "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.DataPrevisao, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.KitPago, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdKit, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "PRODUTOS_AC.IdProd, "
                        + "PRODUTOS_AC.DescricaoProd, "
                        + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_AC  "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE KitPago='" + pKIT_pago + "' "
                        + "AND DataPrevisao='" + jDataSistema.getText() + "'");
                while (conecta.rs.next()) {
                    AlertaKitHigiente pDigi = new AlertaKitHigiente();
                    pDigi.setIdRegProdutoKC(conecta.rs.getInt("IdPROG"));
                    pDigi.setDataPrevisao(conecta.rs.getDate("DataPrevisao"));
                    pDigi.setKitPago(conecta.rs.getString("KitPago"));
                    pDigi.setIdKit(conecta.rs.getInt("IdKit"));
                    pDigi.setKitInicial(conecta.rs.getInt("KitInicial"));
                    pDigi.setKitDecendial(conecta.rs.getInt("KitDecendial"));
                    pDigi.setKitQuinzenal(conecta.rs.getInt("KitQuinzenal"));
                    pDigi.setKitMensal(conecta.rs.getInt("KitMensal"));
                    pDigi.setKitSemestral(conecta.rs.getInt("KitSemestral"));
                    pDigi.setKitAnual(conecta.rs.getInt("KitAnual"));
                    pDigi.setCodigoProduto(conecta.rs.getInt("IdProd"));
                    pDigi.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                    pDigi.setQuantProd(conecta.rs.getInt("QuantItem"));
                    listaInternosKitComp.add(pDigi);
                    ++pTOTAL_produtos;
                }
                return listaInternosKitComp;
            } catch (SQLException ex) {
                Logger.getLogger(ControleListaKitsAgendado.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conecta.desconecta();
            }
        }
        return null;
    }

    public AlertaKitHigiente LISTAR_AGENDA_kit(AlertaKitHigiente objComp) {
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT DISTINCT "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.DataPrevisao, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.KitPago, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "PRODUTOS_AC.IdProd, "
                        + "PRODUTOS_AC.DescricaoProd, "
                        + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_AC  "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE KitPago='" + pKIT_pago + "' "
                        + "AND DataPrevisao='" + dataSisConvert + "'");
                conecta.rs.first();
                objComp.setDataPrevisao(conecta.rs.getDate("DataPrevisao"));
            } catch (SQLException ex) {
            }
            conecta.desconecta();
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT DISTINCT "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdPROG, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.DataPrevisao, "
                        + "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.KitPago, "
                        + "KITS_HIGIENE_INTERNO.KitInicial, "
                        + "KITS_HIGIENE_INTERNO.KitDecendial, "
                        + "KITS_HIGIENE_INTERNO.KitQuinzenal, "
                        + "KITS_HIGIENE_INTERNO.KitMensal, "
                        + "KITS_HIGIENE_INTERNO.KitSemestral, "
                        + "KITS_HIGIENE_INTERNO.KitAnual, "
                        + "PRODUTOS_AC.IdProd, "
                        + "PRODUTOS_AC.DescricaoProd, "
                        + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                        + "FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS "
                        + "INNER JOIN KITS_HIGIENE_INTERNO "
                        + "ON PROGRAMACAO_PAGAMENTO_KITS_INTERNOS.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                        + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                        + "INNER JOIN PRODUTOS_AC  "
                        + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                        + "WHERE KitPago='" + pKIT_pago + "' "
                        + "AND DataPrevisao='" + jDataSistema.getText() + "'");
                conecta.rs.first();
                objComp.setDataPrevisao(conecta.rs.getDate("DataPrevisao"));
            } catch (SQLException ex) {
            }
            conecta.desconecta();
        }
        return objComp;
    }

    public ParametrosCrc VERIFICAR_alerta(ParametrosCrc objParCrc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "HabilitarAlerta "
                    + "FROM PARAMETROSCRC");
            conecta.rs.first();
//            objParCrc.setHabilitarAlerta(conecta.rs.getString("HabilitarAlerta"));    
            pALERTA = conecta.rs.getString("HabilitarAlerta");
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaKitsAgendado.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objParCrc;
    }
}
