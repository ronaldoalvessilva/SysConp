/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutosPagtoKitInterno;
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
