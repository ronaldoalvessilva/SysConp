/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaCadastroPaiEapi2;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleEAPI2 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaCadastroPaiEapi2 objEapi2 = new FichaCadastroPaiEapi2();
    int codInt;

    public FichaCadastroPaiEapi2 incluirPaiEAPI2(FichaCadastroPaiEapi2 objEapi2) {
        buscarInternoCrc(objEapi2.getNomeInternoCrc(), objEapi2.getIdInternoCrc());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_EAPI2 (IdPai,IdInternoCrc,ASSISTENCIA,DOCUMENTOCIVIL,EAPI2PAI,TecnicoServicoSocial,TecnicoPsicologico,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objEapi2.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objEapi2.getaSSISTENCIA());
            pst.setString(4, objEapi2.getdOCUMENTOCIVIL());
            pst.setString(5, objEapi2.geteAPI2PAI());
            pst.setString(6, objEapi2.getTecnicoServicoSocial());
            pst.setString(7, objEapi2.getTecnicoPsicologico());
            pst.setString(8, objEapi2.getUsuarioInsert());
            pst.setString(9, objEapi2.getDataInsert());
            pst.setString(10, objEapi2.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi2;
    }

    public FichaCadastroPaiEapi2 alterarPaiEAPI2(FichaCadastroPaiEapi2 objEapi2) {
        buscarInternoCrc(objEapi2.getNomeInternoCrc(), objEapi2.getIdInternoCrc());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_EAPI2 SET IdPai=?,IdInternoCrc=?,ASSISTENCIA=?,DOCUMENTOCIVIL=?,EAPI2PAI=?,TecnicoServicoSocial=?,TecnicoPsicologico=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPai='" + objEapi2.getIdPai() + "'");
            pst.setInt(1, objEapi2.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objEapi2.getaSSISTENCIA());
            pst.setString(4, objEapi2.getdOCUMENTOCIVIL());
            pst.setString(5, objEapi2.geteAPI2PAI());
            pst.setString(6, objEapi2.getTecnicoServicoSocial());
            pst.setString(7, objEapi2.getTecnicoPsicologico());
            pst.setString(8, objEapi2.getUsuarioInsert());
            pst.setString(9, objEapi2.getDataInsert());
            pst.setString(10, objEapi2.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi2;
    }

    public FichaCadastroPaiEapi2 excluirPaiEAPI2(FichaCadastroPaiEapi2 objEapi2) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_EAPI2 WHERE IdPai='" + objEapi2.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi2;
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
