/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PsicologiaMedicoPaiPsicosocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControlePsicologiaMedicoPaiPsicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PsicologiaMedicoPaiPsicosocial objPsiMed = new PsicologiaMedicoPaiPsicosocial();
    int codInt;

    public PsicologiaMedicoPaiPsicosocial incluirPsicologiaMedicoPaiPsicosocial(PsicologiaMedicoPaiPsicosocial objPsiMed) {
        buscarInternoCrc(objPsiMed.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL (IdPai,IdInternoCrc,FamiliaTranstornoMental,QuemTranstornoMental,QualTranstornoMental,NecessidadePSI,ConsultaPSI,AcompanhaPSI,"
                    + "FazUsoDroga,QuaisDrogas,CompartilhaDrogas,ReducaoDanos,PorqueReduzDanos,AceitaProgramasDanos,PorqueAceitaProgroReduDanos,QueixaProbSaude,Hipertensao,Diabetes,Tuberculose,DST,Hepatite,Hanseniase,OutrasDoencas,"
                    + "QuaisOutrasDoencas,ProblemasSaudeBucal,FazTratamentoBucal,QuaisTratamentoBucal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPsiMed.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objPsiMed.getFamiliaTranstornoMental());
            pst.setString(4, objPsiMed.getQuemTranstornoMental());
            pst.setString(5, objPsiMed.getQualTranstornoMental());
            pst.setString(6, objPsiMed.getNecessidadePSI());
            pst.setInt(7, objPsiMed.getConsultaPSI());
            pst.setInt(8, objPsiMed.getAcompanhaPSI());
            pst.setString(9, objPsiMed.getFazUsoDroga());
            pst.setString(10, objPsiMed.getQuaisDrogas());
            pst.setString(11, objPsiMed.getCompartilhaDrogas());
            pst.setString(12, objPsiMed.getReducaoDanos());
            pst.setString(13, objPsiMed.getPorqueReduzDanos());
            pst.setString(14, objPsiMed.getAceitaProgramasDanos());
            pst.setString(15, objPsiMed.getPorqueAceitaProgroReduDanos());
            pst.setString(16, objPsiMed.getQueixaProbSaude());
            pst.setInt(17, objPsiMed.getHipertensao());
            pst.setInt(18, objPsiMed.getDiabetes());
            pst.setInt(19, objPsiMed.getTuberculose());
            pst.setInt(20, objPsiMed.getdST());
            pst.setInt(21, objPsiMed.getHepatite());
            pst.setInt(22, objPsiMed.getHanseniase());
            pst.setInt(23, objPsiMed.getOutrasDoencas());
            pst.setString(24, objPsiMed.getQuaisOutrasDoencas());
            pst.setString(25, objPsiMed.getProblemasSaudeBucal());
            pst.setString(26, objPsiMed.getFazTratamentoBucal());
            pst.setString(27, objPsiMed.getQuaisTratamentoBucal());
            pst.setString(28, objPsiMed.getUsuarioInsert());
            pst.setString(29, objPsiMed.getDataInsert());
            pst.setString(30, objPsiMed.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPsiMed;
    }

    public PsicologiaMedicoPaiPsicosocial alterarPsicologiaMedicoPaiPsicosocial(PsicologiaMedicoPaiPsicosocial objPsiMed) {
        buscarInternoCrc(objPsiMed.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,FamiliaTranstornoMental=?,QuemTranstornoMental=?,QualTranstornoMental=?,NecessidadePSI=?,ConsultaPSI=?,AcompanhaPSI=?,"
                    + "FazUsoDroga=?,QuaisDrogas=?,CompartilhaDrogas=?,ReducaoDanos=?,PorqueReduzDanos=?,AceitaProgramasDanos=?,PorqueAceitaProgroReduDanos=?,QueixaProbSaude=?,Hipertensao=?,Diabetes=?,Tuberculose=?,DST=?,Hepatite=?,Hanseniase=?,OutrasDoencas=?,"
                    + "QuaisOutrasDoencas=?,ProblemasSaudeBucal=?,FazTratamentoBucal=?,QuaisTratamentoBucal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPsiMed='" + objPsiMed.getIdPsiMed() + "'");
            pst.setInt(1, objPsiMed.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objPsiMed.getFamiliaTranstornoMental());
            pst.setString(4, objPsiMed.getQuemTranstornoMental());
            pst.setString(5, objPsiMed.getQualTranstornoMental());
            pst.setString(6, objPsiMed.getNecessidadePSI());
            pst.setInt(7, objPsiMed.getConsultaPSI());
            pst.setInt(8, objPsiMed.getAcompanhaPSI());
            pst.setString(9, objPsiMed.getFazUsoDroga());
            pst.setString(10, objPsiMed.getQuaisDrogas());
            pst.setString(11, objPsiMed.getCompartilhaDrogas());
            pst.setString(12, objPsiMed.getReducaoDanos());
            pst.setString(13, objPsiMed.getPorqueReduzDanos());
            pst.setString(14, objPsiMed.getAceitaProgramasDanos());
            pst.setString(15, objPsiMed.getPorqueAceitaProgroReduDanos());
            pst.setString(16, objPsiMed.getQueixaProbSaude());
            pst.setInt(17, objPsiMed.getHipertensao());
            pst.setInt(18, objPsiMed.getDiabetes());
            pst.setInt(19, objPsiMed.getTuberculose());
            pst.setInt(20, objPsiMed.getdST());
            pst.setInt(21, objPsiMed.getHepatite());
            pst.setInt(22, objPsiMed.getHanseniase());
            pst.setInt(23, objPsiMed.getOutrasDoencas());
            pst.setString(24, objPsiMed.getQuaisOutrasDoencas());
            pst.setString(25, objPsiMed.getProblemasSaudeBucal());
            pst.setString(26, objPsiMed.getFazTratamentoBucal());
            pst.setString(27, objPsiMed.getQuaisTratamentoBucal());
            pst.setString(28, objPsiMed.getUsuarioUp());
            pst.setString(29, objPsiMed.getDataUp());
            pst.setString(30, objPsiMed.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPsiMed;
    }

    public PsicologiaMedicoPaiPsicosocial excluirPsicologiaMedicoPaiPsicosocial(PsicologiaMedicoPaiPsicosocial objPsiMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL WHERE IdPsiMed='" + objPsiMed.getIdPsiMed() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPsiMed;
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
