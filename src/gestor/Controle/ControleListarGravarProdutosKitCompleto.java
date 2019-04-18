/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoInternosKitLote;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jTabelaProdutosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdProd;
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
// GRAVAR E LISTAR OS PRODUTOS DO KIT COMPLETO APOS SELECIONADO
public class ControleListarGravarProdutosKitCompleto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    int codProd;

    public ProdutoInternosKitLote incluirProdutosKitCompletoIncompleto(ProdutoInternosKitLote objProdKit) {
        buscarProduto(objProdKit.getDescricaoProduto(), objProdKit.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO (IdRegistroComp,IdKit,IdProd,QuantProd,Agrupado,TipoKitCI,Gravado,Liberado,Pago,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objProdKit.getIdRegistroComp());
            pst.setInt(2, objProdKit.getIdKit());
            pst.setInt(3, codProd);
            pst.setFloat(4, objProdKit.getQuantidadeProd());
            pst.setString(5, objProdKit.getAgrupado());
            pst.setInt(6, objProdKit.getTipoKitCI());
            pst.setInt(7, objProdKit.getGravado());
            pst.setString(8, objProdKit.getLiberado());
            pst.setString(9, objProdKit.getPago());
            pst.setString(10, objProdKit.getUsuarioInsert());
            pst.setString(11, objProdKit.getDataInsert());
            pst.setString(12, objProdKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos com kit completo.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote excluirUmProdutoKitCompletoIncompleto(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO WHERE IdRegistroComp='" + objProdKit.getIdRegistroComp() + "'AND IdProd='" + objProdKit.getIdProd() + "'AND TipoKitCI='" + objProdKit.getTipoKitCI() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR produto do kit.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }
    // DELETE TODOS OS REGISTROS DA TABELA QUE CONTIVER OS ID PRINCIPAL NA TABELA ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO
    public ProdutoInternosKitLote excluirTodosProdutosKitCompletoIncompleto(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO WHERE IdRegistroComp='" + objProdKit.getIdRegistroComp() + "'AND TipoKitCI='" + objProdKit.getTipoKitCI() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR produto do kit.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote atualizarProdutoUtilizadoKit(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE SET Utili=? WHERE IdRegistroComp='" + objProdKit.getIdRegistroComp() + "' AND IdProd='" + objProdKit.getIdProd() + "'");
            pst.setString(1, objProdKit.getpUtili());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR produto.(ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public List<ProdutoInternosKitLote> read() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
//            conecta.executaSQL("SELECT * FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
//                    + "INNER JOIN PRODUTOS_AC "
//                    + "ON ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd=PRODUTOS_AC.IdProd "
//                    + "WHERE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
//                    + "AND ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd!=" + jTabelaProdutosKitCompleto.getValueAt(jTabelaProdutosKitCompleto.getSelectedRow(), 0) + "'");
            conecta.executaSQL("SELECT * FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp='" + jIdRegistroComp.getText() + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdRegProdKit(conecta.rs.getInt("IdRegProdKit"));
                pDigiProd.setIdKit(conecta.rs.getInt("IdKit"));
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getInt("QuantProd"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
                qtdProd = qtdProd + 1;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListarGravarProdutosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public void buscarProduto(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + nome + "' AND IdProd='" + codigo + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do PRODUTO a ser exibido !!!");
        }
        conecta.desconecta();
    }
}
