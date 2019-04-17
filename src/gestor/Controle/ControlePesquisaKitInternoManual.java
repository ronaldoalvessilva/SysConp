/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio1;
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_KITS_DECENDIAL_INTERNOS SET KitPago=?,DataPagto=? "
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
            conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE  "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON PRODUTOS_AC.IdProd=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND QuantProd>0");
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
