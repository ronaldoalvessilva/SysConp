/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensDevolucaoAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleUtilizaEmprestimo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensDevolucaoAcervo objItensDevolucao = new ItensDevolucaoAcervo();

    public ItensDevolucaoAcervo atualizaUtilizaDevolucaoAcervo(ItensDevolucaoAcervo objItensDevolucao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_EMPRESTIMO_ACERVO SET UtilizadoDevolucao=? WHERE IdEmprestimo='" + objItensDevolucao.getIdEmprestimo() + "'AND IdLivro='" + objItensDevolucao.getIdLivro()  + "'");
            pst.setString(1, objItensDevolucao.getUtilizaEmprestimoAcervo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível alterar a UTILIZAÇÃO.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensDevolucao;
    }
}
