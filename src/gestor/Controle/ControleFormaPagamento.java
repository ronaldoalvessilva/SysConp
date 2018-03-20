/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FormaPagamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleFormaPagamento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FormaPagamento objForma = new FormaPagamento();

    public FormaPagamento incluirFormaPagamento(FormaPagamento objForma) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FORMA_PAGAMENTO (DataForma,StatusForma,DescricaoForma,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objForma.getDataForma().getTime()));
            pst.setString(2, objForma.getStatusForma());
            pst.setString(3, objForma.getDescricaoForma());
            pst.setString(4, objForma.getUsuarioInsert());
            pst.setString(5, objForma.getDataInsert());
            pst.setString(6, objForma.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForma;
    }

    public FormaPagamento alterarFormaPagamento(FormaPagamento objForma) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FORMA_PAGAMENTO SET DataForma=?,StatusForma=?,DescricaoForma=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdForma='" + objForma.getIdForma() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objForma.getDataForma().getTime()));
            pst.setString(2, objForma.getStatusForma());
            pst.setString(3, objForma.getDescricaoForma());
            pst.setString(4, objForma.getUsuarioUp());
            pst.setString(5, objForma.getDataUp());
            pst.setString(6, objForma.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForma;
    }

    public FormaPagamento excluirFormaPagamento(FormaPagamento objForma) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FORMA_PAGAMENTO WHERE IdForma='" + objForma.getIdForma() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForma;
    }
}
