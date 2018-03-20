/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EapiCrcPaiPsicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEapiCrcPaiPsicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EapiCrcPaiPsicoSocial objEapi = new EapiCrcPaiPsicoSocial();
    int codInt, codUnid;

    public EapiCrcPaiPsicoSocial incluirEapiCrcPaiPsicoSocial(EapiCrcPaiPsicoSocial objEapi) {
        buscarInternoCrc(objEapi.getNomeInternoCrc());
        buscarUnidade(objEapi.getDescricaoUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EAPI_CRC_PAI_PSICOSOCIAL (IdPai,IdInternoCrc,IdUnid,TempPenaSentenca,TempoPenaCumprida,AssistenciaJuridica,TempoPenaACumprir,ReintegraSistemaPenal,SituacaoJuridica,"
                    + "DataEntradaSistemaPenal,DefensorPublico,OutroDefensor,QualDefensor,TextoPSP,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objEapi.getIdPai());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setString(4, objEapi.getTempPenaSentenca());
            pst.setString(5, objEapi.getTempoPenaCumprida());
            pst.setString(6, objEapi.getAssistenciaJuridica());
            pst.setString(7, objEapi.getTempoPenaACumprir());
            pst.setString(8, objEapi.getReintegraSistemaPenal());
            pst.setString(9, objEapi.getSituacaoJuridica());
            if (objEapi.getDataEntradaSistemaPenal() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objEapi.getDataEntradaSistemaPenal().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.setString(11, objEapi.getDefensorPublico());
            pst.setString(12, objEapi.getOutroDefensor());
            pst.setString(13, objEapi.getQualDefensor());
            pst.setString(14, objEapi.getTextoPSP());
            pst.setString(15, objEapi.getUsuarioInsert());
            pst.setString(16, objEapi.getDataInsert());
            pst.setString(17, objEapi.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi;
    }

    public EapiCrcPaiPsicoSocial alterarEapiCrcPaiPsicoSocial(EapiCrcPaiPsicoSocial objEapi) {
        buscarInternoCrc(objEapi.getNomeInternoCrc());
        buscarUnidade(objEapi.getDescricaoUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EAPI_CRC_PAI_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,IdUnid=?,TempPenaSentenca=?,TempoPenaCumprida=?,AssistenciaJuridica=?,TempoPenaACumprir=?,ReintegraSistemaPenal=?,SituacaoJuridica=?,"
                    + "DataEntradaSistemaPenal=?,DefensorPublico=?,OutroDefensor=?,QualDefensor=?,TextoPSP=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEapi='" + objEapi.getIdEapi() + "'");
            pst.setInt(1, objEapi.getIdPai());
            pst.setInt(2, codInt);
            pst.setInt(3, codUnid);
            pst.setString(4, objEapi.getTempPenaSentenca());
            pst.setString(5, objEapi.getTempoPenaCumprida());
            pst.setString(6, objEapi.getAssistenciaJuridica());
            pst.setString(7, objEapi.getTempoPenaACumprir());
            pst.setString(8, objEapi.getReintegraSistemaPenal());
            pst.setString(9, objEapi.getSituacaoJuridica());
            if (objEapi.getDataEntradaSistemaPenal() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objEapi.getDataEntradaSistemaPenal().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.setString(11, objEapi.getDefensorPublico());
            pst.setString(12, objEapi.getOutroDefensor());
            pst.setString(13, objEapi.getQualDefensor());
            pst.setString(14, objEapi.getTextoPSP());
            pst.setString(15, objEapi.getUsuarioUp());
            pst.setString(16, objEapi.getDataUp());
            pst.setString(17, objEapi.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi;
    }

    public EapiCrcPaiPsicoSocial excluirEapiCrcPaiPsicoSocial(EapiCrcPaiPsicoSocial objEapi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EAPI_CRC_PAI_PSICOSOCIAL WHERE IdEapi='" + objEapi.getIdEapi() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEapi;
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

    public void buscarUnidade(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE WHERE DescricaoUnid='" + desc + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
