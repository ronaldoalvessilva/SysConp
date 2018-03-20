/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.BiometriaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleBiometriaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    BiometriaInternos objBio = new BiometriaInternos();

    int codigoInterno;

    public BiometriaInternos incluirBiometriaInterno(BiometriaInternos objBio) {
        buscarInternoBio(objBio.getIdInternoCrc(), objBio.getNomeInternoBio());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO BIOMETRIA_INTERNOS(DataCadastro,IdInternoCrc,BiometriaDedo1,BiometriaDedo2,BiometriaDedo3,BiometriaDedo4,CaminhoImagemDedo1,CaminhoImagemDedo2,CaminhoImagemDedo3,CaminhoImagemDedo4,CaminhoImagemDedo5,CaminhoImagemDedo6,CaminhoImagemDedo7,CaminhoImagemDedo8,CaminhoImagemDedo9,CaminhoImagemDedo10,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objBio.getDataCadastro().getTime()));
            pst.setInt(2, codigoInterno);
            pst.setBytes(3, objBio.getBiometriaDedo1());
            pst.setBytes(4, objBio.getBiometriaDedo2());
            pst.setBytes(5, objBio.getBiometriaDedo3());
            pst.setBytes(6, objBio.getBiometriaDedo4());
            pst.setString(7, objBio.getCaminhoImagemDedo1());
            pst.setString(8, objBio.getCaminhoImagemDedo2());
            pst.setString(9, objBio.getCaminhoImagemDedo3());
            pst.setString(10, objBio.getCaminhoImagemDedo4());
            pst.setString(11, objBio.getCaminhoImagemDedo5());
            pst.setString(12, objBio.getCaminhoImagemDedo6());
            pst.setString(13, objBio.getCaminhoImagemDedo7());
            pst.setString(14, objBio.getCaminhoImagemDedo8());
            pst.setString(15, objBio.getCaminhoImagemDedo9());
            pst.setString(16, objBio.getCaminhoImagemDedo10());
            pst.setString(17, objBio.getUsuarioInsert());
            pst.setString(18, objBio.getDataInsert());
            pst.setString(19, objBio.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar biometria.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objBio;
    }

    public BiometriaInternos alterarBiometriaInterno(BiometriaInternos objBio) {
        buscarInternoBio(objBio.getIdInternoCrc(), objBio.getNomeInternoBio());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE BIOMETRIA_INTERNOS SET DataCadastro=?,IdInternoCrc=?,BiometriaDedo1=?,BiometriaDedo2=?,BiometriaDedo3=?,BiometriaDedo4=?,CaminhoImagemDedo1=?,CaminhoImagemDedo2=?,CaminhoImagemDedo3=?,CaminhoImagemDedo4=?,CaminhoImagemDedo5=?,CaminhoImagemDedo6=?,CaminhoImagemDedo7=?,CaminhoImagemDedo8=?,CaminhoImagemDedo9=?,CaminhoImagemDedo10=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objBio.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objBio.getDataCadastro().getTime()));
            pst.setInt(2, codigoInterno);
            pst.setBytes(3, objBio.getBiometriaDedo1());
            pst.setBytes(4, objBio.getBiometriaDedo2());
            pst.setBytes(5, objBio.getBiometriaDedo3());
            pst.setBytes(6, objBio.getBiometriaDedo4());
            pst.setString(7, objBio.getCaminhoImagemDedo1());
            pst.setString(8, objBio.getCaminhoImagemDedo2());
            pst.setString(9, objBio.getCaminhoImagemDedo3());
            pst.setString(10, objBio.getCaminhoImagemDedo4());
            pst.setString(11, objBio.getCaminhoImagemDedo5());
            pst.setString(12, objBio.getCaminhoImagemDedo6());
            pst.setString(13, objBio.getCaminhoImagemDedo7());
            pst.setString(14, objBio.getCaminhoImagemDedo8());
            pst.setString(15, objBio.getCaminhoImagemDedo9());
            pst.setString(16, objBio.getCaminhoImagemDedo10());
            pst.setString(17, objBio.getUsuarioUp());
            pst.setString(18, objBio.getDataUp());
            pst.setString(19, objBio.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar biometria.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objBio;
    }

    public void buscarInternoBio(int codigo, String nomeInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE IdInternoCrc='" + codigo + "' "
                    + "AND NomeInternoCrc='" + nomeInterno + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro do interno.");
        }
        conecta.desconecta();
    }
}
