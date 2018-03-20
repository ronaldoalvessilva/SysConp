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
public class ControleItensRolVisitasReligiosa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRolVisitas objItenRol = new ItensRolVisitas();
    int codVisita;
    int codInt;

    //Incluir itens (VISITAS) no Rol.
    public ItensRolVisitas incluirItensRolReligiao(ItensRolVisitas objItenRol) {
        buscarVisita(objItenRol.getNomeVisita(), objItenRol.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ROL_VISITAS_RELIGIOSA (DataRol,IdRol,IdCod,IdVisitaRel,DataInicio,Domingo,Segunda,Terca,Quarta,Quinta,Sexta,Sabado,StatusVisita,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenRol.getDataRol().getTime()));
            pst.setInt(2, objItenRol.getIdRol());
            pst.setInt(3, objItenRol.getIdInstituicao());
            pst.setInt(4, codVisita);
            pst.setTimestamp(5, new java.sql.Timestamp(objItenRol.getDataInicio().getTime()));
            pst.setInt(6, objItenRol.getDomingoVisita());
            pst.setInt(7, objItenRol.getSegundaVisita());
            pst.setInt(8, objItenRol.getTercaVisita());
            pst.setInt(9, objItenRol.getQuartaVisita());
            pst.setInt(10, objItenRol.getQuintaVisita());
            pst.setInt(11, objItenRol.getSextaVisita());
            pst.setInt(12, objItenRol.getSabadoVisita());
            pst.setString(13, objItenRol.getStatusVisitaInterno());
            pst.setString(14, objItenRol.getUsuarioInsert());
            pst.setString(15, objItenRol.getDataInsert());
            pst.setString(16, objItenRol.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItenRol;
    }

    //Alterar itens (VISITAS) do Rol 
    public ItensRolVisitas alterarItensRolReligiao(ItensRolVisitas objItenRol) {
        buscarVisita(objItenRol.getNomeVisita(), objItenRol.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ROL_VISITAS_RELIGIOSA SET DataRol=?,IdRol=?,IdCod=?,IdVisitaRel=?,DataInicio=?,Domingo=?,Segunda=?,Terca=?,Quarta=?,Quinta=?,Sexta=?,Sabado=?,StatusVisita=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemRol='" + objItenRol.getIdItemRol() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenRol.getDataRol().getTime()));
            pst.setInt(2, objItenRol.getIdRol());
            pst.setInt(3, objItenRol.getIdInstituicao());
            pst.setInt(4, codVisita);
            pst.setTimestamp(5, new java.sql.Timestamp(objItenRol.getDataInicio().getTime()));
            pst.setInt(6, objItenRol.getDomingoVisita());
            pst.setInt(7, objItenRol.getSegundaVisita());
            pst.setInt(8, objItenRol.getTercaVisita());
            pst.setInt(9, objItenRol.getQuartaVisita());
            pst.setInt(10, objItenRol.getQuintaVisita());
            pst.setInt(11, objItenRol.getSextaVisita());
            pst.setInt(12, objItenRol.getSabadoVisita());
            pst.setString(13, objItenRol.getStatusVisitaInterno());
            pst.setString(14, objItenRol.getUsuarioUp());
            pst.setString(15, objItenRol.getDataUp());
            pst.setString(16, objItenRol.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItenRol;
    }

    // Excluir itens (VISITAS) do Rol
    public ItensRolVisitas excluirItensRolReligiao(ItensRolVisitas objItenRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ROL_VISITAS_RELIGIOSA WHERE IditemRol='" + objItenRol.getIdItemRol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItenRol;
    }
    // Buscar Visitante

    public void buscarVisita(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITAS_RELIGIOSA_INTERNOS WHERE NomeVisitaRel='" + nome + "'AND IdVisitaRel='" + codigo + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisitaRel");
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
