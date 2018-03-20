/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensListaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensListaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensListaInternos objItensLista = new ItensListaInternos();

    int codInt;

    public ItensListaInternos incluirItensListaInternos(ItensListaInternos objItensLista) {
        buscarInternoCrc(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_LISTA_ROL (IdRol,IdInternoCrc,StatusInterna,DataValidade,UsuarioInsert,DataInsert,HorarioInsert,GrauParentesco) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensLista.getIdLista());
            pst.setInt(2, codInt);
            pst.setString(3, objItensLista.getStatusInterno());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensLista.getDataValidade().getTime()));
            pst.setString(5, objItensLista.getUsuarioInsert());
            pst.setString(6, objItensLista.getDataInsert());
            pst.setString(7, objItensLista.getHoraInsert());
            pst.setString(8, objItensLista.getGrauParentescoInterno());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public ItensListaInternos alterarItensListaInternos(ItensListaInternos objItensLista) {
        buscarInternoCrc(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_LISTA_ROL SET IdRol=?,IdInternoCrc=?,StatusInterna=?,DataValidade=?,UsuarioUp=?,DataUp=?,HorarioUp=?,GrauParentesco=? WHERE IdItem='" + objItensLista.getIdItem() + "'");
            pst.setInt(1, objItensLista.getIdLista());
            pst.setInt(2, codInt);
            pst.setString(3, objItensLista.getStatusInterno());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensLista.getDataValidade().getTime()));
            pst.setString(5, objItensLista.getUsuarioUpdate());
            pst.setString(6, objItensLista.getDataUpdate());
            pst.setString(7, objItensLista.getHoraUpdate());
            pst.setString(8, objItensLista.getGrauParentescoInterno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public ItensListaInternos excluirItensListaInternos(ItensListaInternos objItensLista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_LISTA_ROL WHERE IdItem='" + objItensLista.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public void buscarInternoCrc(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
