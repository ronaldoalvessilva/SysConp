/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleAcompanhaEnfermaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirAcompanhamentoEnfermaria(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO "
                    + "ACOMPANHAMENTO_INTERNO_ENFERMARIA (IdLanc,IdInternoCrc,DataReg,"
                    + "Diabetes,DiabControl,QtdDiabetes,Hipertensao,HiperControl,QtdHipertensao,"
                    + "Escabiose,EscabioseCura,QtdEscabiose,Hanseniase,HanseniaseCura,QtdHanseniase,"
                    + "Sifilis,SifilisCura,QtdSifilis,Tuberculose,TuberculoseCura,QtdTuberculose,"
                    + "Hiv,HivControlada,QtdHiv,HepatiteB,HepatiteBCont,QtdHepatiteB,HepatiteC,HepatiteCCont,"
                    + "QtdHepatiteC,Dst,DstCurada,QtdDst,Vdlr,VdlrCurada,QtdVdlr,Vacina,VacinaCura,QtdVacina,"
                    + "Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataReg().getTime()));
            pst.setString(4, objPerfilInter.getDiabetes());
            pst.setString(5, objPerfilInter.getDiabControl());
            pst.setInt(6, objPerfilInter.getQtdDiabetes());
            pst.setString(7, objPerfilInter.getHipertensao());
            pst.setString(8, objPerfilInter.getHiperControl());
            pst.setInt(9, objPerfilInter.getQtdHipertensao());
            pst.setString(10, objPerfilInter.getEscabiose());
            pst.setString(11, objPerfilInter.getEscabioseCura());
            pst.setInt(12, objPerfilInter.getQtdEscabiose());
            pst.setString(13, objPerfilInter.getHanseniase());
            pst.setString(14, objPerfilInter.getHanseniaseCura());
            pst.setInt(15, objPerfilInter.getQtdHanseniase());
            pst.setString(16, objPerfilInter.getSifilis());
            pst.setString(17, objPerfilInter.getSifilisCura());
            pst.setInt(18, objPerfilInter.getQtdSifilis());
            pst.setString(19, objPerfilInter.getTuberculose());
            pst.setString(20, objPerfilInter.getTuberculoseCura());
            pst.setInt(21, objPerfilInter.getQtdTuberculose());
            pst.setString(22, objPerfilInter.getHiv());
            pst.setString(23, objPerfilInter.getHivControlada());
            pst.setInt(24, objPerfilInter.getQtdHib());
            pst.setString(25, objPerfilInter.getHepatiteB());
            pst.setString(26, objPerfilInter.getHepatiBCont());
            pst.setInt(27, objPerfilInter.getQtdHepatiteB());
            pst.setString(28, objPerfilInter.getHepatiteC());
            pst.setString(29, objPerfilInter.getHepatiCcont());
            pst.setInt(30, objPerfilInter.getQtdHepatiteC());
            pst.setString(31, objPerfilInter.getDst());
            pst.setString(32, objPerfilInter.getCuraDst());
            pst.setInt(33, objPerfilInter.getQdtDst());
            pst.setString(34, objPerfilInter.getvDLR());
            pst.setString(35, objPerfilInter.getCuraVdlr());
            pst.setInt(36, objPerfilInter.getQtdVdlr());
            pst.setString(37, objPerfilInter.getVacina());
            pst.setString(38, objPerfilInter.getVacinaCura());
            pst.setInt(39, objPerfilInter.getQtdVacina());
            pst.setString(40, objPerfilInter.getObservacaoEnf());
            pst.setString(41, objPerfilInter.getUsuarioInsert());
            pst.setString(42, objPerfilInter.getDataInsert());
            pst.setString(43, objPerfilInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento alterarAcompanhamentoEnfermaria(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ACOMPANHAMENTO_INTERNO_ENFERMARIA SET IdLanc=?,IdInternoCrc=?,DataReg=?,Diabetes=?,DiabControl=?,QtdDiabetes=?,Hipertensao=?,HiperControl=?,QtdHipertensao=?,Escabiose=?,EscabioseCura=?,QtdEscabiose=?,Hanseniase=?,HanseniaseCura=?,QtdHanseniase=?,Sifilis=?,SifilisCura=?,QtdSifilis=?,Tuberculose=?,TuberculoseCura=?,QtdTuberculose=?,Hiv=?,HivControlada=?,QtdHiv=?,HepatiteB=?,HepatiteBCont=?,QtdHepatiteB=?,HepatiteC=?,HepatiteCCont=?,QtdHepatiteC=?,Dst=?,DstCurada=?,QtdDst=?,Vdlr=?,VdlrCurada=?,QtdVdlr=?,Vacina=?,VacinaCura=?,QtdVacina=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEnf='" + objPerfilInter.getIdEnf() + "'AND IdLanc='" + objPerfilInter.getIdIndAco() + "'");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataReg().getTime()));
            pst.setString(4, objPerfilInter.getDiabetes());
            pst.setString(5, objPerfilInter.getDiabControl());
            pst.setInt(6, objPerfilInter.getQtdDiabetes());
            pst.setString(7, objPerfilInter.getHipertensao());
            pst.setString(8, objPerfilInter.getHiperControl());
            pst.setInt(9, objPerfilInter.getQtdHipertensao());
            pst.setString(10, objPerfilInter.getEscabiose());
            pst.setString(11, objPerfilInter.getEscabioseCura());
            pst.setInt(12, objPerfilInter.getQtdEscabiose());
            pst.setString(13, objPerfilInter.getHanseniase());
            pst.setString(14, objPerfilInter.getHanseniaseCura());
            pst.setInt(15, objPerfilInter.getQtdHanseniase());
            pst.setString(16, objPerfilInter.getSifilis());
            pst.setString(17, objPerfilInter.getSifilisCura());
            pst.setInt(18, objPerfilInter.getQtdSifilis());
            pst.setString(19, objPerfilInter.getTuberculose());
            pst.setString(20, objPerfilInter.getTuberculoseCura());
            pst.setInt(21, objPerfilInter.getQtdTuberculose());
            pst.setString(22, objPerfilInter.getHiv());
            pst.setString(23, objPerfilInter.getHivControlada());
            pst.setInt(24, objPerfilInter.getQtdHib());
            pst.setString(25, objPerfilInter.getHepatiteB());
            pst.setString(26, objPerfilInter.getHepatiBCont());
            pst.setInt(27, objPerfilInter.getQtdHepatiteB());
            pst.setString(28, objPerfilInter.getHepatiteC());
            pst.setString(29, objPerfilInter.getHepatiCcont());
            pst.setInt(30, objPerfilInter.getQtdHepatiteC());
            pst.setString(31, objPerfilInter.getDst());
            pst.setString(32, objPerfilInter.getCuraDst());
            pst.setInt(33, objPerfilInter.getQdtDst());
            pst.setString(34, objPerfilInter.getvDLR());
            pst.setString(35, objPerfilInter.getCuraVdlr());
            pst.setInt(36, objPerfilInter.getQtdVdlr());
            pst.setString(37, objPerfilInter.getVacina());
            pst.setString(38, objPerfilInter.getVacinaCura());
            pst.setInt(39, objPerfilInter.getQtdVacina());
            pst.setString(40, objPerfilInter.getObservacaoEnf());
            pst.setString(41, objPerfilInter.getUsuarioUp());
            pst.setString(42, objPerfilInter.getDataUp());
            pst.setString(43, objPerfilInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento excluirAcompanhamentoEnfermaria(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ACOMPANHAMENTO_INTERNO_ENFERMARIA WHERE IdEnf='" + objPerfilInter.getIdEnf() + "'AND IdLanc='" + objPerfilInter.getIdIndAco() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
