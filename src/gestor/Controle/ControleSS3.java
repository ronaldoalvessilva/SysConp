/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SS3PaiPsicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSS3 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SS3PaiPsicoSocial objSS3 = new SS3PaiPsicoSocial();
    int codInt;

    public SS3PaiPsicoSocial incluirSS3PaiPsicoSocial(SS3PaiPsicoSocial objSS3) {
        buscarInternoCrc(objSS3.getNomeInternoCrc());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SS3_PAI_PSICOSOCIAL (IdPai,IdInternoCrc,TextoCEDEGEP,TextoCRASCREAS,TextoASSISTENCIA,TextoDOCUMENTOCIVIL,DataInclusaoPAI,TecnicoServicoSocial,TecnicoPsicologico,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSS3.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objSS3.getTextoCEDEGEP());
            pst.setString(4, objSS3.getTextoCRASCREAS());
            pst.setString(5, objSS3.getTextoASSISTENCIA());
            pst.setString(6, objSS3.getTextoDOCUMENTOCIVIL());
            if (objSS3.getDataInclusaoPAI() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objSS3.getDataInclusaoPAI().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objSS3.getTecnicoServicoSocial());
            pst.setString(9, objSS3.getTecnicoPsicologico());

            pst.setString(10, objSS3.getUsuarioInsert());
            pst.setString(11, objSS3.getDataInsert());
            pst.setString(12, objSS3.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSS3;
    }

    public SS3PaiPsicoSocial alterarSS3PaiPsicoSocial(SS3PaiPsicoSocial objSS3) {
        buscarInternoCrc(objSS3.getNomeInternoCrc());

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SS3_PAI_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,TextoCEDEGEP=?,TextoCRASCREAS=?,TextoASSISTENCIA=?,TextoDOCUMENTOCIVIL=?,DataInclusaoPAI=?,TecnicoServicoSocial=?,TecnicoPsicologico=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSS3='" + objSS3.getIdSS3() + "'");
            pst.setInt(1, objSS3.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objSS3.getTextoCEDEGEP());
            pst.setString(4, objSS3.getTextoCRASCREAS());
            pst.setString(5, objSS3.getTextoASSISTENCIA());
            pst.setString(6, objSS3.getTextoDOCUMENTOCIVIL());
            if (objSS3.getDataInclusaoPAI() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objSS3.getDataInclusaoPAI().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objSS3.getTecnicoServicoSocial());
            pst.setString(9, objSS3.getTecnicoPsicologico());

            pst.setString(10, objSS3.getUsuarioInsert());
            pst.setString(11, objSS3.getDataInsert());
            pst.setString(12, objSS3.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSS3;
    }

    public SS3PaiPsicoSocial excluirSS3PaiPsicoSocial(SS3PaiPsicoSocial objSS3) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SS3_PAI_PSICOSOCIAL WHERE IdSS3='" + objSS3.getIdSS3() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSS3;
    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
