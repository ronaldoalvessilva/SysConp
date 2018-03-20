/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Doencas;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleDoencas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Doencas objDoen = new Doencas();

    public Doencas incluirDoencas(Doencas objDoen) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DOENCAS (DataLanc,Descricao,Cid,UsuarioInsert,DataInsert,HorarioInsert)VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objDoen.getDataLanc().getTime()));
            pst.setString(2, objDoen.getDescricao());
            pst.setString(3, objDoen.getCid());
            pst.setString(4, objDoen.getUsuarioInsert());
            pst.setString(5, objDoen.getDataInsert());
            pst.setString(6, objDoen.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objDoen;
    }

    public Doencas alterarDoencas(Doencas objDoen) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DOENCAS SET DataLanc=?,Descricao=?,Cid=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDoenca='" + objDoen.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objDoen.getDataLanc().getTime()));
            pst.setString(2, objDoen.getDescricao());
            pst.setString(3, objDoen.getCid());
            pst.setString(4, objDoen.getUsuarioUp());
            pst.setString(5, objDoen.getDataUp());
            pst.setString(6, objDoen.getHorarioUp());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objDoen;
    }

    public Doencas excluirDoencas(Doencas objDoen) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DOENCAS WHERE IdDoenca='" + objDoen.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objDoen;
    }
}
