/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutosPagtoKitInterno;
import static gestor.Visao.TelaCancelamentoKit.codigoInterno;
import static gestor.Visao.TelaCancelamentoKit.jIdInternoKitBio1;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdKit;
import static gestor.Visao.TelaCancelamentoKit.pRegistroComp;
import static gestor.Visao.TelaCancelamentoKit.pCodigoInterno;
import static gestor.Visao.TelaCancelamentoKit.pCodigoProd;
import static gestor.Visao.TelaCancelamentoKit.pQuantidade;
import static gestor.Visao.TelaCancelamentoKit.pCODIGO_PRODUTO;
import static gestor.Visao.TelaCancelamentoKit.pQUANTIDADE_PRODUTO;
import static gestor.Visao.TelaCancelamentoKit.estoque;
import static gestor.Visao.TelaCancelamentoKit.codigoInternoKit;
import static gestor.Visao.TelaCancelamentoKit.codigoKit;
import static gestor.Visao.TelaCancelamentoKit.jIdInternoKitBio1;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleItensProdutosCancelamentoKitInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutosPagtoKitInterno objItensPagtoProd = new ProdutosPagtoKitInterno();

    int codProd;
    String pBio = null;
    public static int qtdInternos = 0;
    int pZERO = 0;

    public ProdutosPagtoKitInterno incluirPagamentoProdutoKitInterno(ProdutosPagtoKitInterno objItensPagtoProd) {
        buscarProduto(objItensPagtoProd.getDescricaoProduto(), objItensPagtoProd.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS (IdRegistro,IdItemINT,IdProd,"
                    + "QuantProd,DataEntrega,Horario,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPagtoProd.getIdPagto());
            pst.setInt(2, objItensPagtoProd.getIdItem());
            pst.setInt(3, codProd);
            pst.setFloat(4, objItensPagtoProd.getQuatProd());
            if (objItensPagtoProd.getDataEntrega() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensPagtoProd.getDataEntrega().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItensPagtoProd.getHorario());
            pst.setString(7, objItensPagtoProd.getUsuarioInsert());
            pst.setString(8, objItensPagtoProd.getDataInsert());
            pst.setString(9, objItensPagtoProd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno excluirPagamentoProdutoKitInterno(ProdutosPagtoKitInterno objItensPagtoProd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdItem=ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdItem "
                    + "WHERE IdInternoCrc='" + objItensPagtoProd.getIdInternoCrc() + "'AND IdPagto=");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno BUSCAR_SALDO_produto(ProdutosPagtoKitInterno objItensPagtoProd) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno BUSCAR_SALDO_estoque(ProdutosPagtoKitInterno objItensPagtoProd) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdProd,SaldoAtual "
                    + "FROM PRODUTOS_AC "
                    + "PRODUTOS_AC.IdProd='" + objItensPagtoProd.getIdProd() + "'");
            conecta.rs.first();
            pCODIGO_PRODUTO = conecta.rs.getInt("IdProd");
            pQUANTIDADE_PRODUTO = conecta.rs.getInt("SaldoAtual");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno PESQUISAR_PRODUTOS_KIT_InternoManual(ProdutosPagtoKitInterno objItensPagtoProd) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc,"
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
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
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND KITS_HIGIENE_INTERNO.IdKit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + estoque + "'");
            conecta.rs.first();
            codigoInternoKit = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //VERIFICAR SE O INTERNO JÁ FOI INSERIDO NO DOCUMENTO
    public ProdutosPagtoKitInterno PESQUISAR_INTERNO_manual(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND IdPagto='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno alterarPagamentoProdutoKitInterno(ProdutosPagtoKitInterno objItensPagtoProd) {
        buscarProduto(objItensPagtoProd.getDescricaoProduto(), objItensPagtoProd.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO SET QuantProd=? "
                    + "WHERE IdProd='" + objItensPagtoProd.getIdProd() + "'");
            pst.setFloat(1, objItensPagtoProd.getQuatProd());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno alterarSaldoEstoque(ProdutosPagtoKitInterno objItensPagtoProd) {
        buscarProduto(objItensPagtoProd.getDescricaoProduto(), objItensPagtoProd.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SALDO_ESTOQUE_AC SET SaldoAtual=? "
                    + "WHERE IdProd='" + objItensPagtoProd.getIdProd() + "'");
            pst.setFloat(1, objItensPagtoProd.getQuatProd());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public void buscarProduto(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                    + "WHERE DescricaoProd='" + desc + "' "
                    + "AND IdProd='" + cod + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PRODUTOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
