/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Social2FamiliarPsicosocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSocial2VisitaIntimaPsicosocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Social2FamiliarPsicosocial objSocial2Vista = new Social2FamiliarPsicosocial();
    int codInt, codVisita;

    public Social2FamiliarPsicosocial incluirVisitaIntimaPsicoSocial(Social2FamiliarPsicosocial objSocial2Vista) {
        buscarInternoCrc(objSocial2Vista.getNomeInternoCrc());
        buscarVisitas(objSocial2Vista.getNomeVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOCIAL2_VISITA_INTIMA_PSICOSOCIAL (IdPai,IdInternoCrc,IdVisita,Ocupacao,Idade,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSocial2Vista.getIdPai());
            pst.setInt(2, codInt);
            pst.setInt(3, codVisita);
            pst.setString(4, objSocial2Vista.getOcupacao());                        
            pst.setInt(5, objSocial2Vista.getIdade());
            pst.setString(6, objSocial2Vista.getUsuarioInsert());
            pst.setString(7, objSocial2Vista.getDataInsert());
            pst.setString(8, objSocial2Vista.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Vista;
    }

    public Social2FamiliarPsicosocial alterarVisitaIntimaPsicoSocial(Social2FamiliarPsicosocial objSocial2Vista) {
        buscarInternoCrc(objSocial2Vista.getNomeInternoCrc());
        buscarVisitas(objSocial2Vista.getNomeVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOCIAL2_VISITA_INTIMA_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,IdVisita=?,Ocupacao=?,Idade=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSol2Visita='" + objSocial2Vista.getIdSol2Visita() + "'");
            pst.setInt(1, objSocial2Vista.getIdPai());
            pst.setInt(2, codInt);
            pst.setInt(3, codVisita);
            pst.setString(4, objSocial2Vista.getOcupacao());
            pst.setInt(5, objSocial2Vista.getIdade());            
            pst.setString(6, objSocial2Vista.getUsuarioInsert());
            pst.setString(7, objSocial2Vista.getDataInsert());
            pst.setString(8, objSocial2Vista.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Vista;
    }

    public Social2FamiliarPsicosocial excluirVisitaIntimaPsicoSocial(Social2FamiliarPsicosocial objSocial2Vista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOCIAL2_VISITA_INTIMA_PSICOSOCIAL WHERE IdSol2Visita='" + objSocial2Vista.getIdSol2Visita() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Vista;
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

    public void buscarVisitas(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
