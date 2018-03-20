/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ListaPassagemAlbergados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleListagemPassagemAlbergados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
   ListaPassagemAlbergados objAgenda = new ListaPassagemAlbergados(); 
    int codOperacao;    

    public ListaPassagemAlbergados incluirLista(ListaPassagemAlbergados objAgenda) {
        buscarOperacao(objAgenda.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LISTA_PASSAGEM_ALBERGADOS (StatusLanc,DataCadastro,IdOp,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objAgenda.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgenda.getDataCadastro().getTime()));
            pst.setInt(3, codOperacao);
            pst.setString(4, objAgenda.getObsLanc());
            pst.setString(5, objAgenda.getUsuarioInsert());
            pst.setString(6, objAgenda.getDataInsert());
            pst.setString(7, objAgenda.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public ListaPassagemAlbergados alterarLista(ListaPassagemAlbergados objAgenda) {
        buscarOperacao(objAgenda.getNomeOperacao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LISTA_PASSAGEM_ALBERGADOS SET StatusLanc=?,DataCadastro=?,IdOp=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAgenda='" + objAgenda.getIdAgenda() + "'");
            pst.setString(1, objAgenda.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgenda.getDataCadastro().getTime()));
            pst.setInt(3, codOperacao);
            pst.setString(4, objAgenda.getObsLanc());
            pst.setString(5, objAgenda.getUsuarioUp());
            pst.setString(6, objAgenda.getDataUp());
            pst.setString(7, objAgenda.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public ListaPassagemAlbergados excluirLista(ListaPassagemAlbergados objAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LISTA_PASSAGEM_ALBERGADOS WHERE IdAgenda='" + objAgenda.getIdAgenda() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public ListaPassagemAlbergados finalizarLista(ListaPassagemAlbergados objAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LISTA_PASSAGEM_ALBERGADOS SET StatusLanc=? WHERE IdAgenda='" + objAgenda.getIdAgenda() + "'");
            pst.setString(1, objAgenda.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public void buscarOperacao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OPERACAO WHERE DescricaoOp='" + desc + "'");
            conecta.rs.first();
            codOperacao = conecta.rs.getInt("IdOp");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar operação" + e);
        }
        conecta.desconecta();
    }
}
