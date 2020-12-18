/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRolVisitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensRolVisitas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRolVisitas objItenRol = new ItensRolVisitas();
    int codVisita;
    int codInt;

    //Incluir itens (VISITAS) no Rol.
    public ItensRolVisitas incluirItensRol(ItensRolVisitas objItenRol) {
        buscarVisita(objItenRol.getNomeVisita(), objItenRol.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSROL (DataRol,IdRol,IdInternoCrc,IdVisita,DataInicio,StatusVisita,UsuarioInsert,DataInsert,HorarioInsert,ParentescoVisita) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenRol.getDataRol().getTime()));
            pst.setInt(2, objItenRol.getIdRol());
            pst.setInt(3, objItenRol.getIdInternoCrc());
            pst.setInt(4, codVisita);
            pst.setTimestamp(5, new java.sql.Timestamp(objItenRol.getDataInicio().getTime()));
            pst.setString(6, objItenRol.getStatusVisitaInterno());
            pst.setString(7, objItenRol.getUsuarioInsert());
            pst.setString(8, objItenRol.getDataInsert());
            pst.setString(9, objItenRol.getHoraInsert());
            pst.setString(10, objItenRol.getParentescoVisita());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();

        return objItenRol;
    }

    //Alterar itens (VISITAS) do Rol 
    public ItensRolVisitas alterarItensRol(ItensRolVisitas objItenRol) {
        buscarVisita(objItenRol.getNomeVisita(), objItenRol.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSROL SET DataRol=?,IdRol=?,IdInternoCrc=?,IdVisita=?,DataInicio=?,StatusVisita=?,UsuarioUp=?,DataUp=?,HorarioUp=?,ParentescoVisita=? WHERE IdItemRol='" + objItenRol.getIdItemRol() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenRol.getDataRol().getTime()));
            pst.setInt(2, objItenRol.getIdRol());
            pst.setInt(3, objItenRol.getIdInternoCrc());
            pst.setInt(4, codVisita);
            pst.setTimestamp(5, new java.sql.Timestamp(objItenRol.getDataInicio().getTime()));
            pst.setString(6, objItenRol.getStatusVisitaInterno());
            pst.setString(7, objItenRol.getUsuarioUp());
            pst.setString(8, objItenRol.getDataUp());
            pst.setString(9, objItenRol.getHoraUp());
            pst.setString(10, objItenRol.getParentescoVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();

        return objItenRol;
    }

    // Excluir itens (VISITAS) do Rol
    public ItensRolVisitas excluirItensRol(ItensRolVisitas objItenRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSROL WHERE IditemRol='" + objItenRol.getIdItemRol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();

        return objItenRol;
    }
    // Buscar Visitante

    public void buscarVisita(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + nome + "'AND IdVisita='" + codigo + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
