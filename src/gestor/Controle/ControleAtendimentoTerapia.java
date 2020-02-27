/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoTerapeuta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAtendimentoTerapia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoTerapeuta objAtend = new AtendimentoTerapeuta();
    int codInt;

    // Incluir Atendimeto do Terapia Ocupacional
    public AtendimentoTerapeuta incluirAtendTerapia(AtendimentoTerapeuta objAtend) {
        buscarInternoCrc(objAtend.getNomeInternoCrc(),objAtend.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTOTERAPIA (StatusLanc,DataLanc,IdInternoCrc,Dominancia,Amputacao,"
                    + "DeficienciaOcupa,Reabilitacao,Motora,Cognitiva,Sensorial,IntPsi,AVD,AIVD,Lazer,Trabalho,ObsDesempenhoOcupacional,PaisVivos,"
                    + "TemCompanheira,TemFilhos,QuantosFilhos,VisitaFamiliar,SFSeg,SFTer,SFQua,SFQui,SFSex,SFSab,SFDom,VisitaIntima,IntSeg,IntTer,IntQua,IntQui,IntSex,IntSab,IntDom,"
                    + "ObsHistoricoFamiliar,Hipertensao,Diabetes,Cancer,ProRespiratorio,TransMental,InfectoContagiosa,DoencasDigestiva,DeficienciaVAF,ObsDadosClinicos,"
                    + "Tabagismo,QuantoTabagismo,Etilismo,TipoEtilismo,EtilismoUsuario,MedicacaoAlopatica,TipoMedicacaoAlopatica,MedicacaoAlopaticaUsuario,SPA,"
                    + "TipoSPA,SPAUsuario,ObsTriagemSPA,VidaSexual,MetodoContraCeptivo,QualMetodoContraCeptivo,Gestante,Aborto,MotivoAborto,"
                    + "PraticaAtividadeFisica,QualAtividadeFisica,TrataPsicologico,ObsEstiloVida,Humor,Insonia,Irritabilidade,Frustracao,DificuldadeConcentrar,"
                    + "Raiva,Inquietacao,Ansiedade,ObsAlteracoesPsicologicas,UsuarioInsert,DataInsert,HorarioInsert,TabagismoUsuario) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtend.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtend.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            //DESEMPENHO OCUPACIONAL
            pst.setString(4, objAtend.getDominancia());
            pst.setString(5, objAtend.getAmputacao());
            pst.setString(6, objAtend.getDeficienciaOcupa());
            pst.setString(7, objAtend.getReabilitacao());
            pst.setString(8, objAtend.getMotora());
            pst.setString(9, objAtend.getCognitiva());
            pst.setString(10, objAtend.getSensorial());
            pst.setString(11, objAtend.getIntPsi());
            pst.setString(12, objAtend.getaVD());
            pst.setString(13, objAtend.getaIVD());
            pst.setString(14, objAtend.getLazer());
            pst.setString(15, objAtend.getTrabalho());
            pst.setString(16, objAtend.getObsDesempenhoOcupacional());
            // HISTÓRICO FAMILIAR
            pst.setString(17, objAtend.getPaisVivos());
            pst.setString(18, objAtend.getTemCompanheira());
            pst.setString(19, objAtend.getTemFilhos());
            pst.setInt(20, objAtend.getQuantosFilhos());
            pst.setString(21, objAtend.getVisitaFamiliar());
            pst.setInt(22, objAtend.getsFSeg());
            pst.setInt(23, objAtend.getsFTer());
            pst.setInt(24, objAtend.getsFQua());
            pst.setInt(25, objAtend.getsFQui());
            pst.setInt(26, objAtend.getsFSex());
            pst.setInt(27, objAtend.getsFSab());
            pst.setInt(28, objAtend.getsFDom());
            pst.setString(29, objAtend.getVisitaIntima());
            pst.setInt(30, objAtend.getIntSeg());
            pst.setInt(31, objAtend.getIntTer());
            pst.setInt(32, objAtend.getIntQua());
            pst.setInt(33, objAtend.getIntQui());
            pst.setInt(34, objAtend.getIntSex());
            pst.setInt(35, objAtend.getIntSab());
            pst.setInt(36, objAtend.getIntDom());
            pst.setString(37, objAtend.getObsHistoricoFamiliar());
            // DADOS CLINICOS
            pst.setString(38, objAtend.getHipertensao());
            pst.setString(39, objAtend.getDiabetes());
            pst.setString(40, objAtend.getCancer());
            pst.setString(41, objAtend.getProRespiratorio());
            pst.setString(42, objAtend.getTransMental());
            pst.setString(43, objAtend.getInfectoContagiosa());
            pst.setString(44, objAtend.getDoencasDigestiva());
            pst.setString(45, objAtend.getDeficienciaVAF());
            pst.setString(46, objAtend.getObsDadosClinicos());
            // QUALIDADE DE VIDA (TRIAGEM SPA)
            pst.setString(47, objAtend.getTabagismo());
            pst.setInt(48, objAtend.getQuantoTabagismo());
            pst.setString(49, objAtend.getEtilismo());
            pst.setString(50, objAtend.getTipoEtilismo());
            pst.setString(51, objAtend.getEtilismoUsuario());
            pst.setString(52, objAtend.getMedicacaoAlopativa());
            pst.setString(53, objAtend.getTipoMedicacaoAlopativa());
            pst.setString(54, objAtend.getMedicaoAlopaticaUsuario());
            pst.setString(55, objAtend.getsPA());
            pst.setString(56, objAtend.getTipoSPA());
            pst.setString(57, objAtend.getsPAUsuario());
            pst.setString(58, objAtend.getObsTriagemSPA());
            // QUALIDADE DE VIDA (ESTILO VIDA)
            pst.setString(59, objAtend.getVidaSexual());
            pst.setString(60, objAtend.getMetodoContraCeptivo());
            pst.setString(61, objAtend.getQualMetodoContraCeptivo());
            pst.setString(62, objAtend.getGestante());
            pst.setString(63, objAtend.getAborto());
            pst.setString(64, objAtend.getMotivoAborto());
            pst.setString(65, objAtend.getPraticaAtividadeFisica());
            pst.setString(66, objAtend.getQualAtividadeFisica());
            pst.setString(67, objAtend.getTrataPsicologica());
            pst.setString(68, objAtend.getObsEstiloVida());
            // ALTERAÇÕES PSICOLOGICAS
            pst.setString(69, objAtend.getHumor());
            pst.setString(70, objAtend.getInsonia());
            pst.setString(71, objAtend.getIrritabilidade());
            pst.setString(72, objAtend.getFrustracao());
            pst.setString(73, objAtend.getDificuldadeConcentrar());
            pst.setString(74, objAtend.getRaiva());
            pst.setString(75, objAtend.getInquietacao());
            pst.setString(76, objAtend.getAnsiedade());
            pst.setString(77, objAtend.getObsAlteracoesPsicologicas());
            pst.setString(78, objAtend.getUsuarioInsert());
            pst.setString(79, objAtend.getDataInsert());
            pst.setString(80, objAtend.getHoraInsert());
            pst.setString(81, objAtend.getTabagismoUsuario());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    // Alterar Atendimeto do Terapia Ocupacional
    public AtendimentoTerapeuta alterarAtendTerapia(AtendimentoTerapeuta objAtend) {
        buscarInternoCrc(objAtend.getNomeInternoCrc(),objAtend.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTERAPIA  SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,Dominancia=?,Amputacao=?,"
                    + "DeficienciaOcupa=?,Reabilitacao=?,Motora=?,Cognitiva=?,Sensorial=?,IntPsi=?,AVD=?,AIVD=?,Lazer=?,Trabalho=?,ObsDesempenhoOcupacional=?,PaisVivos=?,"
                    + "TemCompanheira=?,TemFilhos=?,QuantosFilhos=?,VisitaFamiliar=?,SFSeg=?,SFTer=?,SFQua=?,SFQui=?,SFSex=?,SFSab=?,SFDom=?,VisitaIntima=?,IntSeg=?,IntTer=?,IntQua=?,IntQui=?,IntSex=?,IntSab=?,IntDom=?,"
                    + "ObsHistoricoFamiliar=?,Hipertensao=?,Diabetes=?,Cancer=?,ProRespiratorio=?,TransMental=?,InfectoContagiosa=?,DoencasDigestiva=?,DeficienciaVAF=?,ObsDadosClinicos=?,"
                    + "Tabagismo=?,QuantoTabagismo=?,Etilismo=?,TipoEtilismo=?,EtilismoUsuario=?,MedicacaoAlopatica=?,TipoMedicacaoAlopatica=?,MedicacaoAlopaticaUsuario=?,SPA=?,"
                    + "TipoSPA=?,SPAUsuario=?,ObsTriagemSPA=?,VidaSexual=?,MetodoContraCeptivo=?,QualMetodoContraCeptivo=?,Gestante=?,Aborto=?,MotivoAborto=?,"
                    + "PraticaAtividadeFisica=?,QualAtividadeFisica=?,TrataPsicologico=?,ObsEstiloVida=?,Humor=?,Insonia=?,Irritabilidade=?,Frustracao=?,DificuldadeConcentrar=?,"
                    + "Raiva=?,Inquietacao=?,Ansiedade=?,ObsAlteracoesPsicologicas=?,UsuarioUp=?,DataUp=?,HorarioUp=?,TabagismoUsuario=?  WHERE IdLanc='" + objAtend.getIdLanc() + "'");
            pst.setString(1, objAtend.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtend.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            //DESEMPENHO OCUPACIONAL
            pst.setString(4, objAtend.getDominancia());
            pst.setString(5, objAtend.getAmputacao());
            pst.setString(6, objAtend.getDeficienciaOcupa());
            pst.setString(7, objAtend.getReabilitacao());
            pst.setString(8, objAtend.getMotora());
            pst.setString(9, objAtend.getCognitiva());
            pst.setString(10, objAtend.getSensorial());
            pst.setString(11, objAtend.getIntPsi());
            pst.setString(12, objAtend.getaVD());
            pst.setString(13, objAtend.getaIVD());
            pst.setString(14, objAtend.getLazer());
            pst.setString(15, objAtend.getTrabalho());
            pst.setString(16, objAtend.getObsDesempenhoOcupacional());
            // HISTÓRICO FAMILIAR
            pst.setString(17, objAtend.getPaisVivos());
            pst.setString(18, objAtend.getTemCompanheira());
            pst.setString(19, objAtend.getTemFilhos());
            pst.setInt(20, objAtend.getQuantosFilhos());
            pst.setString(21, objAtend.getVisitaFamiliar());
            pst.setInt(22, objAtend.getsFSeg());
            pst.setInt(23, objAtend.getsFTer());
            pst.setInt(24, objAtend.getsFQua());
            pst.setInt(25, objAtend.getsFQui());
            pst.setInt(26, objAtend.getsFSex());
            pst.setInt(27, objAtend.getsFSab());
            pst.setInt(28, objAtend.getsFDom());
            pst.setString(29, objAtend.getVisitaIntima());
            pst.setInt(30, objAtend.getIntSeg());
            pst.setInt(31, objAtend.getIntTer());
            pst.setInt(32, objAtend.getIntQua());
            pst.setInt(33, objAtend.getIntQui());
            pst.setInt(34, objAtend.getIntSex());
            pst.setInt(35, objAtend.getIntSab());
            pst.setInt(36, objAtend.getIntDom());
            pst.setString(37, objAtend.getObsHistoricoFamiliar());
            // DADOS CLINICOS
            pst.setString(38, objAtend.getHipertensao());
            pst.setString(39, objAtend.getDiabetes());
            pst.setString(40, objAtend.getCancer());
            pst.setString(41, objAtend.getProRespiratorio());
            pst.setString(42, objAtend.getTransMental());
            pst.setString(43, objAtend.getInfectoContagiosa());
            pst.setString(44, objAtend.getDoencasDigestiva());
            pst.setString(45, objAtend.getDeficienciaVAF());
            pst.setString(46, objAtend.getObsDadosClinicos());
            // QUALIDADE DE VIDA (TRIAGEM SPA)
            pst.setString(47, objAtend.getTabagismo());
            pst.setInt(48, objAtend.getQuantoTabagismo());
            pst.setString(49, objAtend.getEtilismo());
            pst.setString(50, objAtend.getTipoEtilismo());
            pst.setString(51, objAtend.getEtilismoUsuario());
            pst.setString(52, objAtend.getMedicacaoAlopativa());
            pst.setString(53, objAtend.getTipoMedicacaoAlopativa());
            pst.setString(54, objAtend.getMedicaoAlopaticaUsuario());
            pst.setString(55, objAtend.getsPA());
            pst.setString(56, objAtend.getTipoSPA());
            pst.setString(57, objAtend.getsPAUsuario());
            pst.setString(58, objAtend.getObsTriagemSPA());
            // QUALIDADE DE VIDA (ESTILO VIDA)
            pst.setString(59, objAtend.getVidaSexual());
            pst.setString(60, objAtend.getMetodoContraCeptivo());
            pst.setString(61, objAtend.getQualMetodoContraCeptivo());
            pst.setString(62, objAtend.getGestante());
            pst.setString(63, objAtend.getAborto());
            pst.setString(64, objAtend.getMotivoAborto());
            pst.setString(65, objAtend.getPraticaAtividadeFisica());
            pst.setString(66, objAtend.getQualAtividadeFisica());
            pst.setString(67, objAtend.getTrataPsicologica());
            pst.setString(68, objAtend.getObsEstiloVida());
            // ALTERAÇÕES PSICOLOGICAS
            pst.setString(69, objAtend.getHumor());
            pst.setString(70, objAtend.getInsonia());
            pst.setString(71, objAtend.getIrritabilidade());
            pst.setString(72, objAtend.getFrustracao());
            pst.setString(73, objAtend.getDificuldadeConcentrar());
            pst.setString(74, objAtend.getRaiva());
            pst.setString(75, objAtend.getInquietacao());
            pst.setString(76, objAtend.getAnsiedade());
            pst.setString(77, objAtend.getObsAlteracoesPsicologicas());
            pst.setString(78, objAtend.getUsuarioUp());
            pst.setString(79, objAtend.getDataUp());
            pst.setString(80, objAtend.getHoraUp());
            pst.setString(81, objAtend.getTabagismoUsuario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    // Excluir Atendimeto do Terapia Ocupacional
    public AtendimentoTerapeuta excluirAtendTerapia(AtendimentoTerapeuta objAtend) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTOTERAPIA WHERE IdLanc='" + objAtend.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    // Finalizar Atendimeto do Terapia Ocupacional
    public AtendimentoTerapeuta finalizarAtendTerapia(AtendimentoTerapeuta objAtend) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTERAPIA SET StatusLanc=? WHERE IdLanc='" + objAtend.getIdLanc() + "'");
            pst.setString(1, objAtend.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtend;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                            + "IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
