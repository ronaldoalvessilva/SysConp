/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.AvaliacaoI;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAvaliacaoIDAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AvaliacaoI objAvaliaI = new AvaliacaoI();

    public AvaliacaoI incluirAvaliacaoI(AvaliacaoI objAvaliaI) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALIACAO_TO_I(IdATN,IdInternoCrc,ConhecoHabilidades,AcreditaRealizacoes,EsperoResultados,AcreditoRealizaTrabalho,AcreditoRealizaLar,"
                    + "AcreditoDiverteLazer,FacoAtividades,TenhoExpectativa,TenhoObjetoFuturo,IdentificoGostos,ParticipoProjetosImport,TenhoVariosInteresse,CostumoComprometo,DeEstudante,DeTrabalho,DeAmigo,DeFamiliar,"
                    + "ReconhecoPapeis,MantenhoVida,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAvaliaI.getIdATN());
            pst.setInt(2, objAvaliaI.getIdInternoCrc());
            pst.setString(3, objAvaliaI.getConhecoHabilidades());
            pst.setString(4, objAvaliaI.getAcreditaRealizacoes());
            pst.setString(5, objAvaliaI.getEsperoResultados());
            pst.setString(6, objAvaliaI.getAcreditoRealizaTrabalho());
            pst.setString(7, objAvaliaI.getAcreditoRealizaLar());
            pst.setString(8, objAvaliaI.getAcreditoDiverteLazer());
            pst.setString(9, objAvaliaI.getFacoAtividades());
            pst.setString(10, objAvaliaI.getTenhoExpectativa());
            pst.setString(11, objAvaliaI.getTenhoObjetoFuturo());
            pst.setString(12, objAvaliaI.getIdentificoGostos());
            pst.setString(13, objAvaliaI.getParticipoProjetosImport());
            pst.setString(14, objAvaliaI.getTenhoVariosInteresse());
            pst.setString(15, objAvaliaI.getCostumoComprometo());
            pst.setString(16, objAvaliaI.getDeEstudante());
            pst.setString(17, objAvaliaI.getDeTrabalho());
            pst.setString(18, objAvaliaI.getDeAmigo());
            pst.setString(19, objAvaliaI.getDeFamiliar());
            pst.setString(20, objAvaliaI.getReconhecoPapeis());
            pst.setString(21, objAvaliaI.getMantenhoVida());
            pst.setString(22, objAvaliaI.getUsuarioInsert());
            pst.setString(23, objAvaliaI.getDataInsert());
            pst.setString(24, objAvaliaI.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objAvaliaI;
    }

    public AvaliacaoI alterarAvaliacaoI(AvaliacaoI objAvaliaI) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAO_TO_I SET IdATN=?,IdInternoCrc=?,ConhecoHabilidades=?,AcreditaRealizacoes=?,EsperoResultados=?,AcreditoRealizaTrabalho=?,AcreditoRealizaLar=?,"
                    + "AcreditoDiverteLazer=?,FacoAtividades=?,TenhoExpectativa=?,TenhoObjetoFuturo=?,IdentificoGostos=?,ParticipoProjetosImport=?,TenhoVariosInteresse=?,CostumoComprometo=?,DeEstudante=?,DeTrabalho=?,DeAmigo=?,DeFamiliar=?,"
                    + "ReconhecoPapeis=?,MantenhoVida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAvaliaTOI='" + objAvaliaI.getIdAvaliaI() + "' "
                    + "AND IdATN='" + objAvaliaI.getIdATN() + "'");
            pst.setInt(1, objAvaliaI.getIdATN());
            pst.setInt(2, objAvaliaI.getIdInternoCrc());
            pst.setString(3, objAvaliaI.getConhecoHabilidades());
            pst.setString(4, objAvaliaI.getAcreditaRealizacoes());
            pst.setString(5, objAvaliaI.getEsperoResultados());
            pst.setString(6, objAvaliaI.getAcreditoRealizaTrabalho());
            pst.setString(7, objAvaliaI.getAcreditoRealizaLar());
            pst.setString(8, objAvaliaI.getAcreditoDiverteLazer());
            pst.setString(9, objAvaliaI.getFacoAtividades());
            pst.setString(10, objAvaliaI.getTenhoExpectativa());
            pst.setString(11, objAvaliaI.getTenhoObjetoFuturo());
            pst.setString(12, objAvaliaI.getIdentificoGostos());
            pst.setString(13, objAvaliaI.getParticipoProjetosImport());
            pst.setString(14, objAvaliaI.getTenhoVariosInteresse());
            pst.setString(15, objAvaliaI.getCostumoComprometo());
            pst.setString(16, objAvaliaI.getDeEstudante());
            pst.setString(17, objAvaliaI.getDeTrabalho());
            pst.setString(18, objAvaliaI.getDeAmigo());
            pst.setString(19, objAvaliaI.getDeFamiliar());
            pst.setString(20, objAvaliaI.getReconhecoPapeis());
            pst.setString(21, objAvaliaI.getMantenhoVida());
            pst.setString(22, objAvaliaI.getUsuarioUp());
            pst.setString(23, objAvaliaI.getDataUp());
            pst.setString(24, objAvaliaI.getHorarioUp());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objAvaliaI;
    }

    public AvaliacaoI excluirAvaliacaoI(AvaliacaoI objAvaliaI) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALIACAO_TO_I WHERE IdAvaliaTOI='" + objAvaliaI.getIdAvaliaI() + "' "
                    + "AND IdATN='" + objAvaliaI.getIdATN() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objAvaliaI;
    }
}
