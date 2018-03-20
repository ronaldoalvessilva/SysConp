/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CCGF_PAI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleCCGF {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CCGF_PAI objCcgf = new CCGF_PAI();

    public CCGF_PAI incluirCCGF_PAI(CCGF_PAI objCcgf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_CCGF (IdPai,IdInternoCrc,TemFilhos,QuantosFilhos,ReconhecerPaterna,DadosPaternidade,EstaoFilho,"
                    + "NecessidaEspecial,NecessidadeESP,CRAS,CREAS,RecebeBeneficio,QuaisBeneficiosFamilia,AntesBeneficio,QuaisBeneficiosAntesPrisao,"
                    + "NecessitaBeneficio,QuemNecessitaBeneficio,Moradia,Modalidade,Abastecimento,EliminaDejetos,Descarte,FamiliaVulneraSocial,ViveuRua,QuantoTempo,Motivo,FamiliaDetido,"
                    + "RestabelecerVinculo,ComoRestabelecer,UsuarioInsert,DataInsert,HorarioInsert) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objCcgf.getIdPai());
            pst.setInt(2, objCcgf.getIdInternoCrc());
            pst.setString(3, objCcgf.getTemFilhos());
            pst.setInt(4, objCcgf.getQuantosFilhos());
            pst.setString(5, objCcgf.getReconhecerPaterna());
            pst.setString(6, objCcgf.getDadosPaternidade());
            pst.setString(7, objCcgf.getEstaoFilhos());
            pst.setString(8, objCcgf.getNecessidaEspecial());
            pst.setString(9, objCcgf.getNecessidadeESP());
            pst.setString(10, objCcgf.getcRAS());
            pst.setString(11, objCcgf.getcREAS());
            pst.setString(12, objCcgf.getRecebeBeneficio());
            pst.setString(13, objCcgf.getQuaisBeneficiosFamilia());
            pst.setString(14, objCcgf.getAntesBeneficio());
            pst.setString(15, objCcgf.getQuaisBeneficiosAntesPrisao());
            pst.setString(16, objCcgf.getNecessitaBeneficio());
            pst.setString(17, objCcgf.getQuemNecessitaBeneficio());
            pst.setString(18, objCcgf.getMoradia());
            pst.setString(19, objCcgf.getModalidade());
            pst.setString(20, objCcgf.getAbastecimento());
            pst.setString(21, objCcgf.getEliminaDejetos());
            pst.setString(22, objCcgf.getDescarte());
            pst.setString(23, objCcgf.getFamiliaVulneraSocial());
            pst.setString(24, objCcgf.getViveuRua());
            pst.setInt(25, objCcgf.getQuantoTempo());
            pst.setString(26, objCcgf.getMotivo());
            pst.setString(27, objCcgf.getFamiliaDetido());
            pst.setString(28, objCcgf.getRestabelecerVinculo());
            pst.setString(29, objCcgf.getComoRestabelecer());
            pst.setString(30, objCcgf.getUsuarioInsert());
            pst.setString(31, objCcgf.getDataInsert());
            pst.setString(32, objCcgf.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCcgf;
    }

    public CCGF_PAI alterarCCGF_PAI(CCGF_PAI objCcgf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_CCGF SET IdPai=?,IdInternoCrc=?,TemFilhos=?,QuantosFilhos=?,ReconhecerPaterna=?,DadosPaternidade=?,EstaoFilho=?,"
                    + "NecessidaEspecial=?,NecessidadeESP=?,CRAS=?,CREAS=?,RecebeBeneficio=?,QuaisBeneficiosFamilia=?,AntesBeneficio=?,QuaisBeneficiosAntesPrisao=?,"
                    + "NecessitaBeneficio=?,QuemNecessitaBeneficio=?,Moradia=?,Modalidade=?,Abastecimento=?,EliminaDejetos=?,Descarte=?,FamiliaVulneraSocial=?,ViveuRua=?,QuantoTempo=?,Motivo=?,FamiliaDetido=?,"
                    + "RestabelecerVinculo=?,ComoRestabelecer=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE IdPai='" + objCcgf.getIdPai() + "'");
            pst.setInt(1, objCcgf.getIdPai());
            pst.setInt(2, objCcgf.getIdInternoCrc());
            pst.setString(3, objCcgf.getTemFilhos());
            pst.setInt(4, objCcgf.getQuantosFilhos());
            pst.setString(5, objCcgf.getReconhecerPaterna());
            pst.setString(6, objCcgf.getDadosPaternidade());
            pst.setString(7, objCcgf.getEstaoFilhos());
            pst.setString(8, objCcgf.getNecessidaEspecial());
            pst.setString(9, objCcgf.getNecessidadeESP());
            pst.setString(10, objCcgf.getcRAS());
            pst.setString(11, objCcgf.getcREAS());
            pst.setString(12, objCcgf.getRecebeBeneficio());
            pst.setString(13, objCcgf.getQuaisBeneficiosFamilia());
            pst.setString(14, objCcgf.getAntesBeneficio());
            pst.setString(15, objCcgf.getQuaisBeneficiosAntesPrisao());
            pst.setString(16, objCcgf.getNecessitaBeneficio());
            pst.setString(17, objCcgf.getQuemNecessitaBeneficio());
            pst.setString(18, objCcgf.getMoradia());
            pst.setString(19, objCcgf.getModalidade());
            pst.setString(20, objCcgf.getAbastecimento());
            pst.setString(21, objCcgf.getEliminaDejetos());
            pst.setString(22, objCcgf.getDescarte());
            pst.setString(23, objCcgf.getFamiliaVulneraSocial());
            pst.setString(24, objCcgf.getViveuRua());
            pst.setInt(25, objCcgf.getQuantoTempo());
            pst.setString(26, objCcgf.getMotivo());
            pst.setString(27, objCcgf.getFamiliaDetido());
            pst.setString(28, objCcgf.getRestabelecerVinculo());
            pst.setString(29, objCcgf.getComoRestabelecer());
            pst.setString(30, objCcgf.getUsuarioUp());
            pst.setString(31, objCcgf.getDataUp());
            pst.setString(32, objCcgf.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCcgf;
    }

    public CCGF_PAI excluirCCGF_PAI(CCGF_PAI objCcgf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_CCGF WHERE IdPai='" + objCcgf.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCcgf;
    }
}
