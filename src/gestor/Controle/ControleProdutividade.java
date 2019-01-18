/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Produtividade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geiba
 */
public class ControleProdutividade {
    
     ConexaoBancoDados conecta = new ConexaoBancoDados();

    public List<Produtividade> read() {

        conecta.abrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtividade> produtividades = new ArrayList<>();

        try {
            //conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP");
            //stmt = conecta.stmt("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produtividade produtividade = new Produtividade();

                produtividade.setUsuarioInsert(rs.getString("UsuarioInsert"));
                produtividade.setTipoAtendimento(rs.getString("TipoAtendimento"));
                produtividades.add(produtividade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Produtividade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }

        return produtividades;

    }

//    public List<Atendimento> readForDesc(String desc) {
//
//        Connection con = ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<Produto> produtos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
//            stmt.setString(1, "%" + desc + "%");
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                Produto produto = new Produto();
//
//                produto.setId(rs.getInt("id"));
//                produto.setDescricao(rs.getString("descricao"));
//                produto.setQtd(rs.getInt("qtd"));
//                produto.setPreco(rs.getDouble("preco"));
//                produtos.add(produto);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }
//
//        return produtos;
//
//    }

    
}
