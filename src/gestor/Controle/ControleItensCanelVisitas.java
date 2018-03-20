/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensCancelamentoVisita;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensCanelVisitas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensCancelamentoVisita objItenCancel = new ItensCancelamentoVisita();
    int codVisita;
    int codInt;

    //Incluir itens (VISITAS) no Rol.
    public ItensCancelamentoVisita incluirItensCancel(ItensCancelamentoVisita objItenCancel) {
        buscarVisita(objItenCancel.getNomeVisita(), objItenCancel.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL (DataRolCan,IdCan,IdInternoCrc,IdVisita,DataBloqueio,StatusVisita,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenCancel.getDataCan().getTime()));
            pst.setInt(2, objItenCancel.getIdCan());
            pst.setInt(3, objItenCancel.getIdInternoCrc());
            pst.setInt(4, codVisita);
            pst.setTimestamp(5, new java.sql.Timestamp(objItenCancel.getDataBloqueio().getTime()));
            pst.setString(6, objItenCancel.getStatusVisitaInterno());
            pst.setString(7, objItenCancel.getMotivoCancela());
            pst.setString(8, objItenCancel.getUsuarioInsert());
            pst.setString(9, objItenCancel.getDataInsert());
            pst.setString(10, objItenCancel.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItenCancel;
    }

    //Alterar itens (VISITAS) do Rol 
    public ItensCancelamentoVisita alterarItensCancel(ItensCancelamentoVisita objItenCancel) {
        buscarVisita(objItenCancel.getNomeVisita(), objItenCancel.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL SET DataRolCan=?,IdCan=?,IdInternoCrc=?,IdVisita=?,DataBloqueio=?,StatusVisita=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemCanExt='" + objItenCancel.getIdItemCanExt() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenCancel.getDataCan().getTime()));
            pst.setInt(2, objItenCancel.getIdCan());
            pst.setInt(3, objItenCancel.getIdInternoCrc());
            pst.setInt(4, codVisita);
            pst.setTimestamp(5, new java.sql.Timestamp(objItenCancel.getDataBloqueio().getTime()));
            pst.setString(6, objItenCancel.getStatusVisitaInterno());
            pst.setString(7, objItenCancel.getMotivoCancela());
            pst.setString(8, objItenCancel.getUsuarioUp());
            pst.setString(9, objItenCancel.getDataUp());
            pst.setString(10, objItenCancel.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItenCancel;
    }

    // Excluir itens (VISITAS) do Rol
    public ItensCancelamentoVisita excluirItensCancel(ItensCancelamentoVisita objItenCancel) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL WHERE IdItemCanExt='" + objItenCancel.getIdItemCanExt() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados. \n\nERRO:" + ex);
        }
        conecta.desconecta();

        return objItenCancel;
    }

    public ItensCancelamentoVisita alterarItensRol(ItensCancelamentoVisita objItenCancel) {
        buscarVisita(objItenCancel.getNomeVisita(), objItenCancel.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSROL SET StatusVisita=? WHERE IdInternoCrc='" + objItenCancel.getIdInternoCrc() + "'AND IdVisita='" + objItenCancel.getIdVisita() + "'");
            pst.setString(1, objItenCancel.getStatusVisitaInterno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();

        return objItenCancel;
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

    public void buscarInterno(String nome, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + id + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
