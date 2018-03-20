/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RolVisitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleRolVisitas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RolVisitas objRol = new RolVisitas();
    int codInt;

    public RolVisitas incluirRolVisitas(RolVisitas objRol) {
        buscarInterno(objRol.getNomeInternoCrc(),objRol.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ROLVISITAS (DataRol,StatusRol,IdInternoCrc,ObsRol,ObsPortaria,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objRol.getDataRol().getTime()));
            pst.setString(2, objRol.getStatusRol());
            pst.setInt(3, codInt);
            pst.setString(4, objRol.getObsRol());
            pst.setString(5, objRol.getObsPortaria());
            pst.setString(6, objRol.getUsuarioInsert());
            pst.setString(7, objRol.getDataInsert());
            pst.setString(8, objRol.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas alterarRolVisitas(RolVisitas objRol) {
        buscarInterno(objRol.getNomeInternoCrc(), objRol.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET DataRol=?,StatusRol=?,IdInternoCrc=?,ObsRol=?,ObsPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRol='" + objRol.getIdRol() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objRol.getDataRol().getTime()));
            pst.setString(2, objRol.getStatusRol());
            pst.setInt(3, codInt);
            pst.setString(4, objRol.getObsRol());
            pst.setString(5, objRol.getObsPortaria());
            pst.setString(6, objRol.getUsuarioUp());
            pst.setString(7, objRol.getDataUp());
            pst.setString(8, objRol.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas exclusaoRolVisitas(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ROLVISITAS WHERE IdRol='" + objRol.getIdRol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas finalizarRolVisitas(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=? WHERE IdRol='" + objRol.getIdRol() + "'");
            pst.setString(1, objRol.getStatusRol());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    // Finalizar Rol de visitas quando o interno sair da unidade pela portaria

    public RolVisitas finalizarRolVisitasPortaria(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=?,ObsPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRol.getIdInterno() + "'");
            pst.setString(1, objRol.getStatusRol());
            pst.setString(2, objRol.getObsRol());
            pst.setString(3, objRol.getUsuarioUp());
            pst.setString(4, objRol.getDataUp());
            pst.setString(5, objRol.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas alterarRecebeVisitaAtendimentoSocial(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOSOCIAL SET RecebeVisita=? WHERE IdInternoCrc='" + objRol.getIdInterno() + "'");
            pst.setString(1, objRol.getRecebeVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo  + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da INTERNO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
