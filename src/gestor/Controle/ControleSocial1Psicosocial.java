/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Social1PaiPsicosocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleSocial1Psicosocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Social1PaiPsicosocial objSocial1Pai = new Social1PaiPsicosocial();
    int codInt;

    public Social1PaiPsicosocial incluirSocial1Psicosocial(Social1PaiPsicosocial objSocial1Pai) {
        buscarInternoCrc(objSocial1Pai.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOCIAL1_PAI_PSICOSOCIAL (IdPai,IdInternoCrc,DocumentoCivil,CNascimento,RG,CPF,CTPS,"
                    + "OutrosDoc,QtdFilhosMaior,FilhosSemRegistros,QtdFilhosSemRegistro,QtdFilhosMenor,ObservacaoFilhos,VulnerabilidaSocial,AtendePrevistas,"
                    + "InseriProgramaSocial,QualProgramaSocial,PartFamiliaCumpre,IntervencaoPrograma,LocalizacaoFamiliares,ObservacaoParticipacaoFamilia,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSocial1Pai.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objSocial1Pai.getDocumentoCivil());
            pst.setString(4, objSocial1Pai.getcNascimento());
            pst.setString(5, objSocial1Pai.getrG());
            pst.setString(6, objSocial1Pai.getcPF());
            pst.setString(7, objSocial1Pai.getcTPS());
            pst.setString(8, objSocial1Pai.getOutrosDoc());
            pst.setInt(9, objSocial1Pai.getQtdFilhosMaior());
            pst.setString(10, objSocial1Pai.getFilhosSemRegistros());
            pst.setInt(11, objSocial1Pai.getQtdFilhosSemRegistro());
            pst.setInt(12, objSocial1Pai.getQtdFilhosMenor());
            pst.setString(13, objSocial1Pai.getObservacaoFilhos());
            pst.setString(14, objSocial1Pai.getVulnerabilidaSocial());
            pst.setString(15, objSocial1Pai.getAtendePrevistas());
            pst.setString(16, objSocial1Pai.getInseriProgramaSocial());
            pst.setString(17, objSocial1Pai.getQualProgramaSocial());
            pst.setInt(18, objSocial1Pai.getPartFamiliaCumpre());
            pst.setString(19, objSocial1Pai.getIntervencaoPrograma());
            pst.setString(20, objSocial1Pai.getLocalizacaoFamiliares());
            pst.setString(21, objSocial1Pai.getObservacaoParticipacaoFamilia());
            pst.setString(22, objSocial1Pai.getUsuarioInsert());
            pst.setString(23, objSocial1Pai.getDataInsert());
            pst.setString(24, objSocial1Pai.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial1Pai;
    }

    public Social1PaiPsicosocial alterarSocial1Psicosocial(Social1PaiPsicosocial objSocial1Pai) {
        buscarInternoCrc(objSocial1Pai.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOCIAL1_PAI_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,DocumentoCivil=?,CNascimento=?,RG=?,CPF=?,CTPS=?,"
                    + "OutrosDoc=?,QtdFilhosMaior=?,FilhosSemRegistros=?,QtdFilhosSemRegistro=?,QtdFilhosMenor=?,ObservacaoFilhos=?,VulnerabilidaSocial=?,AtendePrevistas=?,"
                    + "InseriProgramaSocial=?,QualProgramaSocial=?,PartFamiliaCumpre=?,IntervencaoPrograma=?,LocalizacaoFamiliares=?,ObservacaoParticipacaoFamilia=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPaiSS1='" + objSocial1Pai.getIdPaiSS1() + "'");
            pst.setInt(1, objSocial1Pai.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objSocial1Pai.getDocumentoCivil());
            pst.setString(4, objSocial1Pai.getcNascimento());
            pst.setString(5, objSocial1Pai.getrG());
            pst.setString(6, objSocial1Pai.getcPF());
            pst.setString(7, objSocial1Pai.getcTPS());
            pst.setString(8, objSocial1Pai.getOutrosDoc());
            pst.setInt(9, objSocial1Pai.getQtdFilhosMaior());
            pst.setString(10, objSocial1Pai.getFilhosSemRegistros());
            pst.setInt(11, objSocial1Pai.getQtdFilhosSemRegistro());
            pst.setInt(12, objSocial1Pai.getQtdFilhosMenor());
            pst.setString(13, objSocial1Pai.getObservacaoFilhos());
            pst.setString(14, objSocial1Pai.getVulnerabilidaSocial());
            pst.setString(15, objSocial1Pai.getAtendePrevistas());
            pst.setString(16, objSocial1Pai.getInseriProgramaSocial());
            pst.setString(17, objSocial1Pai.getQualProgramaSocial());
            pst.setInt(18, objSocial1Pai.getPartFamiliaCumpre());
            pst.setString(19, objSocial1Pai.getIntervencaoPrograma());
            pst.setString(20, objSocial1Pai.getLocalizacaoFamiliares());
            pst.setString(21, objSocial1Pai.getObservacaoParticipacaoFamilia());
            pst.setString(22, objSocial1Pai.getUsuarioUp());
            pst.setString(23, objSocial1Pai.getDataUp());
            pst.setString(24, objSocial1Pai.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial1Pai;
    }

    public Social1PaiPsicosocial excluirSocial1Psicosocial(Social1PaiPsicosocial objSocial1Pai) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOCIAL1_PAI_PSICOSOCIAL WHERE IdPaiSS1=" + objSocial1Pai.getIdPaiSS1() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial1Pai;
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
