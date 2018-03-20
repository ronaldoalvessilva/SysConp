/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensListagemInternosAlbergados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensListagemAlbergados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensListagemInternosAlbergados objItensAgenda = new ItensListagemInternosAlbergados();
    int codInterno;

    public ItensListagemInternosAlbergados incluirItensListagemAlbergados(ItensListagemInternosAlbergados objItensAgenda) {
        buscarInterno(objItensAgenda.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_LISTA_PASSAGEM_ALBERGADOS (IdAgenda,IdInternoCrc,StatusInterno,SituacaoInterno,ObservacaoInterno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensAgenda.getIdAgenda());
            pst.setInt(2, codInterno);
            pst.setString(3, objItensAgenda.getStatusInterno());
            pst.setString(4, objItensAgenda.getSituacaoInterno());
            pst.setString(5, objItensAgenda.getObservacaoInterno());
            pst.setString(6, objItensAgenda.getUsuarioInsert());
            pst.setString(7, objItensAgenda.getDataInsert());
            pst.setString(8, objItensAgenda.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public ItensListagemInternosAlbergados alterarItensListagemAlbergados(ItensListagemInternosAlbergados objItensAgenda) {
        buscarInterno(objItensAgenda.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_LISTA_PASSAGEM_ALBERGADOS SET IdAgenda=?,IdInternoCrc=?,StatusInterno=?,SituacaoInterno=?,ObservacaoInterno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensAgenda.getIdItem() + "'");
            pst.setInt(1, objItensAgenda.getIdAgenda());
            pst.setInt(2, codInterno);
            pst.setString(3, objItensAgenda.getStatusInterno());
            pst.setString(4, objItensAgenda.getSituacaoInterno());
            pst.setString(5, objItensAgenda.getObservacaoInterno());
            pst.setString(6, objItensAgenda.getUsuarioUp());
            pst.setString(7, objItensAgenda.getDataUp());
            pst.setString(8, objItensAgenda.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public ItensListagemInternosAlbergados excluirItensListagemAlbergados(ItensListagemInternosAlbergados objItensAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_LISTA_PASSAGEM_ALBERGADOS WHERE IdItem='" + objItensAgenda.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensAgenda;
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o interno!!!\nERRO: " + ex);
        }
    }
}
