/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.AvaliacaoII;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAvaliacaoIIDAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AvaliacaoII objAvaliaII = new AvaliacaoII();

    public AvaliacaoII incluirAvaliacaoII(AvaliacaoII objAvaliaII) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AVALIACAO_TO_II(IdATN,IdInternoCrc,OrganizoTempo,MantenhoPapeis,SouRotina,ConsigoOutros,TenhoSocial,"
                    + "PlanejoAgir,ConcentroTrabalho,IdentificoProblemas,IdentificoSolucaoProblemas,QuandoAgir,ConsigoHigiene,ConsigoCotidianas,ConsigoFinancas,ConsigoCasa,SintoPreciso,CostumoFrequentar,DataAplicacao,"
                    + "ResponsavelAplicacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAvaliaII.getIdATN());
            pst.setInt(2, objAvaliaII.getIdInternoCrc());
            pst.setString(3, objAvaliaII.getOrganizoTempo());
            pst.setString(4, objAvaliaII.getMantenhoPapeis());
            pst.setString(5, objAvaliaII.getSouRotina());
            pst.setString(6, objAvaliaII.getConsigoOutros());
            pst.setString(7, objAvaliaII.getTenhoSocial());
            pst.setString(8, objAvaliaII.getPlanejoAgir());
            pst.setString(9, objAvaliaII.getConcentroTrabalho());
            pst.setString(10, objAvaliaII.getIdentificoProblemas());
            pst.setString(11, objAvaliaII.getIdentificoSolucaoProblemas());
            pst.setString(12, objAvaliaII.getQuandoAgir());
            pst.setString(13, objAvaliaII.getConsigoHigiene());
            pst.setString(14, objAvaliaII.getConsigoCotidianas());
            pst.setString(15, objAvaliaII.getConsigoFinancas());
            pst.setString(16, objAvaliaII.getConsigoCasa());
            pst.setString(17, objAvaliaII.getSintoPreciso());
            pst.setString(18, objAvaliaII.getCostumoFrequentar());
            if (objAvaliaII.getDataAplicacao() != null) {
                pst.setTimestamp(19, new java.sql.Timestamp(objAvaliaII.getDataAplicacao().getTime()));
            } else {
                pst.setDate(19, null);
            }
            pst.setString(20, objAvaliaII.getResponsavelAplicacao());
            pst.setString(21, objAvaliaII.getUsuarioInsert());
            pst.setString(22, objAvaliaII.getDataInsert());
            pst.setString(23, objAvaliaII.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objAvaliaII;
    }

    public AvaliacaoII alterarAvaliacaoII(AvaliacaoII objAvaliaII) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAO_TO_II SET IdATN=?,IdInternoCrc=?,OrganizoTempo=?,MantenhoPapeis=?,SouRotina=?,ConsigoOutros=?,TenhoSocial=?,"
                    + "PlanejoAgir=?,ConcentroTrabalho=?,IdentificoProblemas=?,IdentificoSolucaoProblemas=?,QuandoAgir=?,ConsigoHigiene=?,ConsigoCotidianas=?,ConsigoFinancas=?,ConsigoCasa=?,SintoPreciso=?,CostumoFrequentar=?,DataAplicacao=?,"
                    + "ResponsavelAplicacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE IdAvaliaTOII='" + objAvaliaII.getIdAvaliaTOII() + "' "
                    + "AND IdATN='" + objAvaliaII.getIdATN() + "'");
            pst.setInt(1, objAvaliaII.getIdATN());
            pst.setInt(2, objAvaliaII.getIdInternoCrc());
            pst.setString(3, objAvaliaII.getOrganizoTempo());
            pst.setString(4, objAvaliaII.getMantenhoPapeis());
            pst.setString(5, objAvaliaII.getSouRotina());
            pst.setString(6, objAvaliaII.getConsigoOutros());
            pst.setString(7, objAvaliaII.getTenhoSocial());
            pst.setString(8, objAvaliaII.getPlanejoAgir());
            pst.setString(9, objAvaliaII.getConcentroTrabalho());
            pst.setString(10, objAvaliaII.getIdentificoProblemas());
            pst.setString(11, objAvaliaII.getIdentificoSolucaoProblemas());
            pst.setString(12, objAvaliaII.getQuandoAgir());
            pst.setString(13, objAvaliaII.getConsigoHigiene());
            pst.setString(14, objAvaliaII.getConsigoCotidianas());
            pst.setString(15, objAvaliaII.getConsigoFinancas());
            pst.setString(16, objAvaliaII.getConsigoCasa());
            pst.setString(17, objAvaliaII.getSintoPreciso());
            pst.setString(18, objAvaliaII.getCostumoFrequentar());
            if (objAvaliaII.getDataAplicacao() != null) {
                pst.setTimestamp(19, new java.sql.Timestamp(objAvaliaII.getDataAplicacao().getTime()));
            } else {
                pst.setDate(19, null);
            }
            pst.setString(20, objAvaliaII.getResponsavelAplicacao());
            pst.setString(21, objAvaliaII.getUsuarioUp());
            pst.setString(22, objAvaliaII.getDataUp());
            pst.setString(23, objAvaliaII.getHorarioUp());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objAvaliaII;
    }

    public AvaliacaoII excluirAvaliacaoII(AvaliacaoII objAvaliaII) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AVALIACAO_TO_II WHERE IdAvaliaTOII='" + objAvaliaII.getIdAvaliaTOII()+ "'AND IdATN='" + objAvaliaII.getIdATN() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objAvaliaII;
    }
}
