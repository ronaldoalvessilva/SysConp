/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Controle.*;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoPsicologica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAdminssaoPsicologiaDAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPsicologica objAdmPsi = new AdmissaoPsicologica();
    int codInterno;

    public AdmissaoPsicologica incluirNovaAdmissaoPsi(AdmissaoPsicologica objAdmPsi) {
        buscarInterno(objAdmPsi.getNomeInterno(), objAdmPsi.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PORTA_ENTRADA_PSICOLOGIA (StatusLanc,DataLanc,IdInternoCrc,PresoAntes,FamiliaPreso,QuemFamiliaPreso,OndePreso,HistoricoCriminal,"
                    + "UsaDrogras,Alcool,Cigarro,Maconha,Crack,Cocaina,Cola,Outros,OutrasDrogas,QualIdade,PorqueUsaDrogas,Drogas,TratamentoPSI,MedicamentoPSI,QualMedicamento,AcompanhaPSI,TranstornoMental,"
                    + "DepartamentoEncaminha,DataEncaminhamento,HoraAcompanha,Encaminhamento,TratamentoSaude,QualTratamentoSaude,OndeFazTratamento,TratamentoAnteriores,"
                    + "SituacaoTraumatica,QualSituacaoTraumatica,HouveTentativaSuicidio,PorQueSuicidio,ComoFoiTentarSuicidio,OndeTentouSuicidio,TentativaSuicidio,"
                    + "QualMedicamentoUtiliza,PorqueUsaMedicamento,UsoMedicamentos,RecebeVisitas,Familiares,UsuarioInsert,DataInsert,HorarioInsert,IdLanc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAdmPsi.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmPsi.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            // HISTORICO CRIMINAL
            pst.setString(4, objAdmPsi.getPresoAntes());
            pst.setString(5, objAdmPsi.getFamiliaPreso());
            pst.setString(6, objAdmPsi.getQuemFamiliaPreso());
            pst.setString(7, objAdmPsi.getOndePreso());
            pst.setString(8, objAdmPsi.getHistoricoCriminal());
            // DROGAS
            pst.setString(9, objAdmPsi.getUsaDrogras());
            pst.setInt(10, objAdmPsi.getAlcool());
            pst.setInt(11, objAdmPsi.getCigarro());
            pst.setInt(12, objAdmPsi.getMaconha());
            pst.setInt(13, objAdmPsi.getCrack());
            pst.setInt(14, objAdmPsi.getCocaina());
            pst.setInt(15, objAdmPsi.getCola());
            pst.setInt(16, objAdmPsi.getOutros());
            pst.setString(17, objAdmPsi.getOutrasDrogas());
            pst.setInt(18, objAdmPsi.getQualIdade());
            pst.setString(19, objAdmPsi.getPorqueUsaDrogas());
            pst.setString(20, objAdmPsi.getDrogas());
            // TRANSTORNO MENTAL
            pst.setString(21, objAdmPsi.getTratamentoPSI());
            pst.setString(22, objAdmPsi.getMedicamentoPSI());
            pst.setString(23, objAdmPsi.getQualMedicamento());
            pst.setString(24, objAdmPsi.getAcompanhaPSI());
            pst.setString(25, objAdmPsi.getTranstornoMental());
            // ENCAMINHAMENTO
            pst.setString(26, objAdmPsi.getDepartamentoEncaminha());
            if (objAdmPsi.getDataEncaminhamento() != null) {
                pst.setTimestamp(27, new java.sql.Timestamp(objAdmPsi.getDataEncaminhamento().getTime()));
            } else {
                pst.setDate(27, null);
            }
            pst.setString(28, objAdmPsi.getHoraAcompanha());
            pst.setString(29, objAdmPsi.getEncaminhamento());
            //TRATAMENTO ANTERIORES
            pst.setString(30, objAdmPsi.getTratamentoSaude());
            pst.setString(31, objAdmPsi.getQualTratamentoSaude());
            pst.setString(32, objAdmPsi.getOndeFazTratamento());
            pst.setString(33, objAdmPsi.getTratamentoAntriores());
            // TENTATIVA DE SUICIDIO
            pst.setString(34, objAdmPsi.getSituacaoTraumatica());
            pst.setString(35, objAdmPsi.getQualSituacaoTraumatica());
            pst.setString(36, objAdmPsi.getHouveTentativaSuicidio());
            pst.setString(37, objAdmPsi.getPorQueSuicidio());
            pst.setString(38, objAdmPsi.getComoFoiTentarSuicidio());
            pst.setString(39, objAdmPsi.getOndeTentouSuicidio());
            pst.setString(40, objAdmPsi.getTentativaSuicidio());
            // USO DE MEDICAMENTOS
            pst.setString(41, objAdmPsi.getQualMedicamentoUtiliza());
            pst.setString(42, objAdmPsi.getPorqueUsaMedicamento());
            pst.setString(43, objAdmPsi.getUsoMedicamentos());
            // FAMILIARES
            pst.setString(44, objAdmPsi.getRecebeVisitas());
            pst.setString(45, objAdmPsi.getFamiliares());
            pst.setString(46, objAdmPsi.getUsuarioInsert());
            pst.setString(47, objAdmPsi.getDataInsert());
            pst.setString(48, objAdmPsi.getHoraInsert());
            pst.setInt(49, objAdmPsi.getIdLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public AdmissaoPsicologica alterarNovaAdmissaoPsi(AdmissaoPsicologica objAdmPsi) {
        buscarInterno(objAdmPsi.getNomeInterno(), objAdmPsi.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_PSICOLOGIA SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,PresoAntes=?,FamiliaPreso=?,QuemFamiliaPreso=?,OndePreso=?,HistoricoCriminal=?,"
                    + "UsaDrogras=?,Alcool=?,Cigarro=?,Maconha=?,Crack=?,Cocaina=?,Cola=?,Outros=?,OutrasDrogas=?,QualIdade=?,PorqueUsaDrogas=?,Drogas=?,TratamentoPSI=?,MedicamentoPSI=?,QualMedicamento=?,AcompanhaPSI=?,TranstornoMental=?,"
                    + "DepartamentoEncaminha=?,DataEncaminhamento=?,HoraAcompanha=?,Encaminhamento=?,TratamentoSaude=?,QualTratamentoSaude=?,OndeFazTratamento=?,TratamentoAnteriores=?,"
                    + "SituacaoTraumatica=?,QualSituacaoTraumatica=?,HouveTentativaSuicidio=?,PorQueSuicidio=?,ComoFoiTentarSuicidio=?,OndeTentouSuicidio=?,TentativaSuicidio=?,"
                    + "QualMedicamentoUtiliza=?,PorqueUsaMedicamento=?,UsoMedicamentos=?,RecebeVisitas=?,Familiares=?,UsuarioUp=?,DataUp=?,HorarioUp=?,IdLanc=? WHERE IdPortaPSI='" + objAdmPsi.getIdPortaPSI()+ "'");
            pst.setString(1, objAdmPsi.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmPsi.getDataLanc().getTime()));
            pst.setInt(3, codInterno);
            // HISTORICO CRIMINAL
            pst.setString(4, objAdmPsi.getPresoAntes());
            pst.setString(5, objAdmPsi.getFamiliaPreso());
            pst.setString(6, objAdmPsi.getQuemFamiliaPreso());
            pst.setString(7, objAdmPsi.getOndePreso());
            pst.setString(8, objAdmPsi.getHistoricoCriminal());
            // DROGAS
            pst.setString(9, objAdmPsi.getUsaDrogras());
            pst.setInt(10, objAdmPsi.getAlcool());
            pst.setInt(11, objAdmPsi.getCigarro());
            pst.setInt(12, objAdmPsi.getMaconha());
            pst.setInt(13, objAdmPsi.getCrack());
            pst.setInt(14, objAdmPsi.getCocaina());
            pst.setInt(15, objAdmPsi.getCola());
            pst.setInt(16, objAdmPsi.getOutros());
            pst.setString(17, objAdmPsi.getOutrasDrogas());
            pst.setInt(18, objAdmPsi.getQualIdade());
            pst.setString(19, objAdmPsi.getPorqueUsaDrogas());
            pst.setString(20, objAdmPsi.getDrogas());
            // TRANSTORNO MENTAL
            pst.setString(21, objAdmPsi.getTratamentoPSI());
            pst.setString(22, objAdmPsi.getMedicamentoPSI());
            pst.setString(23, objAdmPsi.getQualMedicamento());
            pst.setString(24, objAdmPsi.getAcompanhaPSI());
            pst.setString(25, objAdmPsi.getTranstornoMental());
            // ENCAMINHAMENTO
            pst.setString(26, objAdmPsi.getDepartamentoEncaminha());
            if (objAdmPsi.getDataEncaminhamento() != null) {
                pst.setTimestamp(27, new java.sql.Timestamp(objAdmPsi.getDataEncaminhamento().getTime()));
            } else {
                pst.setDate(27, null);
            }
            pst.setString(28, objAdmPsi.getHoraAcompanha());
            pst.setString(29, objAdmPsi.getEncaminhamento());
            //TRATAMENTO ANTERIORES
            pst.setString(30, objAdmPsi.getTratamentoSaude());
            pst.setString(31, objAdmPsi.getQualTratamentoSaude());
            pst.setString(32, objAdmPsi.getOndeFazTratamento());
            pst.setString(33, objAdmPsi.getTratamentoAntriores());
            // TENTATIVA DE SUICIDIO
            pst.setString(34, objAdmPsi.getSituacaoTraumatica());
            pst.setString(35, objAdmPsi.getQualSituacaoTraumatica());
            pst.setString(36, objAdmPsi.getHouveTentativaSuicidio());
            pst.setString(37, objAdmPsi.getPorQueSuicidio());
            pst.setString(38, objAdmPsi.getComoFoiTentarSuicidio());
            pst.setString(39, objAdmPsi.getOndeTentouSuicidio());
            pst.setString(40, objAdmPsi.getTentativaSuicidio());
            // USO DE MEDICAMENTOS
            pst.setString(41, objAdmPsi.getQualMedicamentoUtiliza());
            pst.setString(42, objAdmPsi.getPorqueUsaMedicamento());
            pst.setString(43, objAdmPsi.getUsoMedicamentos());
            // FAMILIARES
            pst.setString(44, objAdmPsi.getRecebeVisitas());
            pst.setString(45, objAdmPsi.getFamiliares());
            pst.setString(46, objAdmPsi.getUsuarioUp());
            pst.setString(47, objAdmPsi.getDataUp());
            pst.setString(48, objAdmPsi.getHoraUp());
            pst.setInt(49, objAdmPsi.getIdLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public AdmissaoPsicologica excluirNovaAdmissaoPsi(AdmissaoPsicologica objAdmPsi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PORTA_ENTRADA_PSICOLOGIA WHERE IdPortaPSI='" + objAdmPsi.getIdPortaPSI()+ "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public AdmissaoPsicologica finalizarNovaAdmissaoPsi(AdmissaoPsicologica objAdmPsi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_PSICOLOGIA SET StatusLanc=? WHERE IdPortaPSI='" + objAdmPsi.getIdPortaPSI()+ "'");
            pst.setString(1, objAdmPsi.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    public void buscarInterno(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
