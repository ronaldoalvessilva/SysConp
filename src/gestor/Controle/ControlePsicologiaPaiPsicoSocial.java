/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PsicologiaPaiPsicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePsicologiaPaiPsicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PsicologiaPaiPsicoSocial objPsicoPaiSocial = new PsicologiaPaiPsicoSocial();
    int codInt;

    public PsicologiaPaiPsicoSocial incluirPsicologiaPsicoSocial(PsicologiaPaiPsicoSocial objPsicoPaiSocial) {
        buscarInternoCrc(objPsicoPaiSocial.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PSICOLOGIA_PAI_PSICOSOCIAL (IdPai,IdInternoCrc,TranstornoMental,TratamentoAnterior,QuaisTratamentosMentais,OutrosTratamento,FoiInternado,EspecificarFrequenciasLocais,"
                    + "MedicacoesUtilizadas,EpisodioDepressivo,SurtoPsicotico,TentativaSuicidio,ComportamentoViolento,EnvolveJustica,UsoMedicaPsiquia,ObservacaoDepressivo,ObservacaoSurto,ObservacaoTentativaSuicidio,ObservacaoComportamentoViolento,"
                    + "ObservacaoEnvolveJustica,ObservacaoUsoMedicacoPsiquiatrica,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPsicoPaiSocial.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objPsicoPaiSocial.getTranstornoMental());
            pst.setString(4, objPsicoPaiSocial.getTratamentoAnterior());
            pst.setString(5, objPsicoPaiSocial.getQuaisTratamentosMentais());
            pst.setString(6, objPsicoPaiSocial.getOutrosTratamento());
            pst.setString(7, objPsicoPaiSocial.getFoiInternado());
            pst.setString(8, objPsicoPaiSocial.getEspecificarFrequenciasLocais());
            pst.setString(9, objPsicoPaiSocial.getMedicacoesUtilizadas());
            pst.setString(10, objPsicoPaiSocial.getEpisodioDepressivo());
            pst.setString(11, objPsicoPaiSocial.getSurtoPsicotico());
            pst.setString(12, objPsicoPaiSocial.getTentativaSuicidio());
            pst.setString(13, objPsicoPaiSocial.getComportamentoViolento());
            pst.setString(14, objPsicoPaiSocial.getEnvolveJustica());
            pst.setString(15, objPsicoPaiSocial.getUsoMedicaPsiquia());
            pst.setString(16, objPsicoPaiSocial.getObservacaoDepressivo());
            pst.setString(17, objPsicoPaiSocial.getObservacaoSurto());
            pst.setString(18, objPsicoPaiSocial.getObservacaoTentativaSuicidio());
            pst.setString(19, objPsicoPaiSocial.getObservacaoComportamentoViolento());
            pst.setString(20, objPsicoPaiSocial.getObservacaoEnvolveJustica());
            pst.setString(21, objPsicoPaiSocial.getObservacaoUsoMedicacoPsiquiatrica());
            pst.setString(22, objPsicoPaiSocial.getUsuarioInsert());
            pst.setString(23, objPsicoPaiSocial.getDataInsert());
            pst.setString(24, objPsicoPaiSocial.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPsicoPaiSocial;
    }

    public PsicologiaPaiPsicoSocial alterarPsicologiaPsicoSocial(PsicologiaPaiPsicoSocial objPsicoPaiSocial) {
        buscarInternoCrc(objPsicoPaiSocial.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PSICOLOGIA_PAI_PSICOSOCIAL SET IdPai=?,IdInternoCrc=?,TranstornoMental=?,TratamentoAnterior=?,QuaisTratamentosMentais=?,OutrosTratamento=?,FoiInternado=?,EspecificarFrequenciasLocais=?,"
                    + "MedicacoesUtilizadas=?,EpisodioDepressivo=?,SurtoPsicotico=?,TentativaSuicidio=?,ComportamentoViolento=?,EnvolveJustica=?,UsoMedicaPsiquia=?,ObservacaoDepressivo=?,ObservacaoSurto=?,ObservacaoTentativaSuicidio=?,ObservacaoComportamentoViolento=?,"
                    + "ObservacaoEnvolveJustica=?,ObservacaoUsoMedicacoPsiquiatrica=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPsiPai='" + objPsicoPaiSocial.getIdPsiPai() + "'");
            pst.setInt(1, objPsicoPaiSocial.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objPsicoPaiSocial.getTranstornoMental());
            pst.setString(4, objPsicoPaiSocial.getTratamentoAnterior());
            pst.setString(5, objPsicoPaiSocial.getQuaisTratamentosMentais());
            pst.setString(6, objPsicoPaiSocial.getOutrosTratamento());
            pst.setString(7, objPsicoPaiSocial.getFoiInternado());
            pst.setString(8, objPsicoPaiSocial.getEspecificarFrequenciasLocais());
            pst.setString(9, objPsicoPaiSocial.getMedicacoesUtilizadas());
            pst.setString(10, objPsicoPaiSocial.getEpisodioDepressivo());
            pst.setString(11, objPsicoPaiSocial.getSurtoPsicotico());
            pst.setString(12, objPsicoPaiSocial.getTentativaSuicidio());
            pst.setString(13, objPsicoPaiSocial.getComportamentoViolento());
            pst.setString(14, objPsicoPaiSocial.getEnvolveJustica());
            pst.setString(15, objPsicoPaiSocial.getUsoMedicaPsiquia());
            pst.setString(16, objPsicoPaiSocial.getObservacaoDepressivo());
            pst.setString(17, objPsicoPaiSocial.getObservacaoSurto());
            pst.setString(18, objPsicoPaiSocial.getObservacaoTentativaSuicidio());
            pst.setString(19, objPsicoPaiSocial.getObservacaoComportamentoViolento());
            pst.setString(20, objPsicoPaiSocial.getObservacaoEnvolveJustica());
            pst.setString(21, objPsicoPaiSocial.getObservacaoUsoMedicacoPsiquiatrica());
            pst.setString(22, objPsicoPaiSocial.getUsuarioInsert());
            pst.setString(23, objPsicoPaiSocial.getDataInsert());
            pst.setString(24, objPsicoPaiSocial.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPsicoPaiSocial;
    }

    public PsicologiaPaiPsicoSocial excluirPsicologiaPsicoSocial(PsicologiaPaiPsicoSocial objPsicoPaiSocial) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PSICOLOGIA_PAI_PSICOSOCIAL WHERE IdPsiPai='" + objPsicoPaiSocial.getIdPsiPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPsicoPaiSocial;
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
