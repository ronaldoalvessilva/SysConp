/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEmprestimoAcervo;
import gestor.Modelo.ItensReservaAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleUtilizaReserva {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEmprestimoAcervo objItensEmprestimo = new ItensEmprestimoAcervo();

    public ItensEmprestimoAcervo atualizaUtilizaReservaAcervo(ItensEmprestimoAcervo objItensEmprestimo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_RESERVA_ACERVO SET UtilizaReserva=? WHERE IdReserva='" + objItensEmprestimo.getIdReserva() + "'");
            pst.setString(1, objItensEmprestimo.getUtilizaReservaAcervo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível alterar a UTILIZAÇÃO.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEmprestimo;
    }

    public ItensEmprestimoAcervo atualizaSaldoReservaAcervo(ItensEmprestimoAcervo objItensEmprestimo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTOQUE_ACERVO SET QtdReservada=? WHERE IdLivro='" + objItensEmprestimo.getIdLivro()+ "'AND IdEstoque='" + objItensEmprestimo.getIdEstoque() + "'");
            pst.setFloat(1, objItensEmprestimo.getQtdReserva());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível alterar ESTOQUE.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEmprestimo;
    }
}
