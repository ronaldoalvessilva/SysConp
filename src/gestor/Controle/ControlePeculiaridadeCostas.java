/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PeculiaridadeCostas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePeculiaridadeCostas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PeculiaridadeCostas objPecuCosta = new PeculiaridadeCostas();

    public PeculiaridadeCostas incluirPeculiaridadeCostas(PeculiaridadeCostas objPecuCosta) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PECULIARIDADE_COSTAS (DataPec,IdInternoCrc,RegiaoCostas,TextoPeculiaridade,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPecuCosta.getDataPec().getTime()));
            pst.setInt(2, objPecuCosta.getIdInternoCrc());
            pst.setString(3, objPecuCosta.getRegiaoCostas());
            pst.setString(4, objPecuCosta.getTextoPeculiaridade());
            pst.setString(5, objPecuCosta.getUsuarioInsert());
            pst.setString(6, objPecuCosta.getDataInsert());
            pst.setString(7, objPecuCosta.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPecuCosta;
    }

    public PeculiaridadeCostas alterarPeculiaridadeCostas(PeculiaridadeCostas objPecuCosta) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PECULIARIDADE_COSTAS SET DataPec=?,IdInternoCrc=?,RegiaoCostas=?,TextoPeculiaridade=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objPecuCosta.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPecuCosta.getDataPec().getTime()));
            pst.setInt(2, objPecuCosta.getIdInternoCrc());
            pst.setString(3, objPecuCosta.getRegiaoCostas());
            pst.setString(4, objPecuCosta.getTextoPeculiaridade());
            pst.setString(5, objPecuCosta.getUsuarioUp());
            pst.setString(6, objPecuCosta.getDataUp());
            pst.setString(7, objPecuCosta.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPecuCosta;
    }

    public PeculiaridadeCostas excluirPeculiaridadeCostas(PeculiaridadeCostas objPecuCosta) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PECULIARIDADE_COSTAS WHERE IdItem='" + objPecuCosta.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPecuCosta;
    }
}
