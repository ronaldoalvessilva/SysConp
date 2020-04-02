/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ObjetoProcedimento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleObjetosProcedimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ObjetoProcedimento objProce = new ObjetoProcedimento();

    public ObjetoProcedimento incluirObjetosProcetimento(ObjetoProcedimento objProce) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OBJETOSPROCEDIMENTOS (StatusLanc,DataLanc,DescricaoObjeto,FotoObjeto,UsuarioInsert,DataInsert,HorarioInsert,Modelo,Marca) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objProce.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objProce.getDataLanc().getTime()));
            pst.setString(3, objProce.getDescricaoObjeto());
            pst.setString(4, objProce.getFotoObjeto());
            pst.setString(5, objProce.getUsuarioInsert());
            pst.setString(6, objProce.getDataInsert());
            pst.setString(7, objProce.getHorarioInsert());
            pst.setString(8, objProce.getModelo());
            pst.setString(9, objProce.getMarca());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProce;
    }

    public ObjetoProcedimento alterarObjetosProcetimento(ObjetoProcedimento objProce) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OBJETOSPROCEDIMENTOS SET StatusLanc=?,DataLanc=?,DescricaoObjeto=?,FotoObjeto=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Modelo=?,Marca=? WHERE IdObjeto='" + objProce.getIdObjeto() + "'");
            pst.setString(1, objProce.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objProce.getDataLanc().getTime()));
            pst.setString(3, objProce.getDescricaoObjeto());
            pst.setString(4, objProce.getFotoObjeto());
            pst.setString(5, objProce.getUsuarioUp());
            pst.setString(6, objProce.getDataUp());
            pst.setString(7, objProce.getHorarioUp());
            pst.setString(8, objProce.getModelo());
            pst.setString(9, objProce.getMarca());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProce;
    }

    public ObjetoProcedimento excluirObjetosProcetimento(ObjetoProcedimento objProce) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OBJETOSPROCEDIMENTOS WHERE IdObjeto='" + objProce.getIdObjeto() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProce;
    }
}
