/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio1;
import static gestor.Visao.TelaPagamentoKitInternoCPK.jIdKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControlePesquisaKitInternoManual {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    int codInt;
    String utilizado = "Sim";
    int quant = 0;

    public ProdutoInternosKitLote alterarKitInicial(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_INICIAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitDecendial(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_DECENDIAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitQuinzenal(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_QUINZENAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitMensal(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_MENSAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitSemestral(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_SEMESTRAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitAnual(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_ANUAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public List<ProdutoInternosKitLote> read() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
           conecta.executaSQL("SELECT DISTINCT ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd,PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd,PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem,ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND KITS_HIGIENE_INTERNO.IdKit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "'");   
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getInt("QuantItem"));
                pDigiProd.setQtdEstoque(conecta.rs.getFloat("QuantProd"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
//                qtdProd = qtdProd + 1;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
