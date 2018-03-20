/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaCadastroPaiEapi1;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEAPI1 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaCadastroPaiEapi1 objEapi1 = new FichaCadastroPaiEapi1();
    int codInt;

    public FichaCadastroPaiEapi1 incluirPaiEAPI(FichaCadastroPaiEapi1 objEapi1) {
        buscarInternoCrc(objEapi1.getNomeInternoCrc(), objEapi1.getIdInternoCrc());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_EAPI1 (IdPai,IdInternoCrc,PSP,CEDEGEP,CRASCREAS,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objEapi1.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objEapi1.getpSP());
            pst.setString(4, objEapi1.getcEDEGEP());
            pst.setString(5, objEapi1.getcRASCREAS());
            pst.setString(6, objEapi1.getUsuarioInsert());
            pst.setString(7, objEapi1.getDataInsert());
            pst.setString(8, objEapi1.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi1;
    }

    public FichaCadastroPaiEapi1 alterarPaiEAPI(FichaCadastroPaiEapi1 objEapi1) {
        buscarInternoCrc(objEapi1.getNomeInternoCrc(), objEapi1.getIdInternoCrc());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_EAPI1 SET IdPai=?,IdInternoCrc=?,PSP=?,CEDEGEP=?,CRASCREAS=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPai='" + objEapi1.getIdPai() + "'");
            pst.setInt(1, objEapi1.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objEapi1.getpSP());
            pst.setString(4, objEapi1.getcEDEGEP());
            pst.setString(5, objEapi1.getcRASCREAS());
            pst.setString(6, objEapi1.getUsuarioInsert());
            pst.setString(7, objEapi1.getDataInsert());
            pst.setString(8, objEapi1.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi1;
    }

    public FichaCadastroPaiEapi1 excluirPaiEAPI(FichaCadastroPaiEapi1 objEapi1) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_EAPI1 WHERE IdPai='" + objEapi1.getIdPai() + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi1;
    }

    public void buscarInternoCrc(String desc, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + id + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
