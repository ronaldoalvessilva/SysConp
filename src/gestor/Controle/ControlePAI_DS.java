/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaPAI_DS;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePAI_DS {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaPAI_DS objFichaDS = new FichaPAI_DS();
    int codInt;

    public FichaPAI_DS incluirPAI_DS(FichaPAI_DS objFichaDS) {
        buscarInternoCrc(objFichaDS.getNomeInternoCrc(), objFichaDS.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_DS (IdPai,IdInternoCrc,"
                    + "RefereSaude,Hanseniase,Diabetes,Tuberculose,Hipertensao,Hepatites,Sifilis,Escabiose,HIV,OutrasDoencas,"
                    + "FazendoTratamento,Psiquiatrico,OndePsiquiatrico,Psicotropico,QualPsicotropico,Mental,Desanimo,Insonia,FaltaApetite,IsolamentoSocial,"
                    + "PensamentosSuicidas,Agressividade,Inquietacao,OutroDoencas,QualOutrosDoencas,InternadoPSI,DataInternaPSI,"
                    + "AcompanhaCAPS,DataCAPS,UsoPsicoativos,Alcool,Maconha,Cocaina,Cola,Crack,Injetaveis,OutrasSub,QualOutrasSub,"
                    + "CompartilhaCrack,Sudorese,Tremores,Fissura,BocaSeca,Nausea,Desejo,NaoPara,AumentoTolerancia,CAPSAD,DataCAPSAD,"
                    + "EsteveInternado,QuantoTempoInternado,AceitaDanos,SaudeBucal,NecessitaAtende,Enfermagem,Medico,PsiquiatricoN,"
                    + "Psicologico,PessoasQuimica,QuemNecessita,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFichaDS.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDS.getRefereSaude());
            pst.setInt(4, objFichaDS.getHanseniase());
            pst.setInt(5, objFichaDS.getDiabetes());
            pst.setInt(6, objFichaDS.getTuberculose());
            pst.setInt(7, objFichaDS.getHipertensao());
            pst.setInt(8, objFichaDS.getHepatites());
            pst.setInt(9, objFichaDS.getSifilis());
            pst.setInt(10, objFichaDS.getEscabiose());
            pst.setInt(11, objFichaDS.gethIV());
            pst.setString(12, objFichaDS.getOutrasDoencas());            
            pst.setString(13, objFichaDS.getFazendoTratamento());
            pst.setString(14, objFichaDS.getPsiquiatrico());
            pst.setString(15, objFichaDS.getOndePsiquiatrico());
            pst.setString(16, objFichaDS.getPsicotropico());
            pst.setString(17, objFichaDS.getQualPsicotropico());
            pst.setString(18, objFichaDS.getMental());
            pst.setInt(19, objFichaDS.getDesanimo());
            pst.setInt(20, objFichaDS.getInsonia());
            pst.setInt(21, objFichaDS.getFaltaApetite());
            pst.setInt(22, objFichaDS.getIsolamentoSocial());            
            pst.setInt(23, objFichaDS.getPensamentosSuicidas());
            pst.setInt(24, objFichaDS.getAgressividade());
            pst.setInt(25, objFichaDS.getInquietacao());
            pst.setInt(26, objFichaDS.getOutroDoencas());
            pst.setString(27, objFichaDS.getQualOutrosDoencas());
            pst.setString(28, objFichaDS.getInternadoPSI());
            if (objFichaDS.getDataInternaPSI() != null) {
                pst.setTimestamp(29, new java.sql.Timestamp(objFichaDS.getDataInternaPSI().getTime()));
            } else {
                pst.setDate(29, null);
            }
            pst.setString(30, objFichaDS.getAcompanhaCAPS());
            if (objFichaDS.getDataCAPS() != null) {
                pst.setTimestamp(31, new java.sql.Timestamp(objFichaDS.getDataCAPS().getTime()));
            } else {
                pst.setDate(31, null);
            }
            pst.setString(32, objFichaDS.getUsoPsicoativos());
            pst.setInt(33, objFichaDS.getAlcool());
            pst.setInt(34, objFichaDS.getMaconha());
            pst.setInt(35, objFichaDS.getCocaina());
            pst.setInt(36, objFichaDS.getCola());
            pst.setInt(37, objFichaDS.getCrack());
            pst.setInt(38, objFichaDS.getInjetaveis());
            pst.setInt(39, objFichaDS.getOutrasSub());
            pst.setString(40, objFichaDS.getQualOutrasSub());
            pst.setString(41, objFichaDS.getCompartilhaCrack());
            pst.setInt(42, objFichaDS.getSudorese());
            pst.setInt(43, objFichaDS.getTremores());
            pst.setInt(44, objFichaDS.getFissura());
            pst.setInt(45, objFichaDS.getBocaSeca());
            pst.setInt(46, objFichaDS.getNausea());
            pst.setInt(47, objFichaDS.getDesejo());
            pst.setInt(48, objFichaDS.getNaoPara());
            pst.setInt(49, objFichaDS.getAumentoTolerancia());
            pst.setString(50, objFichaDS.getcAPSAD());
            if (objFichaDS.getDataCAPSAD() != null) {
                pst.setTimestamp(51, new java.sql.Timestamp(objFichaDS.getDataCAPSAD().getTime()));
            } else {
                pst.setDate(51, null);
            }
            pst.setString(52, objFichaDS.getEsteveInternado());
            pst.setInt(53, objFichaDS.getQuantoTempoInternado());
            pst.setString(54, objFichaDS.getAceitaDanos());
            pst.setString(55, objFichaDS.getSaudeBucal());
            pst.setString(56, objFichaDS.getNecessitaAtende());
            pst.setInt(57, objFichaDS.getEnfermagem());
            pst.setInt(58, objFichaDS.getMedico());
            pst.setInt(59, objFichaDS.getPsiquiatricoN());
            pst.setInt(60, objFichaDS.getPsicologico());
            pst.setString(61, objFichaDS.getPessoasQuimica());
            pst.setString(62, objFichaDS.getQuemNecessita());
            pst.setString(63, objFichaDS.getUsuarioInsert());
            pst.setString(64, objFichaDS.getDataInsert());
            pst.setString(65, objFichaDS.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDS;
    }

    public FichaPAI_DS alterarPAI_DS(FichaPAI_DS objFichaDS) {
        buscarInternoCrc(objFichaDS.getNomeInternoCrc(), objFichaDS.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_DS SET IdPai=?,IdInternoCrc=?,"
                    + "RefereSaude=?,Hanseniase=?,Diabetes=?,Tuberculose=?,Hipertensao=?,Hepatites=?,Sifilis=?,Escabiose=?,HIV=?,OutrasDoencas=?,"
                    + "FazendoTratamento=?,Psiquiatrico=?,OndePsiquiatrico=?,Psicotropico=?,QualPsicotropico=?,Mental=?,Desanimo=?,Insonia=?,FaltaApetite=?,IsolamentoSocial=?,"
                    + "PensamentosSuicidas=?,Agressividade=?,Inquietacao=?,OutroDoencas=?,QualOutrosDoencas=?,InternadoPSI=?,DataInternaPSI=?,"
                    + "AcompanhaCAPS=?,DataCAPS=?,UsoPsicoativos=?,Alcool=?,Maconha=?,Cocaina=?,Cola=?,Crack=?,Injetaveis=?,OutrasSub=?,QualOutrasSub=?,"
                    + "CompartilhaCrack=?,Sudorese=?,Tremores=?,Fissura=?,BocaSeca=?,Nausea=?,Desejo=?,NaoPara=?,AumentoTolerancia=?,CAPSAD=?,DataCAPSAD=?,"
                    + "EsteveInternado=?,QuantoTempoInternado=?,AceitaDanos=?,SaudeBucal=?,NecessitaAtende=?,Enfermagem=?,Medico=?,PsiquiatricoN=?,"
                    + "Psicologico=?,PessoasQuimica=?,QuemNecessita=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPai='" + objFichaDS.getIdPai() + "'");
            pst.setInt(1, objFichaDS.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDS.getRefereSaude());
            pst.setInt(4, objFichaDS.getHanseniase());
            pst.setInt(5, objFichaDS.getDiabetes());
            pst.setInt(6, objFichaDS.getTuberculose());
            pst.setInt(7, objFichaDS.getHipertensao());
            pst.setInt(8, objFichaDS.getHepatites());
            pst.setInt(9, objFichaDS.getSifilis());
            pst.setInt(10, objFichaDS.getEscabiose());
            pst.setInt(11, objFichaDS.gethIV());
            pst.setString(12, objFichaDS.getOutrasDoencas());
            pst.setString(13, objFichaDS.getFazendoTratamento());
            pst.setString(14, objFichaDS.getPsiquiatrico());
            pst.setString(15, objFichaDS.getOndePsiquiatrico());
            pst.setString(16, objFichaDS.getPsicotropico());
            pst.setString(17, objFichaDS.getQualPsicotropico());
            pst.setString(18, objFichaDS.getMental());
            pst.setInt(19, objFichaDS.getDesanimo());
            pst.setInt(20, objFichaDS.getInsonia());
            pst.setInt(21, objFichaDS.getFaltaApetite());
            pst.setInt(22, objFichaDS.getIsolamentoSocial());
            pst.setInt(23, objFichaDS.getPensamentosSuicidas());
            pst.setInt(24, objFichaDS.getAgressividade());
            pst.setInt(25, objFichaDS.getInquietacao());
            pst.setInt(26, objFichaDS.getOutroDoencas());
            pst.setString(27, objFichaDS.getQualOutrosDoencas());
            pst.setString(28, objFichaDS.getInternadoPSI());
            if (objFichaDS.getDataInternaPSI() != null) {
                pst.setTimestamp(29, new java.sql.Timestamp(objFichaDS.getDataInternaPSI().getTime()));
            } else {
                pst.setDate(29, null);
            }
            pst.setString(30, objFichaDS.getAcompanhaCAPS());
            if (objFichaDS.getDataCAPS() != null) {
                pst.setTimestamp(31, new java.sql.Timestamp(objFichaDS.getDataCAPS().getTime()));
            } else {
                pst.setDate(31, null);
            }
            pst.setString(32, objFichaDS.getUsoPsicoativos());
            pst.setInt(33, objFichaDS.getAlcool());
            pst.setInt(34, objFichaDS.getMaconha());
            pst.setInt(35, objFichaDS.getCocaina());
            pst.setInt(36, objFichaDS.getCola());
            pst.setInt(37, objFichaDS.getCrack());
            pst.setInt(38, objFichaDS.getInjetaveis());
            pst.setInt(39, objFichaDS.getOutrasSub());
            pst.setString(40, objFichaDS.getQualOutrasSub());
            pst.setString(41, objFichaDS.getCompartilhaCrack());
            pst.setInt(42, objFichaDS.getSudorese());
            pst.setInt(43, objFichaDS.getTremores());
            pst.setInt(44, objFichaDS.getFissura());
            pst.setInt(45, objFichaDS.getBocaSeca());
            pst.setInt(46, objFichaDS.getNausea());
            pst.setInt(47, objFichaDS.getDesejo());
            pst.setInt(48, objFichaDS.getNaoPara());
            pst.setInt(49, objFichaDS.getAumentoTolerancia());
            pst.setString(50, objFichaDS.getcAPSAD());
            if (objFichaDS.getDataCAPSAD() != null) {
                pst.setTimestamp(51, new java.sql.Timestamp(objFichaDS.getDataCAPSAD().getTime()));
            } else {
                pst.setDate(51, null);
            }
            pst.setString(52, objFichaDS.getEsteveInternado());
            pst.setInt(53, objFichaDS.getQuantoTempoInternado());
            pst.setString(54, objFichaDS.getAceitaDanos());
            pst.setString(55, objFichaDS.getSaudeBucal());
            pst.setString(56, objFichaDS.getNecessitaAtende());
            pst.setInt(57, objFichaDS.getEnfermagem());
            pst.setInt(58, objFichaDS.getMedico());
            pst.setInt(59, objFichaDS.getPsiquiatricoN());
            pst.setInt(60, objFichaDS.getPsicologico());
            pst.setString(61, objFichaDS.getPessoasQuimica());
            pst.setString(62, objFichaDS.getQuemNecessita());
            pst.setString(63, objFichaDS.getUsuarioInsert());
            pst.setString(64, objFichaDS.getDataInsert());
            pst.setString(65, objFichaDS.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDS;
    }

    public FichaPAI_DS excluirPAI_DS(FichaPAI_DS objFichaDS) {        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_DS WHERE IdPai='" + objFichaDS.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDS;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
