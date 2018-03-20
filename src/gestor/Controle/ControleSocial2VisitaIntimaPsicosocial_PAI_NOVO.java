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
public class ControleSocial2VisitaIntimaPsicosocial_PAI_NOVO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Social2FamiliarPsicosocial objSocial2Vista = new Social2FamiliarPsicosocial();
    int codInt, codVisita;

    public Social2FamiliarPsicosocial incluirVisitaIntimaPsicoSocial(Social2FamiliarPsicosocial objSocial2Vista) {
        buscarInternoCrc(objSocial2Vista.getNomeInternoCrc(), objSocial2Vista.getIdInternoCrc());
        buscarVisitas(objSocial2Vista.getNomeVisita(), objSocial2Vista.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_CCGF_VF2 (IdPai,IdInternoCrc,IdVisita,Ocupacao,Idade,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
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
        buscarInternoCrc(objSocial2Vista.getNomeInternoCrc(), objSocial2Vista.getIdInternoCrc());
        buscarVisitas(objSocial2Vista.getNomeVisita(), objSocial2Vista.getIdVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_CCGF_VF2 SET IdPai=?,IdInternoCrc=?,IdVisita=?,Ocupacao=?,Idade=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdVF2='" + objSocial2Vista.getIdSol2Visita() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_CCGF_VF2 WHERE IdVF2='" + objSocial2Vista.getIdSol2Visita() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Vista;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarVisitas(String desc, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'AND IdVisita='" + id + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
