/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TerapiaPedagogiaPsicosocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleTerapiaPedagogiaPsicoSocialPAI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TerapiaPedagogiaPsicosocial objTeraPed = new TerapiaPedagogiaPsicosocial();
    int codInt;

    public TerapiaPedagogiaPsicosocial incluirTerapiaPedPsicoSocial(TerapiaPedagogiaPsicosocial objTeraPed) {
        buscarInternoCrc(objTeraPed.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TERAPIA_PEDAGOGIA_PSICOSOCIAL (IdPai,IdInternoCrc,Escolaridade,DemandaEscolar,FrequnetaEscola,QualEscola,Instrucao,ObservacaoTOPED,"
                    + "Profissao,ParticipaLabor,QualLabor,ObservacaoLabor,DemandaQualiProf,QualDemanda,ExperienciaTrabRenda,QualExperiencia,Habilidades,ParticipaAtividade,QuaisAtividades,DemandaParticaCultura,"
                    + "Esporte,QualEsporte,Lazer,QualLazer,Cultura,QualCultura,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objTeraPed.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objTeraPed.getEscolaridade());
            pst.setString(4, objTeraPed.getDemandaEscolar());
            pst.setString(5, objTeraPed.getFrequnetaEscola());
            pst.setString(6, objTeraPed.getQualEscola());
            pst.setInt(7, objTeraPed.getInstrucao());
            pst.setString(8, objTeraPed.getObservacaoTOPED());
            pst.setString(9, objTeraPed.getProfissao());
            pst.setString(10, objTeraPed.getParticipaLabor());
            pst.setString(11, objTeraPed.getQualLabor());
            pst.setString(12, objTeraPed.getObservacaoLabor());
            pst.setString(13, objTeraPed.getDemandaQualiProf());
            pst.setString(14, objTeraPed.getQualDemanda());
            pst.setString(15, objTeraPed.getExperienciaTrabRenda());
            pst.setString(16, objTeraPed.getQualExperiencia());
            pst.setString(17, objTeraPed.getHabilidades());
            pst.setString(18, objTeraPed.getParticipaAtividade());
            pst.setString(19, objTeraPed.getQuaisAtividades());
            pst.setString(20, objTeraPed.getDemandaParticaCultura());
            pst.setString(21, objTeraPed.getEsporte());
            pst.setString(22, objTeraPed.getQualEsporte());
            pst.setString(23, objTeraPed.getLazer());
            pst.setString(24, objTeraPed.getQualLazer());
            pst.setString(25, objTeraPed.getCultura());
            pst.setString(26, objTeraPed.getQualCultura());
            pst.setString(27, objTeraPed.getUsuarioInsert());
            pst.setString(28, objTeraPed.getDataInsert());
            pst.setString(29, objTeraPed.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTeraPed;
    }

    public TerapiaPedagogiaPsicosocial alterarTerapiaPedPsicoSocial(TerapiaPedagogiaPsicosocial objTeraPed) {
        buscarInternoCrc(objTeraPed.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TERAPIA_PEDAGOGIA_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,Escolaridade=?,DemandaEscolar=?,FrequnetaEscola=?,QualEscola=?,Instrucao=?,ObservacaoTOPED=?,"
                    + "Profissao=?,ParticipaLabor=?,QualLabor=?,ObservacaoLabor=?,DemandaQualiProf=?,QualDemanda=?,ExperienciaTrabRenda=?,QualExperiencia=?,Habilidades=?,ParticipaAtividade=?,QuaisAtividades=?,DemandaParticaCultura=?,"
                    + "Esporte=?,QualEsporte=?,Lazer=?,QualLazer=?,Cultura=?,QualCultura=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdToPed='" + objTeraPed.getIdToPed() + "'");
            pst.setInt(1, objTeraPed.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objTeraPed.getEscolaridade());
            pst.setString(4, objTeraPed.getDemandaEscolar());
            pst.setString(5, objTeraPed.getFrequnetaEscola());
            pst.setString(6, objTeraPed.getQualEscola());
            pst.setInt(7, objTeraPed.getInstrucao());
            pst.setString(8, objTeraPed.getObservacaoTOPED());
            pst.setString(9, objTeraPed.getProfissao());
            pst.setString(10, objTeraPed.getParticipaLabor());
            pst.setString(11, objTeraPed.getQualLabor());
            pst.setString(12, objTeraPed.getObservacaoLabor());
            pst.setString(13, objTeraPed.getDemandaQualiProf());
            pst.setString(14, objTeraPed.getQualDemanda());
            pst.setString(15, objTeraPed.getExperienciaTrabRenda());
            pst.setString(16, objTeraPed.getQualExperiencia());
            pst.setString(17, objTeraPed.getHabilidades());
            pst.setString(18, objTeraPed.getParticipaAtividade());
            pst.setString(19, objTeraPed.getQuaisAtividades());
            pst.setString(20, objTeraPed.getDemandaParticaCultura());
            pst.setString(21, objTeraPed.getEsporte());
            pst.setString(22, objTeraPed.getQualEsporte());
            pst.setString(23, objTeraPed.getLazer());
            pst.setString(24, objTeraPed.getQualLazer());
            pst.setString(25, objTeraPed.getCultura());
            pst.setString(26, objTeraPed.getQualCultura());
            pst.setString(27, objTeraPed.getUsuarioUp());
            pst.setString(28, objTeraPed.getDataUp());
            pst.setString(29, objTeraPed.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTeraPed;
    }

    public TerapiaPedagogiaPsicosocial excluirTerapiaPedPsicoSocial(TerapiaPedagogiaPsicosocial objTeraPed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TERAPIA_PEDAGOGIA_PSICOSOCIAL WHERE IdToPed='" + objTeraPed.getIdToPed() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTeraPed;
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
