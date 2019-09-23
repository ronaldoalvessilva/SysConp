/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LiberadoresInternoColaboradores;
import gestor.Modelo.Pavilhao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleLiberadorBasePSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Pavilhao objLibera = new Pavilhao();
    LiberadoresInternoColaboradores objLib = new LiberadoresInternoColaboradores();
    int codigoPav;

    public LiberadoresInternoColaboradores incluirLiberador(LiberadoresInternoColaboradores objLib) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LIBERADOR_ESCOLTA_INTERNO_PSP (StatusLibera,DataRegistro,IdPav,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objLib.getStatusLibera());
            pst.setTimestamp(2, new java.sql.Timestamp(objLib.getDataRegistro().getTime()));
            pst.setInt(3, objLib.getIdPav());
            pst.setString(4, objLib.getObservacao());
            pst.setString(5, objLib.getUsuarioInsert());
            pst.setString(6, objLib.getDataInsert());
            pst.setString(7, objLib.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLib;
    }

    public LiberadoresInternoColaboradores alterarLiberador(LiberadoresInternoColaboradores objLib) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LIBERADOR_ESCOLTA_INTERNO_PSP SET StatusLibera=?,DataRegistro=?,IdPav=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLibe='" + objLib.getIdLibe() + "'");
            pst.setString(1, objLib.getStatusLibera());
            pst.setTimestamp(2, new java.sql.Timestamp(objLib.getDataRegistro().getTime()));
            pst.setInt(3, objLib.getIdPav());
            pst.setString(4, objLib.getObservacao());
            pst.setString(5, objLib.getUsuarioUp());
            pst.setString(6, objLib.getDataUp());
            pst.setString(7, objLib.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLib;
    }

    public LiberadoresInternoColaboradores excluirLiberador(LiberadoresInternoColaboradores objLib) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LIBERADOR_ESCOLTA_INTERNO_PSP WHERE IdLibe='" + objLib.getIdLibe() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLib;
    }
}
