/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitasDiversas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitasDiversas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitasDiversas objViDi = new VisitasDiversas();

    public VisitasDiversas incluirVisitas(VisitasDiversas objViDi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VISITASDIVERSAS (DataCadastro,FotoVisita,NomeVisita,RgVisita,CpfVisita,CnhVisita,ClasseVisita,ObsVisita,UsuarioInsert,DataInsert,HorarioInsert,TipoVisita) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objViDi.getDataCadastro().getTime()));
            pst.setString(2, objViDi.getFotoVisita());
            pst.setString(3, objViDi.getNomeVisita());
            pst.setString(4, objViDi.getRgVisita());
            pst.setString(5, objViDi.getCpfVisita());
            pst.setString(6, objViDi.getCnhVisita());
            pst.setString(7, objViDi.getClasseVisita());
            pst.setString(8, objViDi.getObsVisita());
            pst.setString(9, objViDi.getUsuarioInsert());
            pst.setString(10, objViDi.getDataInsert());
            pst.setString(11, objViDi.getHoraInsert());
            pst.setString(12, objViDi.getTipoVisita());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objViDi;
    }

    public VisitasDiversas alterarVisitas(VisitasDiversas objViDi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITASDIVERSAS SET DataCadastro=?,FotoVisita=?,NomeVisita=?,RgVisita=?,CpfVisita=?,CnhVisita=?,ClasseVisita=?,ObsVisita=?,UsuarioUp=?,DataUp=?,HorarioUp=?,TipoVisita=? WHERE IdVisita='" + objViDi.getIdVisita() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objViDi.getDataCadastro().getTime()));
            pst.setString(2, objViDi.getFotoVisita());
            pst.setString(3, objViDi.getNomeVisita());
            pst.setString(4, objViDi.getRgVisita());
            pst.setString(5, objViDi.getCpfVisita());
            pst.setString(6, objViDi.getCnhVisita());
            pst.setString(7, objViDi.getClasseVisita());
            pst.setString(8, objViDi.getObsVisita());
            pst.setString(9, objViDi.getUsuarioUp());
            pst.setString(10, objViDi.getDataUp());
            pst.setString(11, objViDi.getHoraUp());
            pst.setString(12, objViDi.getTipoVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objViDi;
    }

    public VisitasDiversas excluirVisitas(VisitasDiversas objViDi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VISITASDIVERSAS WHERE IdVisita='" + objViDi.getIdVisita() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objViDi;
    }
}
