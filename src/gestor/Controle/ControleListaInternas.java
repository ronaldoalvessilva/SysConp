/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ListaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleListaInternas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ListaInternos objListaInternas = new ListaInternos();
    int codInt;

    public ListaInternos incluirListaInternos(ListaInternos objListaInternas) {
        buscarInternoCrc(objListaInternas.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LISTA_ROL_INTERNOS (StatusLista,DataLista,IdInternoCrc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objListaInternas.getStatusLista());
            pst.setTimestamp(2, new java.sql.Timestamp(objListaInternas.getDataLista().getTime()));
            pst.setInt(3, codInt);            
            pst.setString(4, objListaInternas.getObservacao());
            pst.setString(5, objListaInternas.getUsuarioInsert());
            pst.setString(6, objListaInternas.getDataInsert());
            pst.setString(7, objListaInternas.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objListaInternas;
    }

    public ListaInternos alterarListaInternos(ListaInternos objListaInternas) {
        buscarInternoCrc(objListaInternas.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LISTA_ROL_INTERNOS SET StatusLista=?,DataLista=?,IdInternoCrc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLista='" + objListaInternas.getIdLista() + "'");
            pst.setString(1, objListaInternas.getStatusLista());
            pst.setTimestamp(2, new java.sql.Timestamp(objListaInternas.getDataLista().getTime()));
            pst.setInt(3, codInt);            
            pst.setString(4, objListaInternas.getObservacao());
            pst.setString(5, objListaInternas.getUsuarioUpdate());
            pst.setString(6, objListaInternas.getDataUpdate());
            pst.setString(7, objListaInternas.getHoraUpdate());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objListaInternas;
    }

    public ListaInternos excluirListaInternos(ListaInternos objListaInternas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LISTA_ROL_INTERNOS WHERE IdLista='" + objListaInternas.getIdLista() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objListaInternas;
    }

    public ListaInternos finalizaListaInternos(ListaInternos objListaInternas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LISTA_ROL_INTERNOS SET StatusLista=? WHERE IdLista='" + objListaInternas.getIdLista() + "'");
            pst.setString(1, objListaInternas.getStatusLista());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objListaInternas;
    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
