/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.BiometriaColaboradores;
import gestor.Modelo.BiometriaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleBiometriaColaboradores {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    BiometriaColaboradores objBio = new BiometriaColaboradores();

    int codigoFunc;

    public BiometriaColaboradores incluirBiometriaColaborador(BiometriaColaboradores objBio) {
        buscarColaboradorBio(objBio.getIdFunc(), objBio.getNomeColabordor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO BIOMETRIA_COLABORADORES(DataCadastro,IdFunc,BiometriaDedo1,BiometriaDedo2,BiometriaDedo3,BiometriaDedo4,CaminhoImagemDedo1,CaminhoImagemDedo2,CaminhoImagemDedo3,CaminhoImagemDedo4,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objBio.getDataCadastro().getTime()));
            pst.setInt(2, codigoFunc);
            pst.setBytes(3, objBio.getBiometriaDedo1());
            pst.setBytes(4, objBio.getBiometriaDedo2());
            pst.setBytes(5, objBio.getBiometriaDedo3());
            pst.setBytes(6, objBio.getBiometriaDedo4());
            pst.setString(7, objBio.getCaminhoImagemDedo1());
            pst.setString(8, objBio.getCaminhoImagemDedo2());
            pst.setString(9, objBio.getCaminhoImagemDedo3());
            pst.setString(10, objBio.getCaminhoImagemDedo4());           
            pst.setString(11, objBio.getUsuarioInsert());
            pst.setString(12, objBio.getDataInsert());
            pst.setString(13, objBio.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar biometria.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objBio;
    }

    public BiometriaColaboradores alterarBiometriaColaborador(BiometriaColaboradores objBio) {
        buscarColaboradorBio(objBio.getIdFunc(), objBio.getNomeColabordor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE BIOMETRIA_COLABORADORES SET DataCadastro=?,IdFunc=?,BiometriaDedo1=?,BiometriaDedo2=?,BiometriaDedo3=?,BiometriaDedo4=?,CaminhoImagemDedo1=?,CaminhoImagemDedo2=?,CaminhoImagemDedo3=?,CaminhoImagemDedo4=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFunc='" + objBio.getIdFunc()+ "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objBio.getDataCadastro().getTime()));
            pst.setInt(2, codigoFunc);
            pst.setBytes(3, objBio.getBiometriaDedo1());
            pst.setBytes(4, objBio.getBiometriaDedo2());
            pst.setBytes(5, objBio.getBiometriaDedo3());
            pst.setBytes(6, objBio.getBiometriaDedo4());
            pst.setString(7, objBio.getCaminhoImagemDedo1());
            pst.setString(8, objBio.getCaminhoImagemDedo2());
            pst.setString(9, objBio.getCaminhoImagemDedo3());
            pst.setString(10, objBio.getCaminhoImagemDedo4());            
            pst.setString(11, objBio.getUsuarioUp());
            pst.setString(12, objBio.getDataUp());
            pst.setString(13, objBio.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar biometria.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objBio;
    }

    public void buscarColaboradorBio(int codigo, String nomeInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE IdFunc='" + codigo + "' "
                    + "AND NomeFunc='" + nomeInterno + "'");
            conecta.rs.first();
            codigoFunc = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro do colaborador.");
        }
        conecta.desconecta();
    }
}
