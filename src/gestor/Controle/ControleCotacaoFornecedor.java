/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CotacaoCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCotacaoFornecedor {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CotacaoCompras objCotacao = new CotacaoCompras();
    int codFornecedor;
    int codFormaPagto;

    public CotacaoCompras incluirForncedorCotacao(CotacaoCompras objCotacao) {
        buscarFormaPagto(objCotacao.getDescricaoFormaPagto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FORNECEDORES_COTACAO_COMPRAS (IdCota,IdForn,IdForma,PrazoEntrega,ObservacaoFornecedor,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCotacao.getIdCota());
            pst.setInt(2, objCotacao.getIdForn());
            pst.setInt(3, codFormaPagto);
            pst.setString(4, objCotacao.getPrazoEntrega());
            pst.setString(5, objCotacao.getObservacaoFornecedor());
            pst.setString(6, objCotacao.getUsuarioInsert());
            pst.setString(7, objCotacao.getDataInsert());
            pst.setString(8, objCotacao.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objCotacao;
    }

    public CotacaoCompras alterarForncedorCotacao(CotacaoCompras objCotacao) {
        buscarFormaPagto(objCotacao.getDescricaoFormaPagto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FORNECEDORES_COTACAO_COMPRAS SET IdCota=?,IdForn=?,IdForma=?,PrazoEntrega=?,ObservacaoFornecedor=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCota='" + objCotacao.getIdCota() + "'AND IdForn='" + objCotacao.getIdForn()  + "'");
            pst.setInt(1, objCotacao.getIdCota());
            pst.setInt(2, objCotacao.getIdForn());
            pst.setInt(3, codFormaPagto);
            pst.setString(4, objCotacao.getPrazoEntrega());
            pst.setString(5, objCotacao.getObservacaoFornecedor());
            pst.setString(6, objCotacao.getUsuarioUp());
            pst.setString(7, objCotacao.getDataUp());
            pst.setString(8, objCotacao.getHorarioUp());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objCotacao;
    }

    public CotacaoCompras excluirForncedorCotacao(CotacaoCompras objCotacao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FORNECEDORES_COTACAO_COMPRAS WHERE IdCota='" + objCotacao.getIdCota() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objCotacao;
    }

    public void buscarFornecedor(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORNECEDORES_COMPRAS WHERE RazaoSocial='" + desc + "'");
            conecta.rs.first();
            codFornecedor = conecta.rs.getInt("IdForn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORNECEDOR DE COMPRAS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarFormaPagto(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORMA_PAGAMENTO WHERE DescricaoForma='" + desc + "'");
            conecta.rs.first();
            codFormaPagto = conecta.rs.getInt("IdForma");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORMA DE PAGAMENTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
